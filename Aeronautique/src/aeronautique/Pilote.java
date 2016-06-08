package aeronautique;

public class Pilote {

	private int numPil = 0;
	private String nomPil;
	private String adr;
	private int sal;
	
	public Pilote(String nom, String adr, int sal) {
		super();
		this.numPil = numPil++;
		this.nomPil = nom;
		this.adr = adr;
		this.sal = sal;
	}
	
	
}