package net.cb.dcm.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import net.cb.dcm.jpa.entities.Device;
import net.cb.dcm.jpa.entities.MediaContent;
import net.cb.dcm.jpa.entities.Tag;

public class DeviceDAO extends GenericDao<Device> {
	
	public Device findDeviceByIp(String ip) {
		TypedQuery<Device> query = entityManager.createQuery("SELECT d FROM Device d WHERE d.ip = :ip", Device.class);
		List<Device> foundDevices = query.setParameter("ip", ip).getResultList();
		if(foundDevices.size() == 1) {
			return foundDevices.get(0);
		} else {
			return null;
		}
	}
	
	public Device registerNewDevice(String ip) {
		Device device = new Device();
		device.setIp(ip);
		device.setName("Samsung Tv " + ip);
		this.insert(device);
		return device;
	}
	
	public List<MediaContent> findMediaByDeviceTag(Device device) {
		TypedQuery<MediaContent> query = entityManager.createQuery("SELECT m FROM MediaContent m "
													+ " WHERE m.tags IN :tags"
													+ " GROUP BY m HAVING COUNT(m) = :count", MediaContent.class);
		List<Tag> tags = device.getTags();
		query.setParameter("tags", tags);
		query.setParameter("count", tags.size());
		return query.getResultList();
	}
	
}
