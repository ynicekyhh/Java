package tree;

import queue.Queue;

public class PriorityQueue<E> implements Queue<E> {
	private int size;
	private Comparator<E> comparator;
	private E[] arrayHeap;

	public PriorityQueue(int capacity, Comparator<E> comparator) {
		this.size = 0;
		this.comparator = comparator;
		resize(capacity);
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = arrayHeap[i];
		}
		arrayHeap = temp;
	}

	public E poll() {
		if (0 == size) {
			throw new IndexOutOfBoundsException("Index:" + 0 + ", size:" + size);
		}

		E data = arrayHeap[1];
		E lastItem = arrayHeap[size];

		int parentIndex = 1;
		while (true) {
			int leftChildIndex = parentIndex * 2;
			if (leftChildIndex > size) {
				break;
			}

			int childIndex = 0;
			if (leftChildIndex == size) {
				childIndex = leftChildIndex;
			} else {
				int rightChildIndex = parentIndex * 2 + 1;

				int result = comparator.compare(arrayHeap[leftChildIndex], arrayHeap[rightChildIndex]);
				childIndex = (result <= 0) ? leftChildIndex : rightChildIndex;
			}

			int result = comparator.compare(lastItem, arrayHeap[childIndex]);
			if (result <= 0) {
				break;
			}

			arrayHeap[parentIndex] = arrayHeap[childIndex];
			parentIndex = childIndex;
		}

		arrayHeap[parentIndex] = lastItem;
		arrayHeap[size--] = null;
		return data;
	}

	@Override
	public void offer(E item) {
		if (arrayHeap.length <= size) {
			resize(arrayHeap.length * 2);
		}

		int index = size + 1;
		while (index != 1) {
			int parentIndex = index / 2;

			int result = comparator.compare(arrayHeap[parentIndex], item);
			if (result <= 0) {
				break;
			}

			arrayHeap[index] = arrayHeap[parentIndex];
			index = parentIndex;
		}

		arrayHeap[index] = item;
		size++;
	}

	public E peek() {
		return arrayHeap[1];
	}
}
