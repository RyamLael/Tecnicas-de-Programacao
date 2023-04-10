package Lista02;
import java.util.Scanner;
public class Exercicio2 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int numuser=0, soma=0;
		
		while(numuser>=0) {
			
			System.out.println("Digite um número inteiro: ");
			numuser = leitor.nextInt();
			
			if(numuser>=0)
				soma = soma + numuser;
			
		}
		
		System.out.println("A soma dos números positivos lidos é: " + soma);

	}

}
