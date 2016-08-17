package com.my.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SortUtils {

	public static void exchange(int i, int j, List<Integer> list) {
		Integer i1 = list.get(i);
		Integer j1 = list.get(j);
		list.set(i, j1);
		list.set(j, i1);
	}

	public static List<Integer> copyArr(List<Integer> origArr, int start, int end) {
		int length = end - start + 1;
		Integer[] destArr = new Integer[length];
		System.arraycopy(origArr.toArray(), start, destArr, 0, length);
		return Arrays.stream(destArr).collect(Collectors.toList());
	}

	public static List<Integer> genList(int size) {
		List<Integer> list = new ArrayList<>();
		Random rd = new Random();
		for (int i = 0; i < size; i++) {
			list.add(rd.nextInt(2*size));
		}
		return list;
	}
}
