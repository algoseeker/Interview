import java.util.ArrayList;

public class MinHeap{
	ArrayList<Tuple> queue = new ArrayList<Tuple>();	
	int heapsize = 0;	

	public Tuple extractMin(){
		if(heapsize>1){
			Tuple min = queue.get(0);
			queue.set(0,queue.get(heapsize-1));
			queue.remove(heapsize-1);
			heapsize--;
			minHeapify(0);
			return min;
		} else if(heapsize == 1){
			Tuple min = queue.get(0);
			heapsize--;
			queue.remove(0);
			return min;	
		}
		return null;
	}

	public boolean isEmpty(){
		if(heapsize==0)
			return true;
		return false;
	}
	public void insert(Tuple t){
		queue.add(t);
		heapsize++;
		heapify(heapsize-1);	
	}

	// traverse down the tree
	public void minHeapify(int index){
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int smallest = index;
		if(left<heapsize && queue.get(left).getValue()<queue.get(smallest).getValue()){
			smallest = left;
		} 
		if(right<heapsize && queue.get(right).getValue()<queue.get(smallest).getValue()){
			smallest = right;
		}
		if(smallest!=index){
			Tuple temp = queue.get(index);
			queue.set(index,queue.get(smallest));
			queue.set(smallest,temp);
			minHeapify(smallest);
		}
	}
	

	// traverse up the tree
	public void heapify(int index){
		if(index == 0)
			return;
		int parent = (index-1)/2;
		if(queue.get(parent).getValue()>queue.get(index).getValue()){
			// exchange parent and child
			Tuple temp = queue.get(parent);
			queue.set(parent,queue.get(index));
			queue.set(index,temp);
			heapify(parent);
		}
	} 
}
