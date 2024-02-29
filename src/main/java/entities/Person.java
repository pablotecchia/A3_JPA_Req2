package entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Car> cochesPropiedad;
    

	public Person() {
		super();
	}

	
	public Person(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getDni() {
		return id;
	}



	public void setDni(int dni) {
		this.id = dni;
	}





	public List<Car> getCochesPropiedad() {
		return cochesPropiedad;
	}





	public void setCochesPropiedad(List<Car> cochesPropiedad) {
		this.cochesPropiedad = cochesPropiedad;
	}





	@Override
	public int hashCode() {
		return Objects.hash(id, name, cochesPropiedad);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(cochesPropiedad, other.cochesPropiedad);
	}


	@Override
	public String toString() {
		return "Person [dni=" + id + ", name=" + name + ", cochesPropiedad=" + cochesPropiedad + "]";
	}




	
	

}
