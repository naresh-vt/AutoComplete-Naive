package com.naresh.auto;

import java.util.Comparator;

public class Suggestions implements Comparable<Suggestions> {
	
	public String word;
	public int freq;
	
	public Suggestions(String word, int freq) {
        if (word == null) {
            throw new java.lang.NullPointerException();
        }
        if (freq < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.word = word;
        this.freq = freq;
    }
	
	public static Comparator<Suggestions> byReverseFreqOrder() {
        return new Comparator<Suggestions>(){
            public int compare(Suggestions t1, Suggestions t2) {
                if (t1.freq > t2.freq) {
                    return -1;
                } else if (t1.freq == t2.freq) {
                    return 0;
                } else {
                    return 1;
                }
            } 
        };
        
    }
	
	 public static Comparator<Suggestions> byPrefixOrder(int prefLen) {
	        final int len = prefLen;
	        return new Comparator<Suggestions>(){
	            public int compare(Suggestions t1, Suggestions t2) {
	                String s1 = t1.word;
	                String s2 = t2.word;
	                int minlength = s1.length() < s2.length() ? s1.length() : s2.length();
	                if (minlength >= len) {
	                    return s1.substring(0, len).compareTo(s2.substring(0, len));
	                } else if (s1.substring(0, minlength).compareTo(s2.substring(0, minlength)) == 0) {
	                    if (s1.length() == minlength) return -1;
	                    else return 1;
	                } else return s1.substring(0, minlength).compareTo(s2.substring(0, minlength));
	            } 
	        };
	        
	    }
	 
	 public int compareTo(Suggestions that) {
	        String s1 = this.word;
	        String s2 = that.word;
	        return s1.compareTo(s2);
	             
	    }



}
