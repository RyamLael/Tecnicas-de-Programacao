package Lista02;
import java.util.Scanner;
public class Exercicio8 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		String expression;
		int a, b;
		
		System.out.println("Digite uma expressão matemática: ");
		expression = leitor.nextLine();
		
		for(a=0; a<expression.length(); a++) {
			if(expression.charAt(a) == '(') {
				for(b=0; b<expression.length(); b++) {
					if(!(expression.charAt(a)==')')) {
						System.out.println("Está faltando um )");
					}
				}
				
			}
				
			System.out.print(expression.charAt(a)+ " ");
		}
		
	}

}
