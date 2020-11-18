import java.util.*;
import edu.duke.*;

/**
 * Use EarthQuakeParser class and various Filter classes to read in earthquake data
 * from an external source and perform various filtering tasks
 * @author: Kristen Phan (https://github.com/kristenphan)
 * @version: Nov 18, 2020
 */
public class EarthQuakeClient {
    
    /**
     * Read data from a data source and return an ArrayList of <QuakeEntry> quakeData
     */
    public ArrayList<QuakeEntry> readData(String source) {
        // Read in earthquake data
        EarthQuakeParser parser = new EarthQuakeParser(); 
        ArrayList<QuakeEntry> quakeData  = parser.read(source);         
        System.out.println("Read data for "+ quakeData.size() + " quakes");
        return quakeData;
    }
    
    /**
     * Return an ArrayList of QuakeEntry's containing all QuakeEntry's from @param quakeData
     * which satisfy @param Filter f condition
     */
    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        }
        return answer;
    } 

    /**
     * Apply multiple filters to quakeData by calling MatchAllFilters class 
     * and print the result
     */
    public void applyFilters() {
        // Read data
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> quakeData = readData(source);
        // Create and add filters to MatchAllFilter
        MatchAllFilters maf = new MatchAllFilters();
        double minMag = 0.0;
        double maxMag = 5.0;
        MagRangeFilter magRangeFilter = new MagRangeFilter(minMag, maxMag);
        maf.addFilter(magRangeFilter);
        //double minDepth = -180000;
        //double maxDepth = -30000;
        //DepthRangeFilter depthRangeFilter = new DepthRangeFilter(minDepth, maxDepth);
        //maf.addFilter(depthRangeFilter);
        double maxDist = 3000000;
        Location loc = new Location(55.7308, 9.1153);
        MaxDistFilter maxDistFilter = new MaxDistFilter(maxDist, loc);
        maf.addFilter(maxDistFilter);
        String phrase = "e";
        String where = "any";
        PhraseFilter phraseFilter = new PhraseFilter(where, phrase);
        maf.addFilter(phraseFilter);
        // Apply all filters to quakeData and print the result
        int count = 0;
        for (QuakeEntry qe: quakeData) {
            if (maf.satisfies(qe)) {
                System.out.println(qe);
                count++;
            }
        }
        System.out.printf("Found %d quakes that satisfy the criteria.\n", count);
        System.out.println("Filters used: " + maf.getName());
    }
    
    /**
     * Call dumpCSV() method to create a CSV file
     */
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    /**
     * Write into a CSV file from an ArrayList
     */
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
