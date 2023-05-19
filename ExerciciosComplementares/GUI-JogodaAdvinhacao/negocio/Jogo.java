package negocio;

import java.util.Random;
import apresentacao.*;

public class Jogo {

	private Jogador jogador;
	private Tela tela;
	private int numeroEscolhido;
	private boolean jogando;

	public Jogo() {
		tela = new Tela();
		jogador = new Jogador();
		numeroEscolhido = sortearNumero();
		jogando = true;
	}

	public void inciarJogoGUI() {
		jogador.setNome(tela.entradaDados("Qual � o seu nome?"));
		tela.mesagem("Seja bem vindo: " + jogador.getNome());
		jogadas();
	}
	
	public int sortearNumero() {
		Random random = new Random();
		int numeroSorteado = random.nextInt(10);
		return numeroSorteado;
	}

	public int solicitarNumero() {
		String numero = tela.entradaDados(tentativasRealizadas()+"Informe um numero:");
		jogador.addNumero(Integer.parseInt(numero));
		jogador.setNumeroTentativa();
		return Integer.parseInt(numero);
	}

	public void jogadas() {
		do {
			verificarAcerto();
		} while (jogando);

		fimDoJogo();
	}

	private void fimDoJogo() {

		String numeros = "";
		for (Integer numero : jogador.getListaNumeros()) {
			numeros += " - " + numero;
		}
		tela.mesagem("Numeros apostados: " + numeros);

	}

	public boolean verificarMenor(int numero) {
		if (numero < numeroEscolhido)
			return true;

		return false;
	}
	
	public String tentativasRealizadas() {
		
		String tentativas="Tentativas: ";
		if(jogador.getNumeroTentativa()==0) 
			return "";
		
		for(int testes : jogador.getListaNumeros()) {
			tentativas+= (testes + "    ");
		}
		return tentativas+"\n";
		
	}

	public void verificarAcerto() {
		
		int numero = solicitarNumero();
			
		if (numero == numeroEscolhido) {
			tela.mesagem("Parabens voce acertou! numero de tentativas: " + jogador.getNumeroTentativa());
			jogando = false;
		} else {		
			if (verificarMenor(numero)) {
				tela.mesagem("Deu ruim,  voce errou! \ntente um numero maior...");
			} else {
				tela.mesagem("Deu ruim,  voce errou! \nTente numero menor");
			}
		}
		
	}
	

	// public void verificarAcerto() {
	// do {
	// if (solicitarNumero() == numeroEscolhido) {
	// jogador.setNumeroTentativa();
	// tela.mesagem("Parabens voce acertou! numero de tentativas: " +
	// jogador.getNumeroTentativa());
	// return;
	// } else {
	// tela.mesagem("Deu ruim, voce errou");
	// jogador.setNumeroTentativa();
	// }
	// } while (true);
	// }
}
