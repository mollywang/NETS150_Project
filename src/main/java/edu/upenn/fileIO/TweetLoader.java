package edu.upenn.fileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import edu.upenn.model.Tweet;

/**
 * Gets a file from file system and loads all the information of tweets in the sample format
 *
 */
public class TweetLoader {
	private List<Tweet> tweets;

	/**
	 * 
	 * @param loadFile
	 *            The file from which the tweets will be loaded.
	 * @throws IllegalLineFormatException
	 * @throws InvalidFileException
	 */
	public TweetLoader(FileReader loadFile) throws InvalidFileException {
		tweets = new LinkedList<Tweet>();
		String line;
		try {
			BufferedReader bufferedReader = new BufferedReader(loadFile);
			while ((line = bufferedReader.readLine()) != null) {
				parseTweet(line);
			}

		} catch (FileNotFoundException e) {
			tweets = null;
		} catch (IOException e) {
			tweets = null;
		}

	}
	/**
	 * parses one raw tweet and adds it to internal data structure
	 * @param rawTweet
	 */
	public void parseTweet(String rawTweet){
		Double latitude = null, longitude = null;
		String[] text = rawTweet.split("\t");//("([0-9]*\\.[0-9]+)\\ (-[0-9]*\\.?[0-9]+)");//separate coordinates from the rest
		String [] coordinates = text[0].split(" ");
		System.out.println(text.length);
		if(text.length<2){
			System.out.println("broke");
			return;
		}
		try{			
			latitude = Double.valueOf(coordinates[0]);
			longitude = Double.valueOf(coordinates[1]);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		tweets.add(new Tweet(latitude,longitude,text[1]));
	}
	//42.531041999999999 -82.90854831 I'm at Holiday Inn Express Suites & Hotel Roseville MI (31900 Little Mack Ave., at Masonic Blvd., Roseville) http://t.co/EbQPqgB
	
	public List<Tweet> getTweets(){
		return tweets;
	}

}
