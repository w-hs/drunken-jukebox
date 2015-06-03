package de.whs.drunkenjukebox.client.voteapp;

public interface VoteListener {
	public void onDownVote(PlayListEntryWidget entry);
	public void onUpVote(PlayListEntryWidget entry);
}
