package AulaPratica;

public class Professores extends Clientes{

	public Professores(String name, String matricula) {
		super(name, matricula);
		  duracaoEmprestimo=20;
	      maxEmprestimos=10;
	      quantEmprestimos=0;
	      Tps=0;
	      tipo="Professor:";
    }
}