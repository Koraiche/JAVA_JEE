package web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.IProduitDao;
import dao.impl.ProduitDaoImpl;
import entities.Produit;
import web.ProduitModel;

@WebServlet(name="cs", urlPatterns = {"*.do"})
public class ProduitControllerServlet extends HttpServlet {
    private IProduitDao produitRepository;
    
    @Override
    public void init() throws ServletException {
    	//this.produitRepository = new ProduitDaoImpl();
    	//ApplicationContext applicationContext=WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
    	//this.produitRepository = applicationContext.getBean(IProduitDao.class);
    	//this.produitRepository = (IProduitDao)applicationContext.getBean("dao");
    	this.produitRepository = new ProduitDaoImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path = request.getServletPath();
    	System.out.println(path);
    	if(path.equals("/index.do") || path.equals("/home.do")){ 
    		ProduitModel produitModel = new ProduitModel();
    		produitModel.setMotCle("");
    		produitModel.setProduits(produitRepository.findAll());
    		request.setAttribute("model", produitModel);
        	request.getRequestDispatcher("vue/produits.jsp").forward(request, response);
    	}
		else if(path.equals("/search.do")) {
    		String motCle = request.getParameter("motCle");
    		ProduitModel produitModel = new ProduitModel();
    		produitModel.setMotCle(motCle);
    		produitModel.setProduits(produitRepository.findByMc(motCle));
    		request.setAttribute("model", produitModel);
        	request.getRequestDispatcher("vue/produits.jsp").forward(request, response);

    	}
		else if(path.equals("/saisie.do")) {
        	request.getRequestDispatcher("vue/saisie.jsp").forward(request, response);

    	}
		else if(path.equals("/addProduct.do") && request.getMethod().equals("POST")) {
        	System.out.println(request.getParameter("prix"));
        	Produit produit = produitRepository.save(new Produit(null,
        			request.getParameter("designation"),
        			Double.parseDouble(request.getParameter("prix")),
        			Integer.parseInt(request.getParameter("quantite"))));
        	request.setAttribute("produit", produit);
        	request.getRequestDispatcher("vue/confirmation.jsp").forward(request, response);

		}
		else if(path.equals("/delete.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			produitRepository.delete(id);
        	response.sendRedirect("index.do");
    	}
		else if(path.equals("/edit.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit produit = produitRepository.findById(id);
			request.setAttribute("produit", produit);
        	request.getRequestDispatcher("vue/edit_produit.jsp").forward(request, response);
    	}
		else if(path.equals("/view.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit produit = produitRepository.findById(id);
			request.setAttribute("produit", produit);
        	request.getRequestDispatcher("vue/view_produit.jsp").forward(request, response);
    	}
		else if(path.equals("/updateProduct.do") && request.getMethod().equals("POST")) {
        	Produit produit = new Produit(
        			Long.parseLong(request.getParameter("id")),
        			request.getParameter("designation"),
        			Double.parseDouble(request.getParameter("prix")),
        			Integer.parseInt(request.getParameter("quantite")));
        	produitRepository.update(produit);
        	request.setAttribute("produit", produit);
        	request.getRequestDispatcher("vue/confirmation.jsp").forward(request, response);

		}
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
    	
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doGet(request, response);
    }
    
}
