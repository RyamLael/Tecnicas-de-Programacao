package TrabalhoMensal1;

import java.util.ArrayList;


public class Plano {
	protected ArrayList<Celula> listaCelulas;
	protected int tamanhoX;
	protected int tamanhoY;
	
	public Plano(int tamanhoX, int tamanhoY) {
		listaCelulas= new ArrayList<Celula>();
		
		Celula celulaNula=new Celula(0,0,0);
		listaCelulas.add(celulaNula);
		
		int contador=1;
		for(int y=1; y<=tamanhoY; y++) {
			for(int x=1; x<=tamanhoX;x++) {
				listaCelulas.add(new Celula(x, y, contador));
				contador++;
			}
		}
		this.tamanhoX=tamanhoX;
		this.tamanhoY=tamanhoY;
	}
	
	
	protected void mostrarPlano() {
		System.out.println("\n\n\n");
		for(int x=0, y=1, id=listaCelulasSize()-tamanhoX+1; id>1; x++,id++) {
			if(x>=tamanhoX) {
				System.out.print("\n");
				y++;
				x=0;
				id=listaCelulasSize()-y*(tamanhoX)+1;
			}
			
			if(id>=1 && listaCelulas.get(id).possuiEntidades())
				System.out.printf("[%s] ", listaCelulas.get(id).exibirSimbolosdasEntidades());
			else if(id >=1 && listaCelulas.get(id).roboPassou) 
				System.out.printf("[*] ");
			else if(id>=1)
				System.out.printf("[ ] ");
		}
		System.out.println("\n\n\n");
	}
	
	
	protected int encontrarId(int x, int y){
		int posx=1,posy=1;
		for(int id=1; id<listaCelulasSize(); posy++){

			for(posx=1; posx<=tamanhoX; posx++,id++) {
			
				if(posx==x && posy==y) {
					return id;
				}
			}
		}
		return 0;
	}
	
	
	protected int encontrarRobo(Robo roboRequerido) {
		return encontrarId(roboRequerido.posx,roboRequerido.posy);
	}
	
	
	public Celula retornarCelula(int id) {
		return listaCelulas.get(id);
	}
	
	
	public int listaCelulasSize(){
		return listaCelulas.size()-1;
	}
		
}
