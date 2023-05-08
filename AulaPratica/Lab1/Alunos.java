package AulaPratica;

public class Alunos extends Clientes {

	public Alunos(String name, String matricula) {
		super(name, matricula);
      this.duracaoEmprestimo=10;
      this.quantEmprestimos=0;
      this.maxEmprestimos=5;
      this.Tps=0;
      this.tipo="Aluno:";
	}
}
