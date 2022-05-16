package com.swaglabs.util;

import java.util.List;

public class Sort {

	public static boolean isDescendingString(List<String> list) {
		for(int i=0; i<list.size()-1; i++) {
			if(list.get(i).compareTo(list.get(i+1))<0){
				return false;
			}
		}		
		return true;
	}
}
