package com.licence.dataservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.licence.dataservice.locationhandleing.geocode.GeocodeResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class GeolocationController {
    String key = "AIzaSyDTCGpIPqgSsuW0v4SQ5iMs18bBRxmVo-I";

    @RequestMapping(path = "/geocode", method = RequestMethod.GET )
    public GeocodeResult getGeocode(@RequestParam String address) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/geocode/json?language=en&address=" + encodedAddress +"&key="+key)
                .get()
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ObjectMapper objectMapper = new ObjectMapper();
        GeocodeResult result = objectMapper.readValue(responseBody.string(), GeocodeResult.class);
        System.out.println(request.toString());
        //return responseBody.string();
        return result;
    }
}
