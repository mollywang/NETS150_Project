package edu.upenn.main;

import java.io.File;
import java.io.FileReader;
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
		Map<State,Integer> positiveTweetSet = new HashMap<State,Integer> ();
		Map<State,Integer> negativeTweetSet = new HashMap<State,Integer> ();
		StateManager stateManager = new StateManager();
		SentimentManager sentimentManager = new SentimentManager();
		for (Tweet tweet : ireneTweets) {
			if(sentimentManager.isPositive(tweet)){
				addToSet(stateManager, positiveTweetSet, tweet);
			}else{
				addToSet(stateManager, positiveTweetSet, tweet);
			}
			
		}
		
		printSet(stateManager,positiveTweetSet);
		printSet(stateManager,negativeTweetSet);
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

	private static List<Tweet> loadTweets(String path) {
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
