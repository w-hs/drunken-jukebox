package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

import de.whs.drunkenjukebox.resources.AppConstants;

public class DISliderJQ extends Composite {

	private AppConstants constants = GWT.create(AppConstants.class);
	
	private String id;
	private SliderListener sliderListener;

	public DISliderJQ(String id) {
		this.id = id;
		
		String s = "<div id='"+id+"' style='width: 282px; background: linear-gradient(to right, green , blue);   margin-left: 10px;'></div>";
		//SafeHtml sliderDivSafeHtml = SafeHtmlUtils.fromString(s);
		HTML sliderDiv = new HTML(s);
		
		HorizontalPanel mainPanel = new HorizontalPanel();
		mainPanel.add(sliderDiv);
		

		initWidget(mainPanel);
		
	}

	@Override
	protected void onAttach() {
		
		initSlider(this, id);
	}
	
	public void setSliderListener(SliderListener listener) {
		sliderListener = listener;
	}

	private void onSlide(int s) {
		if(sliderListener != null)
		sliderListener.onSlide(s);
	}

	public void setValue(int val) {
		setSliderValue(id, val);
	}

	public int getValue() {
		return getSliderValue(id);
	}

	private native int getSliderValue(String id)
	/*-{
		var $ = $wnd.jQuery;
		return $("#"+id).slider("value");
	}-*/;

	private native int setSliderValue(String id, int value)
	/*-{
		var $ = $wnd.jQuery;
		return $("#"+id).slider("value", value);
	}-*/;

	private native void initSlider(DISliderJQ x, String identifier)
	/*-{
		var $ = $wnd.jQuery;
		
		$( document ).ready(function() {

			$("#"+identifier)
					.slider(
							{ 	min: 1,
      							max: 100,
								slide : function(event, ui) {
									x.@de.whs.drunkenjukebox.client.voteapp.DISliderJQ::onSlide(I)(ui.value);
								}
							});
							
			
			
			//alert($("#"+identifier));
			//console.log( $("#"+identifier) );
			//setTimeout(function(){console.log($("#"+identifier).slider());},5000);
			
		});
		
	}-*/;

}
