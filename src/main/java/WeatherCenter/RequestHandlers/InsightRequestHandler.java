package com.williamng.weathercenter;
import java.util.Date;
import java.text.DateFormat;

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
import com.williamng.weathercenter.WeatherInsights;

public class InsightRequestHandler implements RequestHandler {
	private MessageBuilder mb;
	
	public InsightRequestHandler() {
		super();
		mb = new MessageBuilderImpl();
	}
	
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("InsightIntent"));
	}
	
	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "";
		WeatherInsights i = null;
		Map<String, Slot> slots = null;
		WeatherService service = new WeatherService();
		Location loc = null;
		try {
			slots = ((IntentRequest) input.getRequestEnvelope().getRequest()).getIntent().getSlots();
			if(slots.size() > 0) {
				// Use the provided location
				Slot addrSlot = slots.get("Address");
				if(addrSlot != null) {
					loc = LocationBuilder.getLocation(addrSlot.getValue());
					if(loc != null) {
						i = service.getWeatherInsights(loc);
						speechText += mb.getWeatherInsightsMessage(loc, i);
					}
				}
			} else {
				// use users current location
				loc = LocationBuilder.getLocation("Victorville");
				i = service.getWeatherInsights(loc);
				speechText += mb.getWeatherInsightsMessage(loc, i);
			}
		} catch (Exception e) {
			speechText = e.toString();	
		}
		
		return input.getResponseBuilder()
				.withSpeech(speechText)
				.build();
	}
}