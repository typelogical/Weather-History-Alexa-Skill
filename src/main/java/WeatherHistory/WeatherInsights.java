package com.williamng.weathercenter;

public class WeatherInsights {
	public Integer getPeriod() { return period; }
	public Double getAvgMaxTemp() { return avgMaxTemp;}
	public Double getAvgMinTemp() { return avgMinTemp;}
	public Double getAvgMaxApparentTemp() { return avgMaxApparentTemp;}
	public Double getAvgMinApparentTemp() { return avgMinApparentTemp;}
	public Double getAvgHighTemp() { return avgHighTemp;}
	public Double getAvgLowTemp() { return avgLowTemp;}
	public Integer getRainyDays() { return rainyDays;}
	public Integer getSnowyDays() { return snowyDays;}
	public String getClassifcation() { return classifcation;}
	
	/*
		@param period the number of years data spans
	*/
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public void setAvgMaxTemp(Double avgMaxTemp) { this.avgMaxTemp = avgMaxTemp;}
	public void setAvgMinTemp(Double avgMinTemp) { this.avgMinTemp = avgMinTemp;}
	public void setAvgMaxApparentTemp(Double avgMaxApparentTemp){ this.avgMaxApparentTemp = avgMaxApparentTemp;}
	public void setAvgMinApparentTemp(Double avgMinApparentTemp) { this.avgMinApparentTemp = avgMinApparentTemp;}
	public void setAvgHighTemp(Double avgHighTemp) { this.avgHighTemp = avgHighTemp;}
	public void setAvgLowTemp(Double avgLowTemp) { this.avgLowTemp = avgLowTemp;}
	public void setRainyDays(Integer rainyDays) { this.rainyDays = rainyDays;}
	public void setSnowyDays(Integer snowyDays) { this.snowyDays = snowyDays;}
	public void setClassifcation(String classification) { this.classifcation = classifcation;}
	
	private Integer period;
	//private Integer maxTemp;
	private Integer minTemp;
	private Double avgMaxTemp;
	private Double avgMinTemp;
	private Double avgMaxApparentTemp;
	private Double avgMinApparentTemp;
	private Double avgHighTemp;
	private Double avgLowTemp;
	private Integer rainyDays;
	private Integer snowyDays;
	private String classifcation;
}