package Lista02;
public class Exercicio6 {
	
	public static void main(String[] args) {
		
		int aux=0, x, y, timessymmetrical=0;
		int matriz[][] = new int [3][3];
		int matriztrans[][] = new int [3][3];
		
		//Creating a exemple of matrix
		for(x=0; x<3; x++) {
			for(y=0;y<3;y++) {
				matriz[x][y]=aux;
				aux++;
			}
		}
		
		//Showing matrix in column x row form
		System.out.println(matriz[0][0]  +" "+ matriz[0][1]+ " "+ matriz[0][2]+"\n" +
		matriz[1][0] + " " + matriz[1][1] + " " + matriz[1][2] + "\n" +
		matriz[2][0] + " " + matriz[2][1] + " " + matriz[2][2] + "\n");
		
		//Inverting rows by columns to find the inverse
		for(x=0,aux=0; x<3; x++) {
			for(y=0;y<3;y++) {
				matriztrans[y][x]=aux;
				aux++;
			}
		}
		
		//Showing the transposed matrix
		System.out.println(matriztrans[0][0]  +" "+ matriztrans[0][1]+ " "+ matriztrans[0][2]+"\n" +
				matriztrans[1][0] + " " + matriztrans[1][1] + " " + matriztrans[1][2] + "\n" +
				matriztrans[2][0] + " " + matriztrans[2][1] + " " + matriztrans[2][2] + "\n");
		
		//Testing the times matrix and symmetric matrix are equal
		for(x=0,aux=0; x<3; x++) {
			for(y=0;y<3;y++) {
				if(matriz[x][y]==matriztrans[x][y])
					timessymmetrical++;
			}
		}
		
		if(timessymmetrical==9) 
			System.out.println("This matrix is symmetric");
		else
			System.out.println("This matrix isn't symmetric");
	}
}
