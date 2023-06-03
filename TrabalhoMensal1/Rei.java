package TrabalhoMensal1;

public class Rei extends Robo{

	public Rei(int xinitial, int yinitial, Plano plano, String nome) {
		super(xinitial, yinitial, plano, nome);
		this.simbolo="R";
		
		adicionarAoHistorico(this.posx, this.posy, this);
	}
	
	public void avancar(int quantcasas) {
		if(movimentoValidoRei(posx+quantcasas,posy+quantcasas, quantcasas)) {
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).roboPassou=true;
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).listaEntidades.remove(this);
			plano.listaCelulas.get(plano.encontrarId(this.posx+=quantcasas, this.posy+=quantcasas)).listaEntidades.add(this);
			
			adicionarAoHistorico(this.posx, this.posy, this);
			adicionarPontos(this);
		}
		else
			System.out.println("⚠ A posição que voce pretende ir é inválida\n");
	}
	
	
	public void retroceder(int quantcasas) {
		if(movimentoValidoRei(posx-quantcasas,posy+quantcasas,quantcasas)) {
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).roboPassou=true;
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).listaEntidades.remove(this);
			plano.listaCelulas.get(plano.encontrarId(this.posx-=quantcasas, this.posy+=quantcasas)).listaEntidades.add(this);
			
			adicionarAoHistorico(this.posx, this.posy, this);
			adicionarPontos(this);
		}
		else
			System.out.println("⚠ A posição que voce pretende ir é inválida0\n");
	}
	

	public boolean movimentoValidoRei(int casapretendidaX, int casapretendidaY, int quantcasas){
		if(quantcasas>4) {
			System.out.println("Você pode andar até no máximo 4 casas com o Rei...");
			return false;
		}
		else {
			return movimentoValido(casapretendidaX, casapretendidaY);
		}
	}
}
