package dao;

import java.util.List;

import entities.Produit;

public interface IProduitDao {
	public void init() ;
   public Produit save(Produit produit);
   public List<Produit> findAll();
   public List<Produit> findByMc(String motCle);
   public Produit findById(Long id);
   public Produit update(Produit produit);
   public void delete(Long id);
}
