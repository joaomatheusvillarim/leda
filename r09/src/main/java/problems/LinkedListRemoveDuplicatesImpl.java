package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
        if (!node.isNIL()) {
            SingleLinkedListNode<T> outer = node;
            while (outer != null) {
                SingleLinkedListNode<T> inner = outer;
                while(inner != null) {
                    if (node.equals(inner.getNext())) {
                        this.remover(inner);
                    }
                    inner = inner.getNext();
                }
                outer = outer.getNext();
            }
        }
    }

    public void remover(SingleLinkedListNode<T> predecessor) {
        predecessor.setNext(predecessor.getNext().getNext());
    }

}

