package com.williamng.weathercenter.Message;
import java.util.Date;

import com.darkskyapi.Location;
import com.darkskyapi.Weather;

import com.williamng.weathercenter.WeatherInsights;

public interface MessageBuilder {
		
	public String getCurrentWeatherMessage(Location loc, Weather w);
	/*
	public String getPastWeatherMessage(Date d, Weather w);
	public String getWeatherForacst(Date d, WeatherForcast w);
	public String getCompareCurrentWeatherMessage(Weather curr, Weather past);
	*/
	public String getPastWeatherMessage(Location loc, Weather w, Date date);
	
	public String getWeatherInsightsMessage(Location loc, WeatherInsights i);
}