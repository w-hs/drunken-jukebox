package de.whs.drunkenjukebox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PartyPeople {

	@Id
	@GeneratedValue
	private int id;
	
	private int currentDI;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentDI() {
		return currentDI;
	}

	public void setCurrentDI(int currentDI) {
		this.currentDI = currentDI;
	}
}
