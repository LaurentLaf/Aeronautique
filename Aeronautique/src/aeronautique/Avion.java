package aeronautique;

public class Avion {

	private int numAv = 0;
	private String nomAv;
	private String loc;
	private int capacite;
	
	public Avion(String nom, String loc, int capacite) {
		super();
		this.numAv = numAv++;
		this.nomAv = nom;
		this.loc = loc;
		this.capacite = capacite;
	}
	
	//Ajout de commentaire
	
	//Ajout d'un deuxième commentaire
	
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
