package edu.upenn.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.upenn.fileIO.TweetLoader;
import edu.upenn.model.State;
import edu.upenn.model.Tweet;
import edu.upenn.service.SentimentManager;
import edu.upenn.service.StateManager;

public class TTweets {
	private static final String tweetsPath = "res/tweets_";

	public static void main(String[] args) {
		List <Tweet> ireneTweets = new LinkedList<Tweet>();
		for(int i =1;i<=3;i++){
			ireneTweets.addAll(getIreneTweets(tweetsPath+i+".txt"));
		}
		System.out.println(ireneTweets.size());
		//dumpTweetsByState(ireneTweets);
		StateManager stateManager = new StateManager();
		Map<State,Integer> sortedTweets = sortByState(stateManager,ireneTweets);
		System.out.println("Printing: state  | #ofTweets");
		printSet(stateManager,sortedTweets);
		System.out.println();
		
		SentimentManager sentimentManager = new SentimentManager();
		sentimentManager.determineSentiment(sortedTweets.keySet());
		
	}
	/**
	 * Sorts the list of Irene Tweets into a map containing a State as key and the number of tweets for that state as value.
	 * @param ireneTweets
	 */
	private static Map<State,Integer> sortByState(StateManager stateManager,List<Tweet> ireneTweets) {
		Map<State,Integer> tweetSet = new HashMap<State,Integer> ();
		for (Tweet tweet : ireneTweets) {			
			addToSet(stateManager, tweetSet, tweet);		
		}
		return tweetSet;
	}

	/**
	 * Used to dump the filtered Tweets by state in a file for further processing with Microsoft excel.
	 * @param tweets
	 */
	@SuppressWarnings("unused")
	private static void dumpTweetsByState(List<Tweet> tweets){
		StateManager stateManager = new StateManager();
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("res/tweetsByState.txt", true)));
			for (Tweet tweet : tweets) {
				State s = stateManager.findStateForTweet(tweet);
				s.getName();
			    out.println(s.getName()+"\t"+tweet.getText());
			}
			out.close();
		} catch (IOException e) {
			System.err.println("error while creating file");
		}
	}
	private static void addToSet(StateManager stateManager,Map<State,Integer> tweetSet, Tweet tweet){
		State s = stateManager.findStateForTweet(tweet);
		Integer currentCount = tweetSet.get(s);
		if(currentCount!=null){
			tweetSet.put(s, currentCount+1);
		}else{
			tweetSet.put(s, 1);
		}
	}
	/**
	 * Prints the number of Tweets in the map for every state in the US.
	 * @param stateManager
	 * @param tweetSet
	 */
	private static void printSet(StateManager stateManager, Map<State,Integer> tweetSet){
		for(State s: stateManager.getStates()){
			Integer count = tweetSet.get(s);
			System.out.println(s + " "+(count ==null?0:count)) ;
		}
	}

	private static List<Tweet> getIreneTweets(String fileName) {
		List<Tweet> tweets = loadTweets(fileName);
//		
//		SentimentManager sentiment = new SentimentManager();
		List<Tweet> ireneTweets = new LinkedList<Tweet>();
		for (Tweet tweet : tweets) {
			if(tweet.getText().toLowerCase().contains("irene")){
				ireneTweets.add(tweet);
			}
//			System.out.println(tweet.getState().getName());
		}
//		System.out.println("done! tweets count: "+tweets.size());
//		System.out.println("irene tweets count: "+ireneTweets.size());
		return ireneTweets;
	}

	private static List<Tweet> loadTweets(final String path) {
		File file = new File(path);
		FileReader fr;
		TweetLoader loader = null;
		try {
			fr = new FileReader(file);
			loader = new TweetLoader(fr);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}
		return loader.getTweets();
	}
}
