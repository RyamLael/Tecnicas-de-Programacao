package Lista4Qst17;

public class Celula {
	public int id;
	public String simbolo;
	
	public String retornarCelula() {
		if(simbolo!=null) {
			return simbolo;
		}
		else
			return Integer.toString(id);
	}
}