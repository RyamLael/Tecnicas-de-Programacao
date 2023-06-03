package TrabalhoMensal1;

public class Bug extends Entidade {
	public int pontuacao;
	
	public Bug(int xinitial, int yinitial, Plano plano) {
		super(xinitial, yinitial, plano);
		this.simbolo="β";
		this.pontuacao=-15;
	}
}
