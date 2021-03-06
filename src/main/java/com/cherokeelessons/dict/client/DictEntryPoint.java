package com.cherokeelessons.dict.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.fusesource.restygwt.client.Defaults;

import com.cherokeelessons.dict.shared.Log;
import com.cherokeelessons.dict.shared.RestApi;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.Scheduler;
import com.google.web.bindery.event.shared.EventBus;

public class DictEntryPoint implements EntryPoint {

	public static RestApi api = GWT.create(RestApi.class);

	public static final EventBus eventBus = new DeferredEventBus();

	private final Logger logger = Log.getGwtLogger(new ConsoleLogHandler2(), this.getClass().getSimpleName());

	public DictEntryPoint() {

	}

	static {
		Defaults.setRequestTimeout(120 * 1000);
	}

	private UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {
		private final Logger logger = Log.getGwtLogger(new ConsoleLogHandler2(), this.getClass().getSimpleName());

		@Override
		public void onUncaughtException(Throwable e) {
			if (e != null) {
				logger.log(Level.SEVERE, "onUncaughtException", e);
			}
			logger.log(Level.SEVERE, "onUncaughtException: NULL!");
		}
	};

	private native void error(String message) /*-{
												$wnd.console.error(message);
												}-*/;

	@Override
	public void onModuleLoad() {
		// GWT.setUncaughtExceptionHandler(handler);
		logger.log(Level.INFO, "DictionaryApplication#");
		DictionaryApplication app = new DictionaryApplication();
		Scheduler.get().scheduleDeferred(app);
	}
}
