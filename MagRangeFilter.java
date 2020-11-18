
/**
 * Implement the Filter interface to filter earthquake data based on a magnitude range, inclusive
 * @assignment desc: https://www.coursera.org/learn/java-programming-design-principles/supplement/3RkuE/programming-exercise-searching-earthquake-data
 * @author: Kristen Phan (https://github.com/kristenphan)
 * @verion: Nov 18, 2020
 */
public class MagRangeFilter implements Filter {
    private double minMag; 
    private double maxMag; 
    
    public MagRangeFilter(double min, double max) { 
        minMag = min;
        maxMag = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return (qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag); 
    } 
    
    public String getName() {
        return "MagRange";
    }
}
