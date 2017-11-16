package net.cb.dcm.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class for DeviceStatus
 *
 */
@Entity
@Table(name = "device_statuses")
public class DeviceStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="DEVICE_ID")
	private Device device;
	
	@OneToMany(mappedBy = "deviceStatus")
	private List<DeviceStatusValue> deviceStatusValues;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	public DeviceStatus() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}

	public List<DeviceStatusValue> getDeviceStatusValues() {
		return deviceStatusValues;
	}
	public void setDeviceStatusValues(List<DeviceStatusValue> deviceStatusValues) {
		this.deviceStatusValues = deviceStatusValues;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

   
}
