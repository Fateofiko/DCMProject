package net.cb.dcm.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DevicePropTypePropRelation
 * It's used only for proper database table generation.
 * Instead use directly {@link DevicePropertyType#getProperties()}
 *
 */
@Entity
@Table(name = "dev_prop_type_properties")
public class DevicePropTypePropRelation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "DEV_PROP_TYPE_ID")
	private int devicePropertyTypeId; 
	
	@Column(name = "PROPERTY_ID")
	private int propertyId; 
	

	public DevicePropTypePropRelation() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getDevicePropertyTypeId() {
		return devicePropertyTypeId;
	}


	public void setDevicePropertyTypeId(int devicePropertyTypeId) {
		this.devicePropertyTypeId = devicePropertyTypeId;
	}


	public int getPropertyId() {
		return propertyId;
	}


	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
   
}
