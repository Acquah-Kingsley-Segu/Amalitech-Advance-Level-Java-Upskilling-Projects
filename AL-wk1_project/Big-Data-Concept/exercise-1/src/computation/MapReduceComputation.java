package computation;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.stream;

public class MapReduceComputation{
	private static List<Map<String, Integer>> nodesResults = new ArrayList<>(); //emulates all node processes
	private static Map<String, Integer> mapReduceResult = new HashMap<>();

	/**
	 * Main point where the MapReduce Algorithm starts
	 *
	 * @param words all the sentences to be processed
	 * @return Map<String, Integer> type that contains the count of word
	 */
	public static Map<String, Integer> execute(String[] words){
		// call map method
		for (String line : words) {
			line = line.replaceAll("[\\p{Punct}]", ""); // remove punctuations
			nodesResults.add(MapReduceComputation.mapJob(line));
		}
		Map<String, String> shuffledWords = MapReduceComputation.shuffleJob();
		// call reduce method here
		MapReduceComputation.reduceJob(shuffledWords);
		return MapReduceComputation.mapReduceResult;
	}

	/**
	 * This method takes a sentence or line and then creates a correlation
	 * between the words and their count in the given sentense or line.
	 *
	 * @param line sentence to be processed
	 * @return     a Map<String, Integer> type
	 */
	private static Map<String, Integer> mapJob(String line){
		Map<String, Integer> wordCounts = new HashMap<>();
		for (String word : line.trim().toLowerCase().split(" ")){
			wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
		}
		return wordCounts;
	}

	/**
	 * This method takes all data results proceed by the mapJob.
	 * It then create and intermediary data to be used by the reduceJob
	 * How: it loops over the node(map) resultsand then group similar words
	 * 	with their counts together
	 *
	 * @return a Map<String, String> type
	 */
	private static Map<String, String> shuffleJob(){
		Map<String, String> shuffledWords = new HashMap<>();
		
		for (Map<String, Integer> result : MapReduceComputation.nodesResults){
			for (Map.Entry<String, Integer> entry : result.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue().toString();

				shuffledWords.put(key, shuffledWords.getOrDefault(key, "") + value + " ");
			}
		}
		return shuffledWords;
	}

	/**
	 * Takes the shuffled words and create a single value out of
	 * all their counts across multiple nodes
	 *
	 * @param intermData the result from shuffleJob
	 *
	 * @return void
	 */
	private static void reduceJob(Map<String, String> intermData){
		for (Map.Entry<String, String> entry : intermData.entrySet()){
			String key = entry.getKey();
			String[] values = entry.getValue().split(" ");
			int count = 0;
			
			for (String value : values){
				count += Integer.parseInt(value);
			}
			MapReduceComputation.mapReduceResult.put(key, count);
		}
	}

}
