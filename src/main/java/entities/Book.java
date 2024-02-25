package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "libros")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "titulo")
	private String title;
	
	@Column(name = "precio")
	private double price;
	
	@Column(name = "id_autor")
	private int idAuthor;
	
	@Column(name = "id_editorial")
	private int idEditorial;
	
	@ManyToMany(mappedBy = "listBooks", cascade = CascadeType.PERSIST)
	private List<Library> listLibraries;
	
	public Book() {
		super();
	}

	public Book(String title, double price, int idAuthor, int idEditorial) {
		super();
		this.title = title;
		this.price = price;
		this.idAuthor = idAuthor;
		this.idEditorial = idEditorial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public List<Library> getListLibraries() {
		return listLibraries;
	}

	public void setListLibraries(List<Library> listLibraries) {
		this.listLibraries = listLibraries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", idAuthor=" + idAuthor + ", idEditorial="
				+ idEditorial + "]";
	}
	
	
}
