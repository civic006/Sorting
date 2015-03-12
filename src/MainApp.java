import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class MainApp {

	public static void main(String args[]) {

		// Sort two sorted arrays
		int[] A = { 2, 3, 4, 7 };
		int[] B = { 1, 5, 8 };
		System.out.println(Arrays.toString(sortTwoArrays(A, B)));

		// Sort anagrams
		String[] simpleAnagramArray = { "bee", "milk", "tree", "klmi" };
		System.out.println(Arrays.toString(sortAnagrams(simpleAnagramArray)));
	}

	// ---------------------------------------------------------------------------------
	// Sort two sorted arrays simple example

	// Sort two sorted arrays where A has a buffer for B.
	public static int[] sortTwoArrays(int[] A, int[] B) {

		int currentIndex = A.length + B.length - 1;
		int currentAIndex = A.length - 1;
		int currentBIndex = B.length - 1;

		// Setup problem so A has buffer at end
		A = Arrays.copyOf(A, currentIndex + 1);

		while (currentBIndex >= 0) {
			if (currentAIndex >= 0 && A[currentAIndex] > B[currentBIndex]) {
				A[currentIndex] = A[currentAIndex];
				currentAIndex--;
			} else {
				A[currentIndex] = B[currentBIndex];
				currentBIndex--;
			}
			currentIndex--;
		}

		return A;
	}

	// ---------------------------------------------------------------------------------

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
