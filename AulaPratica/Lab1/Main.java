package AulaPratica;

public class Main {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		
	
		biblioteca.addPublicacoes(new Livros("AlgebraLinear","2003", "Jebafran", 5));	
		biblioteca.addPublicacoes(new Artigos("Tcc do Rui", "2004", "Rui frigelis", 10));
		
		biblioteca.pesquisarPublicacao("AlgebraLinear");
		
		biblioteca.addClientes(new Alunos("Ryam","5"));	
		
		biblioteca.emprestimo("Ryam", "AlgebraLinear");
		biblioteca.emprestimo("Ryam", "Tcc do Rui");
		
		biblioteca.colsultaMatricula("5");
		biblioteca.exibirEmprestimos();
	}
}

