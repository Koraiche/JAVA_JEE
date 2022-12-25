package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;
import model.CreditModel;

@WebServlet(name="cs", urlPatterns = {"/calculerMensualite.do","*.php"})
public class ControlleurServlet extends HttpServlet{
	private ICreditMetier creditMetier;
	@Override
	public void init() throws ServletException{
		creditMetier = new CreditMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("creditModel",new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		CreditModel model = new CreditModel();
		model.setDuree(duree);
		model.setMontant(montant);
		model.setTaux(taux);
		double mensualite = this.creditMetier.calculerMensuliteCredit(montant, taux, duree);
		model.setMensualite(mensualite);
		//CreditModel model = new CreditModel(Double.parseDouble(request.getParameter("montant")),Integer.parseInt(request.getParameter("duree")),Double.parseDouble(request.getParameter("taux")),this.creditMetier.calculerMensuliteCredit(montant, taux, duree));
		System.out.println(mensualite);
		request.setAttribute("creditModel",model);
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
}
