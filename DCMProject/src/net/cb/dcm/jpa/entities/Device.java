package net.cb.dcm.jpa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.cb.dcm.enums.DeviceType;

/**
 * Entity class for Device 
 *
 */
@Entity
@Table(name = "devices")
@NamedQuery(name = "AllDevices", query = "select d from Device d")
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30)
	private String name;

	@Column(length = 250)
	private String description;

	@Column(name = "dev_type")
	private DeviceType devType; // (integer) � device type (1 � monitor, 2 � mobile
							// device, 3�)

	private int size; // Size in inches

	@Column(length = 50)
	private String model;

	@Column(length = 40, unique = true, nullable = false)
	private String ip;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEV_PROP_TYPE_ID", referencedColumnName = "ID")
	private DevicePropertyType devicePropertyType;

//	@OneToMany(mappedBy = "device")
//	private List<DeviceTagRelation> tags;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "dev_tag_rel", 
		joinColumns = @JoinColumn(name = "DEVICE_ID", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "TAG_ID", referencedColumnName = "ID"))
	private List<Tag> tags;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURR_DEV_STATUS_ID", referencedColumnName = "ID")
	private DeviceStatus currentDeviceStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURR_DEV_SCHEDULE_ID", referencedColumnName = "ID")
	private DeviceSchedule currentDeviceSchedule;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DeviceType getDevType() {
		return devType;
	}

	public void setDevType(DeviceType devType) {
		this.devType = devType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

//	public void addTag(Tag ioTag) {
//		DeviceTagRelation loRel = new DeviceTagRelation();
//		loRel.setDevice(this);
//		loRel.setDeviceId(this.getId());
//
//		loRel.setTag(ioTag);
//		loRel.setTagId(ioTag.getId());
//		if (this.tags == null)
//			this.tags = new ArrayList<>();
//
//		this.tags.add(loRel);
//		// Also add the association object to the employee.
//		ioTag.getDevices().add(loRel);
//	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public DevicePropertyType getDevicePropertyType() {
		return devicePropertyType;
	}

	public void setDevicePropertyType(DevicePropertyType devicePropertyType) {
		this.devicePropertyType = devicePropertyType;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public DeviceStatus getCurrentDeviceStatus() {
		return currentDeviceStatus;
	}

	public void setCurrentDeviceStatus(DeviceStatus currentDeviceStatus) {
		this.currentDeviceStatus = currentDeviceStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public DeviceSchedule getCurrentDeviceSchedule() {
		return currentDeviceSchedule;
	}

	public void setCurrentDeviceSchedule(DeviceSchedule currentDeviceSchedule) {
		this.currentDeviceSchedule = currentDeviceSchedule;
	}
}
