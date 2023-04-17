package Lista3;
import java.util.Scanner;
public class Exercicio1 {

	public static int Somatorio(int[] vetsomatorio) {
		int soma=0;
			
		if(vetsomatorio.length<3)
			return 0;
		
		for(int i=2; i < vetsomatorio.length-2; i++) {
			soma= soma +vetsomatorio[i];
		}
		
		return soma;
	}
	
	public static float Media(float[] vetmedia1,float[] vetmedia2) {
		float media, soma=0, tamvetores = vetmedia1.length + vetmedia2.length;
		
		for(int i=0;i<tamvetores; i++) {
			
			soma=soma + vetmedia1[i];
			soma=soma + vetmedia2[i];
			
		}
		
		return media=soma/tamvetores;
	}
	
	public static float MediaPonderada(float[] vetvalores, float [] vetpesos) {
		float media, soma=0, pesos=0;
		
		for(int i=0; i< vetvalores.length;i++) {
			soma = soma+vetvalores[i]*vetpesos[i];
			pesos = pesos+vetpesos[i];
		}
		return soma/pesos;
	}
	
	public static int ContElementos(int[] vet1, int[] vet2, int elemento){
		int ocorrencias=0;
		for(int i=0; i<vet1.length; i++) {
			if(vet1[i]==elemento)
				ocorrencias++;
			if(vet2[i]==elemento)
				ocorrencias++;
			
		}
		return ocorrencias;
	}
	
	public static int[] CopiaVetor(int[] vetororiginal) {
		int vetorcopia[]= new int[vetororiginal.length];
		
		for(int j=0; j<vetororiginal.length; j++) {
			vetorcopia[j]=vetororiginal[j];
		}	
		return vetorcopia;
	}
	
	public static int[] VetorCrescente(int[] vetor) {
		int aux;
		for(int i=0; i<vetor.length-1;i++) {
			if(vetor[i]>vetor[i+1]) {
				aux=vetor[i+1];
				vetor[i+1]=vetor[i];
				vetor[i]=aux;
				VetorCrescente(vetor);
			}
		}
		return vetor;
	}
	
	public static boolean isOrdered(int[] vetorordn) {
		
		for(int i=0;i<vetorordn.length-1; i++) {
			if(vetorordn[i]>vetorordn[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		int funcaoid;
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o número da função pretendida: ");
		funcaoid = leitor.nextInt();
		
		switch(funcaoid){
		
			case 1:
				
				//SOMATÓRIO
				int vetsomatorio[]= {1,2,3,5,7,11,13,17};
				System.out.println("Função somatório: " + Somatorio(vetsomatorio));
			break;
			
			case 2:
				
				//MÉDIA
				float vetmedia1[]= {1,2,3,4,5,6,7};
				float vetmedia2[]= {1,2,3,4,5,6,7};
				System.out.println("Função média: " + Media(vetmedia1, vetmedia2));
				
			break;
			
			case 3: 
				
				// MÉDIA PONDERADA
				float vetvalores[]={8,9,10};
				float vetpesos[]= {1,2,3};
				System.out.println("Função média ponderada: "+ MediaPonderada(vetvalores,vetpesos));
				
			break;
			 
			case 4:
				
				//CONTAGEM DE ELEMENTOS
				int vet1[]= {1,1,2,3,4,5}; int vet2[]= {1,2,4,5,6,7};
				int elemento;
				
				System.out.println("Digite um elemento para saber quantas vezes ele se repete nos vetores");
				elemento = leitor.nextInt();
				
				System.out.println("Função da contagem de elementos: "+ ContElementos(vet1,vet2, elemento));
			
			break;
			
			case 5:
				
				//CÓPIA DE VETOR
				int vetororiginal[]= {1,2,3,4,5,6,7};
				int[] vetorcopia= CopiaVetor(vetororiginal);
				
				System.out.println("Função que copia um vetor: ");
				for(int i=0; i<vetorcopia.length;i++) {
					System.out.print(vetorcopia[i] + " ");
				}
			break;
			
			case 6:
				
				//ORDENAÇÃO CRESCENTE
				int vetor[]= {5,3,4,2,1};
				int[] vetorcres=VetorCrescente(vetor);
				
				System.out.println("O vetor é:");
				for(int i=0; i<vetorcres.length;i++) {
					System.out.print(vetorcres[i] + " ");
				}
			break;
			
			case 7:
				
				//VERIFICAR SE ESTÁ EM ORDEM CRESCENTE
				int vetorordn[]= {4,3,5,2,1};
				if(isOrdered(vetorordn))
					System.out.println("True");
				else
					System.out.println("False");
			break;
		}
			
		
	}

}
