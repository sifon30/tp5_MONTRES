package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity  
public class Genre implements Serializable {
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long idGen;
	private String 	nomGen;
	
	@Temporal( TemporalType.DATE)
	private Date dateCreation;
	

	@OneToMany (mappedBy="genre") 
     private List<Montre> montres;
	
	
	public Genre() {
		super();
	}
	public Genre(String nomGen, Date dateCreation) {
		super();
		this.nomGen = nomGen;
		this.dateCreation = dateCreation;
	}
	public Long getIdGen() {
		return idGen;
	}
	public void setIdGen(Long idGen) {
		this.idGen = idGen;
	}
	public String getNomGen() {
		return nomGen;
	}
	public void setNomGen(String nomGen) {
		this.nomGen = nomGen;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public List<Montre> getMontres() {
		return montres;
	}
	public void setMontres(List<Montre> montres) {
		this.montres = montres;
	}
	@Override
	public String toString() {
		return "Genre [idGen=" + idGen + ", nomGen=" + nomGen + ", dateCreation=" + dateCreation + ", montres="
				+ montres + "]";
	}
	
}