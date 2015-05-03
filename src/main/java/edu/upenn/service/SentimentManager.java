package edu.upenn.service;

import java.util.ArrayList;
import java.util.Set;

import edu.upenn.model.State;
import edu.upenn.vectors.Corpus;
import edu.upenn.vectors.Document;
import edu.upenn.vectors.VectorSpaceModel;

public class SentimentManager {
	private static final String positivePath = "res/positive.txt";
	private static final String negativePath = "res/negative.txt";
	private ArrayList<Document> positiveQuery = new ArrayList<Document>(2);
	private ArrayList<Document> negativeQuery = new ArrayList<Document>(2);
	private Document positive = new Document(positivePath);
	private Document negative = new Document(negativePath);

	public SentimentManager() {
		positiveQuery.add(positive);
		negativeQuery.add(negative);
	}

	public void determineSentiment(Set<State> states) {
		ArrayList<Document> documents = new ArrayList<Document>();
		documents.add(positive);
		documents.add(negative);
		for (State state : states) {
			documents.add(new Document("res/filteredTweets/"
					+ state.getName().toLowerCase() + ".txt"));
		}
		Corpus corpus = new Corpus(documents);

		VectorSpaceModel vectorSpace = new VectorSpaceModel(corpus);

		for (int i = 2; i < documents.size(); i++) {
			Document doc = documents.get(i);
//			System.out.println("\nComparing to " + doc);
			double positiveVal = vectorSpace.cosineSimilarity(positive, doc);
//			System.out.println("positive val: " + positiveVal);
			double negativeVal = vectorSpace.cosineSimilarity(negative, doc);
//			System.out.println("negative val: " + negativeVal);
//			System.out.println(); 
			String state = doc.toString().split("/")[2].split("\\.")[0];
			System.out.print(state);
			if(positiveVal>negativeVal){
				System.out.println(" Positive");
			}else if(negativeVal>positiveVal){
				System.out.println(" Negative");
			}else{
				System.out.println(" Unknown");
			}
		}
	}

}
