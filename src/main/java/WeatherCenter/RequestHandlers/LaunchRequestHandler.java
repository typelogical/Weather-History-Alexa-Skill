package com.williamng.weathercenter;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import com.darkskyapi.*;
import com.williamng.weathercenter.Message.*;
import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.requestType(LaunchRequest.class));
	}		
	
	/*
		
	*/
	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "Welcom to Weather Center.";
	
		return input.getResponseBuilder()
			.withSpeech(speechText)
			.withSimpleCard("HelloWorld", speechText)
			.withReprompt(speechText)	//TODO: Need to close session
			.build();
	}
}