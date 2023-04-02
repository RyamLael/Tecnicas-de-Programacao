package Lista01;
import java.util.Scanner;
public class Exercicio3 {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		int a,b;
		//goto
		
		System.out.println("Digite um valor inteiro para a:");
		a = leitor.nextInt();
		System.out.println("Digite um valor inteiro para b:");
		b = leitor.nextInt();
		
		if(a==10){
			System.out.println("a==10");
			if(a+b==20)
				System.out.println("a+b==20");		
		}
		//esse passo é desnecessário, sempre que a+b=20 e a = 10, b será = 10
		if(b==10)
			System.out.println("b==10");
	}
}	