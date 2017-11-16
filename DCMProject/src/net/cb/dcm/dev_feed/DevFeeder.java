package net.cb.dcm.dev_feed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.cb.dcm.enums.DevResponseDataType;
import net.cb.dcm.jpa.DeviceDAO;
import net.cb.dcm.jpa.GenericDao;
import net.cb.dcm.jpa.PlaylistDao;
import net.cb.dcm.jpa.entities.Device;
import net.cb.dcm.jpa.entities.Loop;
import net.cb.dcm.jpa.entities.MediaContent;
import net.cb.dcm.jpa.entities.Playlist;
import net.cb.dcm.jpa.entities.Tag;

/**
 * Servlet for processing http request for new content from the samsung tv app
 * and other smart devices.
 */
public class DevFeeder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger moLogger = LoggerFactory.getLogger(DevFeeder.class);

	private DeviceDAO deviceDao = new DeviceDAO();

	/** {@inheritDoc} */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loIp = request.getParameter("ip");
		String lsServerUrl = "http://" + request.getServerName() + ":" + request.getServerPort();
		if (loIp == null || loIp.isEmpty()) {
			moLogger.debug("No device IP. Generating default response.");
			this.getPlayList(null, lsServerUrl, response);
		} else {
			Device loDevice = deviceDao.findDeviceByIp(loIp);
			if (loDevice == null || loDevice.getId() <= 0) {
				GenericDao<Tag> tagDao = new GenericDao<Tag>() {
				};

				moLogger.debug("Register new device with IP " + loIp);
				//// Register device ID in the database
				//// Maybe registering only the IP, then the system
				//// opearator should see it in the
				//// list as a device without data, and maintain it.
				loDevice = deviceDao.registerNewDevice(loIp);
				loDevice.setTags(tagDao.findAll());
				deviceDao.update(loDevice);
				// Load device default playlist
				this.getPlayList(loDevice, lsServerUrl, response);
			} else {
				// TODO Get device playlist and load it
				List<Tag> tags = loDevice.getTags();
				this.getPlayList(loDevice, lsServerUrl, response);
			}
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Should not be called
		doGet(request, response);
	}

	/**
	 * Generates default json data with play list files for the device
	 * 
	 * @param serverUrl
	 *            Server url including port number
	 * @param response
	 *            - Response to write json data
	 * @throws IOException
	 */
	private void getPlayList(Device device, String serverUrl, HttpServletResponse response) throws IOException {
		Gson loGson = new GsonBuilder().setPrettyPrinting().create();
		DevResponse loDevResponse = new DevResponse(serverUrl);
		loDevResponse.setResponseDataType(DevResponseDataType.PLAY_LIST);
		
		List<MediaContent> mediaContents = new ArrayList<MediaContent>();
		if (device != null) {
			mediaContents = deviceDao.findMediaByDeviceTag(device);
		}
		PlaylistDao playlistDao = new PlaylistDao(deviceDao);
		if (mediaContents.isEmpty()) {
			
			Playlist defaultPlaylist = playlistDao.findDefaultPlaylist();
			if (defaultPlaylist != null) {
				mediaContents = defaultPlaylist.getMediaContents();
			}
		} else {
			List<Playlist> playlists = playlistDao.findAll();
			List<Loop> loops = new ArrayList<>();
			final List<MediaContent> fMediaContents = mediaContents;
			// Check playst contents is included in device tags
			for (Playlist playlist : playlists) {
				List<MediaContent> deviceMedia = playlist.getMediaContents()
						.stream()
						.filter(media -> fMediaContents.contains(media))
						.collect(Collectors.toList());
				if(!deviceMedia.isEmpty()) {
					Loop loop = new Loop();
					loop.setMediaContents(deviceMedia);
					loop.setValidFrom(playlist.getValidFrom());
					loop.setValidTo(playlist.getValidTo());
					loops.add(loop);
				}
			}
			
			List<Loop> orderedLoops = new ArrayList<Loop>();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			for (Loop loop : loops) {

			}
		}
		loDevResponse.setMediaContents(mediaContents);

		loDevResponse.generateResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(loGson.toJson(loDevResponse.getResponseJson()));
	}
}
