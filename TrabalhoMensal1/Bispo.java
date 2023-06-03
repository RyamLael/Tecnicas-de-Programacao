package TrabalhoMensal1;

public class Bispo extends Robo{

	
	public Bispo(int xinitial, int yinitial, Plano plano, String nome) {
		super(xinitial, yinitial, plano, nome);
		this.simbolo="B";
		
		adicionarAoHistorico(this.posx, this.posy, this);
	}
	
	public void avancar(int quantcasas) {
		if(movimentoValidoBispo(posx+quantcasas,posy+quantcasas, quantcasas)) {
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).roboPassou=true;
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).listaEntidades.remove(this);
			plano.listaCelulas.get(plano.encontrarId(this.posx+=quantcasas, this.posy+=quantcasas)).listaEntidades.add(this);
			
			adicionarAoHistorico(this.posx, this.posy, this);
			adicionarPontos(this);
		}
	}
	
	
	public void retroceder(int quantcasas) {
		if(movimentoValidoBispo(posx-quantcasas,posy-quantcasas,quantcasas)) {
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).roboPassou=true;
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).listaEntidades.remove(this);
			plano.listaCelulas.get(plano.encontrarId(this.posx-=quantcasas, this.posy-=quantcasas)).listaEntidades.add(this);
			
			adicionarAoHistorico(this.posx, this.posy, this);
			adicionarPontos(this);
		}
		else
			System.out.println("⚠ A posição que voce pretende ir é inválida\n");
	}
	

	public boolean movimentoValidoBispo(int casapretendidaX, int casapretendidaY, int quantcasas){
		if(quantcasas>2) {
			System.out.println("Você pode andar até no máximo 2 casas com o Bispo...");
			return false;
		}
		else {
			return movimentoValido(casapretendidaX, casapretendidaY);
		}
	}
}
