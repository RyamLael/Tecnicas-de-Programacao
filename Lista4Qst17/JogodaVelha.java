package Lista4Qst17;
import java.util.Scanner;
public class JogodaVelha {
	
	private int posicaoEscolhida;
	private Celula[][]tabuleiro;
	private Jogador jogador1, jogador2;
	private Scanner leitor;
	
	public JogodaVelha() {
		this.leitor = new Scanner(System.in);
		tabuleiro = new Celula[3][3];
		int id=1;
		for(int i=0; i<=2; i++) {
			for(int j=0; j<=2;j++,id++) {
				Celula c1=new Celula();
				tabuleiro[i][j]=c1;
				tabuleiro[i][j].id=id;
			}
		}
	}
	
	
	public void iniciarJogo() {
		
		System.out.println("Digite o nome do jogador 1: ");
		String nomejogador1 = leitor.nextLine();
		System.out.println("Escolha um símbolo: [x/o]");
		String simbolo1 = leitor.nextLine();
		
		//verifica se o usuário digitou x ou o
		boolean simbolovalido=false;
		while(simbolovalido==false) {
			if(simbolo1.equals("x") || simbolo1.equals("o")) 
				simbolovalido=true;
			else {
				System.out.println("O simbolo digitado é inválido (digite x ou o)...\nEscolha um símbolo: [x/o]");
				simbolo1 = leitor.nextLine();
			}
		}
		this.jogador1 = new Jogador(nomejogador1,simbolo1);
		
		
		System.out.println("Digite o nome do jogador 2: ");
		String nomejogador2 = leitor.nextLine();
		String simbolo2="";	
		if(simbolo1.equals("x")) 
			simbolo2="o";
		else
			simbolo2="x";
		this.jogador2 = new Jogador(nomejogador2,simbolo2);
		
		System.out.printf("O jogador 1 (%s) ficou com o símbolo [%s] e o jogador 2 (%s) ficou com o símbolo [%s]\n\n", nomejogador1,simbolo1, nomejogador2,simbolo2);
		
		gameplay();
	}
	
	
	private void gameplay() {
		
		boolean fim=false;
		for(int i=1;fim!=true;i++) {
			
			//interação com o jogador 1
			System.out.printf("\nJogador 1 (%s), informe uma posição para jogar: \n\n", jogador1.name);
			exibirTabuleiro();
			posicaoEscolhida = leitor.nextInt();
			
			while(jogadaValida(posicaoEscolhida)==false) {
				System.out.printf("\nJogador 1 (%s), informe uma posição para jogar: \n\n",jogador1.name);
				exibirTabuleiro();
				posicaoEscolhida = leitor.nextInt();
			}
				
			retornarPosicaoMatriz(posicaoEscolhida).simbolo=jogador1.simbolo;
			i++;
			if(fimdejogo(i)) {
				exibirTabuleiro(); 
				fim=true; 
				return;
			}
			
			//interação com o jogador 2
			System.out.printf("\nJogador 2 (%s), informe uma posição para jogar: \n\n", jogador2.name);
			exibirTabuleiro();
			posicaoEscolhida = leitor.nextInt();
			
			while(jogadaValida(posicaoEscolhida)==false) {
				System.out.printf("\nJogador 2 (%s), informe uma posição para jogar: \n\n",jogador1.name);
				exibirTabuleiro();
				posicaoEscolhida = leitor.nextInt();
			}
			
			retornarPosicaoMatriz(posicaoEscolhida).simbolo=jogador2.simbolo;
			if(fimdejogo(i)) {
				exibirTabuleiro();
				fim=true;
			}
		}
	}
	
	public boolean jogadaValida(int posicaoEscolhida) {
		//if(posicaoEscolhida isnumber)
		if(posicaoEscolhida>9 || posicaoEscolhida<1) {
			System.out.printf("Digite uma posição válida (Números de 1 a 9)\n",jogador1.name);
			return false;
		}
		if(retornarPosicaoMatriz(posicaoEscolhida).simbolo!=null || retornarPosicaoMatriz(posicaoEscolhida).simbolo!=null) {
			System.out.printf("Digite uma posição que ainda não foi jogada\n",jogador1.name);
			return false;
		}
		return true;
	}
	public void exibirTabuleiro() {
		
		System.out.printf(" %s | %s | %s \n --------- \n %s | %s | %s \n --------- \n %s | %s | %s \n \n", 
				this.tabuleiro[0][0].retornarCelula(), this.tabuleiro[0][1].retornarCelula(),this.tabuleiro[0][2].retornarCelula(),
				this.tabuleiro[1][0].retornarCelula(), this.tabuleiro[1][1].retornarCelula(), this.tabuleiro[1][2].retornarCelula(),
				this.tabuleiro[2][0].retornarCelula(), this.tabuleiro[2][1].retornarCelula(),this.tabuleiro[2][2].retornarCelula());
	}
	
	
	private Celula retornarPosicaoMatriz(int id) {
		for(int i=0; i<=2; i++) {
			for(int j=0; j<=2;j++) {
				if(tabuleiro[i][j].id==id)
					return tabuleiro[i][j];
			}
		}
		return null;
	}
	
	
	//verifica se o jogo terminou
	private boolean fimdejogo(int quantdejogadas) {
		
		//teste do deu velha
		if(quantdejogadas>8) {
			System.out.println("Deu velha");
			return true;
		}
		//linha 1
		if(tabuleiro[0][0].simbolo== tabuleiro[0][1].simbolo && tabuleiro[0][1].simbolo==tabuleiro[0][2].simbolo) {
			if(tabuleiro[0][0].simbolo==jogador1.simbolo) {
				System.out.printf("O jogador 1 [%s] venceu o jogo", jogador1.name);
				return true;
			}
			else if(tabuleiro[0][0].simbolo==jogador2.simbolo) {
				System.out.printf("O jogador 2 [%s] venceu o jogo", jogador2.name);
				return true;
			}
		}
		//linha 2
		if(tabuleiro[1][0].simbolo==tabuleiro[1][1].simbolo && tabuleiro[1][1].simbolo==tabuleiro[1][2].simbolo) {
			if(tabuleiro[1][0].simbolo==jogador1.simbolo) {
				System.out.println("O jogador 1 venceu o jogo");
				return true;
			}
			else if(tabuleiro[1][0].simbolo==jogador2.simbolo) {
				System.out.println("O jogador 2 venceu o jogo");
				return true;
			}
		}
		//linha 3
		if(tabuleiro[2][0].simbolo==tabuleiro[2][1].simbolo && tabuleiro[2][1].simbolo==tabuleiro[2][2].simbolo) {
			if(tabuleiro[2][0].simbolo==jogador1.simbolo) {
				System.out.println("O jogador 1 venceu o jogo");
				return true;
			}
			else if(tabuleiro[2][0].simbolo==jogador2.simbolo) {
				System.out.println("O jogador 2 venceu o jogo");
				return true;
			}
		}
		//coluna 1
		if(tabuleiro[0][0].simbolo == tabuleiro[1][0].simbolo && tabuleiro[1][0].simbolo==tabuleiro[2][0].simbolo) {
			if(tabuleiro[0][0].simbolo==jogador1.simbolo) {
				System.out.println("O jogador 1 venceu o jogo");
				return true;
			}
			else if(tabuleiro[0][0].simbolo==jogador2.simbolo) {
				System.out.println("O jogador 2 venceu o jogo");
				return true;
			}
		}
		//coluna 2
		if(tabuleiro[0][1].simbolo==tabuleiro[1][1].simbolo && tabuleiro[1][1].simbolo == tabuleiro[2][1].simbolo) {
			if(tabuleiro[0][1].simbolo==jogador1.simbolo) {
				System.out.println("O jogador 1 venceu o jogo");
				return true;
			}
			else if(tabuleiro[0][1].simbolo==jogador2.simbolo) {
				System.out.println("O jogador 2 venceu o jogo");
				return true;
			}
		}
		//Coluna 3
		if(tabuleiro[0][2].simbolo==tabuleiro[1][2].simbolo && tabuleiro[1][2].simbolo==tabuleiro[2][2].simbolo) {
			if(tabuleiro[0][2].simbolo==jogador1.simbolo) {
				System.out.println("O jogador 1 venceu o jogo");
				return true;
			}
			else if(tabuleiro[0][2].simbolo==jogador2.simbolo) {
				System.out.println("O jogador 2 venceu o jogo");
				return true;
			}
		}
		//diagonal 1
		if(tabuleiro[0][0].simbolo==tabuleiro[1][1].simbolo && tabuleiro[1][1].simbolo==tabuleiro[2][2].simbolo) {
			if(tabuleiro[0][0].simbolo==jogador1.simbolo) {
				System.out.println("O jogador 1 venceu o jogo");
				return true;
			}
			else if(tabuleiro[0][0].simbolo==jogador2.simbolo) {
				System.out.println("O jogador 2 venceu o jogo");
				return true;
			}
		}
		//diagonal 2
		if(tabuleiro[0][2].simbolo==tabuleiro[1][1].simbolo&& tabuleiro[1][1].simbolo==tabuleiro[2][0].simbolo) {
			if(tabuleiro[0][2].simbolo==jogador1.simbolo) {
				System.out.println("O jogador 1 venceu o jogo");
				return true;
			}
			else if(tabuleiro[0][2].simbolo==jogador2.simbolo) {
				System.out.println("O jogador 2 venceu o jogo");
				return true;
			}
		}
		return false;
	}
}
