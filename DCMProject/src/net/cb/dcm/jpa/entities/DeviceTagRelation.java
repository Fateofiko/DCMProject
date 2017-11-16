package net.cb.dcm.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for relation between {@link Device} and {@link Tag}
 * It's used only for proper database table generation.
 * Instead use directly {@link Device#getTags()}
 */
@Entity
@Table(name="dev_tag_rel")
public class DeviceTagRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "DEVICE_ID")
	private long deviceId;
	
	@Column(name = "TAG_ID")
	private long tagId;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

}
