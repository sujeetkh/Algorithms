package algorithms.queue;

import java.util.LinkedList;
import java.util.Deque;
import java.util.HashSet;

public class LRUCache {
	Deque<Integer> deque;
	HashSet<Integer> set;
	int size;
	int pageFaults;

	LRUCache(int size) {
		this.size = size;
		deque = new LinkedList<Integer>();
		set = new HashSet<Integer>();
		pageFaults = 0;
	}

	public void refer(int value) {

		if (set.contains(value)) {
			deque.remove(value);
			deque.addFirst(value);
		} else {
			if (deque.size() < size) {
				deque.addFirst(value);
				set.add(value);
				pageFaults++;
			} else {
				set.remove(deque.removeLast());
				set.add(value);
				deque.addFirst(value);
				pageFaults++;
			}
		}
	}

	public void printCurrentCache() {
		for (Integer value : deque)
			System.out.println(value);
	}

	public void printPageFaults() {
		System.out.println("Total Page Faults: " + pageFaults);
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.refer(1);
		cache.refer(1);
		cache.refer(2);
		cache.refer(1);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(1);
		cache.refer(5);
		cache.printCurrentCache();
		cache.printPageFaults();
	}
}
