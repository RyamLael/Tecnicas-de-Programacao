package TrabalhoMensal1;

import java.util.ArrayList;

public abstract class Robo extends Entidade implements Movimentacao{
	private int pontuacao;
	protected String nome;
	protected String encontrouAlunoouBugnaRodada;
	protected ArrayList<String> históricodeJogadas;
	protected String dadosdaRodada;
	
	public Robo(int xinitial, int yinitial, Plano plano, String nome) {
		super(xinitial, yinitial, plano);
		this.nome=nome;
		pontuacao=0;
		
		históricodeJogadas= new ArrayList<>();
		históricodeJogadas.add("================================\nMovimentações do robo [" + this.nome+ "]:" );
	}

	protected boolean movimentoValido(int casaPretendidaX, int casaPretendidaY) {
		if(plano.encontrarId(casaPretendidaX, casaPretendidaY)==0)
			return false;
		else
			return true;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	protected void adicionarPontos(Robo robo) {
		
		encontrouAlunoouBugnaRodada=plano.retornarCelula(plano.encontrarRobo(robo)).encontrouBugouAluno(robo);
		
		if(encontrouAlunoouBugnaRodada=="Aluno") {
			
			removerAlunoouRobo(plano.encontrarRobo(robo), "Aluno");
			System.out.println("\n     --------------\n    |  ⚠Atenção!  |\n     --------------\nVocê encontrou um aluno 👦");
			robo.pontuacao+=10;
			
		}
		else if(encontrouAlunoouBugnaRodada=="Bug") {

			removerAlunoouRobo(plano.encontrarRobo(robo), "Bug");
			System.out.println("\n     --------------\n    |  ⚠Atenção!  |\n     --------------\nVocê encontrou um Bug 🐞");
			robo.pontuacao-=15;
			
			}
		}
	
	private void removerAlunoouRobo(int idcelula, String alunoouRobo) {
		
		if(alunoouRobo=="Aluno") {
			for(Entidade entidades: plano.retornarCelula(idcelula).listaEntidades) {
				if(entidades instanceof Aluno)
					plano.retornarCelula(idcelula).listaEntidades.remove(entidades);
			}
		}
		
		else if(alunoouRobo=="Bug") {
			for(Entidade entidades: plano.retornarCelula(idcelula).listaEntidades) {
				if(entidades instanceof Bug)
					plano.retornarCelula(idcelula).listaEntidades.remove(entidades);
			}
		}
	}
	
	protected void adicionarAoHistorico(int posx, int posy, Robo robo) {
		históricodeJogadas.add(adicionarDadosdaJogada(posx, posy, robo));
	}
	
	protected void exibirHistoricoDeJogadas() {
		
		for(String jogadas : históricodeJogadas) 
			System.out.println(jogadas);
		
		System.out.println("Pontuação do robo: "+ this.pontuacao +"\n================================\n");
		
	}

	
	protected String adicionarDadosdaJogada(int posx, int posy, Robo robo) {
		if(plano.retornarCelula(plano.encontrarRobo(robo)).encontrouBugouAluno(robo)=="Aluno"){
			return dadosdaRodada="("+ posx +"," + posy + ") -> [👦]";
		}
		else if(plano.retornarCelula(plano.encontrarRobo(robo)).encontrouBugouAluno(robo)=="Bug"){
			return dadosdaRodada= "("+ posx +"," + posy + ") -> [🐝]";
		}
		else {
			return dadosdaRodada="("+ posx +"," + posy + ")";
		}
	}
	
	protected void exibirUltimaRodada() {
		if(encontrouAlunoouBugnaRodada=="Aluno") {
			System.out.println("🏆 -"+this.nome + " encontrou um Aluno (👦) nessa Rodada: na posição: \n " + this.dadosdaRodada+ "\n");
		}
		
		else if(encontrouAlunoouBugnaRodada=="Bug") {
			System.out.println("☠ -"+this.nome + " encontrou um Bug (🐝) nessa Rodada na posição: \n"+ this.dadosdaRodada+"\n");
		}
		encontrouAlunoouBugnaRodada="";
	}
	
}
