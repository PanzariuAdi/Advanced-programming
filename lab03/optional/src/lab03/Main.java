package lab03;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
		City Miami = new City();

		// Create locations and add it to the city created.
    	Hotel v1 = new Hotel();
		v1.setName("Phoenix I");
		Miami.addNode(v1);

		Museum v2 = new Museum();
		v2.setName("Museum A");
		v2.setTicketPrice(10.5);
		v2.setOpenTime(v2.DefaultOpenTime());
		v2.setCloseTime(v2.DefaultCloseTime());
		Miami.addNode(v2);

		Museum v3 = new Museum();
		v3.setName("Museum B");
		v3.setTicketPrice(12.5);
		v3.setOpenTime(v3.DefaultOpenTime());
		v3.setCloseTime(v3.DefaultCloseTime());
		Miami.addNode(v3);

		Church v4 = new Church();
		v4.setName("Church A");
		v4.setOpenTime(LocalTime.of(7,0));
		v4.setCloseTime(LocalTime.of(22,30));
		Miami.addNode(v4);

		Church v5 = new Church();
		v5.setName("Church B");
		v5.setOpenTime(LocalTime.of(7,30));
		v5.setCloseTime(LocalTime.MIDNIGHT);
		Miami.addNode(v5);

		Restaurant v6 = new Restaurant();
		v6.setName("Restaurant");
		v6.setOpenTime(v6.DefaultOpenTime());
		v6.setCloseTime(v6.DefaultCloseTime());
		Miami.addNode(v6);

		//Set the costs necessary to reach from a destination to another
		v1.setCost(v2, 10);
		v1.setCost(v3, 50);
		v2.setCost(v3, 20);
		v2.setCost(v4, 20);
		v2.setCost(v5, 10);
		v3.setCost(v2, 20);
		v3.setCost(v4, 20);
		v4.setCost(v5, 30);
		v4.setCost(v6, 10);
		v5.setCost(v4, 30);
		v5.setCost(v6, 20);

		// Create Travel plan and add preferences
		TravelPlan t1 = new TravelPlan(Miami);
		t1.addPreference(v2);
		t1.addPreference(v5);

		//Calculate shortest path between locations v1 and v6 throw preference locations.
		calculateShortestPath(Miami, t1, v1, v6);

		Duration program = Duration.ZERO;
		program = Visitable.getVisitingDuration(program, v4);
		System.out.println(program);
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
