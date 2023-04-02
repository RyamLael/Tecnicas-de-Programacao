package Lista01;
import java.util.Scanner;
public class Exercicio7 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int a,b;
		//Sim, eu copiei e colei o início do código inicial todas as vezes, como adivinhou?
		
		System.out.println("Digite um valor inteiro para a:");
		a = leitor.nextInt();
		System.out.println("Digite um valor inteiro para b:");
		b = leitor.nextInt();
		
		if(a>10||a+b==20)
			System.out.println("Números válidos");
		else if(!(a>10))
			System.out.println("Números inválidos");
	}
	
}	