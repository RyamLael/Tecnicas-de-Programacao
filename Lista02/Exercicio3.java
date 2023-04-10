package Lista02;
import java.util.Scanner;
public class Exercicio3 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int numsort=22, numchute;
		
		System.out.println("Adivinhe um número entre 1 e 100: ");
		numchute = leitor.nextInt();
		
		while(numchute!=numsort) {
			
			if(numsort>numchute)
				System.out.println("O número secreto é maior que " + numchute);
			else
				System.out.println("O número secreto é menor que " + numchute);
			
			System.out.println("Digite outro número dentre 1 e 100: ");
			numchute = leitor.nextInt();
			
		}
		
		System.out.println("Parabéns, você acertou! \nO número era: " +numsort);
		
	}

}
