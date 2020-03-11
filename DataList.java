package epam.List;

import java.util.Arrays;

public class DataList<E> 
{
    private int z = 0;
    private static final int CAPACITY = 10; 
    private Object elements[];
    public DataList() {
        elements = new Object[CAPACITY];
    } 
    public void add(E s) {
        if (z == elements.length) {
            ensureCap();
        }
        elements[z++] = s;
    }
    @SuppressWarnings("unchecked")
    public E get(int k) {
        if (k >= z || k < 0) {
            throw new IndexOutOfBoundsException("Index: " + k + ", Size " + k);
        }
        return (E) elements[k];
    }
    @SuppressWarnings("unchecked")
    public E remove(int k) {
        if (k >= z || k < 0) {
            throw new IndexOutOfBoundsException("Index: " + k + ", Size " + k);
        }
        Object item = elements[k];
        int numElts = elements.length - ( k + 1 ) ;
        System.arraycopy( elements, k + 1, elements, k, numElts ) ;
        z--;
        return (E) item;
    }
    public int z() {
        return z;
    }
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < z ;i++) {
             sb.append(elements[i].toString());
             if(i<z-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
    private void ensureCap() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}


