package edu.upenn.service;

import java.util.ArrayList;

import edu.upenn.model.Tweet;
import edu.upenn.vectors.Corpus;
import edu.upenn.vectors.Document;
import edu.upenn.vectors.VectorSpaceModel;

public class SentimentManager {
	public static String positivePath = "res/positive.txt";
	public static String negativePath = "res/negative.txt";
	public boolean isPositive(Tweet tweet) {

		Document positive = new Document(positivePath);
		Document negative = new Document(negativePath);
		Document tweetDoc = new Document(tweet);
		
		ArrayList<Document> positiveQuery = new ArrayList<Document>();
		positiveQuery.add(positive);
		positiveQuery.add(tweetDoc);
		ArrayList<Document> negativeQuery = new ArrayList<Document>();
		negativeQuery.add(negative);
		negativeQuery.add(tweetDoc);
		
		VectorSpaceModel positiveVectorSpace = new VectorSpaceModel(new Corpus(positiveQuery));
		VectorSpaceModel negativeVectorSpace = new VectorSpaceModel(new Corpus(positiveQuery));
		

		for(int i = 1; i < positiveQuery.size(); i++) {
			Document doc = positiveQuery.get(i);
			System.out.println("\nComparing to " + doc);
			System.out.println(positiveVectorSpace.cosineSimilarity(positive, doc));
		}
		
		
		
		return false;
	}
	

}
