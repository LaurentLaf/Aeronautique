package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import aeronautique.Pilote;

public class PiloteDAO extends DAO<Pilote> {

	private static final String TABLE = "PILOTE";
	private static final String CLE_PRIMAIRE = "numPil";
	
	@Override
	public boolean create(Pilote obj) {
		boolean succes = true;
		try {
			String requete = "INSERT INTO "+TABLE+" (nomPil, adr, sal) VALUES (?, ?, ?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, obj.getNomPil());
			pst.setString(2, obj.getAdr());
			pst.setInt(3, obj.getSal());
			pst.executeUpdate();
			
			//Mettre à jour l'identifiant
			obj.setNumPil(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));
			
		} catch (Exception e) {
			succes = false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Pilote obj) {
		Boolean succes = true;
		int id = obj.getNumPil();
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
	public boolean update(Pilote obj) {
		Boolean succes = true;
		
		try {
			String requete = "UPDATE "+TABLE+" SET nomPil = ?,adr = ?, sal = ? WHERE numPil = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, obj.getNomPil());
			pst.setString(2, obj.getAdr());
			pst.setInt(3, obj.getSal());
			pst.setInt(4, obj.getNumPil());
			pst.executeUpdate();
			
		} catch (Exception e) {
			succes = false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public Pilote find(int id) {
		Pilote pilote = null;
		try {
			String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
			ResultSet rs = Connexion.executeQuery(requete);
			rs.next();
			// On peut soit choisir l'intitulé de la colonne ou le numéro d'index de celle-ci
			
			String nom = rs.getString("nomPil");
			//String nom = rs.getString(2);
						
			String adr = rs.getString("adr");
						
			int sal = rs.getInt("sal");
			
			
			pilote = new Pilote(id, nom, adr, sal);
		} catch (Exception e) {
			System.err.println("Le pilote n'existe pas");
			//e.printStackTrace();
		}
		return pilote;
	}
	
}
