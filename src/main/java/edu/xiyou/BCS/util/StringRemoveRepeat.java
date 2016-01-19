/**
 * 去除字符串中重复的
 */

package edu.xiyou.BCS.util;

import java.util.HashSet;
import java.util.Set;

public class StringRemoveRepeat {
	public static String removeRepeat(String str1, String str2){
		Set<String>  set = new HashSet<String>();
		StringBuilder str = new StringBuilder();
		
		for (String string : str1.split(" ")) {
			set.add(string);
		}
		
		for (String string : str2.split(" ")) {
			set.add(string);
		}
		
		int i = 0;
		for (String string : set) {
			if(i++ == set.size()-1){
				str.append(string);
			}else{
				str.append(string+",");
			}
		}
		
		return str.toString();
	}
	
//	public static void main(String[] args) {
//		System.out.println(StringRemoveRepeat.removeRepeat("java a b b b cc c", "python a d c"));;
//	}
}
