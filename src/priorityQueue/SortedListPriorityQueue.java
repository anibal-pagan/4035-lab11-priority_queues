package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

import priorityQueueInterfaces.Entry;

/**
 * Implementation of a PriorityQueue based in an ArrayList<Entry<K, V>>.
 * @author pedroirivera-vega
 *
 * @param <K>
 * @param <V>
 */
public class SortedListPriorityQueue<K, V> extends AbstractListPriorityQueue<K, V> {
	public SortedListPriorityQueue(Comparator<K> cmp) { 
		super(cmp);
	}
	
	public SortedListPriorityQueue() { 
		super(); 
	}
	

	@Override
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
		super.validate(key); 
		Entry<K,V> newest = new PQEntry<K,V>(key, value);
		int curr = list.size()-1; 
		if(list.isEmpty()){
			list.add(0, newest);
			return newest;
		}
		while (curr >= 0  && compare(list.get(curr), newest) > 0)
			curr--;
		if(curr==-1) list.add(0, newest);
		else list.add(curr+1, newest); 
		return newest; 
	}

	@Override
	protected int minEntryIndex() {
		return 0;
	}

}
