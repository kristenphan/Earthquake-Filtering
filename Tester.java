
/**
 * Test applyFilters() from EarthQuakeClient class
 * @assignment desc: https://www.coursera.org/learn/java-programming-design-principles/supplement/yzFlm/programming-exercise-filtering-data
 * @author: Kristen Phan
 * @version: Nov 18, 2020
 */
public class Tester {
    /**
     * Test applyFilters() from EarthQuakeClient class
     */
    public void testApplyFilters() {
        EarthQuakeClient eqc = new EarthQuakeClient();
        eqc.applyFilters();
    }
    
    public static void main(String[] args) {
        Tester t = new Tester();
        t.testApplyFilters();
    }
}
