package Lista01;
import java.util.Scanner;
public class Exercicio11 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int a,b;
		
		System.out.println("Digite um valor inteiro para a:");
		a = leitor.nextInt();
		System.out.println("Digite um valor inteiro para b:");
		b = leitor.nextInt();
		
		if(!(a>10)){
			if(a+b==20)
				System.out.println("a + b = 20");
			else
				System.out.println("Número não válido");
		}
			
	}
	
}	