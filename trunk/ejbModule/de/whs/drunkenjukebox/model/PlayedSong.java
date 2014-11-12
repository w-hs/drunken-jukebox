package de.whs.drunkenjukebox.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlayedSong {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@Column(nullable = false)
	private Song song;
	
	@Column(unique = true, nullable = false)
	private Calendar timestamp;
	
	@Column(nullable = false)
	private int voteCount;
	
	@Column(nullable = false)
	private float averateDI;
}
