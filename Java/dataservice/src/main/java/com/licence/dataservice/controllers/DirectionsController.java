package com.licence.dataservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.licence.dataservice.locationhandleing.Location;
import com.licence.dataservice.locationhandleing.geocode.GeocodeResult;
import com.licence.dataservice.locationhandleing.route.Route;
import com.licence.dataservice.locationhandleing.route.RouteResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DirectionsController {
    String key = "AIzaSyDTCGpIPqgSsuW0v4SQ5iMs18bBRxmVo-I";
    double originLatitude;
    double originLongitude;
    double destinationLatitude;
    double destinationLongitude;

    @RequestMapping(path = "/route", method = RequestMethod.GET )
    public Double RouteLegthRequest(@RequestParam double originLatitude, @RequestParam double originLongitude, @RequestParam double destinationLatitude, @RequestParam double destinationLongitude )throws IOException {
        Double length = 0.0;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/directions/json?destination=" + destinationLatitude +
                        ","+ destinationLongitude + "&origin=" + originLatitude +
                        ","+ originLongitude+"&key="+key)
                .get()
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ObjectMapper objectMapper = new ObjectMapper();
        RouteResult result = objectMapper.readValue(responseBody.string(), RouteResult.class);
        String lengthString = result.getRoutes().get(0).getLegs().get(0).getDistance().getText();
        lengthString = lengthString.substring(0,lengthString.length()-2);
        length = Double.parseDouble(lengthString);
        System.out.println(length);
        return length;
    }

    public Route GetRoute(Location origin, Location destination) throws IOException {
        Route route = new Route();
        route.setOrigin(origin);
        route.setDestination(destination);
        Double length = 0.0;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/directions/json?destination=" + destination.getLng() +
                        ","+ destination.getLat() + "&origin=" + origin.getLng() +
                        ","+ origin.getLat()+"&key="+key)
                .get()
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ObjectMapper objectMapper = new ObjectMapper();
        RouteResult result = objectMapper.readValue(responseBody.string(), RouteResult.class);
        String lengthString = result.getRoutes().get(0).getLegs().get(0).getDistance().getText();
        lengthString = lengthString.substring(0,lengthString.length()-2);
        length = Double.parseDouble(lengthString);
        System.out.println(length);
        route.setLength(length);
        return route;
    }
}

