package net.cb.dcm.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import net.cb.dcm.jpa.entities.Playlist;

public class PlaylistDao extends GenericDao<Playlist> {

	public PlaylistDao(DeviceDAO deviceDao) {
		super(deviceDao);
	}

	public Playlist findDefaultPlaylist() {
		TypedQuery<Playlist> query = entityManager.createQuery("SELECT p FROM Playlist p WHERE p._default = true", Playlist.class);
		List<Playlist> playlists =  query.getResultList();
		if(playlists.size() > 0) {
			return playlists.get(0);
		} else {
			return null;
		}
	}
}
