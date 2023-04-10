package Lista02;
import java.util.Scanner;
public class Exercicio7 {
	public static boolean testeprimo(int numuser) {
		
		int timesdivisible=0;
		int a;
		
		for(a=2;a<=numuser;a++) {
			
			if(numuser%a==0)
				timesdivisible++;
			if(timesdivisible>2) 
				return false;
			
		}
		return true;
	}

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int numuser,divisor;
		
		System.out.println("Digite um número");
		numuser = leitor.nextInt();
		
		if (numuser>2) {
			numuser--;
		
			while(!testeprimo(numuser)) {
				numuser--;
			}
			System.out.println("O maior primo que antecede o número digitado é " + numuser);
		}
		else
			System.out.println("Não existem primos menores que o número digitado");
	}
}
