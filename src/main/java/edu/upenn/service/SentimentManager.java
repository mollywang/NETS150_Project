package edu.upenn.service;

import java.util.ArrayList;

import edu.upenn.model.Tweet;
import edu.upenn.vectors.Corpus;
import edu.upenn.vectors.Document;
import edu.upenn.vectors.VectorSpaceModel;

/**
 * 
 * Take in set of tweets in a state and run cosine similarity of all aggregated 
 * tweets in the state against positive1.txt & negative1.txt
 * Return 1 if cosine similarity value is higher for positive document and 0 
 * otherwise..
 *
 */
public class SentimentManager {
	private static final String positivePath = "res/positive1.txt";
	private static final String negativePath = "res/negative1.txt";
	private ArrayList<Document> positiveQuery = new ArrayList<Document>(2);
	private ArrayList<Document> negativeQuery = new ArrayList<Document>(2);
	private Document positive = new Document(positivePath);
	private Document negative = new Document(negativePath);

	public SentimentManager() {
		positiveQuery.add(positive);
		negativeQuery.add(negative);
	}

	public boolean isPositive(Tweet tweet) {
		Document tweetDoc = new Document(tweet);
		positiveQuery.add(tweetDoc);
		negativeQuery.add(tweetDoc);
		VectorSpaceModel positiveVectorSpace = new VectorSpaceModel(new Corpus(
				positiveQuery));
		VectorSpaceModel negativeVectorSpace = new VectorSpaceModel(new Corpus(
				negativeQuery));

		double positiveVal = positiveVectorSpace.cosineSimilarity(positive,
				tweetDoc);
		System.out.println("positive val: " + positiveVal);
		double negativeVal = negativeVectorSpace.cosineSimilarity(negative,
				tweetDoc);
		System.out.println("negative val: " + negativeVal);
		System.out.println();
		positiveQuery.remove(1);
		negativeQuery.remove(1);

		return positiveVal > negativeVal;
	}

}
