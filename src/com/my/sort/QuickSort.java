package com.my.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.SynchronousQueue;

public class QuickSort implements Sort {

	@Override
	public List<Integer> sort(List<Integer> list) {
		quickSort(list, 0, list.size() - 1);
		return list;
	}

	private void quickSort(List<Integer> list, int p, int r) {
		if (p < r) {
			int q = partition(list, p, r);
			quickSort(list, p, q-1);
			quickSort(list, q + 1, r);
		}
	}

	private int partition(List<Integer> list, int p, int r) {
		int x = list.get(r);// 主元
		int i = p - 1;
		for (int j = p; j <= r; j++) {
			if (list.get(j) <= x) {//取j=r的时候==等号成立把主元交换到中间去
				i++;
				SortUtils.exchange(i, j, list);
//				list.forEach(o -> System.out.print(o + " "));
//				System.out.println();
			}
		}
//		SortUtils.exchange(i + 1, r, list);
		return i;
	}

	public static void main(String[] args) {
		List<Integer> list = SortUtils.genList(20);
//		List<Integer> list = Arrays.asList(2, 8, 7, 1, 3, 5, 6, 4);
		list.forEach(i -> System.out.print(i + " "));
//		new QuickSort().partition(list, 0, 7);
		new QuickSort().sort(list);
		System.out.println();
		list.forEach(i -> System.out.print(i + " "));

	}
}
