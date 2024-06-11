package P1E07;
import java.util.ArrayList;

public class InvertirOrden {
	public void invertirArrayList(ArrayList<Integer> lista) {
		invert(lista, 0, lista.size()-1);
	}
	
	
	private void invert(ArrayList<Integer> lista, int posi, int posj) {
        if(posi >= posj) { 
        	return;
         }else {
        	 int aux = lista.get(posj);
        	 lista.set(posj, lista.get(posi));
        	 lista.set(posi, aux);
        	 invert(lista, posi + 1, posj - 1);
         }
     }
	
	public static void main(String[]args) {
		InvertirOrden invertirOrden = new InvertirOrden();
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		System.out.println("Lista sin invertir: ");
		for(int i:lista) {
			System.out.println(i);
		}
		
		invertirOrden.invertirArrayList(lista);
		System.out.println("Lista invertida: ");
		for(int i:lista) {
			System.out.println(i);
		}
	}
}
