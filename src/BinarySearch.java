public class BinarySearch {

	public static void main(String args[]) {

		int[] simpleSearchArray1 = { 1, 5, 7, 8, 12, 15, 20 };
		int[] simpleSearchArray2 = { 1, 5, 7, 8, 12, 15, 20, 25, 30, 31 };

		System.out.println(binarySearch(simpleSearchArray1, 8));
		System.out.println(binarySearch(simpleSearchArray2, 31));
	}

	public static int binarySearch(int[] searchArray, int searchItem) {
		return binarySearch(searchArray, searchItem, 0, searchArray.length);
	}

	private static int binarySearch(int[] searchArray, int searchItem, int low,
			int high) {
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midValue = searchArray[mid];
			if (midValue < searchItem) {
				low = mid + 1;
			} else if (midValue > searchItem) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
