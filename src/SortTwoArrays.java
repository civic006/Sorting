import java.util.Arrays;

public class SortTwoArrays {

	public static void main(String args[]) {
		// Sort two sorted arrays
		int[] A = { 2, 3, 4, 7 };
		int[] B = { 1, 5, 8 };
		System.out.println(Arrays.toString(sortTwoArrays(A, B)));
	}

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
}