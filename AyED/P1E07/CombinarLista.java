package P1E07;
import java.util.ArrayList;
import java.util.Collections;

public class CombinarLista {
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> newList = new ArrayList<Integer>(lista1);
		newList.addAll(lista2);
		Collections.sort(newList);
		return newList;
	}
	
	public static void main(String[]args) {
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		
		lista1.add(1);
		lista1.add(5);
		lista1.add(10);
		lista1.add(15);
		
		lista2.add(12);
		lista2.add(45);
		lista2.add(60);
		lista2.add(66);
		
		CombinarLista combinarListas = new CombinarLista();
		ArrayList<Integer> listaNueva = combinarListas.combinarOrdenado(lista1, lista2);
		
		System.out.println("Los elementos de la nueva lista son: ");
		for(int i:listaNueva) {
			System.out.println(i);
		}
	}
}
