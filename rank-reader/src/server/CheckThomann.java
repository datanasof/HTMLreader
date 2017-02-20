package server;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CheckThomann {
		
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		HashMap<String, ArrayList<String>> products = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> orionStudio = new ArrayList<String>();
		orionStudio.add("https://www.thomann.de/gb/antelope_orion_studio.htm?ref=search_rslt_orion+studio_376045_0");
		orionStudio.add(" ");
		
		ArrayList<String> goliath = new ArrayList<String>();
		goliath.add("https://www.thomann.de/gb/antelope_goliath.htm?ref=search_rslt_goliath_385579_0");
		goliath.add(" ");
		
		ArrayList<String> zenTour = new ArrayList<String>();
		zenTour.add("https://www.thomann.de/gb/antelope_zen_tour.htm?ref=search_rslt_zen+tour_385578_0");
		zenTour.add(" ");
		
		products.put("OrionStudio.txt", orionStudio);
		products.put("Goliath.txt", goliath);
		products.put("ZenTour.txt", zenTour);
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		
		while(true){
			for (Map.Entry<String, ArrayList<String>> entry : products.entrySet())
			{
			    String url=entry.getValue().get(0);
			    String path=entry.getKey();
			    String ranking=entry.getValue().get(1);
				RankingBot bot = new RankingBot(url, path, ranking);
				Future f = executor.submit(bot);
				String result = (String) f.get();
				if (!result.equals("")){
					ArrayList<String> x = new ArrayList<String>();
					x.add(url);
					x.add(result);
					products.put(path, x);
				}				
			}
			TimeUnit.SECONDS.sleep(300);
		}
	}
	
	
}
