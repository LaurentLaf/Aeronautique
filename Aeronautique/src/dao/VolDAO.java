package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import aeronautique.Vol;

public class VolDAO extends DAO<Vol> {

	private static final String TABLE = "VOL";
	private static final String CLE_PRIMAIRE = "numVol";
	
	@Override
	public boolean create(Vol obj) {
		boolean succes = true;
		try {
			String requete = "INSERT INTO "+TABLE+" (numPil, numAv, villeDep, villeArr, HDep, HArr) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, obj.getNumPil());
			pst.setInt(2, obj.getNumAv());
			pst.setString(3, obj.getVilleDep());
			pst.setString(4, obj.getVilleArr());
			
			Timestamp tsHDep = new Timestamp (obj.getHeureDep().getTimeInMillis());
			pst.setTimestamp(5, tsHDep);
			
			Timestamp tsHArr = new Timestamp (obj.getHeureArr().getTimeInMillis());
			pst.setTimestamp(6, tsHArr);
			
			pst.executeUpdate();
			
			//Mettre à jour l'identifiant
			obj.setNumero(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));
			
		} catch (Exception e) {
			succes = false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Vol obj) {
		Boolean succes = true;
		int id = obj.getNumero();
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
	public boolean update(Vol obj) {
		Boolean succes = true;
		
		try {
			String requete = "UPDATE "+TABLE+" SET numPil = ?,numAv = ?, villeDep = ?, villeArr = ?, HDep = ?, HArr = ? WHERE numVol = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, obj.getNumPil());
			pst.setInt(2, obj.getNumAv());
			pst.setString(3, obj.getVilleDep());
			pst.setString(4, obj.getVilleArr());
			
			Timestamp tsHDep = new Timestamp (obj.getHeureDep().getTimeInMillis());
			pst.setTimestamp(5, tsHDep);
			
			Timestamp tsHArr = new Timestamp (obj.getHeureArr().getTimeInMillis());
			pst.setTimestamp(6, tsHArr);
			
			pst.setInt(7, obj.getNumero());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			succes = false;
			e.printStackTrace();
		}
		return succes;
	}
	
	@Override
	public Vol find(int id) {
		Vol vol = null;
		try {
			String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
			ResultSet rs = Connexion.executeQuery(requete);
			rs.next();
			int numPil = rs.getInt("numPil");
			int numAv = rs.getInt("numAv");
			String villeDep = rs.getString("villeDep");
			String villeArr = rs.getString("villeArr");
			
			GregorianCalendar heureDep = new GregorianCalendar();
			Timestamp hdep = rs.getTimestamp("HDep");
			heureDep.setTimeInMillis(hdep.getTime());
			
			GregorianCalendar heureArr = new GregorianCalendar();
			Timestamp harr = rs.getTimestamp("HArr");
			heureArr.setTimeInMillis(harr.getTime());
			
			vol = new Vol(id, numPil, numAv, villeDep, villeArr, heureDep, heureArr);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vol;
	}
}
