package input_reader;

import java.util.Arrays;

public class InputReader{
	public static String[] readInput(){
		String inputText = """
			The sun was setting over the horizon, casting a warm golden glow across the landscape.
			Birds chirped melodiously as they returned to their nests, and a gentle breeze rustled through the leaves of the trees.
			In the distance, the soft sound of waves crashing against the shore created a soothing backdrop.
			Children played in the park, their laughter filling the air with a sense of joy and innocence.
			It was a peaceful evening, one that made you appreciate the simple beauty of nature.
		""";
		System.out.println("Story: \n" + inputText + "\n");
		return inputText.split("\n");
	}
}
