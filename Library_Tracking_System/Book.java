// import package
package Library_Tracking_System;

//Book Class
public class Book implements Comparable<Book>{
	//Book Class Variables
	private String author, title;
	private int ISBN;
	
	//Constructor
	public Book(String author, String title, int ISBN) {
		this.author = author;
		this.title = title;
		this.ISBN = ISBN;
	}
	
	//Getters/Setters
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getISBN() {
		return ISBN;
	}


	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	//To String 
	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", ISBN=" + ISBN + "]";
	}
	
	//boolean equals method to test if the passed in object is the same book 
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == Book.class) {
			Book new_Book = (Book)obj;
			if (this.ISBN == new_Book.ISBN)
				return true;
		}
	return false;
	}
	//compareTo method compares ISBN numbers of current ISBN to other ISBN and returns int based on values.
	@Override
	public int compareTo(Book o) {
		if(this.ISBN == o.ISBN) {
			return 0;
		} else if (this.ISBN < o.ISBN) {
			return -1;
		}else {
			return 1;
		}
	}	
}
