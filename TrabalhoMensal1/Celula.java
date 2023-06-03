package TrabalhoMensal1;

import java.util.ArrayList;

public class Celula {
	protected ArrayList<Entidade> listaEntidades;
	protected int posx;
	protected int posy;
	protected boolean roboPassou;
	protected int id;
	
	
	public Celula(int posx, int posy, int id) {
		listaEntidades = new ArrayList<Entidade>();
		this.posx=posx;
		this.posy=posy;
		this.id=id;
	}
	
	public String exibirSimbolosdasEntidades() {
		String simbolos="";
		for(Entidade entidades : listaEntidades) {
			simbolos+=entidades.simbolo;
		}
		return simbolos;
	}
	
	public boolean possuiAlunos() {
		for(Entidade entidades : listaEntidades) {
			if(entidades instanceof Aluno)
				return true;
		}
		return false;
	}
	
	public boolean possuiBugs() {
		for(Entidade entidades : listaEntidades) {
			if(entidades instanceof Bug)
				return true;
		}
		return false;
	}
	
	
	public String encontrouBugouAluno(Robo robo) {
		if(listaEntidades.contains(robo) && possuiAlunos()) {
			return("Aluno");
		}
		else if(listaEntidades.contains(robo) && possuiBugs()) {
			return("Bug");
		}
		return"";
	}
	
	public boolean possuiEntidades() {
		for(Entidade entidades: listaEntidades) {
			if(entidades!=null)
				return true;
		}
		return false;
	}
	
}
