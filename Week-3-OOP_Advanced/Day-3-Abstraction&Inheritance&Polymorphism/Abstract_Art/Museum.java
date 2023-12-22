// package com.moneem.art;
import java.util.ArrayList;
import java.util.Random;
public class Museum {


	public static void main(String[] args) {
		// create ArrayList of Art Objects to store paintings and sculptures
		ArrayList<Art> museum=new ArrayList<Art>();
		
		// create 3 instances of Painting
		Painting painting1=new Painting("Mona liza","Leonardo da Vinci","one of the world's most recognizable paintings","painted in oil");
		Painting painting2=new Painting("Rhythm","Piet Mondrian","a pause incorporated into a sequence","Composition en rouge, jaune, bleu et noir");
		Painting painting3=new Painting("The Birth Of Venus","Botticelli","it depicts the godess Venus arriving at the store after her birth","painted in oil");
		
		// create 2 instances of Sculpture
		Sculpture sculpture1= new Sculpture("Ronde-bosse","Michel-Ange","est un des plus hauts chef-d’œuvre de la sculpture","marble");
		Sculpture sculpture2= new Sculpture("De Dokwerker","Mari Silverster Andriessen"," the dock worker was cast in 1952 at the Binder bronze foundry in Haarlem","marble");
		
		// display all painting & sculpture instances info
		painting1.viewArt();
		painting2.viewArt();
		painting3.viewArt();
		
		sculpture1.viewArt();
		sculpture2.viewArt();
		
		// store all painting and sculpture instances in museum ArrayList
		museum.add(painting1);
		museum.add(painting2);
		museum.add(painting3);
		museum.add(sculpture1);
		museum.add(sculpture2);
		
		// get all art title in the museum
		System.out.println("========= Arts Titles in our museum :=======");
		for(Art art: museum) {
			System.out.println(art.getTitle());
		}
		
		
		//use the viewArt() method of all of the artwork in the museum in a random order
		Random randomArt=new Random();
		System.out.println("\n========= Get Random Art in our museum :=======");
		Art myRandomArt=museum.get(randomArt.nextInt(museum.size()));
		myRandomArt.viewArt();
		
		
		
		

	}

}
