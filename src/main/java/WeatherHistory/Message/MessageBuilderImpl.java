package com.williamng.weathercenter.Message;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.NumberFormat;

import com.darkskyapi.Location;
import com.darkskyapi.Weather;

import com.williamng.weathercenter.WeatherInsights;

public class MessageBuilderImpl implements MessageBuilder {
		
	public String getCurrentWeatherMessage(Location loc, Weather w) {
		if(loc == null || w == null) return null;
		StringBuilder sb = new StringBuilder();
		sb.append("In ");
		sb.append(loc.getAddress());
		sb.append(", it is " + formatPercent(w.getTemperature()) + " degrees");
		sb.append(", but feels like " + formatPercent(w.getApparentTemperature()) + " degrees");
		sb.append(", with humidity of " + toPercent(w.getHumidity()));
		sb.append(", a precipitation probablity of " + toPercent(w.getPrecipProbability()));
		sb.append(", a wind direction of " + toWindDirection(w.getWindBearing()));
		sb.append(", a wind speed of " + toMilesPerHour(w.getWindSpeed()));
		sb.append(", and cloud cover of " + toPercent(w.getCloudCover()) + ".");
		return sb.toString();
	}
	
	public String getPastWeatherMessage(Location loc, Weather w, Date date) {
		if(loc == null || w == null || date == null) return null;
		StringBuilder sb = new StringBuilder();
		sb.append("In ");
		sb.append(loc.getAddress());
		sb.append(", on " + toDateStr(date));
		sb.append(", it was " + formatPercent(w.getTemperature()) + " degrees");
		sb.append(", but felt like " + formatPercent(w.getApparentTemperature()) + " degrees");
		sb.append(", with humidity of " + toPercent(w.getHumidity()));
		sb.append(", a precipitation probablity of " + toPercent(w.getPrecipProbability()));
		sb.append(", a wind direction coming from " + toWindDirection(w.getWindBearing()));
		sb.append(", a wind speed of " + toMilesPerHour(w.getWindSpeed()));
		sb.append(", and cloud cover of " + toPercent(w.getCloudCover())+ ".");
		return sb.toString();
	}
	
	public String getWeatherInsightsMessage(Location loc, WeatherInsights i) {
		if(loc == null || i == null) return null;
		StringBuilder sb = new StringBuilder();
		sb.append("During the past " + i.getPeriod() + " years of today in" + loc.getAddress());
		sb.append(", average max temperature was " + formatPercent(i.getAvgMaxTemp()));
		sb.append(", average minimum temperature was " + formatPercent(i.getAvgMinTemp()));
		sb.append(", average max apparent temperature was " + formatPercent(i.getAvgMaxApparentTemp()));
		sb.append(", and average minimum apparent temperature was " + formatPercent(i.getAvgMinApparentTemp()) + ".");
		return sb.toString();
	}
	/*
	pulic bString getPastWeatherMessage(Date d, Weather w);
	public String getWeatherForacst(Date d, WeatherForcast w);
	public String getCompareCurrentWeatherMessage(Weather curr, Weather past);
	*/
	private Object formatPercent(Double val) {
		return Math.round(val);
	}
	private String toPercent(double val) {
		NumberFormat fmt = NumberFormat.getInstance();
		fmt.setMaximumFractionDigits(2);
		return fmt.format(val * 100) + " percent";
	}
	
	private String toMilesPerHour(double val) {
		return val + " miles per hour";	
	}
	
	private String toWindDirection(double val) {
		return val + " degrees north";
	}
	
	private String toDateStr(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//System.out.println(cal);
		Locale locale = Locale.ENGLISH;
		String dateStr = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, locale)
			+ ", " + cal.get(Calendar.DAY_OF_MONTH)
			+ ", " + cal.get(Calendar.YEAR);
		return dateStr;
	}
}