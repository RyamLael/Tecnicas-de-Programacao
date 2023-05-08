package AulaPratica;

import java.util.ArrayList;

public abstract class Clientes {

	public String tipo;
    public String Name;
    public String Matricula;
    public float Tps;
    public int duracaoEmprestimo;
    public int maxEmprestimos;
    public int quantEmprestimos;
    public ArrayList<Publicacoes> publicacoesemPosse;
    
    
	public Clientes(String name, String matricula) {
		publicacoesemPosse= new ArrayList<Publicacoes>();
		Name = name;
		Matricula = matricula;
	}
	public void exibirCliente() {
		System.out.println("Cliente (Matrícula, nome, TPs\n)"+ this.tipo+"\n"+ );
	}

}