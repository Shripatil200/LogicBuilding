package org.example.algorithms;

import java.util.Collection;
import java.util.NoSuchElementException;

public class CustomLinkedList<E>  {
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;



    private static class Node<E>{

        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.prev = prev;
            this.next = next;
        }

    }



    public CustomLinkedList(){
    }

    public CustomLinkedList(Collection<? extends E> c){
        this();
        addAll(c);
    }





    void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;

        if(l == null)
            first = newNode;
        else
            l.next = newNode;

        size++;
    }



    E unlink(Node<E> x){
        E element = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;

        if(prev == null)
            first = next;
        else{
            prev.next = next;
            x.prev = null;
        }

        if(next == null)
            last = prev;
        else{
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size --;
        return element;
    }

    E unlinkFirst(Node<E> f){
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if(next == null)
            last = null;
        else
            next.prev = null;

        size--;
        return element;
    }

    E unlinkLast(Node<E> l){
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;

        if(prev == null){
            first = null;
        }
        else{
            prev.next = null;
        }
        size--;
        return element;
    }



    public E getFirst(){
        Node<E> f = first;
        if(f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public E getLast(){
        Node<E> l = last;
        if(l == null)
            throw new NoSuchElementException();
        return l.item;
    }


    public E removeFirst(){
        final Node<E> f = first;
        if(f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    public E removeLast(){
        final Node<E> l = last;
        if(l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }



    public boolean add(E element){
        linkLast(element);
        return true;
    }


    public boolean remove(Object o){
        if(o == null){
            for(Node<E> x = first; x != null; x = x.next){
                if(x.item == null){
                    unlink(x);
                    return true;
                }
            }
        }else{
            for(Node<E> x = first; x != null; x = x.next){
                if(o.equals(x.item)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean addAll(Collection<? extends E> c){ return addAll(size, c);}

    public boolean addAll(int index, Collection<? extends E> c){
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;

        if(numNew == 0)
            return false;

        Node<E> pred, suss;

        if(index == size){
            suss = null;
            pred = last;
        }else{
            suss = node(index);
            pred = suss.prev;
        }

        for(Object o : a){
            E e = (E) o;
            Node<E> newNode = new Node<>(pred, e , null);
            if(pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;

        }

        if(suss == null){
            last = pred;
        }else{
            pred.next = suss;
            suss.prev = pred;
        }

        size += numNew;
        return true;
    }


    private void checkPositionIndex(int index){
        if(!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isPositionIndex(int index){
        return index >= 0 && index <= size;
    }

    Node<E> node(int index){
        if(index < (size >> 1)){
            Node<E> x = first;
            for(int i = 0; i < index; i++){
                x = x.next;
            }
            return x;
        }else{
            Node<E> x = last;
            for(int i = size -1; i > index; i--){
                x = x.prev;
            }
            return x;
        }
    }





    public boolean add(int index, E e){

        checkPositionIndex(index);

        if(index == size){
            linkLast(e);
        }else{
            linkBefore(e, node(index));
        }

        return true;
    }

    void linkBefore(E e, Node<E> suss){
        final Node<E> pred = suss.prev;
        final Node<E> newNode = new Node<>(pred, e, suss);
        suss.prev = newNode;

        if(pred == null){
            first = newNode;
        }else{
            pred.next = newNode;
        }
        size++;
    }







    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (Node<E> e = first; e != null; e = e.next) {
            str.append(e.item);
            str.append(e.next == null ? "]" : ", ");
        }
       return str.toString();
    }




    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }



}
