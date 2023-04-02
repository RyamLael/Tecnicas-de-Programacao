package Lista01;
import java.util.Scanner;
public class Exercicio4 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int a,b;
		//continue
		
		System.out.println("Digite um valor inteiro para a:");
		a = leitor.nextInt();
		System.out.println("Digite um valor inteiro para b:");
		b = leitor.nextInt();
		
		if(a>10||a+b==20)
			System.out.println("Numero valido");
		else
			if(a==b)
				System.out.println("(a é igual b; A e B são\r\n"
						+ "diferentes de 10; A é menor que 10");
			else
				System.out.println("Número inválido");
	}
}	