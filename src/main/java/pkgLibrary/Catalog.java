package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;

	@XmlElement(name = "book")
	ArrayList<Book> books;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public Book GetBook(String id) throws BookExcep
	{
		try{
		for(Book b : getBooks()){
			if(b.getId() == id){
				return b;
			} else {
				throw new BookExcep(b);
			}
		}
		} catch (BookExcep e)
		{
			throw e;
		}
		return new Book();
	}

	public void AddBook(String id) throws BookExcep{
		for (Book b : books) {
			if (b.getId().equals(id)) {
				throw new BookExcep(b);
			}
		}
		Book b = new Book(id);
		books.add(b);
	}
}