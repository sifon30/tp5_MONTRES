




package metier.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name = "MONTRES")
public class Montre implements Serializable{
	
	@Id 
	@Column (name="ID_Montre")
	@GeneratedValue (strategy=GenerationType.IDENTITY) 

	private Long idMontre;
	@Column (name="NOM_Montre")
	private String nomMontre;
	private double prix;
	
	@ManyToOne

	private Genre genre;

	
	public Montre(String nomMontre, double prix,Genre gen) {

		super();
		this.nomMontre = nomMontre;
		this.prix = prix;
		this.setGenre(gen);
		}

	public Genre getGenre() {
	return genre;
	}
	public void setGenre(Genre genre) {
	this.genre = genre;
	}

	
	public Montre() {
		super();
	}
	public Montre(String nomMontre, double prix) {
		super();
		this.nomMontre = nomMontre;
		this.prix = prix;
	}
	public Long getIdMontre() {
		return idMontre;
	}
	public void setIdMontre(Long idMontre) {
		this.idMontre = idMontre;
	}
	public String getNomMontre() {
		return nomMontre;
	}
	public void setNomMontre(String nomMontre) {
		this.nomMontre = nomMontre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Montre [idMontre=" + idMontre + ", nomMontre=" + nomMontre + ", prix=" + prix + "]";
	}
	
}
