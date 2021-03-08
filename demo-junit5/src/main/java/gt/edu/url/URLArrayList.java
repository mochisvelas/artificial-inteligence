package gt.edu.url;

import java.util.ArrayList;
import java.util.List;

public class URLArrayList<T>
{
     List<T> arrayList;

    public URLArrayList(){
        arrayList = new ArrayList<>();
    }

    public int size(){
        return arrayList.size();
    }

    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    public T get(int i){
        return arrayList.get(i);
    }

    public T set(int i, T t){
        return arrayList.set(i, t);
    }

    public void add(int i, T t){
        arrayList.add(i, t);
    }

    public void remove(int i){
        arrayList.remove(i);
    }
}
