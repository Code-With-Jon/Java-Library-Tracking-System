//import package
package Library_Tracking_System;
//import random library
import java.util.Random;
//Run class
public class Run {
	//Main
	public static void main(String[] args) throws DuplicateException {
		//Create root book node, tracking system, and number generator
		Book rootBook = new Book("Author0", "Title0", 150);
		BookRecord root = new BookRecord(rootBook);
		TrackingSystem trackingSystem = new TrackingSystem(root);
		Random gen = new Random();
		//for loop to create 9 children nodes in the trackingSystem
		for (int i = 1; i < 10; i++) {
			
			Book childBook = new Book("Author" +i, "Title" + i, gen.nextInt(200));
			System.out.println(childBook);
			trackingSystem.add(childBook);
		}
		//Iterator to Iterate over nodes and print all nodes in tracking system
		BookIterator itorator = (BookIterator) trackingSystem.iterator();
		System.out.println(itorator.getQueue().size());
		while(itorator.hasNext()) {
			System.out.println(itorator.next());
		}
		//Iterator to Iterate over nodes and print all nodes in tracking system with Specific Author Filter
		System.out.println("With filter");
		BookIterator iteratorWithAuthor = new BookIterator(trackingSystem.root,"Author0");
		while(iteratorWithAuthor.hasNext()) {
			System.out.println(iteratorWithAuthor.next());
		}
	}

}
