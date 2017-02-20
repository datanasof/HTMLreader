package server;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.io.*;

public class URLRead {
	//public static String url = "https://www.thomann.de/de/antelope_goliath.htm";
	
	public static String getHTML(String url) throws IOException{
		URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        inputLine = in.readLine();
        in.close();
        return inputLine;
	}
	
	private static final Pattern TAG_REGEX = Pattern.compile("<div class=\"rank\">(.+?)<\\/div>");

	private static List<String> getTagValues(final String str) {
	    final List<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = TAG_REGEX.matcher(str);
	    while (matcher.find()) {
	        tagValues.add(matcher.group(1));
	    }
	    return tagValues;
	}
	
	public static String getRating(String url) throws IOException{        
		String str = getHTML(url);
		List<String> deviceRating = new ArrayList<String>();
		deviceRating = getTagValues(str);
		String result = ("Category ranking: " + deviceRating.get(0) + ", Website ranking: " + deviceRating.get(1));
		return result;
	}

	
}