package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
    if (!this.isEmpty()) {
      DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
      if (this.size() == 1) {
        this.head = newNode;
      } else {
		    this.last.getPrevious().setNext(newNode);
        newNode.setPrevious(this.last.getPrevious());
      }
      this.last = newNode;
    }
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
