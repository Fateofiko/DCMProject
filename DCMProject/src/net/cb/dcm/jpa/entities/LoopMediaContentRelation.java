package net.cb.dcm.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: LoopMediaContentRelation
 * It's used only for proper database table generation.
 * Instead use directly {@link Loop#getMediaContents()}
 */
@Entity
@Table(name="dev_loop_media_contents")
public class LoopMediaContentRelation implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "LOOP_ID")
	private long loopId;
	
	@Column(name = "MEDIA_CONTENT_ID")
	private long mediaContentId;

	public LoopMediaContentRelation() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMediaContentId() {
		return mediaContentId;
	}

	public void setMediaContentId(long mediaContentId) {
		this.mediaContentId = mediaContentId;
	}

	public long getLoopId() {
		return loopId;
	}

	public void setLoopId(long loopId) {
		this.loopId = loopId;
	}
   
}
