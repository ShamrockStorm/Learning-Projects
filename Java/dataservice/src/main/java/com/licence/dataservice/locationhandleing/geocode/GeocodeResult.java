package com.licence.dataservice.locationhandleing.geocode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class GeocodeResult {
    List<GeocodeObject> results;
    String status;
    public GeocodeResult() {
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<GeocodeObject> getResults() {
        return results;
    }
    public void setResults(List<GeocodeObject> results) {
        this.results = results;
    }
}
