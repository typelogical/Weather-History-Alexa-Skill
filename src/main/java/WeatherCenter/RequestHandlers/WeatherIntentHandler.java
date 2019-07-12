package com.williamng.weathercenter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.request.Predicates;

import java.util.Optional;
import java.util.Map;
import com.williamng.weathercenter.Message.*;

import com.darkskyapi.*;

public class WeatherIntentHandler implements RequestHandler {
	private MessageBuilder mb;
	public WeatherIntentHandler() {
		super();
		mb = new MessageBuilderImpl();
	}
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("WeatherIntent"));	
	}
	
	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "";
		Map<String, Slot> slots = null;
		try {
			slots = ((IntentRequest) input.getRequestEnvelope().getRequest()).getIntent().getSlots();
			StringBuilder sb = new StringBuilder();
			sb.append("Size of slots: " + slots.size());
			sb.append("\nValues: ");
			for(Slot s : slots.values()) {
				sb.append(s + ", ");	
			}
			speechText = sb.toString() + "\n";
		} catch (Exception e) {
			speechText = e.getStackTrace().toString();
		}
		
		WeatherService service = new WeatherService();
		Weather w = null;
		Location loc = null;
		try {
			if(slots.size() > 0) {
				Slot addrSlot = slots.get("Address");
				Slot dateSlot = slots.get("Date");
				
				if(addrSlot != null && dateSlot != null) {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String s = dateSlot.getValue();
					Date date = df.parse(s);
					loc = LocationBuilder.getLocation(addrSlot.getValue());
					if(loc != null) {
						w = service.getPastWeather(loc, date);
						speechText += mb.getPastWeatherMessage(loc, w, date);
					}
				} else if(addrSlot != null) {
					loc = LocationBuilder.getLocation(addrSlot.getValue());
					if(loc != null) {
						w = service.getCurrentWeather(loc);
						speechText += mb.getCurrentWeatherMessage(loc, w);
					}
				}
			} else {
					loc = LocationBuilder.getLocation("Victorville");
					if(loc != null) {
						w = service.getCurrentWeather(loc);
						speechText += mb.getCurrentWeatherMessage(loc, w);
					}
			}
		} catch(Exception e) {
				speechText = e.toString();
		}
		return input.getResponseBuilder()
			.withSpeech(speechText)
			.build();
	}
}