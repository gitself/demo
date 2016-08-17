package com.my.sort;

import java.util.Arrays;
import java.util.List;


public class MergeSort implements Sort {

	@Override
	public List<Integer> sort(List<Integer> list) {
		mergeSort(list, 0, list.size() - 1);
		return list;
	}

	/**
	 * [p,r] 归并排序p到r元素
	 * 
	 * @param list
	 * @param p
	 *            开始位置()
	 * @param r
	 *            结束位置()
	 * @return
	 */
	private void mergeSort(List<Integer> list, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(list, p, q);
			mergeSort(list, q + 1, r);
			merge(list, p, q, r);
		}
	}

	/**
	 * 将list中的从p开始到q 和 从q+1开始到r结束的2个数组合并按序排好
	 * 
	 * @param list
	 * @param p
	 * @param q
	 * @param r
	 */
	private void merge(List<Integer> list, int p, int q, int r) {
		// int n1 = q - p + 1;
		// int n2 = r - q;
		List<Integer> leftArr = SortUtils.copyArr(list, p, q);
		List<Integer> rightArr = SortUtils.copyArr(list, q + 1, r);
		leftArr.add(Integer.MAX_VALUE);// 放置哨兵牌
		rightArr.add(Integer.MAX_VALUE);
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			Integer left = leftArr.get(i);
			Integer right = rightArr.get(j);
			if (left <= right) {
				list.set(k, left);
				i++;
			} else {
				list.set(k, right);
				j++;
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> origArr = Arrays.asList(3, 2, 1, 123, 7, 9, 22);
		MergeSort sort = new MergeSort();
		// List<Integer> copyArr = sort.copyArr(origArr, 2, 5);
		// sort.merge(origArr, 0, 3, 7);
		sort.sort(origArr);
		origArr.forEach(i -> System.out.print(i + " "));

	}

}
