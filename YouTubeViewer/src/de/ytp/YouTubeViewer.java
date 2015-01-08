package de.ytp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;
import org.json.*;


public class YouTubeViewer {

	private static String playingSong = "";

public static void main(String[] args) {

    NativeInterface.open();
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame frame = new JFrame("YouTube Viewer");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.getContentPane().add(getBrowserPanel(), BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        }
    });
    NativeInterface.runEventPump();
    // don't forget to properly close native components
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
            NativeInterface.close();
        }
    }));
}

public static JPanel getBrowserPanel() {
    JPanel webBrowserPanel = new JPanel(new BorderLayout());
    final JWebBrowser webBrowser = new JWebBrowser();
    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
    webBrowser.setBarsVisible(false);
    //webBrowser.navigate("https://www.youtube.com/v/b-Cr0EWwaTk?fs=1&autoplay=1");
    webBrowser.navigate("");
    
//    new Thread(
//            new Runnable() {
//                public void run() {
//                    try {
//                        Thread.sleep(5 * 1000);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                   
//                    NativeInterface.open(); // not sure what else may be needed for this
//
//                    SwingUtilities.invokeLater(new Runnable() {
//                      public void run() {
//                    	  webBrowser.navigate("https://www.youtube.com/v/gw6FlztSV1Y?fs=1&autoplay=1");
//                      }
//                    });
//                    NativeInterface.runEventPump();
//                }
//   }).start();
    
    
    new Thread(
            new Runnable() {
                public void run() {
                	
                	while(true)
                	{
                	
                		 try {
                             Thread.sleep( 1000);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                		
						try {
							String webPage = "http://localhost:8080/rest/dj/party/currentSong";
							String name = "guest";
							String password = "geheim";
						
							String authString = name + ":" + password;
							//System.out.println("auth string: " + authString);
							byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
							String authStringEnc = new String(authEncBytes);
							//System.out.println("Base64 encoded auth string: " + authStringEnc);
						
							URL url = new URL(webPage);
							URLConnection urlConnection = url.openConnection();
							urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
							InputStream is = urlConnection.getInputStream();
							InputStreamReader isr = new InputStreamReader(is);
						
							int numCharsRead;
							char[] charArray = new char[1024];
							StringBuffer sb = new StringBuffer();
							while ((numCharsRead = isr.read(charArray)) > 0) {
								sb.append(charArray, 0, numCharsRead);
							}
							String result = sb.toString();
						
							//System.out.println("*** BEGIN ***");
							//System.out.println(result);
							//System.out.println("*** END ***");
							JSONObject obj = new JSONObject(result);
							String Yurl = obj.getJSONObject("source").getString("url");
							
							
							if(!Yurl.equals(playingSong))
							{
								playingSong = Yurl;
								NativeInterface.open(); // not sure what else may be needed for this
	
				                    SwingUtilities.invokeLater(new Runnable() {
				                      public void run() {
				                    	  webBrowser.navigate(playingSong+"?fs=1&autoplay=1");
				                      }
				                    });
				                NativeInterface.runEventPump();
			                
							}
							
							
						} catch (Exception e) {
							e.printStackTrace();
						} 
                	}
	           }
	   }).start();
    
    
    
    
    
    
    
    return webBrowserPanel;
}
	
	
}
