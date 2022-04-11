package com.licence.dataservice.locationhandleing;

import com.licence.dataservice.controllers.DirectionsController;
import com.licence.dataservice.controllers.GeolocationController;
import com.licence.dataservice.locationhandleing.route.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRouteCalculator {
    public List<Route> GetRoutesForDelivery(Integer deliveryId){
        List<Route> routes = new ArrayList();
        return routes;
    }
    public List<Route> GetTestRoutes() throws IOException {
        DirectionsController dir = new DirectionsController();
        List<Location> locations = new ArrayList<>();
        Location warehouse = new Location(44.877526,24.854863); // Strada Depozitelor
        Location loc1 = new Location(44.864840,24.862019); //In nord, spitalul militar
        Location loc2 = new Location(44.863562,24.875752); // Calea Bucuresti
        Location loc3 = new Location(44.851789,24.877984); // Parc Electrica
        Location loc4 = new Location(44.854165,24.880826); // UPIT
        locations.add(warehouse);
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        List<Route> routes = new ArrayList<>();
        for(int i=0; i<locations.size()-1;i++)
            for(int j=i+1; j<locations.size(); j++){
                //System.out.println(locations.get(i).toString());
                //System.out.println(locations.get(j).toString());
                Route route = dir.GetRoute(locations.get(i),locations.get(j));
                routes.add(route);
            }
        return routes;
    }
    public void GetDeliveryRoute() throws IOException {
        List<Route> deliveryRoute = new ArrayList<>();
        List<Route> routes = GetTestRoutes();
        for (Route r : routes) {
            System.out.println(r.toString());
        }
        //return deliveryRoute;
    }
}
