package com.aron.algorithms.graph.ShortestPath;

/**
 * Created by jack on 2016/10/30.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
	private int maxN;        // maximum number of elements on PQ
	private int n;           // number of elements on PQ
	private int[] pq;        // binary heap using 1-based indexing
	private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
	private Key[] keys;      // keys[i] = priority of i

	/**
	 * Initializes an empty indexed priority queue with indices between {@code 0}
	 * and {@code maxN - 1}.
	 * @param  maxN the keys on this priority queue are index from {@code 0}
	 *         {@code maxN - 1}
	 * @throws IllegalArgumentException if {@code maxN < 0}
	 */
	public IndexMinPQ(int maxN) {
		if (maxN < 0) throw new IllegalArgumentException();
		this.maxN = maxN;
		n = 0;
		keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
		pq   = new int[maxN + 1];
		qp   = new int[maxN + 1];                   // make this of length maxN??
		for (int i = 0; i <= maxN; i++)
			qp[i] = -1;
	}

	/**
	 * Returns true if this priority queue is empty.
	 *
	 * @return {@code true} if this priority queue is empty;
	 *         {@code false} otherwise
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Is {@code i} an index on this priority queue?
	 *
	 * @param  i an index
	 * @return {@code true} if {@code i} is an index on this priority queue;
	 *         {@code false} otherwise
	 * @throws IndexOutOfBoundsException unless {@code 0 <= i < maxN}
	 */
	public boolean contains(int i) {
		if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
		return qp[i] != -1;
	}

	/**
	 * Returns the number of keys on this priority queue.
	 *
	 * @return the number of keys on this priority queue
	 */
	public int size() {
		return n;
	}

	/**
	 * Associates key with index {@code i}.
	 *
	 * @param  i an index
	 * @param  key the key to associate with index {@code i}
	 * @throws IndexOutOfBoundsException unless {@code 0 <= i < maxN}
	 * @throws IllegalArgumentException if there already is an item associated
	 *         with index {@code i}
	 */
	public void insert(int i, Key key) {
		if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
		if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
		n++;
		qp[i] = n;
		pq[n] = i;
		keys[i] = key;
		swim(n);
	}

	/**
	 * Removes a minimum key and returns its associated index.
	 * @return an index associated with a minimum key
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	public int delMin() throws NoSuchElementException {
		if (n == 0) throw new NoSuchElementException("Priority queue underflow");
		int min = pq[1];
		exch(1, n--);
		sink(1);
		assert min == pq[n+1];
		qp[min] = -1;        // delete
		keys[min] = null;    // to help with garbage collection
		pq[n+1] = -1;        // not needed
		return min;
	}


	/**
	 * Change the key associated with index {@code i} to the specified value.
	 *
	 * @param  i the index of the key to change
	 * @param  key change the key associated with index {@code i} to this key
	 * @throws IndexOutOfBoundsException unless {@code 0 <= i < maxN}
	 * @throws NoSuchElementException no key is associated with index {@code i}
	 */
	public void changeKey(int i, Key key) throws NoSuchElementException {
		if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
		if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
		keys[i] = key;
		swim(qp[i]);
		sink(qp[i]);
	}

	/**
	 * Change the key associated with index {@code i} to the specified value.
	 *
	 * @param  i the index of the key to change
	 * @param  key change the key associated with index {@code i} to this key
	 * @throws IndexOutOfBoundsException unless {@code 0 <= i < maxN}
	 * @deprecated Replaced by {@code changeKey(int, Key)}.
	 */
	@Deprecated
	public void change(int i, Key key) throws NoSuchElementException {
		changeKey(i, key);
	}

	/***************************************************************************
	 * General helper functions.
	 ***************************************************************************/
	private boolean greater(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}

	private void exch(int i, int j) {
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}


	/***************************************************************************
	 * Heap helper functions.
	 ***************************************************************************/
	private void swim(int k) {
		while (k > 1 && greater(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}

	private void sink(int k) {
		while (2*k <= n) {
			int j = 2*k;
			if (j < n && greater(j, j+1)) j++;
			if (!greater(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
}
