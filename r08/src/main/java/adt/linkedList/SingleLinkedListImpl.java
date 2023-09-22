package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> node = this.head;
		int size = 0;
		while (!node.isNIL()) {
			++size;
			node = node.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			SingleLinkedListNode<T> node = this.head;
			while (!node.isNIL()) {
				if (element.equals(node.getData())) {
					result = node.getData();
					break;
				}
				node = node.getNext();
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> node = this.head;
			while (!node.isNIL()) {
				node = node.getNext();
			}
			node.setData(element);
			node.setNext(new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			SingleLinkedListNode<T> node = this.head;
			if (node.getData().equals(element)) {
				this.head = node.getNext();
			} else {
				while (!node.isNIL()) {
					SingleLinkedListNode<T> successor = node.getNext();
					if (element.equals(successor.getData())) {
						node.setNext(successor.getNext());
						break;
					}
					node = node.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.size()];
		if (!this.head.isNIL()) {
			SingleLinkedListNode<T> node = this.head;
			int size = this.size();
			for (int i = 0; i < size; i++) {
				array[i] = node.getData();
				node = node.getNext();
			}
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
