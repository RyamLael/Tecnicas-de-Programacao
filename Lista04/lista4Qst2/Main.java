package lista4Qst2;

public class Main {

	public static void main(String[] args) {
		
		Empregado Yan= new Empregado("Yan", "Marcelo", 100);
		Empregado Antonio= new Empregado("Antonio", "Cruz", 1000);
		
		System.out.println("O salário anual de "+Antonio.getFirstname()+ " "+Antonio.getSurname()+" é "+Antonio.getAnualSalary(Antonio.getSalary()));
		System.out.println("O salário anual de "+Yan.getFirstname()+ " " + Yan.getSurname()+" é "+Yan.getAnualSalary(Yan.getSalary())+"\n");

		Antonio.salaryIncrease("Senha123", "Rampouskiuskin");
		Yan.salaryIncrease("Senha123", "Yan Marcelo");
		
		System.out.println("\nO salário anual de "+Antonio.getFirstname()+ " "+Antonio.getSurname()+" é "+Antonio.getAnualSalary(Antonio.getSalary()));
		System.out.println("O salário anual de "+Yan.getFirstname()+ " " + Yan.getSurname()+" é "+Yan.getAnualSalary(Yan.getSalary()));
		
	}

}
