package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Insurance;
import entities.Car;
import entities.Dealership;
import entities.Person;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("carsJPA");
		EntityManager em = factory.createEntityManager();

		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		// Damos de alta a las personas
		
		Person pedro = new Person("Pedro Sanchez");
		Person luis = new Person("Luis Perez");
		Person maria = new Person("Maria Jimenez");
		
		em.persist(pedro);
		em.persist(luis);
		em.persist(maria);
		
		
		Car coche1 = new Car("Toyota", "Corolla", "1670FHP");
		Car coche2 = new Car("Ford", "Focus", "2525KGB");
		Car coche3 = new Car("Bmw", "Serie 1", "1234MNM");
		Car coche4 = new Car("Honda", "Civic", "4567ABC");
		Car coche5 = new Car("Volkswagen", "Golf", "7890XYZ");
		Car coche6 = new Car("Audi", "A4", "2345PQR");
		
		coche1.setOwner(maria);
		coche2.setOwner(luis);
		coche3.setOwner(pedro);
		
		
		 em.persist(coche1);
		 em.persist(coche2);
		 em.persist(coche3);
		 em.persist(coche4);
		 em.persist(coche5);
		 em.persist(coche6);
		 
		
		Insurance seguro1 = new Insurance("Allianz","1234567890");
		Insurance seguro2 = new Insurance("Balumba","1234567891");
		Insurance seguro3 = new Insurance("Axa","1234567892");
		Insurance seguro4 = new Insurance("Mapfre","1234567893");
		Insurance seguro5 = new Insurance("Qualitas","9999999");
		Insurance seguro6 = new Insurance("Seguros Bilbao","1234567893");
		
		
		 
		
		 // Asignamos los seguros a los coches
		 
		coche1.setInsurance(seguro1);
		coche2.setInsurance(seguro2);
		coche3.setInsurance(seguro3);
		coche4.setInsurance(seguro4);
		coche5.setInsurance(seguro5);
		coche6.setInsurance(seguro6);
		
		
		seguro1.setReferencedCar(coche1);
		seguro2.setReferencedCar(coche2);
	
		 em.persist(seguro1);
		 em.persist(seguro2);
		 em.persist(seguro3);
		 em.persist(seguro4);
		 em.persist(seguro5);
		 em.persist(seguro6);
		
		Dealership concesionario1 = new Dealership("Autansa", "Barcelona");
		Dealership concesionario2 = new Dealership("CarCenter", "Madrid");
		Dealership concesionario3 = new Dealership("Autos del Sur", "Sevilla");
		
		// Creamos primera lista de coches y la asignamos a un concesionario
		
		List<Car> listaCoches1 = new ArrayList<Car>();
		
		listaCoches1.add(coche1);
		listaCoches1.add(coche2);
		listaCoches1.add(coche3);
		listaCoches1.add(coche4);
		
		concesionario1.setListCars(listaCoches1);
		
		// Creamos segunda lista de coches y la asignamos a un concesionario
		
		List<Car> listaCoches2 = new ArrayList<Car>();
		
		listaCoches2.add(coche5);
		listaCoches2.add(coche6);
		
		concesionario2.setListCars(listaCoches2);
		
		em.persist(concesionario1);
		em.persist(concesionario2);
		
		et.commit();
	}

}
