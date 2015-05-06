package de.whs.drunkenjukebox.model;

import java.io.Serializable;

public class PlayListEntry implements Serializable {

	private static final long serialVersionUID = -8853457992660690992L;
	
	private String songName;
	private String interpreter;
	private VoteResult voteResult;
	
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getInterpreter() {
		return interpreter;
	}
	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}
	public VoteResult getVoteResult() {
		return voteResult;
	}
	public void setVoteResult(VoteResult voteResult) {
		this.voteResult = voteResult;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
