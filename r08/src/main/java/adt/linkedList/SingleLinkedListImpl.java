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
		int size = 0;
    if (!this.isEmpty()) {
      SingleLinkedListNode<T> aux = this.head;
      size++;
      while (!aux.getNext().isNIL()) {
        size++;
        aux = aux.getNext();
      }
    }
    return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> resp;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
