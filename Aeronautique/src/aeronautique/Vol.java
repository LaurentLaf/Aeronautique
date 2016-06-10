package aeronautique;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class Vol {
	
	private int numero = 0;
	private int numPil;
	private int numAv;
	private String villeDep;
	private String villeArr;
	private GregorianCalendar heureDep;
	private GregorianCalendar heureArr;
	
	
	// Pour les bases de données, on passera par java.sql.Timestamp
		/* Pour le find :
		 * GregorianCalendar hArr = new GregorianCalendar();
		 * hArr.setTimesInMillis (rs.getTimeStamp("harr").getTime());
		 * Pour le create :
		 * Timestamp ts = new Timestamp (vol.gethDep().getTimeInMillis());
		 * pst.setTimestamp(3,ts); 
		 */
	
	public Vol(int numPil, int numAv, String villeDep, String villeArr, GregorianCalendar heureDep,
			GregorianCalendar heureArr) {
		super();
		this.numero = numero++;
		this.numPil = numPil;
		this.numAv = numAv;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		this.heureDep = heureDep;
		this.heureArr = heureArr;
	}
	
	public Vol(int numVol, int numPil, int numAv, String villeDep, String villeArr,
			GregorianCalendar heureDep,	GregorianCalendar heureArr) {
		super();
		this.numero = numVol;
		this.numPil = numPil;
		this.numAv = numAv;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		this.heureDep = heureDep;
		this.heureArr = heureArr;
	}

	public int getNumero() {return numero;}
	public void setNumero(int numero) {this.numero = numero;}

	public int getNumPil() {return numPil;}
	public void setNumPil(int numPil) {this.numPil = numPil;}

	public int getNumAv() {return numAv;}
	public void setNumAv(int numAv) {this.numAv = numAv;}

	public String getVilleDep() {return villeDep;}
	public void setVilleDep(String villeDep) {this.villeDep = villeDep;}

	public String getVilleArr() {return villeArr;}
	public void setVilleArr(String villeArr) {this.villeArr = villeArr;}

	public GregorianCalendar getHeureDep() {return heureDep;}
	public void setHeureDep(GregorianCalendar heureDep) {this.heureDep = heureDep;}
	
	public GregorianCalendar getHeureArr() {return heureArr;}
	public void setHeureArr(GregorianCalendar heureArr) {this.heureArr = heureArr;}

	@Override
	public String toString() {
		// TimeStamp de java.sql se rapproche du dateTime de sql Server
		Timestamp hDepTs = new Timestamp(heureDep.getTimeInMillis()); 
		Timestamp hArrTs = new Timestamp(heureArr.getTimeInMillis()); 
		return "Vol [numVol=" + numero + ", numAv=" + numAv + ","
				+ "numPil=" + numPil + ", hDep=" + hDepTs + ", hArr="
				+ hArrTs + ", villeDep=" + villeDep + ", villeArr=" +
				villeArr + "]";
	}
	
	
	
}
