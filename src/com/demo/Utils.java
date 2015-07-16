package com.demo;

import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Utils {

    public interface Transformer<E, T> {
        T transform(E object);
    }

    public static <E, T> List<T> transformList(final List<E> list, final Transformer<E, T> transformer) {
        if (list == null) {
            return null;
        }
        // XXX: When we call JacksonMapper.toJson for the list returned,
        // JacksonMapper will try to figure out the bound of "T" by
        // Class<?> of the list.
        // If we create an anonymous inner class as below:
        // return new AbstractList<T>() {
        //    @Override
        //    public T get(int index) {
        //        return transformer.transform(list.get(index));
        //    }
        //
        //    @Override
        //    public int size() {
        //        return list.size();
        //    }
        // };
        // JacksonMapper will fails to get the bound info because "T" is
        // not defined by the anonymous class (JacksonMapper won't fail if
        // run on eclipse, because the eclipse compiler treats anonymous
        // inner class as non-static, and JacksonMapper will handle this
        // special case).
        if (list instanceof RandomAccess) {
            return new RandomAccessList<E, T>(list, transformer);
        } else {
            return new SequentialList<E, T>(list, transformer);
        }
    }

    private static class RandomAccessList<E, T> extends AbstractList<T> {
        private List<E> list;
        private Transformer<E, T> transformer;

        public RandomAccessList(List<E> list, Transformer<E, T> transformer) {
            this.list = list;
            this.transformer = transformer;
        }

        @Override
        public T get(int index) {
            return transformer.transform(list.get(index));
        }

        @Override
        public int size() {
            return list.size();
        }
    }

    private static class SequentialList<E, T> extends AbstractSequentialList<T> {
        private List<E> list;
        private Transformer<E, T> transformer;

        public SequentialList(List<E> list, Transformer<E, T> transformer) {
            this.list = list;
            this.transformer = transformer;
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public ListIterator<T> listIterator(final int index) {

            return new ListIterator<T>() {

                ListIterator<E> listIterator = list.listIterator(index);

                @Override
                public void add(T element) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public boolean hasNext() {
                    return listIterator.hasNext();
                }

                @Override
                public boolean hasPrevious() {
                    return listIterator.hasPrevious();
                }

                @Override
                public T next() {
                    return transformer.transform(listIterator.next());
                }

                @Override
                public int nextIndex() {
                    return listIterator.nextIndex();
                }

                @Override
                public T previous() {
                    return transformer.transform(listIterator.previous());
                }

                @Override
                public int previousIndex() {
                    return listIterator.previousIndex();
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public void set(T element) {
                    throw new UnsupportedOperationException();
                }

            };
        }
    }

}
