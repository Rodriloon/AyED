/*
1. devolverCamino (String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
vacía. (Sin tener en cuenta el combustible).
3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
existe camino retorna la lista vacía. (Las rutas poseen la distancia).
4. caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
5. caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
retorna la lista vacía.
*/
package P5E03;
import P1E08.Queue;
import P5demo.Edge;
import P5demo.Graph;
import P5demo.Vertex;
import java.util.*;

public class Mapa {
	
	Graph<String> mapaCiudades;
	
	public Mapa (Graph<String> map){
		mapaCiudades = map;
	}
	
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		Graph<String> mapa = mapaCiudades;
		boolean[] marca = new boolean[mapa.getSize()];
		List<String> lista = new LinkedList<String>(); 
		// Encuentra el vértice de inicio
	    Vertex<String> inicio = null;
	    boolean found = false;
	    for (Vertex<String> vertice : mapa.getVertices()) {
	        if (!found && vertice.getData().equals(ciudad1)) {
	            inicio = vertice;
	            found = true;
	        }
	    }
	    if (inicio == null) {
	        return lista; // Si la ciudad de inicio no está en el grafo, retorna lista vacía
	    }
	    devolverCaminoDFS(inicio, mapa, lista, marca, ciudad2);
	    // Si lista contiene ciudad2, retorna lista; si no, retorna lista vacía
	    return lista.contains(ciudad2) ? lista : new LinkedList<>();
	}
	public boolean devolverCaminoDFS (Vertex<String> verticeActual, Graph<String> mapa, List<String> lista, boolean[] marca, String ciudad2) {
		marca[verticeActual.getPosition()] = true;
	    lista.add(verticeActual.getData());
	    if (verticeActual.getData().equals(ciudad2)) {
	        return true; // Condición de salida: encontramos la ciudad objetivo
	    }
	    List<Edge<String>> adyacentes = mapa.getEdges(verticeActual);
	    for (Edge<String> e : adyacentes) {
	        Vertex<String> verticeSiguiente = e.getTarget();
	        if (!marca[verticeSiguiente.getPosition()]) {
	            boolean encontrado = devolverCaminoDFS(verticeSiguiente, mapa, lista, marca, ciudad2);
	            if (encontrado) {
	                return true; // Si encontramos el camino, terminamos la recursión
	            }
	        }
	    }
	    lista.remove(lista.size() - 1); // Removemos el último elemento si no encontramos la ciudad objetivo
	    return false;
	}
	
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
	    Graph<String> mapa = mapaCiudades;
	    boolean[] marca = new boolean[mapa.getSize()];
	    List<String> lista = new LinkedList<>();
	    // Encuentra el vértice de inicio sin usar break
	    Vertex<String> inicio = null;
	    boolean found = false;
	    for (Vertex<String> vertice : mapa.getVertices()) {
	        if (!found && vertice.getData().equals(ciudad1)) {
	            inicio = vertice;
	            found = true;
	        }
	    }
	    if (inicio == null) {
	        return lista; // Si la ciudad de inicio no está en el grafo, retorna lista vacía
	    }
	    devolverCaminoExceptuandoDFS(inicio, mapa, lista, marca, ciudad2, ciudades);
	    // Si lista contiene ciudad2, retorna lista; si no, retorna lista vacía
	    return lista.contains(ciudad2) ? lista : new LinkedList<>();
	}
	public boolean devolverCaminoExceptuandoDFS(Vertex<String> verticeActual, Graph<String> mapa, List<String> lista, boolean[] marca, String ciudad2, List<String> ciudades) {
	    if (ciudades.contains(verticeActual.getData())) {
	        return false; // Si la ciudad actual está en la lista de ciudades a excluir, no la procesamos
	    }
	    marca[verticeActual.getPosition()] = true;
	    lista.add(verticeActual.getData());
	    if (verticeActual.getData().equals(ciudad2)) {
	        return true; // Condición de salida: encontramos la ciudad objetivo
	    }
	    List<Edge<String>> adyacentes = mapa.getEdges(verticeActual);
	    for (Edge<String> e : adyacentes) {
	        Vertex<String> verticeSiguiente = e.getTarget();
	        if (!marca[verticeSiguiente.getPosition()]) {
	            boolean encontrado = devolverCaminoExceptuandoDFS(verticeSiguiente, mapa, lista, marca, ciudad2, ciudades);
	            if (encontrado) {
	                return true; // Si encontramos el camino, terminamos la recursión
	            }
	        }
	    }
	    lista.remove(lista.size() - 1); // Removemos el último elemento si no encontramos la ciudad objetivo
	    return false;
	}
	
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
	    Graph<String> mapa = mapaCiudades;
	    // Encuentra los vértices de inicio y destino
	    Vertex<String> inicio = null;
	    Vertex<String> destino = null;
	    for (Vertex<String> vertice : mapa.getVertices()) {
	        if (vertice.getData().equals(ciudad1)) {
	            inicio = vertice;
	        }
	        if (vertice.getData().equals(ciudad2)) {
	            destino = vertice;
	        }
	    }
	    if (inicio == null || destino == null) {
	        return new LinkedList<>(); // Si alguna ciudad no está en el grafo, retorna lista vacía
	    }
	    // Inicialización para el algoritmo de Dijkstra
	    Map<Vertex<String>, Integer> distancias = new HashMap<>();
	    Map<Vertex<String>, Vertex<String>> predecesores = new HashMap<>();
	    PriorityQueue<Vertex<String>> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
	    for (Vertex<String> vertice : mapa.getVertices()) {
	        distancias.put(vertice, Integer.MAX_VALUE); // Inicializa todas las distancias a infinito
	        predecesores.put(vertice, null); // Inicializa todos los predecesores como null
	    }
	    distancias.put(inicio, 0); // La distancia al vértice inicial es 0
	    colaPrioridad.add(inicio);
	    boolean destinoAlcanzado = false;
	    while (!colaPrioridad.isEmpty() && !destinoAlcanzado) {
	        Vertex<String> verticeActual = colaPrioridad.poll();
	        
	        if (verticeActual.equals(destino)) {
	            destinoAlcanzado = true; // Marcamos que hemos alcanzado el destino
	        } else {
	            List<Edge<String>> adyacentes = mapa.getEdges(verticeActual);
	            for (Edge<String> e : adyacentes) {
	                Vertex<String> verticeSiguiente = e.getTarget();
	                int nuevaDistancia = distancias.get(verticeActual) + e.getWeight();
	                if (nuevaDistancia < distancias.get(verticeSiguiente)) {
	                    distancias.put(verticeSiguiente, nuevaDistancia);
	                    predecesores.put(verticeSiguiente, verticeActual);
	                    colaPrioridad.add(verticeSiguiente); // Añadimos el vértice a la cola con nueva distancia
	                }
	            }
	        }
	    }
	    // Construir el camino más corto desde destino hasta inicio
	    List<String> camino = new LinkedList<>();
	    for (Vertex<String> v = destino; v != null; v = predecesores.get(v)) {
	        camino.add(v.getData());
	    }
	    Collections.reverse(camino); // Revertir el camino para que sea desde ciudad1 a ciudad2
	    // Verificar si el camino contiene ciudad1
	    if (camino.isEmpty() || !camino.get(0).equals(ciudad1)) {
	        return new LinkedList<>(); // Si no hay camino desde ciudad1 a ciudad2, retornar lista vacía
	    }
	    return camino;
	}
	
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
	    Graph<String> mapa = mapaCiudades;
	    boolean[] marca = new boolean[mapa.getSize()];
	    List<String> lista = new LinkedList<>();
	    // Encuentra el vértice de inicio sin usar break
	    Vertex<String> inicio = null;
	    boolean found = false;
	    for (Vertex<String> vertice : mapa.getVertices()) {
	        if (!found && vertice.getData().equals(ciudad1)) {
	            inicio = vertice;
	            found = true;
	        }
	    }
	    if (inicio == null) {
	        return lista; // Si la ciudad de inicio no está en el grafo, retorna lista vacía
	    }
	    caminoSinCargarCombustibleDFS(inicio, mapa, lista, marca, ciudad2, tanqueAuto, tanqueAuto);
	    
	    // Si lista contiene ciudad2, retorna lista; si no, retorna lista vacía
	    return lista.contains(ciudad2) ? lista : new LinkedList<>();
	}
	public boolean caminoSinCargarCombustibleDFS(Vertex<String> verticeActual, Graph<String> mapa, List<String> lista, boolean[] marca, String ciudad2, int tanqueAuto, int tanqueRestante) {
	    marca[verticeActual.getPosition()] = true;
	    lista.add(verticeActual.getData());
	    if (verticeActual.getData().equals(ciudad2)) {
	        return true; // Condición de salida: encontramos la ciudad objetivo
	    }
	    List<Edge<String>> adyacentes = mapa.getEdges(verticeActual);
	    for (Edge<String> e : adyacentes) {
	        Vertex<String> verticeSiguiente = e.getTarget();
	        int distancia = e.getWeight();
	        if (!marca[verticeSiguiente.getPosition()] && tanqueRestante >= distancia) {
	            boolean encontrado = caminoSinCargarCombustibleDFS(verticeSiguiente, mapa, lista, marca, ciudad2, tanqueAuto, tanqueRestante - distancia);
	            if (encontrado) {
	                return true; // Si encontramos el camino, terminamos la recursión
	            }
	        }
	    }
	    lista.remove(lista.size() - 1); // Removemos el último elemento si no encontramos la ciudad objetivo
	    marca[verticeActual.getPosition()] = false; // Desmarcamos el vértice para permitir otros caminos
	    return false;
	}
	
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
	    Graph<String> mapa = mapaCiudades;
	    // Encuentra los vértices de inicio y destino
	    Vertex<String> inicio = null;
	    Vertex<String> destino = null;
	    boolean inicioEncontrado = false;
	    boolean destinoEncontrado = false;
	    for (Vertex<String> vertice : mapa.getVertices()) {
	        if (!inicioEncontrado && vertice.getData().equals(ciudad1)) {
	            inicio = vertice;
	            inicioEncontrado = true;
	        }
	        if (!destinoEncontrado && vertice.getData().equals(ciudad2)) {
	            destino = vertice;
	            destinoEncontrado = true;
	        }
	    }
	    if (inicio == null || destino == null) {
	        return new LinkedList<>(); // Si alguna ciudad no está en el grafo, retorna lista vacía
	    }
	    // Inicialización para el algoritmo de Dijkstra modificado
	    Map<Vertex<String>, Integer> cargas = new HashMap<>();
	    Map<Vertex<String>, Vertex<String>> predecesores = new HashMap<>();
	    PriorityQueue<Vertex<String>> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(cargas::get));
	    for (Vertex<String> vertice : mapa.getVertices()) {
	        cargas.put(vertice, Integer.MAX_VALUE); // Inicializa todas las cargas a infinito
	        predecesores.put(vertice, null); // Inicializa todos los predecesores como null
	    }
	    cargas.put(inicio, 0); // La cantidad de cargas para el vértice inicial es 0
	    colaPrioridad.add(inicio);
	    while (!colaPrioridad.isEmpty()) {
	        Vertex<String> verticeActual = colaPrioridad.poll();
	        if (verticeActual.equals(destino)) {
	            break; // Encontramos el destino, salimos del bucle
	        }
	        List<Edge<String>> adyacentes = mapa.getEdges(verticeActual);
	        for (Edge<String> e : adyacentes) {
	            Vertex<String> verticeSiguiente = e.getTarget();
	            int distancia = e.getWeight();
	            int nuevasCargas = cargas.get(verticeActual) + (distancia > tanqueAuto ? 1 : 0);
	            if (distancia <= tanqueAuto && nuevasCargas < cargas.get(verticeSiguiente)) {
	                cargas.put(verticeSiguiente, nuevasCargas);
	                predecesores.put(verticeSiguiente, verticeActual);
	                colaPrioridad.add(verticeSiguiente); // Añadimos el vértice a la cola con nuevas cargas
	            }
	        }
	    }
	    // Construir el camino con menor cantidad de cargas desde destino hasta inicio
	    List<String> camino = new LinkedList<>();
	    for (Vertex<String> v = destino; v != null; v = predecesores.get(v)) {
	        camino.add(v.getData());
	    }
	    Collections.reverse(camino); // Revertir el camino para que sea desde ciudad1 a ciudad2
	    // Verificar si el camino contiene ciudad1
	    if (camino.isEmpty() || !camino.get(0).equals(ciudad1)) {
	        return new LinkedList<>(); // Si no hay camino desde ciudad1 a ciudad2, retornar lista vacía
	    }
	    return camino;
	}
}
