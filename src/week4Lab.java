import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class week4Lab {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//why would we use a StringBuilder instead of a String?
			// A string builder allows us to create a single complex string without creating multiple strings in memory.
		
		//instantiate a new StringBuilder and append the characters 0 through 9 to it separated by dashes
		//make sure no dash appears at the end of the StringBuilder
		StringBuilder newBuild = new StringBuilder();
		for(int i=0;i<10;i++) { newBuild.append(i); newBuild.append("-"); }
		newBuild.deleteCharAt((newBuild.length())-1);  //System.out.println(newBuild);
		
		//create a list of Strings and add 5 Strings to it, each with a different length
		List<String> babyNames = new ArrayList<>();
		babyNames.add("Mike"); //4
		babyNames.add("Jonah"); // 5
		babyNames.add("William"); //7
		babyNames.add("Annelise"); //8
		babyNames.add("Leo"); //3
		
		//write and test a method that takes a list of strings and returns the shortest string
		System.out.println(shortStr(babyNames));
		
		//write and test a method that takes a list of strings and returns the list with the first and last element switched
		System.out.println(switchStr(babyNames));
		
		//write and test a method that takes a list of strings and returns a string with all the list elements concatenated to each other,
		//separated by a comma
		System.out.println(listToString(babyNames));
		
		//write and test a method that takes a list of strings and a string and returns a new list with all strings from the original list
		//containing the second string parameter (i.e. like a search method)
		List<String> searchResults = search(babyNames, "li");
		for (String result : searchResults) {
			System.out.println(result);	}
		System.out.println("-----------");
		
		//write and test a method that takes a list of integers and returns a List<List<Integer>> where the first list in the returned value
		//contains any number from the input list that is divisible by 2, the second list contains values from the input list that are divisible
		//by 3, the third divisible by 5, and the fourth all numbers from the input list not divisible by 2, 3, or 5
		List<Integer> nums = new ArrayList<>();
		for(int i=1;i<30;i++) {	nums.add(i); }
		System.out.println(divisible(nums));
		//write and test a method that takes a list of strings and returns a list of integers that contains the length of each string
		System.out.println(wordLength(babyNames));
		//create a set of strings and add 5 values
		Set<String> parentNames = new TreeSet<>();
		parentNames.add("Star-Lord"); // 9
		parentNames.add("Groot"); // 5
		parentNames.add("Mantis"); // 6
		parentNames.add("Thor"); // 4
		parentNames.add("Valkyrie"); // 8 
		
		//write and test a method that takes a set of strings and a character and returns a set of strings consisting of all the strings in the
		//input set that start with the character parameter.
		System.out.println("Pick a letter: S, G, M, T, V");
		char ch = sc.next().charAt(0);
		System.out.println(charTest(parentNames, ch));
		
		//write and test a method that takes a set of strings and returns a list of the same strings
		System.out.println(stringToList(parentNames));
		//write and test a method that takes a set of integers and returns a new set of integers containing only even numbers from the original set
		Set<Integer> num = new TreeSet<>();
		for(int i=1;i<20;i++) { num.add(i); }
		System.out.println(evenNum(num));
		//create a map of string and string and add 3 items to it where the key of each is a word and the value is the definition of the word
		Map<String,String> dict = new HashMap<String,String>();
		dict.put("honor", "high respect and great esteem");
		dict.put("courage", "strength in the face of pain or grief");
		dict.put("commitment", "a pledge or undertaking");
		//write and test a method that takes a Map<String, String> and a string and returns the value for a key in the map that matches the 
		//string parameter (i.e. like a language dictionary lookup)
		System.out.println(dictLook(dict,"honor"));

		
		
	}

	public static String shortStr(List<String> strL) {
		int num = Integer.MAX_VALUE; String shortest = "null";
		for(int i=0;i<strL.size();i++) {
			System.out.println(strL.get(i));
			if(strL.get(i).length()<num) {
				shortest = strL.get(i);
				num = shortest.length();
			}
		}
		return shortest;
	}
	public static List switchStr(List<String> strL) {
		String temp1 = strL.get(0);
		String temp2 = strL.get(strL.size()-1);
		strL.set(0, temp2); strL.set(strL.size()-1, temp1);
		return strL;
	}
	public static StringBuilder listToString(List<String> strL) {
		StringBuilder temp = new StringBuilder();
		for(String str:strL) {
			temp.append(str);
			temp.append(", "); }
		temp.deleteCharAt(temp.length()-1); temp.deleteCharAt(temp.length()-1);
		return temp;
	}	
	public static List<String> search(List<String> list, String query) {
		List<String> results = new ArrayList<String>();
		for (String string : list) {
			if (string.contains(query)) {
				results.add(string);
			}
		}
		return results;
	}
	public static List<List> divisible(List<Integer> nums){
		List<List> divs = new ArrayList<>();
		List<Integer> dTwo = new ArrayList<>();
		List<Integer> dThree = new ArrayList<>();
		List<Integer> dFive = new ArrayList<>();
		List<Integer> dNot = new ArrayList<>();
		for(int num:nums) {
			if(num%2==0) {dTwo.add(num);}
			if(num%3==0) {dThree.add(num);}
			if(num%5==0) {dFive.add(num);}
			if(num%2!=0 && num%3!=0 && num%5!=0) {dNot.add(num);}
			}
		divs.add(0, dTwo); divs.add(1, dThree); divs.add(2, dFive); divs.add(3, dNot);
		return divs;
	}
	public static List<Integer> wordLength(List<String> words){
		List<Integer> counts = new ArrayList<>();
		for(String word:words) {
			counts.add(word.length()); }
		return counts;
	}
	public static Set<String> charTest(Set<String> testSet, char ch) {
		Set<String> fill = new TreeSet<>();
		for(String str:testSet) {
			if((str.charAt(0) == Character.toUpperCase(ch)) || (str.charAt(0) == Character.toLowerCase(ch))) { fill.add(str); }
		}
		return fill;
	}
	public static List<String> stringToList(Set<String> strS){
		List<String> redo = new ArrayList<>();
		for(String str:strS) { redo.add(str); }
		return redo;
	}
	public static Set<Integer> evenNum(Set<Integer> test){
		Set<Integer> fill = new TreeSet<>();
		for(int num:test) {
			if(num%2==0) { fill.add(num); }	}
		return fill;
	}
	public static String dictLook(Map<String,String> store, String word) {
		String result = store.get(word);
		return result;
	}
	
	
	
}
