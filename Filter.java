
/**
 * Write a description of interface Filter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Filter {
    /**
     * Return true if the QuakeEntry satisfies the filter condition. Otherwise, return false
     */
    public  boolean satisfies(QuakeEntry qe); 
    
    /**
     * Return a the name of a filter
     */
    public String getName();
}
