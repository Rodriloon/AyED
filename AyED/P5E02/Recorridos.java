package P5E02;
import P1E08.Queue;
import P5demo.Edge;
import P5demo.Graph;
import P5demo.Vertex;
import java.util.*;

public class Recorridos<T> {
    
	//DFS buscar por caminos
    //O(V+E) V: numero de vertices y E: numero de aristas
    public List<T> dfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lis = new LinkedList<T>(); 
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                dfs(i, grafo, lis, marca);
            }
        }
        return lis;
    }
    private void dfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        lis.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v); 
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, lis, marca);
            }
        }
    }


    
    //BFS busca por niveles
    //O(V+E) V: numero de vertices y E: numero de aristas
    public List<T> bfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lis = new LinkedList<T>(); 
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                bfs(i, grafo, lis, marca);
            }
        }
        return lis;
    }
    private void bfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue();
            lis.add(w.getData());
            List<Edge<T>> adyacentes = grafo.getEdges(w);
            for (Edge<T> e: adyacentes) {
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
                    q.enqueue(e.getTarget());
                }
            }
        }
    }
}
