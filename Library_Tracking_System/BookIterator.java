//import package
package Library_Tracking_System;
//import Iterator Library
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
//BookIterator class 
public class BookIterator implements Iterator<Book> {
	//Class Variables
	private String author;
	private Queue<BookRecord> records = new LinkedList<BookRecord>();
	//Constructor with BFS author filter
	BookIterator(BookRecord root, String author) {
		this.author = author;
		this.records.add(root);
		traverseBFSwithAuthorFilter(root);
	}
	//Constructor base
	BookIterator(BookRecord root) {
		this.records.add(root);
		traverseBFS(root);
	}
	//BFS with author filter method tests and adds book to records if authors match
	void traverseBFSwithAuthorFilter(BookRecord record) {
		if (record.isLeaf())
			return;
		LinkedList<BookRecord> children = record.getChildren();
		for (BookRecord b : children)
			if (b.getBook().getAuthor().equals(author))
				records.add(b);

		for (BookRecord b : children)
			traverseBFSwithAuthorFilter(b);
	}
	//BFS traversal method  adds children to records
	void traverseBFS(BookRecord record) {
		if (record.isLeaf())
			return;
		LinkedList<BookRecord> children = record.getChildren();
		for (BookRecord b : children)
			records.add(b);

		for (BookRecord b : children)
			traverseBFS(b);
	}
	//override hasNext method tests if there's a next record
	@Override
	public boolean hasNext() {
		if (!records.isEmpty())
			return true;
		return false;
	}
	//override next method if there is a next record, return next record
	@Override
	public Book next() {
		if (hasNext()) {
			return records.poll().getBook();
		}
		return null;
	}
	
	public Queue<BookRecord> getQueue(){
		return records;
	}

}
