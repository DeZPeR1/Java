import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Custom implementation of Set for StringBuilder objects.
 * Internal storage is an array with dynamic resizing.
 */
public class StringBuilderSet implements Set<StringBuilder> {

    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    private StringBuilder[] elements;
    private int size;

    /**
     * Default constructor. Creates an empty set.
     */
    public StringBuilderSet() {
        elements = new StringBuilder[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Constructor that initializes the set with one StringBuilder object.
     *
     * @param element initial element
     */
    public StringBuilderSet(StringBuilder element) {
        this();
        add(element);
    }

    /**
     * Constructor that initializes the set from a standard collection.
     *
     * @param collection collection of StringBuilder objects
     */
    public StringBuilderSet(Collection<StringBuilder> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof StringBuilder)) {
            return false;
        }

        String value = o.toString();
        for (int i = 0; i < size; i++) {
            if (elements[i].toString().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<StringBuilder> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public StringBuilder next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        StringBuilder[] array = new StringBuilder[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) java.util.Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        return a;
    }

    @Override
    public boolean add(StringBuilder element) {
        if (element == null || contains(element)) {
            return false;
        }

        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * GROWTH_FACTOR);
            StringBuilder[] newArray = new StringBuilder[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof StringBuilder)) {
            return false;
        }

        String value = o.toString();

        for (int i = 0; i < size; i++) {
            if (elements[i].toString().equals(value)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends StringBuilder> c) {
        boolean modified = false;
        for (StringBuilder element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                remove(elements[i]);
                i--;
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object obj : c) {
            if (remove(obj)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        size = 0;
    }
}
