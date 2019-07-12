package com.williamng.weatherHistory;
import java.util.Date;
import java.util.ArrayList;

import com.darkskyapi.WeatherServiceImpl;
import com.darkskyapi.Location;
import com.darkskyapi.Weather;
import com.darkskyapi.DailyWeather;
import com.darkskyapi.DailyWeather.WeatherField;

//import org.dom4j.util.IndexedElement;
public class WeatherService {
	com.darkskyapi.WeatherService service;
	public WeatherService() {
		service = new WeatherServiceImpl();
	}
	
	public Weather getCurrentWeather(Location loc) throws Exception{
		Weather w = null;
		w = service.getCurrentWeather(loc);
		return w;
	}
	
	public Weather getPastWeather(Location loc, Date date) throws Exception {
		Weather w = null;
		w = service.getPastWeather(loc, date);
		return w;
	}
	
	public WeatherInsights getWeatherInsights(Location loc) throws Exception {
		int years = 20;
		Date d = new Date();
		int year = d.getYear();
		Double 
			avgMaxTemp = 0.0,
			avgMinTemp = 0.0,
			avgMaxApparentTemp = 0.0,
			avgMinApparentTemp = 0.0,
			avgHighTemp = 0.0,
			avgLowTemp =  0.0;
		ArrayList<DailyWeather> dwList = new ArrayList();
		for(int i = 1; i < years; ++i) {
			d.setYear(year - i);
			DailyWeather dw = service.getDailyWeather(loc, d);
			System.out.println(dw);
			dwList.add(dw);
			
		}
		
		//System.out.println("Log: dwList size: " + dwList.size());
		
		avgMaxTemp = calcAvg(dwList, WeatherField.TEMP_MAX);
		avgMinTemp = calcAvg(dwList, WeatherField.TEMP_MIN);
		avgMaxApparentTemp = calcAvg(dwList, WeatherField.APPARENT_TEMP_MAX);
		avgMinApparentTemp = calcAvg(dwList, WeatherField.APPARENT_TEMP_MIN);
		avgHighTemp = calcAvg(dwList, WeatherField.TEMP_HIGH);
		avgLowTemp = calcAvg(dwList, WeatherField.TEMP_LOW);
		
		WeatherInsights insights = new WeatherInsights();
		insights.setPeriod(years);
		insights.setAvgMaxTemp(avgMaxTemp);
		insights.setAvgMinTemp(avgMinTemp);
		insights.setAvgMaxApparentTemp(avgMaxApparentTemp);
		insights.setAvgMinApparentTemp(avgMinApparentTemp);
		//insights.setAvgHighTemp(avgHighTemp);
		//insights.setAvgLowTemp(avgLowTemp);
		
		return insights;
		
	}
	
	private Double calcAvg(ArrayList<DailyWeather> dwList, WeatherField field) {
		int count = 0;
		double sum = 0.0;
		for(DailyWeather dw : dwList) {
			Object obj = dw.get(field);
			if(obj != null) {
				++count;
				sum += (Double) obj;
			}
		}
		return sum / count;
	}
}