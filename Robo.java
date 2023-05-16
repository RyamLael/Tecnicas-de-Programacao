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
	
	
	public void irparaMoeda() {

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
	
	
	public void caminhoParaA() throws InterruptedException {
		
		setPosicaoRobo(plano.encontrarId(1, plano.tamanhoY));
		plano.mostrarPlano();
		
		for(int y=1; y<plano.tamanhoY;y++) {

			for(int x=1; x<plano.tamanhoX;x++) {
				andarLeste();
				plano.mostrarRastrodoRobo();
				Thread.sleep(1000);
			}
			andarSul();
			plano.mostrarRastrodoRobo();
			y++;
			for(int x=1; x<plano.tamanhoX ;x++) {
				andarOeste();
				plano.mostrarRastrodoRobo();
				Thread.sleep(1000);
			}
			if (y<plano.tamanhoY) {
				andarSul();
				plano.mostrarRastrodoRobo();
				Thread.sleep(1000);
			}
		}
	}
	
	
	public void caminhoParaC() throws InterruptedException {
		plano.mostrarPlano();
		for(int z=1; z<plano.tamanhoX;) {
			for(int i=1; i<=4;i++) {
				switch(i){
				case 1:
					for(int j=1; j<=z;j++) {
						andarLeste();
						plano.mostrarRastrodoRobo();
					}
					break;
				case 2:
					for(int j=1; j<=z;j++) {
						andarSul();
						plano.mostrarRastrodoRobo();
					}
					break;
				case 3:
					for(int j=1; j<=z;j++) {
						andarOeste();
						plano.mostrarRastrodoRobo();
					}
					break;
				case 4:
					for(int j=1; j<=z;j++) {
						andarNorte();
						plano.mostrarRastrodoRobo();
					}
					break;
				}
				if(i%2==0)
					z++;
				Thread.sleep(1000);
			}
		}
	}
	
	
	public void andarNorte() {
		if(movimentoValido(posx,posy+1)) {
				plano.adicionarDirecao("Norte");
				plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
				plano.listaCelulas.get(plano.encontrarId((this.posx), (this.posy+1))).robo=this;
				this.posy++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
	
	public void setPosicaoRobo(int iddaCelula) {
		plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
		plano.listaCelulas.get(iddaCelula).robo=this;
		plano.listaCelulas.get(iddaCelula).robo.posx = plano.listaCelulas.get(iddaCelula).posx;
		plano.listaCelulas.get(iddaCelula).robo.posy = plano.listaCelulas.get(iddaCelula).posy;
		System.out.println("A posicao x e y do robo é: " + plano.listaCelulas.get(iddaCelula).robo.posx + plano.listaCelulas.get(iddaCelula).robo.posy );
		}
	
	
	public void andarNordeste() {
		if(movimentoValido(posx+1,posy+1)) {
			plano.adicionarDirecao("Nordeste");
			plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId(this.posx+1, this.posy+1)).robo=this;
			this.posx++; this.posy++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
		
	}
	
	public void andarLeste() {
		if(movimentoValido(this.posx+1,posy)) {
			plano.adicionarDirecao("Leste");
			plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId((this.posx+1), (this.posy))).robo=this;
			this.posx++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
		
	}
	
	public void andarSuldeste() {
		if(movimentoValido(this.posx+1,this.posy-1)) {
			plano.adicionarDirecao("Suldeste");
			plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId((this.posx+1), (this.posy-1))).robo=this;
			this.posx++; this.posy--;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
		
	}
	
	public void andarSul() {
		if(movimentoValido(this.posx, this.posy-1)) {
			plano.adicionarDirecao("Sul");
			plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId(this.posx, this.posy-1)).robo=this;
			this.posy--;
		}
		else
			System.out.println(" A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
	public void andarSuldoeste() {
		if(movimentoValido(this.posx-1, this.posy-1)) {
			plano.adicionarDirecao("Suldoeste");
			plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId((this.posx-1), (this.posy-1))).robo=this;
			this.posx--; this.posy--;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
	public void andarOeste() {
		if(movimentoValido(this.posx-1,this.posx)) {
			plano.adicionarDirecao("Oeste");
			plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId((this.posx-1), (this.posy))).robo=this;
			this.posx--;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
	
	public void andarNoroeste() {
		if(movimentoValido(this.posx-1, this.posy+1)) {
			plano.adicionarDirecao("Noroeste");
			plano.listaCelulas.get(plano.encontrarRobo()).robo=null;
			plano.listaCelulas.get(plano.encontrarId(this.posx-1, this.posx+1)).robo=this;
			this.posx--; this.posy++;
		}
		else
			System.out.println("A posição que voce pretende ir é inválida (vai para fora do plano)\n");
	}
}