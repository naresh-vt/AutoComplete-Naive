package com.naresh.auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AutoComplete {
	
	private static ArrayList<Suggestions> suggestions ;
	

    public AutoComplete(Suggestions[] sugs) {
    	if (sugs == null) {
    		throw new java.lang.NullPointerException();
    	}
    	this.suggestions = new ArrayList<Suggestions> (Arrays.asList(sugs)) ;
    	Collections.sort(suggestions);
    }	
    public static  Suggestions[] allMatches(String prefix) {
    	if (prefix == null) {
    		throw new java.lang.NullPointerException();
    	}
    	Suggestions temp = new Suggestions(prefix, 0);
    	
    	

    	int fi = BinarySearchInSuggestions.firstIndexOf(suggestions, temp, Suggestions.byPrefixOrder(prefix.length()));
    	int li = BinarySearchInSuggestions.lastIndexOf(suggestions, temp, Suggestions.byPrefixOrder(prefix.length()));
    	if (fi == -1 || li == -1) {
    		System.out.println("No word Found with the given prefix, adding it to Suggestions try next search:::");
    		Suggestions addToSugestion = new Suggestions(prefix, 1);
    		suggestions.add(addToSugestion);
    		Collections.sort(suggestions);
    		return null;
    	}
    	Suggestions[] matches = new Suggestions[li - fi + 1];
    	
		//matches = Arrays.copyOfRange(suggestions, i, j);
    	for(int begin = fi,k=0; begin <=li; begin++,k++){
    		matches[k]= suggestions.get(begin);
    	}
		Arrays.sort(matches, Suggestions.byReverseFreqOrder());
		for(int i =0 ; i<matches.length;i++){
			matches[i].freq++;
		}
		return matches;

    }
	
	public static void main(String[] args){
		Suggestions s1 = new Suggestions("Bangalore",2);
		Suggestions s2 = new Suggestions("Hyderbad",2);
		Suggestions s3 = new Suggestions("Banglaseds",1);
		Suggestions s4 = new Suggestions("Delhi",1);
		Suggestions s5 = new Suggestions("Banaras",3);
		Suggestions[] sugs = {s1,s2,s3,s4,s5};
		AutoComplete auto = new AutoComplete(sugs);
		Scanner in = new Scanner(System.in);

		while(true){
			String word = in.nextLine();
			Suggestions[] words = allMatches(word);
			if(words == null){
				System.out.println("");
				continue;
			}
			for(int i = 0 ; i < words.length; i++){
				System.out.println(words[i].word);
			}
		}
	}

}
