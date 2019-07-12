package com.williamng.weathercenter;
import java.util.Date;

import java.io.PrintStream;
import java.util.ResourceBundle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


import com.darkskyapi.*;
import com.williamng.weathercenter.Message.*;
//import com.darkskyapi.WeatherServiceImpl;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherCenterServiceTest {

	protected static final ResourceBundle testMessages = ResourceBundle.getBundle("testMessages");

	@Captor
	private ArgumentCaptor<String> captorLoggingMessage;

	PrintStream errorStream;
	PrintStream loggingStream;

	//@Test
	public void testGetCurrentWeather() {
		com.williamng.weathercenter.WeatherService service = new com.williamng.weathercenter.WeatherService();
		Location loc = new Location("Universal City",32.003224,-102.065779);
		Weather w = null;
		try {
		w = service.getCurrentWeather(loc);
		
		} catch(Exception e) {
			e.printStackTrace();	
		}
		System.out.println(w);
		//verify(loggingStream, atLeastOnce()).println(captorLoggingMessage.capture());
		//final String loggingMessage = captorLoggingMessage.getValue();
	}
	
	//@Test
	public void testCurrentWeatherMessageBuilder() {
		com.williamng.weathercenter.WeatherService service = new com.williamng.weathercenter.WeatherService();
		MessageBuilderImpl mb = new MessageBuilderImpl();
		Weather w = new Weather();
		try {
		Location loc = LocationBuilder.getLocation("Victorville");
		w = service.getCurrentWeather(loc);String msg = mb.getCurrentWeatherMessage(loc, w);
		System.out.println(msg);
		} catch(Exception e) {
			e.printStackTrace();	
		}
		
	}
	
	//@Test
	public void testPastWeatherMessageBuilder() {
		com.williamng.weathercenter.WeatherService	service = new com.williamng.weathercenter.WeatherService();
		MessageBuilderImpl mb = new MessageBuilderImpl();
		Weather w = null;
		try {
			//Location loc = LocationBuilder.getLocation("Oxford, Misisippi");
			Location loc = LocationBuilder.getLocation("Dallas, Texas");
			//System.out.println(loc);
			Date d = new Date(85, 8, 15); // Sep, 15, 1985
			w = service.getPastWeather(loc, d);
			String msg = mb.getPastWeatherMessage(loc, w, d);
			System.out.println(msg);
		} catch(Exception e) {
			e.printStackTrace();	
		}
	}
	
	@Test
	public void testWeatherInsightsMessageBuilder() {
		com.williamng.weathercenter.WeatherService	service = new com.williamng.weathercenter.WeatherService();
		MessageBuilderImpl mb = new MessageBuilderImpl();
		WeatherInsights i = null;
		try {
			//Location loc = LocationBuilder.getLocation("Oxford, Misisippi");
			Location loc = LocationBuilder.getLocation("Victorville");
			System.out.println(loc);
			i = service.getWeatherInsights(loc);
			String msg = mb.getWeatherInsightsMessage(loc, i);
			System.out.println(msg);
		} catch(Exception e) {
			e.printStackTrace();	
		}
	}
	public void testAppWithName() {
		/*
		App.main(new String[] {"John"});

		verify(loggingStream, atLeastOnce()).println(captorLoggingMessage.capture());
		final String loggingMessage = captorLoggingMessage.getValue();
		assertEquals("[main] INFO App - Hello John! /by " + testMessages.getString("artifactId"), loggingMessage);
	*/
	}
void testWeather() {
		
	}
	@Before
	public void setUp() {
		errorStream = System.err;
		loggingStream = spy(errorStream);
		System.setErr(loggingStream);
	}

	@After
	public void tearDown() {
		System.setErr(errorStream);
	}

}
