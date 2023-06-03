package TrabalhoMensal1;

public class Torre extends Robo{

	public Torre(int xinitial, int yinitial, Plano plano,String nome) {
		super(xinitial, yinitial, plano, nome);
		this.simbolo="T";
		
		adicionarAoHistorico(this.posx, this.posy, this);
	}
	
	public void avancar(int quantcasas) {
		if(movimentoValidoTorre(posx,posy+quantcasas, quantcasas)) {
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).roboPassou=true;
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).listaEntidades.remove(this);
			plano.listaCelulas.get(plano.encontrarId(this.posx, this.posy+=quantcasas)).listaEntidades.add(this);
			
			adicionarAoHistorico(this.posx, this.posy, this);
			this.adicionarPontos(this);
		}
	}
	
	
	public void retroceder(int quantcasas) {
		if(movimentoValidoTorre(posx,posy-quantcasas,quantcasas)) {
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).roboPassou=true;
			
			plano.listaCelulas.get(plano.encontrarRobo(this)).listaEntidades.remove(this);
			plano.listaCelulas.get(plano.encontrarId(this.posx, this.posy-=quantcasas)).listaEntidades.add(this);
			
			adicionarAoHistorico(this.posx, this.posy, this);
			this.adicionarPontos(this);
		}
		else
			System.out.println("⚠ A posição que voce pretende ir é inválida\n");
		
	}
	

	public boolean movimentoValidoTorre(int casapretendidaX, int casapretendidaY, int quantcasas){
		if(quantcasas>2) {
			System.out.println("Você pode andar até no máximo 2 casas com a Torre...");
			return false;
		}
		else {
			return movimentoValido(casapretendidaX, casapretendidaY);
		}
	}
}
