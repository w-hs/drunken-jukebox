package de.whs.drunkenjukebox.client.admin.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.whs.drunkenjukebox.client.admin.AdminServiceAsync;
import de.whs.drunkenjukebox.client.admin.view.SongDetailView;
import de.whs.drunkenjukebox.client.admin.view.SongListView;
import de.whs.drunkenjukebox.client.admin.view.SongManagementView;
import de.whs.drunkenjukebox.shared.Song;

public class SongManagementPresenter {
	private AdminServiceAsync songsSerivce;
	private SongListView songListView;
	private SongDetailView songDetailView;
	private List<Song> internalSongList;
	private List<Song> visibleSongs;
	private Song currentSong;
		
	public SongManagementPresenter(AdminServiceAsync songsSerivce, SongManagementView songManagementView) {
		this.songsSerivce = songsSerivce;
		this.songListView = songManagementView.getListView();
		this.songDetailView = songManagementView.getDetailView();
	}

	public void bind() {
		songListView.getSongsListBox().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				onSelectedSongChange();
			}
		});
		
		songListView.getSearchTextBox().addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				onSearchTextChange();
			}
		});
		
		songListView.getRemoveButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onRemoveSongClick();
			}
		});
	}

	protected void onSearchTextChange() {
		String searchText = songListView.getSearchText().getValue();
		if (searchText.equals("")) {
			visibleSongs = new ArrayList<Song>(internalSongList);
		} else {
			visibleSongs.clear();
			for (Song s : internalSongList) {
				if (s.getTitle().toLowerCase().contains(searchText.toLowerCase())) {
					visibleSongs.add(s);
				}
			}
		}
		songListView.setSongs(getVisibleSongTitles());
	}

	protected void onSelectedSongChange() {
		int index = songListView.getSelectedIndex();
		currentSong = visibleSongs.get(index);

		songDetailView.setSong(currentSong);
	}
	
	protected void onRemoveSongClick() {
		int index = songListView.getSelectedIndex();
		if (index < 0)
			return;
		
		final Song songToRemove = visibleSongs.get(index);		
		songsSerivce.removeSong(songToRemove.getId(), new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				fetchSongs();
			}
			@Override
			public void onFailure(Throwable caught) {
				String message = "Failed to remove Song: " + songToRemove.getTitle();
				Window.alert(message);
			}
		});
	}

	public void go() {
		bind();
		fetchSongs();
	}
	
	private void fetchSongs() {	
		songDetailView.clear();
		songsSerivce.getSongList(new AsyncCallback<ArrayList<Song>>() {

			@Override
			public void onSuccess(ArrayList<Song> result) {
				internalSongList = new ArrayList<Song>(result);
				visibleSongs = new ArrayList<Song>(result);
				songListView.setSongs(getVisibleSongTitles());
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error fetching songs: " + caught.getMessage());
			}
		});
	}
	
	private List<String> getVisibleSongTitles() {
		List<String> titles = new ArrayList<String>();
		for (Song s : visibleSongs)
			titles.add(s.getTitle());
		return titles;
	}
}