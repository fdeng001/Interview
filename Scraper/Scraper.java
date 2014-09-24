package Scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.*;
import java.io.*;

public class Scraper {
	public static void main(String[] args) {
		if (args.length == 0 || args.length > 2) {
			System.out.println("Please input valid parameters.");
			return;
		}
		/* when one arguments are provided,
		 * return result number
		 */
		if (args.length == 1) {
			int num_results = Scraper.ResultNumber(args[0]);
			if (num_results == 0) {
				System.out.println("No results found.");
			} else {
				System.out.println("Number of results is : " + num_results);
			}
		}
		
		/* when two arguments are provided,
		 * return result objects for the specific page
		 */
		
		if (args.length == 2) {
			try {
				int num_results = Scraper.ResultNumber(args[0]);
				if (num_results == 0) {
					System.out.println("No results found.");
				} else {
					System.out.println("Number of results is : " + num_results);
				}
				
				int number = Integer.parseInt(args[1]);
				if (number <= 0) {
					System.out.println("You should give a valid page value.");
				}

				String page_link = Scraper.findPage(args[0], number);
				if (page_link == null) {
					System.out.println("This page is not found.");
				} else {
					System.out.println("Below is the resuls list in the page number:" + number);
					Scraper.showResultInfo(page_link);
				}

			} catch (NumberFormatException nfe){
				System.out.println("You should give an integer value to the second parameter.");
				return ;
			}
		}
	}
	/*
	 * get result number from the keyword
	 * 
	 */
	
	public static int ResultNumber(String keyword){
		String tmpKeyword = keyword.trim();
		if(tmpKeyword=="" || keyword ==null)
			return 0;
		String newurl = translateUrl(keyword);
		String wholeurl = "http://www.walmart.com/search/search-ng.do?ic=16_0&Find=Find&search_query="+newurl+"&Find=Find&search_constraint=0";
		String html = getUrl(wholeurl);
		/* Jsoup
		 * Convert Java String to DOM document
		 */
		Document doc = Jsoup.parse(html);
		try{
			String contentText = doc.select(".mrl.mod-toggleItemCount > span").text();
			if(contentText==null)
				return 0;
			else{
				String[] contentlist = contentText.split(" ");
				int res = Integer.parseInt(contentlist[0]);
				return res;
			}
		}
		catch(Exception e){
			return  0;
		}

	}
	/*
	 * translate keyword to acceptable url's keyword
	 * example: input :"digital camera", "  digital   camera",
	 * 			output:"digital+camera", "++digital+++camera"
	 */
	public static String translateUrl(String url){
		String resUrl = url.replaceAll(" ", "+");
		return resUrl;
	}
	
	/*
	 * get the url's document
	 */
	public static String getUrl(String url){
		URL urlObj = null;
		try{
			urlObj = new URL(url);
		}
		catch(MalformedURLException e){
			System.out.println("The url was malformed!");
			return "";
		}
		URLConnection urlCon = null;
		BufferedReader in = null;
		String outputText = "";
		try{
			urlCon = urlObj.openConnection();
			in = new BufferedReader(new
					InputStreamReader(urlCon.getInputStream()));
			String line = "";
			while((line = in.readLine()) != null){
				outputText += line;
			}
			in.close();
		}catch(IOException e){
			System.out.println("There was an error connecting to the URL");
			return "";
		}
		return outputText;
	}

	/*
	 * find the specific page for the keyword.
	 */
	public static String findPage(String keyword, int number) {
		String tmpKeyword = keyword.trim();
		if(tmpKeyword=="" || keyword ==null)
			return null;
		String newurl = translateUrl(keyword);
		String start = "http://www.walmart.com/search/search-ng.do?ic=16_0&Find=Find&search_query="+newurl+"&Find=Find&search_constraint=0";
		boolean numberOver5 = number > 5? true: false;
		int beforeNum = 1;
		while (number > 5) {
			String html = getUrl(start);

			/* Convert Java String to DOM document */
			Document doc = Jsoup.parse(html);

			/* go to the next five page */
			if (doc.select("div.SPPagination") != null) {
				try{
					if (doc.select("div.SPPagination > nobr > a").get(beforeNum+5) != null) {
						String link = doc.select("div.SPPagination > nobr > a").get(beforeNum+5)
								.attr("href");
						start = "http://www.walmart.com/search/search-ng.do" + link;

						number -= 5;
					} else {
						return null;
					}
				}
				catch(Exception e){
					return null;
				}
			} else {
				return null;
			}
			if(numberOver5)
				beforeNum = 2;
		}

		/*If page 1 is wanted, return the current page */
		if (number == 1) {
			return start;
		}

		String html = getUrl(start);

		/* Convert Java String to DOM document */
		Document doc = Jsoup.parse(html);

		if (doc.select("div.SPPagination") != null) {
			try{
				if (doc.select("div.SPPagination > nobr > a").get(beforeNum+number-1) != null) {
					String link = doc.select("div.SPPagination > nobr > a").get(beforeNum+number-1)
							.attr("href");
					return "http://www.walmart.com/search/search-ng.do" + link;
				} else {
					return null;
				}
			}
			catch(Exception e){
				return null;
			}
		}

		return null;
	}
	
	/*
	 * print the result list
	 */
	public static void showResultInfo(String url) {
		String jsp = getUrl(url);
		if (jsp == null) {
			System.out.println("Failed to retrieve web page.");
			return ;
		}

		/* Jsoup
		 * Convert Java String to DOM document
		 */
		Document doc = Jsoup.parse(jsp);
		Element currentPrice = null;
		int num = doc.select("div.item.item-electronics-view").size();
		for (int i = 0; i < num; i++){
			
			Element current = doc.select("div.item.item-electronics-view").get(i);
			Element currentTitlecontainer = current.getElementsByClass("prodInfo").first()
					.select("div.prodInfo").first()
					.select("div.prodInfoBox").first()
					.select("a.prodLink.ListItemLink").first();
			
			String name = currentTitlecontainer.text();
			System.out.println("Title/Product Name: "+name);
			Element currentPricecontainer = current.getElementsByClass("ItemShelfAvail").first()
					.select("div.OnlinePriceAvail").first()
					.select("div.PriceContent").first();
			
			if(currentPricecontainer.select("div.PriceDisplay").first()==null){
				currentPricecontainer = currentPricecontainer.select("div").first();
				if(currentPricecontainer.select("div.camelPrice").first()==null)
					currentPrice = currentPricecontainer.select("p").first();
				else{
					currentPrice = currentPricecontainer.select("div.camelPrice").first();
				}
			}
			else{

				Element currentPricecompare = currentPricecontainer.select("div.PriceCompare").first();

				if(currentPricecompare != null){
					try{
						currentPrice = currentPricecompare.select("div.BodyS").first();
						if(currentPrice.select("div.BodyM").first()==null){
							currentPrice = currentPrice.select("div.submapPrice").first()
									.select("div.PriceLBold").first();
						}
						else
							currentPrice = currentPrice.select("div.BodyM").first();
					}
					catch(Exception e){
						if(currentPrice == null){
							currentPrice = currentPricecompare.select("div.camelPrice").first();
							if(currentPrice == null){
								currentPrice = currentPricecompare.select("div.BodyS").first()
										.select("div.submapPrice").first()
										.select("div.PriceLBold").first();
							}
						}
					}
				}
				else{
					currentPrice = currentPricecontainer.select("div.camelPrice").first();
					if(currentPrice==null)
						currentPrice = currentPricecontainer;
				}
			}
			String price = currentPrice.text();
			System.out.println("Price: "+price);
			System.out.println("******************************************");
		}
	}
}
