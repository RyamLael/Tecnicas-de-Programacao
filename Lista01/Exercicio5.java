package Lista01;
import java.util.Scanner;
public class Exercicio5 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int a,b;
		//continue a nadar
		
		System.out.println("Digite um valor inteiro para a:");
		a = leitor.nextInt();
		System.out.println("Digite um valor inteiro para b:");
		b = leitor.nextInt();
		
		if(a>10||a+b==20)
			System.out.println("Numero valido");
		else
			System.out.println("Número inválido");
	}
}	