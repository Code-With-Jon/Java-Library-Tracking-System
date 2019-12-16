//import package
package Library_Tracking_System;
//import Iterator library
import java.util.Iterator;
//TrackingSystem class implements Iterable
public class TrackingSystem implements Iterable<Book> {
	//Method Variables
	BookRecord root;
	//Constructor 
	public TrackingSystem(BookRecord root) {
		this.root = root;
	}
	//recursive call on Add method
	public void add(Book book) throws DuplicateException {
		add(book, root);
	}
	//Add method with duplicateException if the book already exists
	public void add(Book book, BookRecord record) throws DuplicateException {
		if (record == null) {
			record = new BookRecord(book, null, null);
			return;
		} else if (record != null) {
			if (book.compareTo(record.getBook()) == 0) {
				throw new DuplicateException();
			} else if (book.compareTo(record.getBook()) == 1) {
				if (!record.hasRight()) {
					record.right = new BookRecord(book, null, null);
					return;
				}
				if (record.hasRight()) {
					add(book, record.getRight());
				}
			} else if (book.compareTo(record.getBook()) == -1) {
				if (!record.hasLeft()) {
					record.left = new BookRecord(book, null, null);
					return;
				}
				if (record.hasLeft()) {
					add(book, record.getLeft());
				}
			}
		}

	}
	//recursive call on contains method
	public boolean contains(Book book) {
		return contains(book, root);
	}
	//Contains Method tests if there is a record of the book by traversing left and right children & comparing
	boolean contains(Book book, BookRecord record) {
		if (record == null) {
			return false;
		} else {
			if (book.compareTo(record.getBook()) == 0) {
				return true;
			} else if (book.compareTo(record.getBook()) == 1) {
				if (!record.hasRight()) {
					return false;
				}
				if (record.hasRight()) {
					contains(book, record.getRight());
				} else if (book.compareTo(record.getBook()) == -1) {
					if (!record.hasLeft()) {
						return false;
					}
					if (record.hasLeft()) {
						contains(book, record.getLeft());
					}
				}
			}
		}
		return false;
	}
	//override Iterator method
	@Override
	public Iterator<Book> iterator() {

		return new BookIterator(root);
	}
}
