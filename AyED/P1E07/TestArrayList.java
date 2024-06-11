package P1E07;
import java.util.Scanner;
import java.util.ArrayList;

public class TestArrayList {
	
	public static boolean esta7e(Estudiante e, ArrayList<Estudiante> list) {
		boolean encontre = false;
		int i = 0;
		while(i < list.size() && (!encontre)){
			if(list.get(i).equals(e)) {
				encontre = true;
			}
			i++;
		}
		return encontre;
	}
	
	public static void metodo7d(){		
		ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
		lista.add(new Estudiante("Valentin", "Capelli", "valentin@gmail.com", "TM", "Diagonal 77"));
		lista.add(new Estudiante("Fabio", "Torrejon", "torrejonfabio@gmail.com", "TM", "Pedro Hita 214"));
		lista.add(new Estudiante("Santiago", "Acuña", "santiacu@gmail.com", "TM", "Republica"));
		
		//copia de la lista "lista"
		ArrayList<Estudiante> cLista = new ArrayList<Estudiante>(lista);
		
		System.out.println("Lista original: ");
		for (Estudiante est : lista) {
			System.out.println(est.getApellido());
		}
		
		System.out.println("--------------------------");
		
		System.out.println("Lista copiada: ");
		for(Estudiante est : cLista) {
			System.out.println(est.getApellido());
		}
		
		//modifico un dato
		Estudiante estMod = lista.get(0);
		estMod.setNombre("cape");
		estMod.setApellido("puto");
		
		System.out.println("--------------------------");
		System.out.println("Imprimo luego de la modificacion de la lista original ");
		System.out.println("Lista original: ");
		for (Estudiante est : lista) {
			System.out.println(est.getApellido());
		}
		
		System.out.println("--------------------------");
		
		System.out.println("Lista copiada: ");
		for(Estudiante est : cLista) {
			System.out.println(est.getApellido());
		}
		
		System.out.println("---------AGREGO-NUEVO-ESTUDIANTE-----------");
		Estudiante testEst = new Estudiante("Fabio", "Torrejon", "torrejonfabio@gmail.com", "TM", "Pedro Hita 214");
		if(!esta7e(testEst, lista)) {
			lista.add(testEst);
			System.out.println("Se agrego correctamente");
		}else {
			System.out.println("No se pudo agregar el estudiante porque ya se encuentra en la lista");
		}
	}	
		
	public static boolean esCapicua(ArrayList<Integer> lista) {
        int posi = 0;
        int posj = lista.size() - 1;
        boolean result = true; 
        while (posi < posj) { 
            if (!lista.get(posi).equals(lista.get(posj))) { 
                result = false; 
                break; 
            }
            posi++; 
            posj--;
        }
        return result;
    }
	
	public static void main(String[]args) {
		Scanner escaner = new Scanner(System.in);
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		System.out.println("Ingrese una lista de numeros (finaliza con '9999')");
		Integer e = escaner.nextInt();
		while(e != 9999) {
			lista.add(e);
			e = escaner.nextInt();
		}
		System.out.println(lista.size());
		System.out.println("Lista: ");
		for(int i: lista) {
			System.out.println(i);	
		}
		escaner.close();
		metodo7d();
		if(esCapicua(lista)) {
			System.out.println("La lista es capicua");
		}
		else {
			System.out.println("No es capicua");
		}
	}
}
