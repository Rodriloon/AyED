package P1E02;
import java.util.Scanner;

public class ejercicio2 {
	
	public static int [] devolverVector(int n) {
		int [] vector = new int[n];
		for(int i = 0; i < n; i++) {
			vector[i] = (i+1) * n;
		}
	return vector;
	}
	
	public static void main (String[]args) {
		Scanner escanner = new Scanner(System.in);
		System.out.println("Ingrese un numero");
		int n = escanner.nextInt();
		int [] vector = devolverVector(n);
		for(int i : vector) {
			System.out.println(i);
		}
        escanner.close();
	}
	
}
