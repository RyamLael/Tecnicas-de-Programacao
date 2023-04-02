package Lista01;
import java.util.Scanner;
public class Exercicio9 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int a,b;
		//  \o/ Que país é esse???
		//   |  
		//  / \
		
		System.out.println("Digite um valor inteiro para a:");
		a = leitor.nextInt();
		System.out.println("Digite um valor inteiro para b:");
		b = leitor.nextInt();
		
	    //eu não entendi se é pra verificar se a>10 e a+b==20 é verdadeiro ou se é
		//para verificar se a>10 é verdadeiro e só depois verificar se a+b==20
		
		if(a>10 && a+b==20) 
			System.out.println("a+b=20");
		else
			System.out.println("Número não válido");
	}
	
}	