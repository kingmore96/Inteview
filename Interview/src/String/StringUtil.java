package String;

import java.util.Arrays;

public class StringUtil {
	
	public static boolean isUniqueChars(String str){
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(i)==str.charAt(j))
					return false;
			}
		}
		return true;
	}
	
	public static boolean isUniqueChars2(String str){
		char[] newStr = str.toCharArray();
		Arrays.sort(newStr);

		for(int i=0;i < newStr.length-1;i++){
			if(newStr[i] == newStr[i+1])
				return false;
		}
		return true;
	}
	
	public static boolean isUniqueChars3(String str){
		if(str.length() > 256) return false;
		
		boolean[] char_bool = new boolean[256];
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i);
			if(char_bool[val] == true)
				return false;
			char_bool[val] = true;
		}
		return true;
	}
	
	public static boolean permutation(String s,String t){
		if(s == null || t == null)
			return false;
		if(s.length() != t.length())
			return false;
		return sort(s).equals(sort(t));
	}

	
	public static boolean permutation2(String s,String t){
		if(s == null || t == null)
			return false;
		if(s.length() != t.length())
			return false;
		
		int[] letters = new int[256];
		for(int i=0;i<s.length();i++){
			int val = s.charAt(i);
			letters[val]++;
		}
		
		for(int i=0;i<t.length();i++){
			int val = t.charAt(i);
			if(--letters[val] < 0){
				return false;
			}
		}
		return true;
	}
	
	private static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static void replaceSpace(char[] str,int length){
		int spaceCount = 0, newLength = 0;
		for(int i=0;i<str.length;i++){
			if(str[i] == ' '){
				spaceCount = spaceCount+1;
			}
		}
		
		newLength = length + spaceCount*2;
		str[newLength] = '\0';
		for(int i= length-1;i>=0;i--){
			if(str[i] == ' '){
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			}
			else{
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		
	}
	
	
	public static String compressDuplicate(String str){
		if(str == null || str.length() == 0)
			return null;
		
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i) == last)
				count++;
			else{
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr.append(last);
		mystr.append(count);
		
		if(mystr.length()>str.length()){
			return str;
		}
		return mystr.toString();
	}
	
	public static boolean isRotateWord(String s1,String s2){
		if(s1 == null || s1.length() == 0 || s2 == null || s2.length() ==0)
			return false;
		
		if(s1.length() != s2.length())
			return false;
		
		char first = s2.charAt(0);
		StringBuffer buffer = new StringBuffer();
		buffer.append(first);
		
		int index = s1.indexOf(buffer.toString());
		String t1 = s1.substring(index);
		String t2 = s1.substring(0, index);
		String t3 = s2.substring(0, t1.length());
		String t4 = s2.substring(t1.length());
		return t1.equals(t3) && t2.equals(t4);
	}
	
	public static boolean isRotateWord2(String s1,String s2){
		//TODO
		if(s1 == null || s1.length() == 0 || s2 == null || s2.length() ==0)
			return false;
		
		if(s1.length() != s2.length())
			return false;
		
		String temp = s1 + s1;
		//return isSubstring(temp,s2);
		return false;
	}
	
}
