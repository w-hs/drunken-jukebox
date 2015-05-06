package de.whs.drunkenjukebox.client.admin.presenter;

import java.util.ArrayList;
import java.util.List;

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
		Widget asWidget();
		void setSongs(List<String> songs);
	}
	
	public interface SongDetailDisplay {
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
		// TODO Auto-generated method stub
		
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
