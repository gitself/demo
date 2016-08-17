package com.my.sort;

import java.util.List;

public class InsertSort implements Sort {

	@Override
	public List<Integer> sort(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			Integer n1 = list.get(i);
			for (int j = 0; j < i; j++) {
				Integer n2 = list.get(j);
				if (n1 < n2) {
					SortUtils.exchange(i, j, list);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<Integer> list = SortUtils.genList(10);
		list.forEach(i -> System.out.print(i + " "));
		new InsertSort().sort(list);
		System.out.println();
		list.forEach(i -> System.out.print(i + " "));
	}
}
