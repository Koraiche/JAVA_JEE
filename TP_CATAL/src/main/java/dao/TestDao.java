package dao;

import java.util.List;

import dao.impl.ProduitDaoImpl;
import entities.Produit;

public class TestDao {

	public static void main(String[] args) {
		IProduitDao produitRepository = new ProduitDaoImpl();
		/*
		Produit produit1 = produitRepository.save(new Produit(null, "HP_6580", 1580, 23));
		Produit produit2 = produitRepository.save(new Produit(null, "DELL_5832", 2570, 74));
		Produit produit3 = produitRepository.save(new Produit(null, "MAC_1475", 3750, 25));
		Produit produit4 = produitRepository.save(new Produit(null, "SAMSUNG_9674", 1740, 14));
		Produit produit5 = produitRepository.save(new Produit(null, "LG_0186", 2910, 35));
		Produit produit6 = produitRepository.save(new Produit(null, "HUAWEI_7391", 1989, 46));
		System.out.println(produit1);
		*/
		List<Produit> listComplete = produitRepository.findAll();
		List<Produit> listAvecMotCle = produitRepository.findByMc("H");
		
		System.out.println(listComplete);
		System.out.println(listAvecMotCle);
	}

}
