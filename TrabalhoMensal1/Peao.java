package TrabalhoMensal1;

public class Peao extends Robo{

	protected Peao(int xinitial, int yinitial, Plano plano, String nome) {
		super(xinitial, yinitial, plano, nome);
		this.simbolo="P";
		
		adicionarAoHistorico(this.posx, this.posy, this);
	}

	
	public void avancar(int quantcasas) {
		if(movimentoValido(posx,posy+quantcasas)) {
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).roboPassou=true;
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).listaEntidades.remove(this);
			plano.listaCelulas.get(plano.encontrarId(this.posx, this.posy+=quantcasas)).listaEntidades.add(this);
			
			adicionarAoHistorico(this.posx, this.posy, this);
			adicionarPontos(this);
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}

	public void retroceder(int quantcasas) {
		if(movimentoValido(posx,posy-quantcasas)) {
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).roboPassou=true;
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).listaEntidades.remove(this);
			plano.listaCelulas.get(plano.encontrarId(this.posx, this.posy-=quantcasas)).listaEntidades.add(this);
			
			adicionarAoHistorico(this.posx, this.posy, this);
			adicionarPontos(this);
		}
		else
			System.out.println("⚠ A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
}
