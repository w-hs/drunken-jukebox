package de.whs.drunkenjukebox.client.voteapp;

import de.whs.drunkenjukebox.shared.PlayListEntry;

public interface VoteListener {
	public void onDownVote(PlayListEntry entry);
	public void onUpVote(PlayListEntry entry);
}
