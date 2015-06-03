package de.whs.drunkenjukebox.shared;

import java.io.Serializable;


public class PlayListEntry implements Serializable {

	private static final long serialVersionUID = -8853457992660690992L;
	
	private String id;
	private String songID;
	private String songName;
	private String interpreter;
	private VoteResult voteResult;
	private int votes;
	
	
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
		
		if(voteResult == VoteResult.DOWN_VOTED)
			votes--;
		if(voteResult == VoteResult.UP_VOTED)
			votes++;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSongID() {
		return songID;
	}
	public void setSongID(String songID) {
		this.songID = songID;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
