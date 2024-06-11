package P1E01;
import java.util.Scanner;

public class ejercicio1 {
	
	public static void imprimirFor (int a, int b) {
		for (int i = a + 1; i < b; i++) {
			System.out.println(i);
		}
	}
	
	public static void imprimirWhile(int a, int b) {
		int i = a + 1;
		while(i < b) {
			System.out.println(i);
			i++;
		}
	}
	
	public static void imprimir(int a, int b) {
		if (a < b - 1) {
			System.out.println(a + 1);
			a++;
			imprimir(a, b);
		}
	}
	
	public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in) ;
        System.out.print("Ingrese un nro: ");
        int a = escaner.nextInt();

        System.out.print("Ingrese otro nro: ");
        int b = escaner.nextInt();
        imprimirFor(a, b);
        System.out.println();
        imprimirWhile(a, b);
        System.out.println();
        imprimir(a, b);
        escaner.close();
    }
	
}
