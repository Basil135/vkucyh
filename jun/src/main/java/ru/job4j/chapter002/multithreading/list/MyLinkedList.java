package ru.job4j.chapter002.multithreading.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class describes simple linked list.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 21.02.2018
 *
 * @param <E> is generic type
 */
@ThreadSafe
public class MyLinkedList<E> implements MyList<E> {
    /**
     * parameter size of the collection.
     */
    @GuardedBy("this")
    private int size = 0;
    /**
     * parameter pointer to the first element of the collection.
     */
    private Entity<E> first;
    /**
     * parameter pointer to the last element of the collection.
     */
    private Entity<E> last;

    /**
     * method find the entity by index.
     *
     * @param index is index of the collection element
     * @return entity
     */
    private synchronized Entity<E> getStep(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Entity<E> result = null;
        Entity<E> current = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                result = current;
                break;
            } else {
                current = current.next;
            }
        }
        return result;
    }

    /**
     * method add element e to the collection.
     *
     * @param e is input element
     * @return true if e successfully added to the collection
     */
    @Override
    public synchronized boolean add(E e) {
        if (first == null) {
            Entity<E> toAdd = new Entity<>(e);
            first = toAdd;
            last = toAdd;
            size++;
        } else {
            Entity<E> old = last;
            Entity<E> toAdd = new Entity<>(e);
            last = toAdd;
            last.setPrev(old);
            old.setNext(toAdd);
            size++;
        }
        return true;
    }

    /**
     * method add element e to the collection by index.
     *
     * @param index is integer number describes position at the collection
     * @param e is input element
     * @return true if element successfully added to the collection
     */
    @Override
    public synchronized boolean add(int index, E e) {
        Entity<E> newEntity = new Entity<>(e);
        if (index == 0) {
            Entity<E> old = first;
            first = newEntity;
            newEntity.setNext(old);
            old.setPrev(newEntity);
        } else if (index == size - 1) {
            Entity<E> old = last;
            last = newEntity;
            newEntity.setPrev(old);
            old.setNext(newEntity);
        } else {
            Entity<E> old = getStep(index);
            old.getPrev().setNext(newEntity);
            newEntity.setPrev(old.getPrev());
            newEntity.setNext(old);
            old.setPrev(newEntity);
        }
        size++;
        return true;
    }

    /**
     * method delete element e from the collection.
     *
     * @param e is input element we need to delete
     * @return true if element e successfully deleted
     */
    @Override
    public synchronized boolean delete(E e) {
        Entity<E> current = first;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(e)) {
                return delete(i);
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * method delete element from the collection by the index.
     *
     * @param index is input index we need to delete
     * @return true if element successfully deleted
     */
    @Override
    public synchronized boolean delete(int index) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            Entity<E> toDel = first;
            first = toDel.getNext();
            if (first != null) {
                first.setPrev(null);
            }
        } else if (index == size - 1) {
            Entity<E> toDel = last;
            last = toDel.getPrev();
            if (last != null) {
                last.setNext(null);
            }
        } else {
            Entity<E> toDel = getStep(index);
            toDel.getPrev().setNext(toDel.getNext());
            toDel.getNext().setPrev(toDel.getPrev());
        }
        size--;
        return true;
    }

    /**
     * method get element from collection by the index.
     *
     * @param index is input index
     * @return return element of the collection by the index
     */
    @Override
    public E get(int index) {
        return getStep(index).value;
    }

    /**
     * method return size of the collection.
     *
     * @return integer number as size of the collection.
     */
    @Override
    public synchronized int size() {
        return size;
    }

    /**
     * method return collection as array.
     *
     * @return array
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = getStep(i).value;
        }
        return result;
    }

    /**
     * method return the iterator of the collection.
     *
     * @return iterator of the collection
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    /**
     * this inner non static class describes iterator class.
     *
     * @param <E> is generic type
     */
    private class MyIterator<E> implements Iterator<E> {
        /**
         * parameter index is index of the iterator.
         */
        @GuardedBy("this")
        private int index = 0;

        /**
         * method return true if iterator have next element.
         *
         * @return true if iterator have next element
         */
        @Override
        public synchronized boolean hasNext() {
            return index < size();
        }

        /**
         * method return next element of the collection by iterator.
         *
         * @return element of yhe collection
         */
        @Override
        public synchronized E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) getStep(index++).value;
        }
    }

    /**
     * This inner non static class describes Simple entity of the collection element.
     *
     * @param <E> is generic type.
     */
    private class Entity<E> {
        /**
         * parameter value is value of the element of collection.
         */
        private E value;
        /**
         * parameter pointer to the previous element of the collection.
         */
        private Entity prev;
        /**
         * parameter pointer to the next element of the collection.
         */
        private Entity next;

        /**
         * constructor of this inner class.
         *
         * @param value is value of this entity
         */
        Entity(E value) {
            this.value = value;
        }

        /**
         * method retorn parameter next.
         *
         * @return next parameter
         */
        public Entity getNext() {
            return next;
        }

        /**
         * method return prev parameter.
         *
         * @return prev parameter
         */
        public Entity getPrev() {
            return prev;
        }

        /**
         * method return value of this entity.
         *
         * @return value of this entity
         */
        public E getValue() {
            return value;
        }

        /**
         * method set next parameter.
         *
         * @param next is next parameter
         */
        public void setNext(Entity next) {
            this.next = next;
        }

        /**
         * method set prev parameter.
         *
         * @param prev is prev parameter
         */
        public void setPrev(Entity prev) {
            this.prev = prev;
        }
    }
}
