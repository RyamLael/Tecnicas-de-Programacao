package Lista01;
import java.util.Scanner;
public class Exercicio10 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int a,b;
		//Voce tira minha pele, eu nao choro, voce sim. Quem sou?
		//A cebola.
		
		System.out.println("Digite um valor inteiro para a:");
		a = leitor.nextInt();
		System.out.println("Digite um valor inteiro para b:");
		b = leitor.nextInt();
		
		if(!(a>10)) 
			System.out.println("Número menor que 10");
			//isso está logicamente errado, pois a pode ser igual a 10
		if(!(a+b==20))
			System.out.println("Número diferente de 20");
	}
}	