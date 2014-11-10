package de.whs.drunkenjukebox.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DIValue {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@Column(nullable = false)
	private PartyPeople person;
	
	@Column(nullable = false)
	private Calendar timestamp;
	
	@Column(nullable = false)
	private int diValue;
}
