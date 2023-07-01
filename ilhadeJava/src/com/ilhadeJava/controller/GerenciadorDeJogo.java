package com.ilhadeJava.controller;

import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ilhadeJava.model.*;
import com.ilhadeJava.view.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class GerenciadorDeJogo {

	private int rodadas;
	private String nomedoJogador;

	private TelaPrincipal telaPrincipal;
	private BotoesRobos botoesRobos;
	private BotoesOperadores botoesOperadores;
	private Tabuleiro tabuleiro;
	private Display display;

	private R2D2 r2d2;
	private C3PO c3po;
	private BB8 bb8;

	public GerenciadorDeJogo(TelaPrincipal telaprincipal) {

		this.telaPrincipal = telaprincipal;
		this.botoesRobos = telaPrincipal.getPainelLateral().getBotoesRobos();
		this.botoesOperadores = telaPrincipal.getPainelLateral().getBotoesOperadores();
		this.tabuleiro = telaPrincipal.getTabuleiro();
		this.display = telaPrincipal.getPainelLateral().getDisplay();
		this.rodadas = 0;

		r2d2 = new R2D2();
		c3po = new C3PO();
		bb8 = new BB8();
		
		popularPlano(tabuleiro.getPlano(), 10, 10);

		telaPrincipal.getPainelSuperior().getBotaoJogar().addActionListener(new Botaojogar());

		botoesRobos.getBotaoR2D2().addActionListener(new AcaoRobos(r2d2));
		botoesRobos.getBotaoC3PO().addActionListener(new AcaoRobos(c3po));
		botoesRobos.getBotaoBB8().addActionListener(new AcaoRobos(bb8));

		botoesOperadores.getVerificar().addActionListener(new acaoVerificar());
		botoesOperadores.getProximaRodada().addActionListener(new acaoProximaRodada());
		botoesOperadores.getSair().addActionListener(new acaoSair());

		for (Celula celula : tabuleiro.getPlano().getListaCelulas()) {

			celula.getBotao().addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					botoesRobos.enableUnpressedButtons();

					if (botoesRobos.todosBotoesPressionados())
						botoesOperadores.getVerificar().setEnabled(true);

					celula.setRoboPassou(true);
					celula.getBotao().setIcon(botoesRobos.getRoboEscolhido().getIcone());

					if (celula.possuiAlunos())
						botoesRobos.getRoboEscolhido().addAlunosEncontrados();
					else if (celula.possuiBugs())
						botoesRobos.getRoboEscolhido().addBugsEncontrados();

					celula.getListaEntidades().add(botoesRobos.getRoboEscolhido());

					botoesRobos.setRoboEscolhido(null);
					onofTabuleiro(false);
				}
			});
		}
	}

	private void popularPlano(Plano plano, int numAlunos, int numBugs) {

		for (int i = 1; i <= numAlunos; i++) {
			tabuleiro.getPlano().getCelula(sortId()).getListaEntidades().add(new Aluno());
			//exibirAlunosouBugs(tabuleiro.getPlano().getCelula(sortId()), new Aluno());
		}
		for (int i = 1; i <= numBugs; i++) {
			tabuleiro.getPlano().getCelula(sortId()).getListaEntidades().add(new Bug());
			//exibirAlunosouBugs(tabuleiro.getPlano().getCelula(sortId()), new Bug());
		}
	}

	private int sortId() {
		Random aleatorio = new Random();
		int idsort = aleatorio.nextInt(64);
		if (tabuleiro.getPlano().getCelula(idsort).possuiEntidades())
			return sortId();
		return idsort;
	}

	private void exibirAlunosouBugs(Celula celula, Entidade alunooubug) {
		int id = celula.getId();
		
		tabuleiro.getPlano().getCelula(id).getListaEntidades().add(alunooubug);
		
		if (alunooubug instanceof Aluno) {
			tabuleiro.getPlano().getCelula(id).getListaEntidades().add(alunooubug);
			tabuleiro.getPlano().getCelula(id).getBotao().setIcon(new Icone("icones/luke.png", 32, 32));
		} else {
			celula.getListaEntidades().add(alunooubug);
			celula.getBotao().setIcon(new Icone("icones/darth.png", 32, 32));
		}
	}

	private void onofTabuleiro(boolean HabilitarouDesabilitar) {
		for (Celula celula : tabuleiro.getPlano().getListaCelulas()) {

			if (celula.isRoboPassou()) {
				celula.getBotao().setEnabled(false);
				celula.getBotao().setDisabledIcon(celula.getBotao().getIcon());
			} else {
				celula.getBotao().setEnabled(HabilitarouDesabilitar);
				celula.getBotao().setDisabledIcon(celula.getBotao().getIcon());
			}
		}
	}

	private void adicionarPontos(Celula celula, Entidade alunooubug) {

		if (celula.possuiRobo(r2d2)) {
			r2d2.setPontuacao(r2d2.getPontuacao() + alunooubug.getPontuacao());
			celula.removerRobo(r2d2);
		} else if (celula.possuiRobo(c3po)) {
			c3po.setPontuacao(c3po.getPontuacao() + alunooubug.getPontuacao());
			celula.removerRobo(c3po);
		} else if (celula.possuiRobo(bb8)) {
			bb8.setPontuacao(bb8.getPontuacao() + alunooubug.getPontuacao());
			celula.removerRobo(bb8);
		}

		display.updateData(r2d2.getPontuacao(), c3po.getPontuacao(), bb8.getPontuacao(), bugsEncontrados(),
				alunosEncontrados());
	}

	private String lerRelatorio() {

		String relatorio = "Relatorio\n";

		try (BufferedReader reader = new BufferedReader(new FileReader("arquivos/registrodejogo.txt"))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] campos = linha.split(";");

				int poscampo = 0;

				for (String campo : campos) {

					switch (poscampo) {
					case 0:
						relatorio += "Nome do jogador: " + campo;
						break;
					case 1:
						relatorio += "\nQuantidade de Jogadas: " + campo;
						break;
					case 2:
						relatorio += "\nCélulas vazias: " + campo;
						break;
					case 3:
						relatorio +="\nAlunos encontrados: " + campo; 
						break;
					case 4:
						relatorio +="\nBugs encontrados: " + campo;
						break;
					case 5:
						relatorio += "\nPontuação: " + campo;
						break;
					case 6:
						relatorio += "\nR2D2: " + campo;
						break;
					case 7:
						relatorio += "\nC3PO: " + campo;
						break;
					case 8:
						relatorio += "\nBB8: " + campo;
						break;
					default:
					}
					poscampo++;
				}
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo");
		}
		return relatorio;
	}

	private int bugsEncontrados() {
		int bugsencontrados = r2d2.getBugsEncontrados() + c3po.getBugsEncontrados() + bb8.getBugsEncontrados();
		return bugsencontrados;
	}

	private int alunosEncontrados() {
		int alunosencontrados = r2d2.getAlunosEncontrados() + c3po.getAlunosEncontrados() + bb8.getAlunosEncontrados();
		return alunosencontrados;
	}
	
	
	private class Botaojogar implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JButton botaoJogar = (JButton) e.getSource();

			if (telaPrincipal.getPainelSuperior().getCampodetexto().getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Digite um nome...");
			else {

				nomedoJogador = telaPrincipal.getPainelSuperior().getCampodetexto().getText();
				botaoJogar.setEnabled(false);
				telaPrincipal.getTabuleiro().setVisible(true);
				telaPrincipal.getPainelLateral().setVisible(true);
			}
		}
	}

	
	private class AcaoRobos implements ActionListener {

		private Robo robo;

		public AcaoRobos(Robo robodobotao) {
			robo = robodobotao;
		}

		public void actionPerformed(ActionEvent e) {

			JButtonrobots botaoRobo = (JButtonrobots) e.getSource();

			botaoRobo.setEnabled(false);
			botaoRobo.setWasPressed(true);

			botaoRobo.setDisabledIcon(robo.getIcone());
			telaPrincipal.getPainelLateral().getBotoesRobos().setRoboEscolhido(robo);

			botoesRobos.disableAllbuttons();
			onofTabuleiro(true);
		}
	}

	
	private class acaoVerificar implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			for (Celula celula : tabuleiro.getPlano().getListaCelulas()) {

				if (celula.possuiAlunos() && celula.possuiRobos()) {
					mudarIcones(celula, "icones/luke.png");
					adicionarPontos(celula, new Aluno());
				} else if (celula.possuiBugs() && celula.possuiRobos()) {
					mudarIcones(celula, "icones/darth.png");
					adicionarPontos(celula, new Bug());
				} else if (celula.possuiRobos()) {
					mudarIcones(celula, "icones/sabredeluz.png");
				}

			}
			botoesOperadores.getVerificar().setEnabled(false);

		}

		private void mudarIcones(Celula celula, String caminhoparaicone) {
			celula.getBotao().setDisabledIcon(new Icone(caminhoparaicone, 32, 32));
			celula.getBotao().setIcon(new Icone(caminhoparaicone, 32, 32));
		}
	}

	private class acaoProximaRodada implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton botaoProximaRodada = ((JButton) e.getSource());

			rodadas++;
			botoesRobos.restoreAllButtons();
		}
	}

	private class acaoSair implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			gerarRelatorio();

			JOptionPane.showMessageDialog(null, lerRelatorio());
			telaPrincipal.dispose();
		}

		private void gerarRelatorio() {

			try {
				File arquivo = new File("arquivos/registrodejogo.txt");
				FileWriter writer = new FileWriter(arquivo);

				writer.write(nomedoJogador + ";" + rodadas + ";" + tabuleiro.getPlano().celulasVazias() + ";"
						+ alunosEncontrados() + ";" + bugsEncontrados() + ";"
						+ (r2d2.getPontuacao() + c3po.getPontuacao() + bb8.getPontuacao()) + ";" + r2d2.getPontuacao()
						+ ";" + c3po.getPontuacao() + ";" + bb8.getPontuacao() + ";");
				writer.close();

			} catch (IOException l) {
				System.out.println("Erro em criar o arquivo");
			}
		}
	}
}