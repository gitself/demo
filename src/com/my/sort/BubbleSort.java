package com.my.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BubbleSort implements Sort {

	public List<Integer> bubbleSort(List<Integer> list) {
		int count = 0;
		print(list);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i) < list.get(j)) {
					SortUtils.exchange(i, j, list);
					count++;
					print(list);
				}
			}
		}
		print(list);
		System.out.println("�ܹ��Ƚϴ�����" + count);
		return list;
	}

	public static void main(String[] args) {
		BubbleSort bsort = new BubbleSort();
		List<Integer> list = Arrays.asList(1, 2, 4, 2, 7);
		// List<Integer> list = bsort.generateList(5);
		bsort.bubbleSort(list);
	}

	@Override
	public List<Integer> sort(List<Integer> list) {

		return bubbleSort(list);
	}

	public void print(List<Integer> list) {
		StringBuilder s = new StringBuilder();
		list.forEach(i -> s.append(i + "_"));
		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}
		System.out.println(s);
	}

	public List<Integer> generateList(int size) {
		List<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			Random rm = new Random();
			int num = rm.nextInt(100);
			list.add(num);
		}
		return list;
	}
}
