
/**
 * Find N-closest quakes
 * @assignment desc: https://www.coursera.org/learn/java-programming-design-principles/supplement/3RkuE/programming-exercise-searching-earthquake-data
 * @author: Kristen Phan (https://github.com/kristenphan)
 */

import java.util.*;

public class ClosestQuakes {
    /**
    * Return an ArrayList of N-cloest earthquakes (@param howMany) to a location (@param current)
    * The earthquakes should be in the ArrayList in order with the closest earthquake in index position 0.  
    * If there are fewer then howMany earthquakes in quakeData, 
    * then the ArrayList returned would be the same size as quakeData. 
    */
   public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany){
       // Create a copy of quakeData to avoid modifying the param and a new ArrayList to store the result
       ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
       ArrayList<QuakeEntry> result = new ArrayList<QuakeEntry>();
       // Iterate through quakeData and filter out N-cloest quakes from the current location
       for(int j=0; j < howMany; j++) {
            int minIndex = 0;
            for(int k=1; k < copy.size(); k++){
                QuakeEntry quake = copy.get(k);
                Location loc = quake.getLocation();
                if (loc.distanceTo(current) < 
                    copy.get(minIndex).getLocation().distanceTo(current)){
                    minIndex = k;   
                }
            }
          
            result.add(copy.get(minIndex));
            copy.remove(minIndex);
       }
       return result;
   }
    
   /**
    * Call getCloest() method to find N-closet earthquakes to a specific location
    */
   public void findClosestQuakes(){
       // Read in quakeData
       EarthQuakeParser parser = new EarthQuakeParser();
       //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
       String source = "data/nov20quakedatasmall.atom";
       ArrayList<QuakeEntry> quakeData  = parser.read(source);
       System.out.println("read data for " + quakeData.size());
       // Set a location 
       Location jakarta  = new Location(-6.211, 106.845);
       // Find N-earthquakes closest to the location
       int howMany = 3;
       ArrayList<QuakeEntry> close = getClosest(quakeData, jakarta, howMany);
       for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000, entry);
       }
       System.out.println("number found: " + close.size());
   }
}
