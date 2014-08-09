package LRUcache;

public interface MyCache
{
    public void addElement(Object key, Object value);
    public Object getElement(Object key);
    public boolean isExist(Object key);
    public int size();
    public int capacity();
    public void clear();
}