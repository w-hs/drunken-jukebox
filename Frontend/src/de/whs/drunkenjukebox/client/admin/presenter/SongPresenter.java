package de.whs.drunkenjukebox.client.admin.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.client.admin.SongsServiceAsync;
import de.whs.drunkenjukebox.shared.Song;

public class SongPresenter implements Presenter {
	private SongsServiceAsync songsSerivce;
	private SongListDisplay songListDisplay;
	private SongDetailDisplay songDetailDisplay;
	private List<Song> songs;
	private Song currentSong;
	
	public interface SongListDisplay {
		void setSongs(List<String> songs);
		HasChangeHandlers getSongsListBox();
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
	}

	private void onSelectedSongChange() {
		int index = songListDisplay.getSelectedIndex();
		currentSong = songs.get(index);

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
				songs = result;
				List<String> data = new ArrayList<String>();
				for (Song s : result)
					data.add(s.getTitle());
				songListDisplay.setSongs(data);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error fetching songs: " + caught.getMessage());
			}
		});
	}
}
