package net.cb.dcm.jpa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "playlists")
public class Playlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=250)
	private String description;
	
	@Column
	private int priority;
	
	@Column
	private boolean active;
	
	@Column(name = "IS_DEFAULT")
	private boolean _default;
	
	@Column(name="VALID_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validFrom;
	
	@Column(name="VALID_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validTo;
	
	@OneToMany
	@JoinTable(name = "playlist_media_contents", 
	joinColumns = @JoinColumn(name = "PLAYLIST_ID", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "MEDIA_CONTENT_ID", referencedColumnName = "ID"))
	private List<MediaContent> mediaContents;

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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDefault() {
		return _default;
	}

	public void setDefault(boolean _default) {
		this._default = _default;
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
}
