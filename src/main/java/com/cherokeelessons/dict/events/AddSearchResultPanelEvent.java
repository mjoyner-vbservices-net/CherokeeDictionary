package com.cherokeelessons.dict.events;

import org.gwtbootstrap3.client.ui.Panel;

import com.google.web.bindery.event.shared.binder.GenericEvent;

public class AddSearchResultPanelEvent extends GenericEvent {
	public final Panel p;
	public AddSearchResultPanelEvent(Panel p) {
		this.p=p;
	}
}
