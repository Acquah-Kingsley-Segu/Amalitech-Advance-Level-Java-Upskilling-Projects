import input_reader.InputReader;
import output_display.OutputDisplay;
import computation.MapReduceComputation;
import java.util.Arrays;
import java.util.Map;

public class MapReduce{
	public static void main(String[] args){
		String[] words = InputReader.readInput();
		Map<String, Integer> result = MapReduceComputation.execute(words);
		System.out.println("The word(s) counts in the above phrase: \n");
		for (Map.Entry<String, Integer> entry : result.entrySet()){
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
