
/**
 * Implement the Filter interface to filter earthquake data based on a depth range, inclusive
 * @assignment desc: https://www.coursera.org/learn/java-programming-design-principles/supplement/3RkuE/programming-exercise-searching-earthquake-data
 * @author: Kristen Phan (https://github.com/kristenphan)
 * @verion: Nov 18, 2020
 */
public class DepthRangeFilter implements Filter
{
    private double minDepth; 
    private double maxDepth;
    
    public DepthRangeFilter(double min, double max) { 
        minDepth = min;
        maxDepth = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return (qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth); 
    } 
    
    public String getName() {
        return "DepthRange";
    }
}
