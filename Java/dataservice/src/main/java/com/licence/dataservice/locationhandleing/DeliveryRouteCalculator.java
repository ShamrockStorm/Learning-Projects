package com.licence.dataservice.locationhandleing;

import com.licence.dataservice.controllers.DirectionsController;
import com.licence.dataservice.controllers.GeolocationController;
import com.licence.dataservice.locationhandleing.route.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRouteCalculator {
    List<Location> locations;
    public List<Route> GetRoutesForDelivery(Integer deliveryId){
        List<Route> routes = new ArrayList();
        return routes;
    }
    public List<Route> GetTestRoutes() throws IOException {
        DirectionsController dir = new DirectionsController();
        locations = new ArrayList<>();
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
    public int[] Kruskal(List<Route> routes){
        routes.sort(Route::compareTo);
        int noDestinations = locations.size();
        double cost = 0.0;
        int[] reached = new int[noDestinations];
        double[] minCost = new double[noDestinations];
        int[] root = new int[noDestinations];
        reached[0] = 1;
        for(int i = 1; i<noDestinations;i++){
            reached[i] = 0;
            for (Route r : routes) {
                if(r.getOrigin().equals(locations.get(0)) && r.getDestination().equals(locations.get(i)))
                    minCost[i] = r.getLength();
            }
            root[i] = 1;
        }
        int y=0;
        int x=0;
        for(int l = 0; l < noDestinations; l++){
            double min = 500.0;
            for(int i = 1; i< noDestinations;i++){
                if(reached[i] == 0 && minCost[i] < min){
                    min = minCost[i];
                    y = i;
                }
            }
            reached[y] = 1;
            x=root[y];
            for (Route r : routes) {
                if(r.getOrigin().equals(locations.get(x)) && r.getDestination().equals(locations.get(y)))
                    cost = cost + r.getLength();
            }
            for(int i = 1; i< noDestinations;i++){
                double curentCost = 0.0;
                for (Route r : routes) {
                    if((r.getOrigin().equals(locations.get(i)) && r.getDestination().equals(locations.get(y)))
                            || (r.getOrigin().equals(locations.get(y)) && r.getDestination().equals(locations.get(i)))) {
                        curentCost = r.getLength();
                    }

                }
                if(reached[i] == 0 && minCost[i] > curentCost){
                    minCost[i] = curentCost;
                    root[i] = y;
                }
            }
        }
        /*
        for (int i : root){
            System.out.println(i);
        }

         */
        return root;
    }
    public List<Route> GetDeliveryRoute() throws IOException {
        List<Route> deliveryRoute = new ArrayList<>();
        List<Route> routes = GetTestRoutes();
        Location currentLocation = locations.get(0);
        int [] visited = new int[locations.size()];
        int locationsVisited = 1;
        while(locationsVisited != locations.size()){
            double minLength = 1000.0;
            Route minRoute = new Route();
            for(Route r : routes){
                if(r.getOrigin() == currentLocation || r.getDestination() == currentLocation){
                    if(r.getLength() < minLength){
                        if(visited[locations.indexOf(r.getOrigin())] == 0 || visited[locations.indexOf(r.getDestination())] == 0) {
                            minLength = r.getLength();
                            minRoute = r;
                        }
                    }
                }
            }
            deliveryRoute.add(minRoute);
            /*
            if(minRoute.getOrigin() == currentLocation) currentLocation = minRoute.getDestination();
            else{ currentLocation = minRoute.getOrigin();
            */
            if(minRoute.getDestination() == currentLocation){
                Location temp = minRoute.getDestination();
                minRoute.setDestination(minRoute.getOrigin());
                minRoute.setOrigin(temp);
            }
            currentLocation = minRoute.getDestination();
            locationsVisited ++;
            visited[locations.indexOf(currentLocation)] = 1;
        }
        /*
        for(Route r : deliveryRoute){
            System.out.println(r.toString());
        }
         */
        return deliveryRoute;
    }
}
