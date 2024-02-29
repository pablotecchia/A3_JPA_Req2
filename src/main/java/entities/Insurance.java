package entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "seguros")
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "compania")
	private String compania;

	@Column(name = "numero_poliza")
	private String policyNumber;

	@OneToOne 
	@JoinColumn(name = "fk_id_coche", referencedColumnName = "id")
	private Car referencedCar;
	
	
	

	public Insurance() {
		super();
	}

	

	public Insurance(String compania, String policyNumber) {
		super();
		this.compania = compania;
		this.policyNumber = policyNumber;
	}



	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPolicyNumber() {
		return policyNumber;
	}



	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}



	public Car getReferencedCar() {
		return referencedCar;
	}



	public void setReferencedCar(Car referencedCar) {
		this.referencedCar = referencedCar;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, policyNumber, referencedCar);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insurance other = (Insurance) obj;
		return id == other.id && Objects.equals(policyNumber, other.policyNumber)
				&& Objects.equals(referencedCar, other.referencedCar);
	}



	@Override
	public String toString() {
		return "Insurance [id=" + id + ", policyNumber=" + policyNumber + ", referencedCar=" + referencedCar + "]";
	}



	

}
