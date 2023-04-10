package Lista02;
import java.util.Scanner;
public class Exercicio5{

	public static void main(String[] args){
		
		Scanner leitor = new Scanner(System.in);
		int limsuperior, colunaesq=0, colunadir=0;
		
		System.out.println("Digite um número para ser o limite superior da sequência: ");
		limsuperior = leitor.nextInt();
		
		for(;colunaesq<=limsuperior;colunaesq++){
			
			for(;colunadir<=limsuperior;colunadir++) 
				System.out.println(colunaesq +" "+colunadir);
			
			colunadir=0;
			
		}
	}
}
