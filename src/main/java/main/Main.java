package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Author;
import entities.Book;
import entities.Editorial;
import entities.Library;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryJPA");
		EntityManager em = factory.createEntityManager();
		
		//OPERACIONES
		//Dar de alta 3 autores
		Author author1 = new Author("Gabriel","García Márquez", new Date(27,2,6));
		Author author2 = new Author("Agatha","Christie", new Date(90,8,15));
		Author author3 = new Author("Stephen","King", new Date(47,8,21));
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(author1);
		em.persist(author2);
		em.persist(author3);
		
		//Dar de alta 2 editoriles
		Editorial editorial1 = new Editorial("Penguin Random House", "123 Main Street, Cityville");
		Editorial editorial2 = new Editorial("HarperCollins", "456 Oak Avenue, Townsville");
		em.persist(editorial1);
		em.persist(editorial2);
		
		//Dar de alta 8 libros
		Book book1 = new Book("Cien años de soledad", 25.99, 1, 1);
		Book book2 = new Book("El asesinato de Roger Ackroyd", 19.99, 2, 2);
		Book book3 = new Book("IT", 21.50, 3, 1);
		Book book4 = new Book("El otoño del patriarca", 29.95, 1, 2);
		Book book5 = new Book("Asesinato en Mesopotamia", 22.75, 2, 1);
		Book book6 = new Book("The shining", 18.99, 3, 2);
		Book book7 = new Book("Crónica de una muerte anunciada", 20.50, 1, 1);
		Book book8 = new Book("Asesinato en el Orient Express", 24.75, 2, 2);
		em.persist(book1);
		em.persist(book2);
		em.persist(book3);
		em.persist(book4);
		em.persist(book5);
		em.persist(book6);
		em.persist(book7);
		em.persist(book8);
		
		//Dar de alta 2 librerías con 4 libros cada una de ellas
		Library library1 = new Library("Librería La Pluma Dorada", "Ana Martínez", "789 Oak Street, Citytown");
		List<Book> listBooks1 = new ArrayList<Book>();
		listBooks1.add(book1);
		listBooks1.add(book2);
		listBooks1.add(book3);
		listBooks1.add(book4);
		library1.setListBooks(listBooks1);
		Library library2 = new Library("Leer es Vivir", "Sara Pérez", "404 Spruce Avenue, Hamletton");
		List<Book> listBooks2 = new ArrayList<Book>();
		listBooks2.add(book5);
		listBooks2.add(book6);
		listBooks2.add(book7);
		listBooks2.add(book8);
		library2.setListBooks(listBooks2);
		em.persist(library1);
		em.persist(library2);
		
		et.commit();
		
		//CONSULTAS
		//Listado de libros
		System.out.println("\nxxxxxxxxxxx LISTADO DE LIBROS xxxxxxxxxxx");
		List<Book> listBooks = em.createQuery("from Book b").getResultList();
		for(Book b : listBooks) {
			System.out.println(b);
		}
		
		//Listado de autores
		System.out.println("\nxxxxxxxxxxx LISTADO DE AUTORES xxxxxxxxxxx");
		List<Author> listAuthors = em.createQuery("from Author a").getResultList();
		for(Author a : listAuthors) {
			System.out.println(a);
		}
		
		//Listado de librerías
		System.out.println("\nxxxxxxxxxxx LISTADO DE LIBRERÍAS xxxxxxxxxxx");
		List<Library> listLibraries = em.createQuery("from Library l").getResultList();
		for(Library l : listLibraries) {
			System.out.println("Librería: " + l.getName() + "\n" + "Libros: " + l.getListBooks());
			System.out.println("---");
		}
		
		//Listado de libros y su librería
		System.out.println("\nxxxxxxxxxxx LISTADO DE LIBROS Y SUS LIBRERÍAS xxxxxxxxxxx");
		List<Object[]> resultList = em.createQuery("SELECT b, l FROM Book b JOIN b.listLibraries l", Object[].class).getResultList();
		for (Object[] result : resultList) {
		    Book book = (Book) result[0];
		    Library library = (Library) result[1];

		    System.out.println("Libro: " + book.getTitle());
		    System.out.println("Librería: " + library.getName());
		    System.out.println("---");
		}
		em.close();
		System.out.println("\nxxxxxxxxxxx FIN DE CONSULTAS xxxxxxxxxxx");
	}

}
