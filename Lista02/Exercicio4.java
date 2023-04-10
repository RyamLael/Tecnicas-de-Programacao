package Lista02;
import java.util.Scanner;
public class Exercicio4 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int colunaesq, colunadir=0;
		//As variáveis referem-se as duas colunas da tabela de multiplicação
		
		System.out.println("Digite um número para saber a tabuada");
		colunaesq = leitor.nextInt();
		
		//Seria melhor um for, mas a questão pede um while
		while(colunadir<10){
			System.out.println(colunaesq +"*"+ colunadir +"="+ colunaesq*colunadir);
			colunadir++;
		}
		
	}
	
}
