package gt.edu.url;

public class URLArrayList<T> implements SimpleList<T>
{

    private T[] arrayList;

    //Size of the URLArrayList
    private int size;

    public URLArrayList(int init){
        super();
        this.arrayList = (T[])new Object[init];
    }

    //Min capacaity of 10
    public URLArrayList(){
        this(10);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //Method to return a value by its index
    public T get(int i){
        RangeCheck(i);
        return arrayList[i];
    }

    //Method to set an element to a new value and return the old one
    public T set(int i, T t){
        RangeCheck(i);
        T oldT = arrayList[i];
        arrayList[i] = t;
        return oldT;
    }

    //Adds a new element to arrayList
    public void add(int i, T t){
        if(i > size || i < 0){
            throw new IndexOutOfBoundsException();
        }

        ensureCapacity(size + 1);
        System.arraycopy(arrayList, i, arrayList, i + 1, size - i);
        arrayList[i] = t;
        size++;
    }

    //Method to remove an element and return it by its index
    public T remove(int i){
        RangeCheck(i);

        T oldValue = arrayList[i];

        int numMoved = size - i -1;
        if(numMoved > 0){
            System.arraycopy(arrayList, i + 1, arrayList, i, numMoved);
        }

        arrayList[--size] = null;

        return oldValue;
    }

    //Method to check if index provided is valid
    private void RangeCheck(int i){
        if(i >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    //Method to ensure capacaity is enough for new elements
    private void ensureCapacity(int minCapacity){
        int oldCapacity = arrayList.length;

        if(minCapacity > oldCapacity){
            Object oldArrayList[] = arrayList;
            int newCapacity = (oldCapacity * 3)/2 + 1;

            if(newCapacity < minCapacity){
                newCapacity = minCapacity;
            }

            arrayList = (T[])new Object[newCapacity];
            System.arraycopy(oldArrayList, 0, arrayList, 0, size);
        }
    }
}
