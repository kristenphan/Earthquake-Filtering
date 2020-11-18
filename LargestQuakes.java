
/**
 * Find N-largest quakes by magnitude from data source
 * 
 * @assignment desc: https://www.coursera.org/learn/java-programming-design-principles/supplement/3RkuE/programming-exercise-searching-earthquake-data
 * @author: Kristen Phan (https://github.com/kristenphan)
 * @verion: 18/11/2020 
 */

import java.util.*;

public class LargestQuakes {
    /**
     * Return an integer representing the index location in @param data 
     * of the earthquake with the largest magnitude
     */
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        // Iterate through data to the find the largest quake by magnitude and its index
        double maxMag = 0;
        int maxIdx = -1;
        for (int i = 0; i < data.size(); i++) {
            QuakeEntry currQuake = data.get(i);
            double currMag = currQuake.getMagnitude();
            if (currMag > maxMag) {
                maxMag = currMag;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    /**
     * Call indexOfLargest() to find and return an ArrayList of N-lagest (@param howMany)
     * earthquakes from @param quakeData
     * If quakeData has fewer than @param howMany earthquakes, the number of earthquakes returned
     * in the ArrayList is equal to the number of earthquakes in quakeData
     */
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        // Make a copy of quakeData to avoid modifying quakeData
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        // Create an ArrayList to store the result
        ArrayList<QuakeEntry> result = new ArrayList<QuakeEntry>();
        // Iterate through quakeData to find N-largest quakes by magnitude
        for (int k = 0; k < howMany; k++) {
            if (copy.size() > 0) {
                int maxIdx = indexOfLargest(copy);
                result.add(copy.get(maxIdx));
                copy.remove(maxIdx);
            }
            else {
                break;
            }
        }
        return result;
    }
    
    /**
     * Call getLargest() to print N-largest earthquakes by magnitude
     */
    public void findLargestQuakes() {
        // Read in quakeData
       EarthQuakeParser parser = new EarthQuakeParser();
       //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
       String source = "data/nov20quakedata.atom";
       ArrayList<QuakeEntry> quakeData  = parser.read(source);
       System.out.println("read data for " + quakeData.size());
       // Dermine the number of earthquakes to look up
       int howMany = 50;
       // Find @param howMany largest earthquakes by magnitude and print the result
       ArrayList<QuakeEntry> largestQuakes = getLargest(quakeData, howMany);
       for (QuakeEntry qe: largestQuakes) { 
            System.out.println(qe);
        }
    }
}
