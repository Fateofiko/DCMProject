package net.cb.dcm.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
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

import net.cb.dcm.enums.MediaObjectType;

@Entity
@Table(name="media_content")
public class MediaContent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length=100, nullable = false)
	private String name;
	
	@Column(length=250)
	private String description;
	
	@Column(name="MEDIA_TYPE", nullable = false)
	private MediaObjectType mediaType;
	
	private long duration;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name = "media_cont_tag_rel", 
	joinColumns = @JoinColumn(name = "MEDIA_CONTENT_ID", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "TAG_ID", referencedColumnName = "ID"))
	private List<Tag> tags;

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

	public MediaObjectType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaObjectType mediaType) {
		this.mediaType = mediaType;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}
