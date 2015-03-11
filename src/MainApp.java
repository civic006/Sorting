import java.util.Arrays;

public class MainApp {

	public static void main(String args[]) {
		int[] A = { 2, 3, 4, 7 };
		int[] B = { 1, 5, 8 };

		System.out.println(Arrays.toString(sortTwoArrays(A, B)));
	}

	public static int[] sortTwoArrays(int[] A, int[] B) {

		int currentIndex = A.length + B.length - 1;
		int currentAIndex = A.length - 1;
		int currentBIndex = B.length - 1;

		// Setup problem so A has buffer at end
		A = Arrays.copyOf(A, currentIndex + 1);
		// int[] out = new int[A.length + B.length];
		// for (int i = 0; i < A.length; i++) {
		// out[i] = A[i];
		// }
		// A = out;

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

	public static void printArray(int[] out) {
		for (int i = 0; i < out.length; i++) {
			System.out.print(out[i]);
			System.out.print(' ');
		}
	}
}
