package AulaPratica;

public class Servidores extends Clientes{

	public Servidores(String name, String matricula) {
		super(name, matricula);
		  duracaoEmprestimo=15;
	      quantEmprestimos=0;
	      maxEmprestimos=7;
	      Tps=0;
	      tipo="Servidores:"
	}
}
