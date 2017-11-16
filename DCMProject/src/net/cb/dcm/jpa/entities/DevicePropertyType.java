package net.cb.dcm.jpa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for DevicePropertyType
 *
 */
@Entity
@Table(name="dev_prop_types")
public class DevicePropertyType implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(length = 512)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "dev_prop_type_properties", 
		joinColumns = @JoinColumn(name = "DEV_PROP_TYPE_ID", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "PROPERTY_ID", referencedColumnName = "ID"))
	private List<Property> properties;

	public DevicePropertyType() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
   
}
