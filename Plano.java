package Lista4Qst18;

import java.util.ArrayList;
import java.util.Random;

public class Plano {
	
	public ArrayList<Celula> listaCelulas;
	public ArrayList<CelulaPercorrida> celulasPercorridas;
	public int tamanhoX;
	public int tamanhoY;

	public Plano(int tamanhoX, int tamanhoY) {
		
		this.tamanhoX=tamanhoX;
		this.tamanhoY=tamanhoY;
		
		celulasPercorridas = new ArrayList<CelulaPercorrida>();
		CelulaPercorrida celulanula= new CelulaPercorrida(0,0,0);
		celulasPercorridas.add(celulanula);
		
		int contador=1;
		for(int y=1; y<=this.tamanhoX; y++) {
			for(int x=1; x<=this.tamanhoY;x++) {
				CelulaPercorrida celula = new CelulaPercorrida(x, y, contador);
				celulasPercorridas.add(celula);
				contador++;
			}
		}
		
		listaCelulas = new ArrayList<Celula>();
		Celula celula0=new Celula(0,0,0);
		listaCelulas.add(celula0);
		
		contador=1;
		for(int y=1; y<=this.tamanhoY; y++) {
			for(int x=1; x<=this.tamanhoX;x++) {
				Celula celula = new Celula(x, y, contador);
				listaCelulas.add(celula);
				contador++;
			}
		}
		adicionarMoeda();
	}
	
	
	private void adicionarMoeda() {
		Random random = new Random();
		int posicaoMoeda=random.nextInt(listaCelulasSize());
		while(listaCelulas.get(posicaoMoeda)==celulaCentraldoPlano()) {
			posicaoMoeda=random.nextInt(listaCelulasSize());
		}
		if (posicaoMoeda==0) {
			posicaoMoeda++;
		}
		Moeda moeda = new Moeda(posicaoMoeda, this);
		System.out.println("Posicao moeda:"+posicaoMoeda);
	}
	
	// essa função serve para ignorar a célula 0;
	public int listaCelulasSize(){
		return listaCelulas.size()-1;
	}
	
	public int celulasPercorridasSize() {
		return celulasPercorridas.size()-1;
	}
		
	
	public Celula celulaCentraldoPlano() {
		if(tamanhoX%2==0) {
			if(tamanhoY%2==0)
				return listaCelulas.get(encontrarId(tamanhoX/2, tamanhoY/2));
			else
				return listaCelulas.get(encontrarId(tamanhoX/2, (tamanhoY+1)/2));
		}
		else {
			if(tamanhoY%2==0)
				return listaCelulas.get(encontrarId((tamanhoX+1)/2, tamanhoY/2));
			else
				return listaCelulas.get(encontrarId((tamanhoX+1)/2, (tamanhoY+1)/2));
		}
	}
	

	public void listarPosicoes() {
		for(int i=1; i<=listaCelulasSize();i++ ) {
			System.out.println(listaCelulas.get(i).imprimir());
		}
	}
	
	
	//Preciso dar explicações detalhadas
	public void mostrarPlano() {
		for(int k=1, j=0, i=listaCelulasSize()-tamanhoX+1; i>1; j++,i++) {
			if(j>=tamanhoX) {
				System.out.print("\n");
				k++;
				j=0;
				i=listaCelulasSize()+k*(-tamanhoX)+1;
			}
			if(encontrarRobo()==i) 
				System.out.printf("[R] ");
			else if(encontrarMoeda()==i)
				System.out.printf("[$] ");
			else if(i>=1)
				System.out.printf("[ ] ");
		}
		System.out.println("\n");
	}
	
	
	public void mostrarRastrodoRobo() {
		for(int k=1, j=0, i=celulasPercorridasSize()-tamanhoX+1; i>1; j++,i++) {
			if(j>=tamanhoX) {
				System.out.print("\n");
				k++;
				j=0;
				i=celulasPercorridasSize()+k*(-tamanhoX)+1;
			}
			if(encontrarRobo()==i) 
				System.out.printf("[R] ");
			else if(encontrarMoeda()==i)
				System.out.printf("[$] ");
			else if(i>=1 && celulasPercorridas.get(i).roboPassou==true) 
				System.out.printf("[*] ");
			else if(i>=1)
				System.out.printf("[ ] ");
			
		}
		System.out.println("\n");
	}
	
	
	public int caminhoparaMoedaX() {
		
		if(listaCelulas.get(encontrarMoeda()).posx > listaCelulas.get(encontrarRobo()).posx)
			return listaCelulas.get(encontrarMoeda()).posx - listaCelulas.get(encontrarRobo()).posx;
		
		else if(listaCelulas.get(encontrarMoeda()).posx < listaCelulas.get(encontrarRobo()).posx)
			return listaCelulas.get(encontrarMoeda()).posx - listaCelulas.get(encontrarRobo()).posx;
		return 0;
	}
	
	//esse menos serve para passar uma informação binária juntamente com a informaçao em forma de inteiro
	public int caminhoparaMoedaY() {
		
		if(listaCelulas.get(encontrarMoeda()).posy > listaCelulas.get(encontrarRobo()).posy)
			return listaCelulas.get(encontrarMoeda()).posy - listaCelulas.get(encontrarRobo()).posy;
		
		else if(listaCelulas.get(encontrarMoeda()).posy < listaCelulas.get(encontrarRobo()).posy)
			return listaCelulas.get(encontrarMoeda()).posy - listaCelulas.get(encontrarRobo()).posy;
		return 0;
	
	}
	
	
	//verifica se há um robo na lista de células; e retorna o id da célula
	public int encontrarRobo() {
		for(int id=1; id<=listaCelulasSize(); id++) {
			if(listaCelulas.get(id).robo!=null) {
				return id;
			}
		}
		return 0;
	}
	
	public int encontrarMoeda() {
		for(int id=1; id<=listaCelulasSize(); id++) {
			if(listaCelulas.get(id).moeda!=null) {
				return id;
				//Celula aux=listaCelulas.get(i);
			}
		}
		return 0;
	}
	
	
	public int encontrarId(int x, int y){
		// Retorna o id da célula que está na posição x e y 
		
		int posx=1,posy=1;
		for(int id=1; id<tamanhoX*tamanhoY;){

			for(int i=1; i<=tamanhoX; i++) {
			
				if(posx==x && posy==y) {
					return id;
				}
				posx++;
				id++;
			}
			posx=1;
			posy++;
		}
		return 0;
	}
	
	
	public void adicionarDirecao(String direcao) {
		celulasPercorridas.get(encontrarRobo()).roboPassou=true;
		celulasPercorridas.get(encontrarRobo()).direcao=direcao;
	}
	
	
	public int quantCasasPercorridas() {
		int quantidadePercorrida=0;
		for(int i=0; i<=celulasPercorridasSize();i++) {
			if(celulasPercorridas.get(i).roboPassou==true)
				quantidadePercorrida++;
		}
		return quantidadePercorrida;
	}
	
	
	public int quantCasasRestantes() {
		return (listaCelulasSize()- quantCasasPercorridas());
	}
	
	
	public void direcoesPercorridas() {
		int casasAndadasNorte=0;
		int casasAndadasNordeste=0;
		int casasAndadasLeste=0;
		int casasAndadasSuldeste=0;
		int casasAndadasSul=0;
		int casasAndadasSuldoeste=0;
		int casasAndadasOeste=0;
		int casasAndadasNoroeste=0;
		for(int i=1; i<=celulasPercorridasSize();i++) {
			
			switch (celulasPercorridas.get(i).direcao) {
			case "Norte":
				casasAndadasNorte++;
				break;
			case "Nordeste":
				casasAndadasNordeste++;
				break;
			case "Leste":
				casasAndadasLeste++;
				break;
			case "Suldeste":
				casasAndadasSuldeste++;
				break;
			case "Sul":
				casasAndadasSul++;
				break;
			case"Suldoeste":
				casasAndadasSuldoeste++;
				break;
			case"Oeste":
				casasAndadasOeste++;
				break;
			case "Noroeste":
				casasAndadasNoroeste++;
				break;
			}
		}
		System.out.printf("Casas Andadas em cada ponto cardeal:\nNorte: %d  Nordeste: %d\nleste: %d  Suldeste: %d\nSul: %d   "
				+ " Suldoeste: %d \nOeste: %d  Noroeste: %d",
				casasAndadasNorte,casasAndadasNordeste,casasAndadasLeste,casasAndadasSuldeste,casasAndadasSul,casasAndadasSuldoeste,casasAndadasOeste,casasAndadasNoroeste);
	}
}
