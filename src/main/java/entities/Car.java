package entities;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "coches")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "marca")
    private String brand;

    @Column(name = "modelo")
    private String model;

    @Column(name = "matricula")
    private String licensePlate;  

    @ManyToOne
    @JoinColumn(name = "fk_owner" ,referencedColumnName = "id") // aqui queria referenciar el dni ( Muchos coches pueden pertenecer a una persona)
    private Person owner; 
    
    @ManyToMany(mappedBy = "listCars", cascade = CascadeType.PERSIST)
	private List<Dealership> listDealership;
  
    
    @OneToOne(mappedBy = "referencedCar", cascade=CascadeType.ALL)
	private Insurance insurance;

    
    // Constructor
    public Car() {
        super();
    }

	public Car(String brand, String model, String licensePlate) {
		super();
		this.brand = brand;
		this.model = model;
		this.licensePlate = licensePlate;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getLicensePlate() {
		return licensePlate;
	}



	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}



	public Person getOwner() {
		return owner;
	}



	public void setOwner(Person owner) {
		this.owner = owner;
	}



	public List<Dealership> getListDealership() {
		return listDealership;
	}



	public void setListDealership(List<Dealership> listDealership) {
		this.listDealership = listDealership;
	}



	public Insurance getInsurance() {
		return insurance;
	}



	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}



	@Override
	public int hashCode() {
		return Objects.hash(brand, id, insurance, licensePlate, listDealership, model, owner);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(brand, other.brand) && id == other.id && Objects.equals(insurance, other.insurance)
				&& Objects.equals(licensePlate, other.licensePlate)
				&& Objects.equals(listDealership, other.listDealership) && Objects.equals(model, other.model)
				&& Objects.equals(owner, other.owner);
	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", licensePlate=" + licensePlate + ", owner="
				+ owner + ", listDealership=" + listDealership + ", insurance=" + insurance + "]";
	}






   
    }

	

