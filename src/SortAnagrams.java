import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class SortAnagrams {

	public static void main(String args[]) {

		// Sort anagrams
		String[] simpleAnagramArray = { "bee", "milk", "tree", "klmi" };
		System.out.println(Arrays.toString(sortAnagrams(simpleAnagramArray)));
	}

	// ---------------------------------------------------------------------------------
	// Sort an array of strings so that all anagrams are next to each other
	// simple example

	// Sort anagrams
	public static String[] sortAnagrams(String[] myArray) {
		Hashtable<String, LinkedList<String>> myHash = new Hashtable<String, LinkedList<String>>();

		for (int i = 0; i < myArray.length; i++) {
			String key = sortString(myArray[i]);
			if (!myHash.containsKey(key)) {
				myHash.put(key, new LinkedList<String>());
			}
			myHash.get(key).push(myArray[i]);
		}

		int currentIndex = 0;
		for (String key : myHash.keySet()) {
			LinkedList<String> currentLinkedList = myHash.get(key);
			for (String value : currentLinkedList) {
				myArray[currentIndex] = value;
				currentIndex++;
			}
		}
		return myArray;
	}

	// Sort anagrams helper. Sorts every string in original array
	private static String sortString(String s) {
		char[] myString = s.toCharArray();
		Arrays.sort(myString);
		return new String(myString);
	}
	// ---------------------------------------------------------------------------------
}
