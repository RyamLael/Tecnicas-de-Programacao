package Lista4Qst18;

public class CelulaPercorrida extends Celula{

	
	public String direcao;
	public boolean roboPassou;
	
	public CelulaPercorrida(int posx, int posy, int id) {
		super(posx, posy, id);
		this.roboPassou=false;
		this.direcao="";
	}
}
