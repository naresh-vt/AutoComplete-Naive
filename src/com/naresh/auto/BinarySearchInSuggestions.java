package com.naresh.auto;

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchInSuggestions {
	

    public static <Suggestions> int firstIndexOf(ArrayList<Suggestions> a, Suggestions prefix, Comparator<Suggestions> comparator) {
    	if (a == null || prefix == null || comparator == null) {
    		throw new java.lang.NullPointerException();
    	}
    	if (a.size() == 0) {
    		return -1;
    	}
    	int l = 0;
    	int r = a.size() - 1;
    	while (l + 1 < r) {
    		int mid = l + (r - l)/2;
    		if (comparator.compare(prefix, a.get(mid)) <= 0) {
    			r = mid;
    		} else {
    			l = mid;
    		}
    	}
    	if (comparator.compare(prefix, a.get(l)) == 0) {
    		return l;
    	}
    	if (comparator.compare(prefix, a.get(r)) == 0) {
    		return r;
    	}
    	return -1;

    }

    public static <Suggestions> int lastIndexOf(ArrayList<Suggestions> a, Suggestions prefix, Comparator<Suggestions> comparator) {
    	if (a == null || prefix == null || comparator == null) {
    		throw new java.lang.NullPointerException();
    	}
    	if (a == null || a.size() == 0) {
    		return -1;
    	}
    	int l = 0;
    	int r = a.size() - 1;
    	while (l + 1 < r) {
    		int mid = l + (r - l)/2;
    		if (comparator.compare(prefix, a.get(mid)) < 0) {
    			r = mid;
    		} else {
    			l = mid;
    		}
    	}
    	if (comparator.compare(prefix, a.get(r)) == 0) {
    		return r;
    	}
    	if (comparator.compare(prefix, a.get(l)) == 0) {
    		return l;
    	}
    	return -1;
    }

}
