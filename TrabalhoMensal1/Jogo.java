package TrabalhoMensal1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
	
	private Plano plano;
	private Scanner leitor;
	private String nomejogador;
	private ArrayList<Robo> listaRobos;
	
	public Jogo() {
		this.leitor = new Scanner(System.in);
		this.listaRobos = new ArrayList<Robo>();
		iniciarJogo();
	}
	
	
	private Celula celulaAleatoria() {
		
		Random aleatorio = new Random();
		int idcelulasort;
		do {
			idcelulasort = aleatorio.nextInt(plano.listaCelulasSize());
		}while(idcelulasort==0); 
		
		return plano.retornarCelula(idcelulasort);
	}
	
	
	private void adicionarRobos() {
		
		listaRobos.add(new Peao(1,1,plano,"peao"));
		listaRobos.add(new Torre(2,1,plano,"torre"));
		listaRobos.add(new Cavalo(3,1,plano, "cavalo"));
		listaRobos.add(new Bispo(4,1,plano, "bispo"));
		listaRobos.add(new Rei(5,1,plano, "rei"));
		listaRobos.add(new Rainha(6,1,plano, "rainha"));
		listaRobos.add(new Andador(7,1,plano, "andador"));
		
	}
	
	private void addAluno(Celula celulaAleatoria) {
		if(celulaAleatoria.possuiEntidades()) {
			addAluno(celulaAleatoria());
		}
		else {
			Aluno aluno = new Aluno(celulaAleatoria.posx, celulaAleatoria.posy, plano);
		}
	}
	
	
	private void addBug(Celula celulaAleatoria) {
		
		if(celulaAleatoria.possuiEntidades()) {
			addBug(celulaAleatoria());
		}
		else {
			Bug bug = new Bug(celulaAleatoria.posx, celulaAleatoria.posy, plano);
		}
	}
	

	private void adicionarBugseAlunos(int numbugsRequeridos, int numalunosRequeridos) {
		for(int quantBugs=0;quantBugs<numbugsRequeridos;quantBugs++) 
			addBug(celulaAleatoria());
		
		for(int quantAlunos=0;quantAlunos<numalunosRequeridos; quantAlunos++)
			addAluno(celulaAleatoria());
	}
	
	
	private void iniciarJogo() {
		
		System.out.println(" --------------------------\n| 🗺Jogo Da Ilha de Java🏝 |\n --------------------------\n\n Olá! Qual seu nome?");
		this.nomejogador = leitor.nextLine();
	
		System.out.println("Seja bem vindo, " + this.nomejogador+"!\n");
		
		
		//Pedindo para o usuário informar o tamanho do eixo YXque ele quer criar
		int eixoX = 0;
		do {
			try {
				System.out.printf("Digite a dimensão X do plano que você preferir (Mínimo 7): \n");
				eixoX= leitor.nextInt();
				
				if(eixoX<7)
					System.out.println("⚠ Digite um valor maior ou igual a 7! \n");
				
			}catch(Exception e){
				System.out.println("\n⚠ Digite um valor válido (Número inteiro)! \n");
				leitor.nextLine();
			}
		}while(eixoX<7);

		
		//Pedindo para o usuário informar o tamanho do eixo Y que ele quer criar
		int eixoY = 0;
		do {
			try {
				System.out.printf("Digite a dimensão Y do plano que você preferir (Mínimo 7): \n");
				eixoY= leitor.nextInt();
				
				if(eixoY<7)
					System.out.println("⚠ Digite um valor maior ou igual a 7! \n");
				
			}catch(Exception e){
				System.out.println("\n⚠ Digite um valor válido (Número inteiro)! \n");
				leitor.nextLine();
			}
		}while(eixoY<7);
		
		
		//Requisitando quantos Bugs o jogador quer que sejam adicionados ao plano
		int numbugsRequeridos=0;
		do {
			try {
				System.out.println("Quantos Bugs você quer que sejam adicionados no seu jogo? (máximo: 1/4 do plano)");
				numbugsRequeridos= leitor.nextInt();
				
				while(numbugsRequeridos>(eixoX*eixoY)*0.25) {
					System.out.println("Digite um número menor de alunos (máximo: 1/4 do plano)");
					numbugsRequeridos= leitor.nextInt();
				}
			}catch(Exception e){
				System.out.println("\n⚠ Digite um valor válido (Número inteiro)! \n");
				leitor.nextLine();
			}
		}while(numbugsRequeridos==0);
		
		
		//Requisitando quantos alunos o jogador quer que sejam adicionados ao plano
		int numalunosRequeridos=0;
		do {
			try {
				System.out.println("Quantos alunos você quer que sejam adicionados no seu jogo?");
				numalunosRequeridos= leitor.nextInt();
				
				while(numalunosRequeridos>(eixoX*eixoY)*0.25) {
					System.out.println("Digite um número menor de alunos (máximo: 1/4 do plano)");
					numalunosRequeridos= leitor.nextInt();
				}
				
			}catch(Exception e){
				System.out.println("\n⚠ Digite um valor válido (Número inteiro)! \n");
				leitor.nextLine();
			}
		}while(numalunosRequeridos==0);

	
		System.out.println("Obrigado pelas informações, estou criando o seu novo jogo");
		
		plano = new Plano(eixoX,eixoY);
		
		adicionarRobos();
		adicionarBugseAlunos(numbugsRequeridos, numalunosRequeridos);
		gameplay();
		
	}
	
	private void movimentarRobo(Robo robo) {
		int retrocederAvancar;
		int quantcasas;

		boolean escolhaValida=true;
		do {
			try {
				
				escolhaValida=true;
				System.out.printf("♟"+robo.nome+ "(%s)\n[1->Avançar | 2->Retroceder] \n\n", robo.simbolo);
				retrocederAvancar = leitor.nextInt();
				
				if(robo instanceof Peao) {
					if(retrocederAvancar==1) {
						robo.avancar(1);
					}
					else if(retrocederAvancar==2) {
						robo.retroceder(1);
					}
				
				}else {
					
					if(retrocederAvancar==1) {
						
						System.out.println("Quantas casas você pretende avançar? ");
						quantcasas = leitor.nextInt();
				
						robo.avancar(quantcasas);
					}
					else if(retrocederAvancar==2) {
						
						System.out.println("Quantas casas você pretende retroceder? ");
						quantcasas = leitor.nextInt();
						
						robo.retroceder(quantcasas);
					}
					else
						System.out.println("Você pulou a jogada...");
				}
				plano.mostrarPlano();
				
			}catch(java.util.InputMismatchException e) {
				System.out.println("\n⚠ Digite um valor válido (Número inteiro)! \n");
				leitor.nextLine();
				
				escolhaValida=false;
			}
		}while(!escolhaValida);
		
	}
	
	
	private void gameplay() {
		
		boolean fim = true;
		
		while (fim) {
			
			plano.mostrarPlano();
			
			System.out.println("\n🕹Mova o robô: \n");

			for(int roboescolhido=1;roboescolhido<=7;roboescolhido++) {
				switch(roboescolhido) {
				case 0:
					fim = false;
					break;
				case 1:
					movimentarRobo(listaRobos.get(0));
					break;
				case 2:
					movimentarRobo(listaRobos.get(1));
					break;
				case 3:
					movimentarRobo(listaRobos.get(2));
					break;
				case 4:
					movimentarRobo(listaRobos.get(3));
					break;
				case 5:
					movimentarRobo(listaRobos.get(4));
					break;
				case 6:
					movimentarRobo(listaRobos.get(5));
					break;
				case 7:
					movimentarRobo(listaRobos.get(6));
					break;
				}
			}
			
			System.out.println("\n --------------\n[Fim da Rodada!]\n --------------");
			
			for(Robo robo : listaRobos) {
				robo.exibirUltimaRodada();
				robo.dadosdaRodada="";
			}
			
			int continuarJogando;
			boolean escolhaValida=false;
			do {
				try {
			
					System.out.println("Você quer continuar jogando? [1->Sim | 0->Não]");
					continuarJogando = leitor.nextInt();
					
					if(continuarJogando==0) 
						fim=false;
					escolhaValida=true;
					
				}catch (java.util.InputMismatchException e) {
					
					System.out.println("\n⚠ Digite um valor válido (Número inteiro)! \n");
					leitor.nextLine();
					
					escolhaValida=false;
				}
			}while(!escolhaValida);
		}
		
		for(Robo robos : listaRobos) {
			robos.exibirHistoricoDeJogadas();
		}
		System.out.printf("Fim de jogo, %s", this.nomejogador);
	}
	
}
