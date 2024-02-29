package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="concesionarios")
public class Dealership {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String name;
    
    @Column(name = "ubicacion")
    private String location;

    @ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="cochesConcesionario",
			  joinColumns = {@JoinColumn(name="id_concesionario", referencedColumnName = "id")},
			  inverseJoinColumns = {@JoinColumn(name="id_coche", referencedColumnName ="id")})
	private List<Car> listCars;
	
	public Dealership() {
		super();
	}

	
	public Dealership(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public List<Car> getListCars() {
		return listCars;
	}


	public void setListCars(List<Car> listCars) {
		this.listCars = listCars;
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
		if (!(obj instanceof Dealership))
			return false;
		Dealership other = (Dealership) obj;
		if (id != other.id)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Dealership [id=" + id + ", name=" + name + ", location=" + location + ", listCars=" + listCars + "]";
	}

	

}
