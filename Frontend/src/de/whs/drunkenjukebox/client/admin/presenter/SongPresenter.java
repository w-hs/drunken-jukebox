package de.whs.drunkenjukebox.client.admin.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.client.admin.SongsServiceAsync;
import de.whs.drunkenjukebox.shared.Song;

public class SongPresenter implements Presenter {
	private SongsServiceAsync songsSerivce;
	private SongListDisplay songListDisplay;
	private SongDetailDisplay songDetailDisplay;
	private List<Song> internalSongList;
	private List<Song> visibleSongs;
	private Song currentSong;
	
	public interface SongListDisplay {
		void setSongs(List<String> songs);
		HasChangeHandlers getSongsListBox();
		HasKeyUpHandlers getSearchTextBox();
		HasValue<String> getSearchText();
		int getSelectedIndex();
		Widget asWidget();
	}
	
	public interface SongDetailDisplay {
		void setSong(Song song);
		Widget asWidget();
	}
	
	
	public SongPresenter(SongsServiceAsync songsSerivce,
			SongListDisplay songListDisplay, SongDetailDisplay songDetailDisplay) {
		
		this.songsSerivce = songsSerivce;
		this.songListDisplay = songListDisplay;
		this.songDetailDisplay = songDetailDisplay;

		bind();
	}

	@Override
	public void bind() {
		songListDisplay.getSongsListBox().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				onSelectedSongChange();
			}
		});		
		songListDisplay.getSearchTextBox().addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				onSearchTextChange();
			}
		});
	}

	protected void onSearchTextChange() {
		String searchText = songListDisplay.getSearchText().getValue();
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
		songListDisplay.setSongs(getVisibleSongTitles());
	}

	private void onSelectedSongChange() {
		int index = songListDisplay.getSelectedIndex();
		currentSong = visibleSongs.get(index);

		songDetailDisplay.setSong(currentSong);
	}

	@Override
	public void go(HasWidgets container) {
		container.add(songListDisplay.asWidget());
		container.add(songDetailDisplay.asWidget());
		fetchSongs();
	}
	
	private void fetchSongs() {	
		songsSerivce.getSongList(new AsyncCallback<ArrayList<Song>>() {

			@Override
			public void onSuccess(ArrayList<Song> result) {
				internalSongList = new ArrayList<Song>(result);
				visibleSongs = new ArrayList<Song>(result);
				songListDisplay.setSongs(getVisibleSongTitles());
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
