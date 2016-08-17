package com.my.sort;

import java.util.List;
import java.util.stream.Collectors;

public class CountSort implements Sort{

	@Override
	public List<Integer> sort(List<Integer> list) {
		
		return null;
	}
	
	private void countSort(List<Integer> list){
		List<Integer> temp = list.stream().collect(Collectors.toList());
		list.forEach(value->list.set(value, list.get(value)+1));
	}

}
