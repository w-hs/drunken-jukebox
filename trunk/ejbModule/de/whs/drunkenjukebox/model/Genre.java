package de.whs.drunkenjukebox.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genre {
	@Id
	@GeneratedValue
	private int id;

	@Column(unique = true, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "genres")
	private Collection<Song> songs = new ArrayList<Song>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
