package scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cse131.ArgsProcessor;

public class Weather {
	
	public static void main(String[] args) throws IOException {
		ArgsProcessor ap = new ArgsProcessor(args);
			
		String zip = ap.nextString("What zip code?");
		
		Document doc = Jsoup.connect("http://www.wunderground.com/cgi-bin/findweather/getForecast?query="+zip).get();
		String wholeThing = doc.toString();
		//
		// Get rid of the print of the whole thing
		//
		// System.out.println(wholeThing);
		//
		// and instead do string searching and trimming 
		// to isolate the temperature reading
		// report that as your output
		//
		int indexw = wholeThing.indexOf("</span> <span _ngcontent-c15=\"\" class=\"wu-label\">");
		String weather = wholeThing.substring(indexw-2, indexw);
		
		System.out.println("Temperature is " + weather); // FIXME
		//
		// And find one more statistic of interest and report that:
		//
		
		int indexl = wholeThing.indexOf("<i _ngcontent-c2=\"\" class=\"fi-star favorite-star\"></i>");
		String location = wholeThing.substring(indexl-20, indexl);
		int indexsub = location.indexOf(">");
		location = location.substring(indexsub+1);
		
		System.out.println("And the location is " + location);  // FIXME

	}

}
