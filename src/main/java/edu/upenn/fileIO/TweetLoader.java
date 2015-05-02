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
				Tweet t = parseTweet(line);
				tweets.add(t);
			}

		} catch (FileNotFoundException e) {
			tweets = null;
		} catch (IOException e) {
			tweets = null;
		}

	}
	/**
	 * parses one raw tweet and adds it to internal data structure
	 * rawTweet is expected to have this format:
	 * 42.531041999999999 -89.90854831'\t'tweetText
	 * @param rawTweet
	 */
	public Tweet parseTweet(String rawTweet){
		Double latitude = null, longitude = null;
		String[] text = rawTweet.split("\t");
		String [] coordinates = text[0].split(" ");
		if(text.length<2){
			throw new IllegalArgumentException("rawTweet doesn't have the expected format");
		}
		try{			
			longitude = Double.valueOf(coordinates[0]);
			latitude = Double.valueOf(coordinates[1]);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return new Tweet(longitude, latitude, text[1]);
	}
	
	public List<Tweet> getTweets(){
		return tweets;
	}

}
