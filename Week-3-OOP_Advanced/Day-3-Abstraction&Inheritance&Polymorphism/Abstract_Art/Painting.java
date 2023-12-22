// package com.moneem.art;

public class Painting extends Art{
	
	// Member variables
	private String paintType;
	
	// Painting constructor
	public Painting(String title, String author, String description,String paintType) {
		super(title, author, description);
		this.paintType=paintType;
	}

	@Override
	public void viewArt() {
		System.out.println("========= Painting =======");
		System.out.printf(" Title : %s \n Author : %s\n Description : %s\n Paint Type : %s\n",
				this.getTitle(),this.getAuthor(),this.getDescription(),this.paintType);	
	}


	// Getters & Setters
	public String getPaintType() {
		return paintType;
	}
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
}
