
/**
 * Implement the Filter interface to filter earthquake data based on max distance from a location, exclusive
 * @assignment desc: https://www.coursera.org/learn/java-programming-design-principles/supplement/3RkuE/programming-exercise-searching-earthquake-data
 * @author: Kristen Phan (https://github.com/kristenphan)
 * @verion: Nov 18, 2020
 */
public class MaxDistFilter implements Filter
{
    private double distMax; 
    private Location loc;
    
    public MaxDistFilter(double max, Location l) { 
        distMax = max;
        loc = l; 
    } 

    public boolean satisfies(QuakeEntry qe) { 
        //System.out.println("dist = " + qe.getLocation().distanceTo(loc) + "\t" + 
        //                   "location = " + qe.getLocation());
        return qe.getLocation().distanceTo(loc) < distMax; 
    } 

    public String getName() {
        return "MaxDist";
    }
}