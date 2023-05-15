package Lista4Qst18;


public class Robo extends Entidade {
	
	public Robo(Celula celulaInicial, Plano plano) {
		
		this.plano=plano;
		this.id=celulaInicial.id;
		this.posx=celulaInicial.posx;
		this.posy=celulaInicial.posy;
		
		celulaInicial.robo=this;
	}
	
	public boolean movimentoValido(int casaPretendidax, int casaPretendidaY) {
		if(plano.encontrarId(casaPretendidax, casaPretendidaY)==0)
			return false;
		else
			return true;
	}
	
	
	public void irparaMoeda() 
	{

		if(plano.caminhoparaMoedaX()>0) {
			for(int i=0; i<=plano.caminhoparaMoedaX();i++) {
				andarLeste();
				System.out.println(plano.caminhoparaMoedaX());
				plano.mostrarRastrodoRobo();
			}
		}
		else if(plano.caminhoparaMoedaX()<0) {
			for(int i=0; i<= -1*plano.caminhoparaMoedaX();i++) {
				andarOeste();
				System.out.println(plano.caminhoparaMoedaX());
				plano.mostrarRastrodoRobo();
			}
		}
		
		if(plano.caminhoparaMoedaY()>0) {
			for(int i=0; i<=plano.caminhoparaMoedaY();i++) {
				andarNorte();
				System.out.println(plano.caminhoparaMoedaY());
				plano.mostrarRastrodoRobo();
			}
		}
		else if(plano.caminhoparaMoedaY()<0) {
			for(int i=0; i<= -1*plano.caminhoparaMoedaY();i++) {
				andarSul();
				System.out.println(plano.caminhoparaMoedaY());
				plano.mostrarRastrodoRobo();
			}
		}
		
	}	
	
	//está errado
	public void caminhoParaA() {
		
		plano.listaCelulas.get(plano.verificarRobo()).robo=null;
		plano.listaCelulas.get(57).robo=this;
		plano.listaCelulas.get(57).posx=1;
		plano.listaCelulas.get(57).posx=8;
		plano.mostrarPlano();
		for(int y=1; y<plano.tamanhoY;y++) {
			System.out.println("primeiro");
			for(int x=1; x<plano.tamanhoX;x++) {
				plano.mostrarPlano();
				andarLeste();
			}
			andarSul();
			y++;
			for(int x=1; x<plano.tamanhoX-1;x++) {
				andarOeste();
				System.out.println("segundo");
			}
			andarSul();
		}
	}
	
	public void andarNorte() {
		if(movimentoValido(posx,posy+1)) {
				plano.adicionarDirecao("Norte");
				plano.listaCelulas.get(plano.verificarRobo()).robo=null;
				plano.listaCelulas.get(plano.encontrarId((this.posx), (this.posy+1))).robo=this;
				this.posy++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
	public void andarNordeste() {
		if(movimentoValido(posx+1,posy+1)) {
			plano.adicionarDirecao("Nordeste");
			plano.listaCelulas.get(plano.verificarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId(this.posx+1, this.posy+1)).robo=this;
			this.posx++; this.posy++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
		
	}
	
	public void andarLeste() {
		if(movimentoValido(this.posx+1,posy)) {
			plano.adicionarDirecao("Leste");
			plano.listaCelulas.get(plano.verificarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId((this.posx+1), (this.posy))).robo=this;
			this.posx++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
		
	}
	
	public void andarSuldeste() {
		if(movimentoValido(this.posx+1,this.posy-1)) {
			plano.adicionarDirecao("Suldeste");
			plano.listaCelulas.get(plano.verificarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId((this.posx+1), (this.posy-1))).robo=this;
			this.posx++; this.posy--;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
		
	}
	
	public void andarSul() {
		if(movimentoValido(this.posx, this.posy-1)) {
			plano.adicionarDirecao("Sul");
			plano.listaCelulas.get(plano.verificarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId(this.posx, this.posy-1)).robo=this;
			this.posy--;
		}
		else
			System.out.println(" A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
	public void andarSuldoeste() {
		if(movimentoValido(this.posx-1, this.posy-1)) {
			plano.adicionarDirecao("Suldoeste");
			plano.listaCelulas.get(plano.verificarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId((this.posx-1), (this.posy-1))).robo=this;
			this.posx--; this.posy--;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
	public void andarOeste() {
		if(movimentoValido(this.posx-1,this.posx)) {
			plano.adicionarDirecao("Oeste");
			plano.listaCelulas.get(plano.verificarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId((this.posx-1), (this.posy))).robo=this;
			this.posx++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
	public void andarNoroeste() {
		if(movimentoValido(this.posx-1, this.posy+1)) {
			plano.adicionarDirecao("Noroeste");
			plano.listaCelulas.get(plano.verificarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId(this.posx-1, this.posx+1)).robo=this;
			this.posx--; this.posy++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
}

