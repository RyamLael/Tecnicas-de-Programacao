package Lista4Qst18;

public class Celula {
	
	public int posx;
	public int posy;
	public int id;
	public Moeda moeda;
	public Robo robo;
	
	//o id sera contado do canto inferior esquerdo, aumentando pelo lado direito até subir de coluna, começando de 1;
	public Celula(int posx, int posy, int id) {
		this.posx=posx;
		this.posy=posy;
		this.id=id;
		this.moeda=null;
		this.robo=null;
	}
	
	public String imprimir() {
		if(robo!=null) {
			return "Célula " + id + " x: "+ posx + " y: "+posy + " Robo";
		}
		else if(moeda!=null)
			return "Célula " + id + " x: "+ posx + " y: "+ posy + " moeda";
		else
			return "Célula " + id + " x: "+ posx + " y: "+posy;
	}
	
}
