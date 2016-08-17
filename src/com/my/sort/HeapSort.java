package com.my.sort;

import java.util.Arrays;
import java.util.List;

public class HeapSort implements Sort {

	private void buildMaxHeap(List<Integer> list) {
		for (int i = list.size() / 2; i >= 1; i--) {
			int heapSize = list.size();
			maxHeapfiy(list, i - 1, heapSize);
		}
	}

	/**
	 * 维护 index 位置最大堆的性质
	 * 
	 * @param list
	 * @return
	 */
	private void maxHeapfiy(List<Integer> list, int index, int heapSize) {
		// 堆数组索引从1开始为了方便计算，而 list索引从0开始，所以要减1
		// int heapSize = list.size();
		int largest = index + 1;
		int left = 2 * largest;
		int right = 2 * largest + 1;
		// 如果list[left]>list[largest] 把left的索引赋值给larest
		if (left <= heapSize && list.get(left - 1) > list.get(largest - 1)) {
			largest = left;
		}
		// 如果list[right]>list[largest] 把right的索引赋值给larest
		if (right <= heapSize && list.get(right - 1) > list.get(largest - 1)) {
			largest = right;
		}
		if (largest != index + 1) {
			// 如果largest有变动，把largest换到原先的位置
			SortUtils.exchange(index, largest - 1, list);
			maxHeapfiy(list, largest - 1, heapSize);
		}
	}

	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
		List<Integer> list = Arrays.asList(2,1,5);
		// hs.maxHeapfiy(list, 1);
		// hs.buildMaxHeap(list);
		hs.heapSort(list);
		list.forEach(i -> System.out.print(i + " "));
	}

	private List<Integer> heapSort(List<Integer> list) {
		buildMaxHeap(list);
		int heapSize = list.size();
		for (int i = list.size(); i >= 2; i--) {
			SortUtils.exchange(0, i - 1, list);
			list.forEach(k->System.out.print(k+" "));
			heapSize--;
			maxHeapfiy(list, 0, heapSize);
			System.out.println();
			list.forEach(n->System.out.print(n+" "));
			System.out.println();
		}
		return list;
	}

	@Override
	public List<Integer> sort(List<Integer> list) {
		return heapSort(list);
	}
}
