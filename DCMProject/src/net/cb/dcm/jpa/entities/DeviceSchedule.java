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
 * Entity implementation class for Entity: DeviceSchedule
 *
 */
@Entity
@Table(name = "device_schedule")
public class DeviceSchedule implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="DEVICE_ID", referencedColumnName = "ID")
	private Device device;
	
	@OneToMany(mappedBy = "deviceSchedule")
	private List<Loop> loops;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	

	public DeviceSchedule() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public List<Loop> getLoops() {
		return loops;
	}

	public void setLoops(List<Loop> loops) {
		this.loops = loops;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
   
}
