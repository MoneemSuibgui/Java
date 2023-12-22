// package com.moneem.art;

public class Sculpture extends Art {
	// Member variables
	private String material;
	
	// Sculpture constructor
	public Sculpture(String title, String author, String description,String material) {
		super(title,author,description);
		this.material=material;
	}
	
	@Override
	public void viewArt() {
		System.out.println("========= Sculpture =======");
		System.out.printf(" Title : %s \n Author : %s\n Description : %s\n Material : %s\n",
				this.getTitle(),this.getAuthor(),this.getDescription(),this.material);	
	}
	
	// Getters & Setters 
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}
