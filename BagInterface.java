package Assignments.Com410.A3.A3CH;

public interface BagInterface {
    
    public int getCurrentSize();
    
    public boolean isEmpty();
    
    public boolean add(String newEntry);
    
    public boolean remove();
    
    public boolean remove(String anEntry);
    
    public void clear();
    
    public int getFrequencyOf(String anEntry);
    
    public boolean contains(String anEntry);
    
    public String[] toArray();
    
}
