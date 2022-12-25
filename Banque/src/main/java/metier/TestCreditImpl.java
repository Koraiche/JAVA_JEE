package metier;

public class TestCreditImpl {

	public static void main(String[] args) {
		ICreditMetier creditMetier =  new CreditMetierImpl();
		double res = creditMetier.calculerMensuliteCredit(1000000, 50000, 15);
		System.out.println(res);
	}

}
