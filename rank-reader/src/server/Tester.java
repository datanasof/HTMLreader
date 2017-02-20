package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tester {

	
	public static void main(String[] args) throws IOException {
		HashMap<String, ArrayList<String>> products = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> orionStudio = new ArrayList<String>();
		orionStudio.add("https://www.thomann.de/gb/antelope_orion_studio.htm?ref=search_rslt_orion+studio_376045_0");
		orionStudio.add(" ..");
		
		ArrayList<String> goliath = new ArrayList<String>();
		goliath.add("https://www.thomann.de/gb/antelope_goliath.htm?ref=search_rslt_goliath_385579_0");
		goliath.add(" ..");
		
		ArrayList<String> zenTour = new ArrayList<String>();
		zenTour.add("https://www.thomann.de/gb/antelope_zen_tour.htm?ref=search_rslt_zen+tour_385578_0");
		zenTour.add(" ..");
		
		products.put("OrionStudio.txt", orionStudio);
		products.put("Goliath.txt", goliath);
		products.put("ZenTour.txt", zenTour);
		
		for (Map.Entry<String, ArrayList<String>> entry : products.entrySet())
		{
		    
			//RankingBot bot = new RankingBot(url, path, ranking)
			System.out.println(entry.getValue().get(0) + "/" + entry.getKey() + "/" + entry.getValue().get(1));
		}
		
		
	}
}
