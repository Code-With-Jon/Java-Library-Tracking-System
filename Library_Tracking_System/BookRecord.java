//import package
package Library_Tracking_System;
//import LinkedList Library 
import java.util.LinkedList;
//BookRecord Class
public class BookRecord {
	//Method variables 
	protected BookRecord left;
	protected BookRecord right;
	protected Book book;
	//Constructor
	public BookRecord(Book book, BookRecord left, BookRecord right) {
		this.book = book;
		this.left = left;
		this.right = right;
	}
	//Base Constructor
	public BookRecord(Book book) {
		this.book = book;
		this.left = null;
		this.right = null;
	}
	//hasRight Method returns true if there is a right child
	public boolean hasRight() {
		if (right != null) {
			return true;
		}
		return false;
	}
	//hasLeft Method returns true if there is a left child
	public boolean hasLeft() {
		if (left != null) {
			return true;
		}
		return false;
	}
	//isLeaf Method returns true if node is a leaf
	public boolean isLeaf() {
		if (right == null && left == null) {
			return true;
		}
		return false;
	}
	//getChildren Method stores children in LinkedList
	public LinkedList<BookRecord> getChildren() {
		LinkedList<BookRecord> temp = new LinkedList<BookRecord>();

		if (hasLeft())
			temp.add(left);
		if (hasRight())
			temp.add(right);

		return temp;
	}
	//Getters && Setters
	public BookRecord getLeft() {
		return left;
	}

	public void setLeft(BookRecord left) {
		this.left = left;
	}

	public BookRecord getRight() {
		return right;
	}

	public void setRight(BookRecord right) {
		this.right = right;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
