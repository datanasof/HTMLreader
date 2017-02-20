package server;

import java.io.IOException;
import java.util.concurrent.Callable;

public class RankingBot implements Callable<String>{
	private final String url;
	private final String filePath;
	private String ranking;	
	
	public RankingBot (String url, String path, String ranking){
		this.url = url;
		this.filePath = path;
		this.ranking = ranking;
	}

	@Override
	public String call() throws Exception {
		try {
			String ranking1 = URLRead.getHTML(url);
			if (!ranking1.equals(ranking)){
				WriteToFile.write(filePath, ranking1);
				return ranking1;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
