package com.consuming_api_.moneem.models;

import java.util.List;

public class People {

	private Integer count;
	private String next;
	private String previous;
	private List<Character> results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<Character> getResults() {
		return results;
	}

	public void setResults(List<Character> results) {
		this.results = results;
	}

}
