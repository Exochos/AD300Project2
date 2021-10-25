import java.util.Iterator;
import java.util.Arrays;

public class SortedArrayList<E extends Comparable<E>> implements SortedArrayListInterface<E> {
    ArrayList<E> arrayList;

    /**
     * Constructor
     */
    public SortedArrayList() {
        arrayList = new ArrayList<>();
    }
    
    /**
     * Constructor
     */
    public SortedArrayList(int intitialCapacity) {
        arrayList = new ArrayList<>(intitialCapacity);
    }

    /**
     * Size of the parent arraylist
     * @return size of the parent arraylist
     */
    @Override
    public int size() {
        return arrayList.size();
    }

    /**
     * Is the Array List empty?
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return arrayList.size() == 0;
    }

    /**
     * clear the list
     */
    @Override
    public void clear() {
        arrayList.clear();
    }

    /**
     * Checks if the list contains the specified element
     * @param element  the element to be checked
     * @return true if the list contains the element, false otherwise
     * @throws IllegalArgumentException if the element is null
     */
    @Override
    public boolean contains(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot search for null value");
        }
        else {
            return indexOf(value) != -1;
        }
    }

    /**
     * Finds the index of the specified element
     * @param element  the element to be found
     * @throws IllegalArgumentException if the element is null
     * @return the index of the element, or the index where it would go if it were to be inserted
     **/
    @Override
    public int indexOf(E value) {
        // if null, throw exception
        if (value == null) {
            throw new IllegalArgumentException("Cannot search for null value");
        }
        // if the list is empty, return Integer.MIN_VALUE
        if (arrayList.size() == 0) {
            return Integer.MIN_VALUE;
        }

        // initialize variables
        int min = 0;
        int max = arrayList.size() - 1;

        while (min <= max) {
            int mid = (max + min) / 2;
            int compare = arrayList.get(mid).compareTo(value);
            if (compare == 0) {
                // if the element is found, check to make sure it is not the element before
                if (((mid-1) >= 0) && (arrayList.get(mid-1).compareTo(value) == 0)) {
                    max--;
                }
                else {
                    return mid;
                }
            } 
            else if (compare < 0) {
                min = mid + 1;
            } 
            else {
                max = mid - 1;
            }
        }

        // if the element is not found, return the index where it would go if it were to be inserted
        if (min > arrayList.size() -1) {
            return Integer.MAX_VALUE;
        }
        else {
            return -min;
        }
    }

    /**
     * Returs the element at the specified index
     * @param index  the index of the element to be returned
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @return the element at the specified index
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Please enter a valid index!");
        }
        return arrayList.get(index);
    }

    /**
     * Inserts the specified element at the specified index
     * @param value  the element to be inserted
     */
    @Override
    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot add null value!");
        }
        int index = indexOf(value);
        if (index == Integer.MAX_VALUE) {
            arrayList.add(value);
        }
        else if (index == Integer.MIN_VALUE) {
            arrayList.add(0, value);
        }
        else {
            arrayList.add(Math.abs(index), value);
        }
    }

    /**
     * Removes the element at the specified index
     * @param index  the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of bounds or if the list is empty
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Invalid input");
        }
        else {
            arrayList.remove(index);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return arrayList.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
            if (i != arrayList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public E[] get(E value, E[] template) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] template) {
        String[] s = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            s[i] = arrayList.get(i).toString();
        }
        return (E[]) s;
    }
}
