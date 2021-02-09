package Entities;

public class Book {

	public String title;
	public String author;
	public int pages;
	public double price;
	public int id;
	
	public Book(String title, String author, int pages, double price, int id) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
		this.id = id;
	}
	
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



//to STRING
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", pages=" + pages + ", price=" + price + ", id=" + id
				+ "]";
	}


	
	

	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void CadastrarLivros() {
		
	}
}
