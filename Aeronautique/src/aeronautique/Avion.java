package aeronautique;

public class Avion {

	private int numAv = 0;
	private String nomAv;
	private String loc;
	private int capacite;
	private int enPlus = 0;
	
	public Avion(String nom, String loc, int capacite) {
		super();
		this.numAv = numAv++;
		this.nomAv = nom;
		this.loc = loc;
		this.capacite = capacite;
		this.enPlus = 15;
	}
	
	//Ajout de commentaire
	
	//Ajout d'un deuxi�me commentaire
	
	//Ajout d'un troisieme commentaire
	
	//Ajout d'un quatri�me commentaire
	
	//Ajout d'un cinqui�me commentaire
	
	//Ajout d'un sixi�me commentaire
	
	//Ajout d'un septieme commentaire
	
	//Ajout d'un huiti�me commentaire
	
	public String getNomAv() {
		return nomAv;
	}

	public void setNomAv(String nomAv) {
		this.nomAv = nomAv;
	}

	@Override
	public String toString() {
		return "Avion [numero=" + numAv + ", nom=" + nomAv + ", loc=" + loc + ", capacite=" + capacite + "]";
	}
}
