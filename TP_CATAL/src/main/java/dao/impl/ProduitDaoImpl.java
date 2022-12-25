package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.SingletonConnection;
import dao.IProduitDao;
import entities.Produit;

public class ProduitDaoImpl implements IProduitDao{
	
	public ProduitDaoImpl() {
		
	}
	
	@Override
	public void init()  {
		System.out.println("Initialisation ......");
	}
	
	@Override
	public Produit save(Produit produit)  {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO PRODUITS(DESIGNATION, PRIX, QUANTITE) VALUES (?, ?, ?)");
			ps.setString(1, produit.getDesignation());
			ps.setString(2, String.valueOf(produit.getPrix()));
			ps.setString(3, String.valueOf(produit.getQuantite()));
			ps.executeUpdate();
			ps.close();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");
			ResultSet res = ps2.executeQuery();
			if(res.next()) {
				produit.setId(res.getLong("MAX_ID"));
			}
			//connection.close(); e use singleton so e should keep connection open

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produit;
	}

	@Override
	public List<Produit> findAll() {
		Connection connection = SingletonConnection.getConnection();
        List<Produit> produits = new ArrayList<>();     
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS");
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				produits.add(new Produit(res.getLong("ID"),res.getString("DESIGNATION"), res.getDouble("PRIX"),res.getInt("QUANTITE")));
			}
			//connection.close(); e use singleton so e should keep connection open

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produits;
	}

	@Override
	public List<Produit> findByMc(String motCle) {
		Connection connection = SingletonConnection.getConnection();
        List<Produit> produits = new ArrayList<>();     
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps.setString(1, "%" + motCle + "%");
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				produits.add(new Produit(res.getLong("ID"),res.getString("DESIGNATION"), res.getDouble("PRIX"),res.getInt("QUANTITE")));
			}
			//connection.close(); e use singleton so e should keep connection open

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produits;
	}

	@Override
	public Produit findById(Long id) {
		Connection connection = SingletonConnection.getConnection();
        Produit produit = null;     
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID=?");
			ps.setLong(1, id);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				produit = new Produit(res.getLong("ID"),res.getString("DESIGNATION"), res.getDouble("PRIX"),res.getInt("QUANTITE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produit;
	}

	@Override
	public Produit update(Produit produit) {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE PRODUITS SET DESIGNATION=?, PRIX=?, QUANTITE=? WHERE ID=?");
			ps.setString(1, produit.getDesignation());
			ps.setString(2, String.valueOf(produit.getPrix()));
			ps.setString(3, String.valueOf(produit.getQuantite()));
			ps.setString(4, String.valueOf(produit.getId()));
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produit;
	}

	@Override
	public void delete(Long id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
