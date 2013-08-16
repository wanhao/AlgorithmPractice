package codinginterview;

import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		int[] data = new int[] { 2, 3, 1, 2, 5, 2, 3, 6, 0, 9 };
		System.out.println(Arrays.toString(data));
		mergeSort(data);
		System.out.println(Arrays.toString(data));

		data = new int[] { 0, 1, 2, 3, 4, 5, 7 };
		System.out.println(Arrays.toString(data));
		mergeSort(data);
		System.out.println(Arrays.toString(data));

		data = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.println(Arrays.toString(data));
		mergeSort(data);
		System.out.println(Arrays.toString(data));

	}

	public static void mergeSort(int[] data) {
		if (data == null || data.length <= 1) {
			return;
		}
		int[] tmp = new int[data.length];
		mergeSort(data, tmp, 0, data.length - 1);
	}

	private static void mergeSort(int[] data, int[] tmp, int low, int high) {
		if (low >= high) {
			return;
		}
		int middle = (low + high) >> 1;
		mergeSort(data, tmp, low, middle);
		mergeSort(data, tmp, middle + 1, high);
		merge(data, tmp, low, middle, high);
	}

	private static void merge(int[] data, int[] tmp, int low, int middle,
			int high) {
		int i = low, j = middle + 1, k = low;
		while (i <= middle && j <= high) {
			if (data[i] < data[j]) {
				tmp[k++] = data[i++];
			} else {
				tmp[k++] = data[j++];
			}
		}
		while (i <= middle) {
			tmp[k++] = data[i++];
		}
		while (j <= high) {
			tmp[k++] = data[j++];
		}
		System.arraycopy(tmp, low, data, low, high - low + 1);
	}

	public static void heapSort(int[] data) {
		if (data == null || data.length <= 1)
			return;
		for (int i = (data.length - 2) / 2; i >= 0; i--) {
			siftdown(data, i, data.length - 1);
		}

		for (int i = data.length - 1; i > 0; i--) {
			swap(data, 0, i);
			siftdown(data, 0, i - 1);
		}
	}

	public static void siftdown(int[] data, int low, int high) {
		int parent = low, child = 0;
		while (parent <= high) {
			child = (parent << 1) + 1;
			if (child > high) {
				break;
			}
			if (child < high && data[child + 1] > data[child]) {
				child += 1;
			}
			if (data[child] > data[parent]) {
				swap(data, parent, child);
				parent = child;
			} else {
				break;
			}
		}
	}

	public static void insertSort(int[] data) {
		if (data == null || data.length <= 1)
			return;

		for (int i = 1; i < data.length; i++) {
			int j = 0, t = data[i];
			for (j = i; j > 0 && data[j - 1] > t; j--) {
				data[j] = data[j - 1];
			}
			data[j] = t;
		}
	}

	public static void bubbleSort(int[] data) {
		if (data == null || data.length <= 1)
			return;
		boolean change = true;
		for (int i = data.length - 1; i >= 1 && change; i--) {
			change = false;
			for (int j = 0; j < i; j++) {
				if (data[j] > data[j + 1]) {
					int tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;

					change = true;
				}
			}
		}
	}

	public static void quickSort1(int[] data, int low, int high) {
		if (low < high) {
			int small = low;
			int pivot = data[low];
			for (int i = low + 1; i <= high; i++) {
				if (data[i] < pivot) {
					// swap(data,++small,i);
					++small;
					if (small != i) {
						swap(data, small, i);
					}
				}
			}
			swap(data, small, low);

			quickSort1(data, low, small - 1);
			quickSort1(data, small + 1, high);
		}
	}

	public static void quickSort2(int[] data, int low, int high) {
		if (low < high) {
			int random = (int) (Math.random() * (high - low + 1)) + low;
			swap(data, random, low);
			int pivot = data[low];
			int i = low, j = high + 1;
			for (;;) {
				while (++i <= high && data[i] < pivot)
					;
				while (data[--j] > pivot)
					;
				if (i >= j)
					break;
				swap(data, i, j);
			}
			swap(data, low, j);

			quickSort2(data, low, j - 1);
			quickSort2(data, j + 1, high);
		}
	}

	public static void swap(int[] data, int a, int b) {
		int tmp = data[a];
		data[a] = data[b];
		data[b] = tmp;
	}
}
