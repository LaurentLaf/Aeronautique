package aeronautique;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import dao.AvionDAO;
import dao.Connexion;
import dao.VolDAO;

public class Principale {

	public static void main(String[] args) {
			
		////////////////////////////////////////////////////////////
		//				TEST POUR AVION							  //
		////////////////////////////////////////////////////////////
		//Pour Find	System.out.println((new AvionDAO()).find(1002));
		
		//Pour update
		//Avion avion = new Avion(1006, "ccc", "Paris", 20);
		//(new AvionDAO()).update(avion);
		
		//Pour create
		//Avion avion = new Avion(2000, "bbb", "Rennes", 10);
		//(new AvionDAO()).create(avion);
		
		//Pour delete
		//Avion avion = new Avion(1005, "aaa", "Rennes", 10);
		//(new AvionDAO()).delete(avion);
		
		////////////////////////////////////////////////////////////
		//				TEST POUR PILOTE						  //
		////////////////////////////////////////////////////////////
		// Test Find System.out.println((new PiloteDAO()).find(1050));
		
		// Test Create
		//Pilote pilote = new Pilote("Toto", "Montpellier", 51000);
		//(new PiloteDAO()).create(pilote);
		
		// Test Update
		//Pilote pilote = new Pilote(1010, "Tata", "Paris", 49000);
		//(new PiloteDAO()).update(pilote);
		
		// Test Delete
		//Pilote pilote = new Pilote(1010, "Tata", "Paris", 49000);
		//(new PiloteDAO()).delete(pilote);
		
		////////////////////////////////////////////////////////
		//				TEST POUR VOL						  //
		////////////////////////////////////////////////////////
		
		//Test Find System.out.println((new VolDAO()).find(1008));
		
		// Test Create
		//GregorianCalendar HDep = new GregorianCalendar(2016, 05, 26, 15, 00, 00);
		//GregorianCalendar HArr = new GregorianCalendar(2016, 05, 26, 16, 00, 00);
		//Vol vol = new Vol(1001, 1001, "Rennes", "Paris", HDep, HArr);
		//(new VolDAO()).create(vol);
		
		// Test Delete
		//GregorianCalendar HDep = new GregorianCalendar(2016, 05, 26, 15, 00, 00);
		//GregorianCalendar HArr = new GregorianCalendar(2016, 05, 26, 16, 00, 00);
		//Vol vol = new Vol(1026, 1001, 1001, "Rennes", "Paris", HDep, HArr);
		//(new VolDAO()).delete(vol);
		
		// Test Update
		//GregorianCalendar HDep = new GregorianCalendar(2016, 05, 26, 17, 00, 00);
		//GregorianCalendar HArr = new GregorianCalendar(2016, 05, 26, 18, 00, 00);
		//Vol vol = new Vol(1024, 1002, 1004, "Rennes", "Paris", HDep, HArr);
		//(new VolDAO()).update(vol);
		
		
		Connexion.fermer();
	}
}
