package String;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test_1_1() {
		String str1 = "";
		String str1_1 = "   ";
		String str2 = "1";
		String str3 = "11";
		String str4 = "qwe";
		String str5 = ",";
		System.out.println(str1.toString() + ":" +StringUtil.isUniqueChars(str1));
		System.out.println(str1.toString() + ":" +StringUtil.isUniqueChars2(str1));
		System.out.println(str1.toString() + ":" +StringUtil.isUniqueChars3(str1));
		System.out.println(str1_1.toString() + ":" +StringUtil.isUniqueChars(str1_1));
		System.out.println(str1_1.toString() + ":" +StringUtil.isUniqueChars2(str1_1));
		System.out.println(str1_1.toString() + ":" +StringUtil.isUniqueChars3(str1_1));
		System.out.println(str2.toString() + ":" +StringUtil.isUniqueChars(str2));
		System.out.println(str2.toString() + ":" +StringUtil.isUniqueChars2(str2));
		System.out.println(str2.toString() + ":" +StringUtil.isUniqueChars3(str2));
		System.out.println(str3.toString() + ":" +StringUtil.isUniqueChars(str3));
		System.out.println(str3.toString() + ":" +StringUtil.isUniqueChars2(str3));
		System.out.println(str3.toString() + ":" +StringUtil.isUniqueChars3(str3));
		System.out.println(str4.toString() + ":" +StringUtil.isUniqueChars(str4));
		System.out.println(str4.toString() + ":" +StringUtil.isUniqueChars2(str4));
		System.out.println(str4.toString() + ":" +StringUtil.isUniqueChars3(str4));
		System.out.println(str5.toString() + ":" +StringUtil.isUniqueChars(str5));
		System.out.println(str5.toString() + ":" +StringUtil.isUniqueChars2(str5));
		System.out.println(str5.toString() + ":" +StringUtil.isUniqueChars3(str5));
	}
	
	@Test
	public void test_1_3(){
		String s = "";
		String t = "";
		System.out.println("s="+ s + " t=" + t + StringUtil.permutation(s, t));
		System.out.println("s="+ s + " t=" + t + StringUtil.permutation2(s, t));

		String s1 = "123";
		String t1 = "321";
		System.out.println("s1="+ s1 + " t1=" + t1 + StringUtil.permutation(s1, t1));
		System.out.println("s1="+ s1 + " t1=" + t1 + StringUtil.permutation2(s1, t1));
		
		String s2 = "abc";
		String t2 = "ABc";
		System.out.println("s2="+ s2 + " t2=" + t2 + StringUtil.permutation(s2, t2));
		System.out.println("s2="+ s2 + " t2=" + t2 + StringUtil.permutation2(s2, t2));
		
		String s3 = "abcD";
		String t3 = "ABcfds";
		System.out.println("s3="+ s3 + " t3=" + t3 + StringUtil.permutation(s3, t3));
		System.out.println("s3="+ s3 + " t3=" + t3 + StringUtil.permutation2(s3, t3));
	}
	
	@Test
	public void test_1_4(){
		char[] str = new char[100];
		for(int i = 0;i<10;i++){
			if((i%2) == 0)
				str[i] = ' ';
			else
				str[i] = 'a';
		}
		StringUtil.replaceSpace(str, 10);
		
		for(int i=0;i<20;i++){
			System.out.println(str[i]);
		}
	}
	
	@Test
	public void test_1_5(){
		String str1 = "";
		String str2 = null;
		String str3 = "avsdqwe";
		String str4 = "aaaccccccfffgfgggg";
		System.out.println("str1" + StringUtil.compressDuplicate(str1));
		System.out.println("str2" + StringUtil.compressDuplicate(str2));
		System.out.println("str3" + StringUtil.compressDuplicate(str3));
		System.out.println("str4" + StringUtil.compressDuplicate(str4));
 	}
	
	@Test
	public void test_1_8(){
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(StringUtil.isRotateWord(s1, s2));
	}
	
}
