package aeronautique;

import dao.AvionDAO;
import dao.Connexion;

public class Principale {

	public static void main(String[] args) {
		

		//Avion avion = new Avion(1005, "aaa", "Rennes", 10);
		//System.out.println(avion.getNumAv());
		
		//Pour Find
		System.out.println((new AvionDAO()).find(1002));
		
		
		//Pour update
		/*
		Avion avion = new Avion(1006, "ccc", "Paris", 20);
		(new AvionDAO()).update(avion);
		*/
		
		//Pour create
		/*
		Avion avion = new Avion(2000, "bbb", "Rennes", 10);
		(new AvionDAO()).create(avion);
		*/
		
		// Pour delete
		/*
		Avion avion = new Avion(1005, "aaa", "Rennes", 10);
		System.out.println(avion.getNumAv());
		*/
		//(new AvionDAO()).delete(avion);
		
		
		
		//Connexion.afficheSelectEtoile("AVION");
		
		
		//AvionDAO a = new AvionDAO();
		//a.delete(avion);
		
		Connexion.fermer();
		
	}
}
