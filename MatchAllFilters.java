/**
 * Implement the Filter interface to filter earthquake data by multiple filters
 * @assignment desc: https://www.coursera.org/learn/java-programming-design-principles/supplement/yzFlm/programming-exercise-filtering-data
 * @author: Kristen Phan (https://github.com/kristenphan)
 * @version: Nov 18, 2020
 */

import java.util.*;

public class MatchAllFilters implements Filter {
    // Create an ArrayList of all filters of interest
    private ArrayList<Filter> filters;
    
    /**
     * Construct a new 
     */
    public MatchAllFilters() {
        filters = new ArrayList<Filter>();
    }
    
    /*
     * Add a new filter to filters
     */
    public void addFilter(Filter f) {
        filters.add(f);
    }
    
    /**
     * Return true if the QuakeEntry satisfies all the filter conditions.
     * Otherwise, return false
     */
    public boolean satisfies(QuakeEntry qe) {
        for (Filter f: filters) {
            if (!f.satisfies(qe)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Return a String representing the names of all filters used
     */
    public String getName() {
        StringBuilder names = new StringBuilder();
        for (Filter f: filters) {
            names.append(f.getName() + "\t");
        }
        return names.toString();
    }
}
