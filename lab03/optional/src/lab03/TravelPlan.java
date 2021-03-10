package lab03;

import java.util.*;

public class TravelPlan {
        City city;
        private List<Location> preferences = new ArrayList<>();

        public TravelPlan(City city) { this.city = city; }
        public TravelPlan(City city, List<Location> preferences) {
                this.city = city;
                this.preferences = preferences;
        }

        public void addPreference(Location preference) { preferences.add(preference); }
        public List<Location> getPreferences() { return preferences; }

        public static City calculateShortestPathFromSource(City city, Location startLocation) {
                startLocation.setDistance(0);

                Set<Location> settledLocations = new HashSet<>();
                Set<Location> unsettledLocations = new HashSet<>();

                unsettledLocations.add(startLocation);
                while(unsettledLocations.size() != 0) {
                        Location currentLocation = getLowestDistanceLocation(unsettledLocations);
                        unsettledLocations.remove(currentLocation);
                        for (Map.Entry<Location, Integer> adjancencyPair : currentLocation.getCost().entrySet()) {
                                Location adjacentLocation = adjancencyPair.getKey();
                                Integer roadCost = adjancencyPair.getValue();
                                if (!settledLocations.contains(adjacentLocation)) {
                                        calculateMinimumDistance(adjacentLocation, roadCost, currentLocation);
                                        unsettledLocations.add(adjacentLocation);
                                }
                        }
                        settledLocations.add(currentLocation);
                }
                return city;
        }

        private static Location getLowestDistanceLocation(Set <Location> unsettledLocations) {
                Location lowestDistanceLocation = null;
                int lowestDistance = Integer.MAX_VALUE;
                for(Location location : unsettledLocations) {
                        int locationDistance = location.getDistance();
                        if(locationDistance < lowestDistance) {
                                lowestDistance = locationDistance;
                                lowestDistanceLocation = location;
                        }
                }
                return lowestDistanceLocation;
        }

        private static void calculateMinimumDistance(Location evaluationLocation, Integer roadCost, Location startLocation){
                Integer startDistance = startLocation.getDistance();
                if(startDistance + roadCost < evaluationLocation.getDistance()) {
                        evaluationLocation.setDistance(startDistance + roadCost);
                        LinkedList <Location> shortestPath = new LinkedList<> (startLocation.getShortestPath());
                        shortestPath.add(startLocation);
                        evaluationLocation.setShortestPath(shortestPath);
                }
        }

        public void showTravel() {
                for (Location node : city.getNodes()) {
                        for(Map.Entry<Location, Integer> entry : node.getCost().entrySet()) {
                                System.out.println(entry.getValue());
                        }
                }
        }
        public static void calculateShortestPath(City city, TravelPlan t1, Location l1, Location l2) {
                List<String> locations = new ArrayList<>();
                TravelPlan.calculateShortestPathFromSource(city, l1);
                locations.add(l1.getName());
                for(Location location : t1.getPreferences()) {
                        locations.add(location.getName());
                        TravelPlan.calculateShortestPathFromSource(city, location);
                }

                for(String location : locations) {
                        System.out.print(location + " -> ");
                }
                System.out.println(l2.getName());
        }

}
