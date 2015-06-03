package de.whs.drunkenjukebox.shared;

import java.io.Serializable;
import java.util.Date;

public class Party implements Serializable {
	
	private static final long serialVersionUID = -6273407605775485301L;
	private String partyId;
	private int drunkenIndex;
	private int partyPeopleCount;
	private Date partyStart;

	public Party() {
		
	}

	public String getPartyId() {
		return partyId;
	}
	
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public int getDrunkenIndex() {
		return drunkenIndex;
	}

	public void setDrunkenIndex(int drunkenIndex) {
		this.drunkenIndex = drunkenIndex;
	}

	public int getPartyPeopleCount() {
		return partyPeopleCount;
	}

	public void setPartyPeopleCount(int partyPeopleCount) {
		this.partyPeopleCount = partyPeopleCount;
	}

	public Date getPartyStart() {
		return partyStart;
	}

	public void setPartyStart(Date partyStart) {
		this.partyStart = partyStart;
	}
}
