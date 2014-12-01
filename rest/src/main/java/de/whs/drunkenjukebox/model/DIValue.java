package de.whs.drunkenjukebox.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DIValue {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private Calendar timestamp;
	
	@Column(nullable = false)
	private int diValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public int getDiValue() {
		return diValue;
	}

	public void setDiValue(int diValue) {
		this.diValue = diValue;
	}
}
