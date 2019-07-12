#Weather Center

---

Author: William Ng
Date: 11-22-18
Version: 0.1

##Description:
Yes, Alexa's built-in weather skill is fine for most days and most people. You ask it for the weather, and
it replies with the current temperature and forcast for the day. This will allow you just enough to decide
what to wear, change your plans, or just give you confirmation to what your body is already telling you. 
If you have a curious mine like the author of this program, you might be intrested in more obsucre details,
such as how the temperature today compares with the same day a year ago, or what the average temperature 
for this day in the area is. With this skill you can do more then verify the current temperature -- 
you can verify also global warming trends. 

##Requirements

*R1. Ask weather for the day

*R2. Ask for weather for current day
	R2.1 Average Temperature
		Should be limited to last 20 years to reduce the number of api request
	R2.2 Compare temperatures
		Should be able to compare today's temperature with any past date( up to the date supported by api)
	R2.3 Ask for record Temp for today
		Should be limited to last 20 years to reduce the number of api request
	R2.4 Ask for verbose info
		Should be able to list all available info on curert day
	R2.5 On this day weather fact [tentative]
		Should be able to generate a radonom fact about today's weather
