package net.cb.dcm.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Loop
 *
 */
@Entity
@Table(name = "device_loop")
public class Loop implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="VALID_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validFrom;
	
	@Column(name="VALID_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validTo;
	
	@OneToMany
	@JoinTable(name = "dev_loop_media_contents", 
	joinColumns = @JoinColumn(name = "LOOP_ID", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "MEDIA_CONTENT_ID", referencedColumnName = "ID"))
	private List<MediaContent> mediaContents;
	
	@ManyToOne
	@JoinColumn(name = "DEVICE_SCHEDULE_ID")
	private DeviceSchedule deviceSchedule;

	public Loop() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public List<MediaContent> getMediaContents() {
		return mediaContents;
	}

	public void setMediaContents(List<MediaContent> mediaContents) {
		this.mediaContents = mediaContents;
	}

	public DeviceSchedule getDeviceSchedule() {
		return deviceSchedule;
	}

	public void setDeviceSchedule(DeviceSchedule deviceSchedule) {
		this.deviceSchedule = deviceSchedule;
	}
   
}
