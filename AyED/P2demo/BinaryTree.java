package P2demo;
import P1E08.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {
		if (isEmpty()) {
			return 0;
		}
		if (isLeaf()) {
			return 1;
		}
		else {
			int hojas = 0;
			if (hasLeftChild()) {
				hojas += this.getLeftChild().contarHojas();
			}
			if (hasRightChild()) {
				hojas += this.getRightChild().contarHojas();
			}
		return hojas;
		}
	}
    	 
    public BinaryTree<T> espejo(){     		  
    	if (this.isEmpty()) {
    		return null;
    	}
    	else {
            BinaryTree<T> espejin = new BinaryTree<T>(this.data);
            if (this.hasLeftChild()) {
                espejin.addRightChild(this.getLeftChild().espejo());
            }
            if (this.hasRightChild()) {
                espejin.addLeftChild(this.getRightChild().espejo());
            }
            return espejin;
    	}
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		
	}
	
	public void printPreOrden() {
		System.out.println(this.getData());
		if (this.hasLeftChild()) {
			this.getLeftChild().printPreOrden();
		}
		if (this.hasRightChild()) {
			this.getRightChild().printPreOrden();
		}
	}
	
	public void printInOrden() {
		if (this.hasLeftChild()) {
			this.getLeftChild().printInOrden();
		}
		System.out.println(this.getData());
		if (this.hasRightChild()) {
			this.getRightChild().printInOrden();
		}
	}
	
	public void printPostOrden() {
		if (this.hasLeftChild()) {
			this.getLeftChild().printPostOrden();
		}
		if (this.hasRightChild()) {
			this.getRightChild().printPostOrden();
		}
		System.out.println(this.getData());
	}
	
	public void printLevelTraversal() {
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			ab = cola.dequeue();
		    if (ab != null) {
		    	System.out.print(ab.getData());
		    	if (ab.hasLeftChild()) {
		    		cola.enqueue(ab.getLeftChild());
		    	}
		    	if (ab.hasRightChild()) {
		    		cola.enqueue(ab.getRightChild());
		    	}
		    } else if (!cola.isEmpty()) {
		    	System.out.println();
		    	cola.enqueue(null);
		    }
		}
	}
		
}

