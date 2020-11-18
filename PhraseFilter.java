/**
 * Implement the Filter interface and filter earthquakes based on their names
 * @assignment desc: https://www.coursera.org/learn/java-programming-design-principles/supplement/3RkuE/programming-exercise-searching-earthquake-data
 * @author: Kristen Phan (https://github.com/kristenphan)
 * @verion: Nov 18, 2020
 */
public class PhraseFilter implements Filter {
    private String where; 
    private String phrase;
    
    public PhraseFilter(String w, String p) { 
        where = w;
        phrase = p;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        if (where.equals("start")) {
            return qe.getInfo().indexOf(phrase) == 0;
        }
        else if (where.equals("end")) {
            return qe.getInfo().lastIndexOf(phrase) == (qe.getInfo().length() - phrase.length());
        }
        else { // where = "any"
            return qe.getInfo().indexOf(phrase) != -1;
        }
    } 
    
    public String getName() {
        return "Phrase";
    }

}