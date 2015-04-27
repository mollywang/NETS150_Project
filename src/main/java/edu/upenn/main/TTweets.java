package edu.upenn.main;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.filter.text.cql2.CQL;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.filter.Filter;

import edu.upenn.fileIO.TweetLoader;
import edu.upenn.model.Tweet;

public class TTweets {
	private static final String statesGeoPath = "res/geo/states.shp";
	private static final String tweetsPath = "res/tweets_1.txt";

	public static void main(String[] args) {
		List<Tweet> tweets = loadTweets(tweetsPath);
		// matchToState();
		
		System.out.println("done! tweets count: "+tweets.size());

	}

	private static List<Tweet> loadTweets(String path) {
		File file = new File(path);
		FileReader fr;
		TweetLoader loader = null;
		try {
			fr = new FileReader(file);
			loader = new TweetLoader(fr);
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
			System.exit(0);
		}
		return loader.getTweets();
	}

	private static void matchToState() {
		File shapeFile = new File(statesGeoPath);
		FileDataStore store;
		try {
			store = FileDataStoreFinder.getDataStore(shapeFile);

			SimpleFeatureSource featureSource = store.getFeatureSource();
			// Boulder, CO
			Filter filter = CQL
					.toFilter("CONTAINS(the_geom, POINT(-105.292778 40.019444))");
			SimpleFeatureCollection features = featureSource
					.getFeatures(filter);

			SimpleFeatureIterator iterator = features.features();
			try {
				while (iterator.hasNext()) {
					SimpleFeature feature = iterator.next();
					System.out.println(feature.getID());
					System.out.println(feature.getAttribute("NAME"));
				}
			} finally {
				iterator.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
