package net.cb.dcm.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PlaylistMediaContentRelation
 *
 */
@Entity
@Table(name = "playlist_media_contents")
public class PlaylistMediaContentRelation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "PLAYLIST_ID")
	private long playlistId;
	
	@Column(name = "MEDIA_CONTENT_ID")
	private long mediaContentId;

	public PlaylistMediaContentRelation() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(long playlistId) {
		this.playlistId = playlistId;
	}

	public long getMediaContentId() {
		return mediaContentId;
	}

	public void setMediaContentId(long mediaContentId) {
		this.mediaContentId = mediaContentId;
	}
   
}
