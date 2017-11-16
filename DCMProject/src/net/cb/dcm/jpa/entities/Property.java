package net.cb.dcm.jpa.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for device Property
 *
 */
@Entity
@Table(name="properties")
public class Property implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 256)
	private String name;
	
	@Column(name="KEY_NAME", nullable = false, length = 24)
	private String key;

	public Property() {
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
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Property other = (Property) obj;
		if (id != other.id)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
   
}
