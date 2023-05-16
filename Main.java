package Lista4Qst18;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Plano plano = new Plano(7,7);
		Robo robo = new Robo(plano.celulaCentraldoPlano(),plano);
		
		plano.mostrarPlano();
		
		//robo.caminhoParaA();
		robo.caminhoParaC();
		plano.mostrarPlano();
		
		
		
	}
}
