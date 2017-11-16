package net.cb.dcm.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DeviceStatusValue
 *
 */
@Entity
@Table(name = "dev_status_values")
public class DeviceStatusValue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="DEV_STATUS_ID")
	private DeviceStatus deviceStatus;
	
	@ManyToOne
	@JoinColumn(name="PROPERTY_ID")
	private Property property;
	
	@Column(length=512)
	private String value;

	public DeviceStatusValue() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DeviceStatus getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(DeviceStatus deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
   
}
