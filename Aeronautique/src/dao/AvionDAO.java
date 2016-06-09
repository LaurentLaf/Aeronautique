package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import aeronautique.Avion;

public class AvionDAO extends DAO<Avion> {

	private static final String TABLE = "Avion";
	private static final String CLE_PRIMAIRE = "numAv";

	@Override
	public boolean create(Avion obj) {
		boolean succes = true;
		try {
			String requete = "INSERT INTO "+TABLE+" (nomAv, loc, capacite) VALUES (?, ?, ?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, obj.getNomAv());
			pst.setString(2, obj.getLoc());
			pst.setInt(3, obj.getCapacite());
			pst.executeUpdate();
			
			//Mettre à jour l'identifiant
			obj.setNumAv(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));
			
		} catch (Exception e) {
			succes = false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Avion obj) {
		Boolean succes = true;
		int id = obj.getNumAv();
		try {
			String requete = "DELETE FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean update(Avion obj) {
		Boolean succes = true;
		
		try {
			String requete = "UPDATE "+TABLE+" SET nomAv = ?,capacite = ?, loc = ? WHERE numAv = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, obj.getNomAv());
			pst.setInt(2, obj.getCapacite());
			pst.setString(3, obj.getLoc());
			pst.setInt(4, obj.getNumAv());
			pst.executeUpdate();
			
		} catch (Exception e) {
			succes = false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public Avion find(int id) {
		Avion avion = null;
		try {
			String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
			ResultSet rs = Connexion.executeQuery(requete);
			rs.next();
			// On peut soit choisir l'intitulé de la colonne ou le numéro d'index de celle-ci
			
			String nom = rs.getString("nomAv");
			//String nom = rs.getString(2);
						
			String loc = rs.getString("loc");
						
			int capacite = rs.getInt("capacite");
			
			
			avion = new Avion(id, nom, loc, capacite);
		} catch (Exception e) {
			System.err.println("L'avion n'existe pas");
			//e.printStackTrace();
		}
		return avion;
	}
}
