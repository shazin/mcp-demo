package com.medium.shazinsadakath.mcp.server.demo.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Tool(description = "Get weather information by city name")
    public String getWeather(String cityName) {
        return "The weather in " + cityName + " is sunny with a temperature of "+ (Math.random() * 1 + 25) +"°C.";
    }
}