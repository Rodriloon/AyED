package P1E08;

public class DoubleEndedQueue<T> extends Queue<T> {
	
	public void enqueueFirst (T data) {
		Queue<T> temp=new Queue<T>();
		while(!super.isEmpty())
			temp.enqueue(super.dequeue());
		super.enqueue(data);
		while(!temp.isEmpty())
			super.enqueue(temp.dequeue());
	}
	
}
