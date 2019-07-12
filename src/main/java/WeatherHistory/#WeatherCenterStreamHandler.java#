package com.williamng.weathercenter;
import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;

//import com.amazon.ask.helloworld.handlers

public class WeatherHistoryStreamHandler extends SkillStreamHandler {
	private static Skill getSkill() {
		return Skills.standard()
			.addRequestHandlers(
				new LaunchRequestHandler(),
				new HelpIntentHandler(),
				new WeatherIntentHandler(),
				new InsightRequestHandler())
			.build();
	}
	
	public WeatherHistoryStreamHandler() {
		super(getSkill());
	}
}