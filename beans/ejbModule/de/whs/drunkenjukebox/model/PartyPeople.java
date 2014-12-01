package de.whs.drunkenjukebox.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PartyPeople {

	@Id
	@GeneratedValue
	private int id;
	
	private int currentDI;
	
	@OneToMany(cascade = { CascadeType.ALL })
	private Collection<DIValue> diValues = new ArrayList<DIValue>();
	
	@OneToMany(cascade = { CascadeType.ALL })
	private Collection<Vote> votes = new ArrayList<Vote>();

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

	public Collection<DIValue> getDiValues() {
		return diValues;
	}

	public void setDiValues(Collection<DIValue> diValues) {
		this.diValues = diValues;
	}

	public Collection<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}
}
