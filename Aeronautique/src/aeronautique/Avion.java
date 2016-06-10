package aeronautique;

public class Avion {

	private int numAv = 1005;
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
	
	public Avion(int numAv, String nom, String loc, int capacite) {
		super();
		this.numAv = numAv;
		this.nomAv = nom;
		this.loc = loc;
		this.capacite = capacite;
	}
	
	

	public int getNumAv() {return numAv;}
	public void setNumAv(int numAv) {this.numAv = numAv;}

	public String getLoc() {return loc;}
	public void setLoc(String loc) {this.loc = loc;}

	public int getCapacite() {return capacite;}
	public void setCapacite(int capacite) {this.capacite = capacite;}

	public String getNomAv() {return nomAv;}
	public void setNomAv(String nomAv) {this.nomAv = nomAv;}

	
	@Override
	public String toString() {
		return "Avion [numero=" + numAv + ", nom=" + nomAv + ", loc=" + loc + ", capacite=" + capacite + "]";
	}
}
