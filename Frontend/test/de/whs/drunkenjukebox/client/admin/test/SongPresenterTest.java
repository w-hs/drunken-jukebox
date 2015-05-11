package de.whs.drunkenjukebox.client.admin.test;

import static org.easymock.EasyMock.createStrictMock;
import junit.framework.TestCase;

import org.junit.Test;

import de.whs.drunkenjukebox.client.admin.SongsServiceAsync;
import de.whs.drunkenjukebox.client.admin.presenter.SongPresenter;

public class SongPresenterTest extends TestCase {
	
	private SongPresenter songPresenter;
	private SongsServiceAsync mockRpcService;
	private SongPresenter.SongListDisplay mockSongListDisplay;
	private SongPresenter.SongDetailDisplay mockSongDetailDisplay;
	
	protected void setUp() {
		mockRpcService = createStrictMock(SongsServiceAsync.class);
		mockSongListDisplay = createStrictMock(SongPresenter.SongListDisplay.class);
		mockSongDetailDisplay = createStrictMock(SongPresenter.SongDetailDisplay.class);
		songPresenter = new SongPresenter(mockRpcService, mockSongListDisplay, mockSongDetailDisplay);
	}

	@Test
	public void test() {
//		songPresenter.
		assertNotNull(songPresenter);
		
	//	fail("Not yet implemented");
	}

}
