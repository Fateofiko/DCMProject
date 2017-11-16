package net.cb.dcm.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *
 */
@Entity
@Table(name="media_cont_tag_rel")
public class MediaContentTagRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="MEDIA_CONTENT_ID")
	private long mediaContentId;
	
	@Column(name="TAG_ID")
	private long tagId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public long getMediaContentId() {
		return mediaContentId;
	}

	public void setMediaContentId(long mediaContentId) {
		this.mediaContentId = mediaContentId;
	}

}
