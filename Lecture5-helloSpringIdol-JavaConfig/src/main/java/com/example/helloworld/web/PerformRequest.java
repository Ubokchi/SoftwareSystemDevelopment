package com.example.helloworld.web;

public class PerformRequest {
	private String performer;
	private String requester;
	private int number;
	
	public String getPerformer() {
		return performer;
	}
	public void setPerformer(String performer) {
		this.performer = performer;
	}
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "PerformRequest [performer=" + performer + ", requester=" + requester + ", number=" + number + "]";
	}
	
}
