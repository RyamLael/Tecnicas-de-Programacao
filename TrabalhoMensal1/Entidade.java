package TrabalhoMensal1;

public class Entidade {
	public Plano plano;
	public int posx;
	public int posy;
	public String simbolo;
	
	public Entidade(int xinitial,int yinitial, Plano plano) {
		this.posx=xinitial;
		this.posy=yinitial;
		this.plano= plano;
		
		plano.listaCelulas.get(plano.encontrarId(this.posx, this.posy)).listaEntidades.add(this);
	}
}
