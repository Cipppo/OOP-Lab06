package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int FROM_NUM = 1000;
	private static final int TO_NUM = 2000;
	
	private static final int ELEM = 102_000;
	private static final int TO_MS = 1_000_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	for(int i = FROM_NUM; i < TO_NUM; i++) {
    		list.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	LinkedList<Integer> list2 = new LinkedList<>();
    	list2.addAll(list);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int v = list.get(0);
    	list.remove(0);
    	list.set(0, list.size());
    	list.set(list.size() -1, v);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for(int i : list) {
    		System.out.println(i);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	long time = System.nanoTime();
    	
    	for(int i = TO_NUM ; i <= ELEM ; i++) {
    		list.add(i);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("Per inserire 100k elementi nella lista, ci ha impiegato "
    						+ time/TO_MS + " ms");
    	
    	time = System.nanoTime();
    	for(int i = TO_NUM; i <= ELEM; i++) {
    		list2.add(i);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("Per inserire 100k elementi nella lista, ci ha impiegato "
				+ time/TO_MS + " ms");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	time = System.nanoTime();
    	
    	for(int i = 0; i < TO_NUM; i++) {
    		list.get(list.size() / 2);
    	}
    	
    	time = System.nanoTime() - time;

    	System.out.println("Per inserire 100k elementi nella lista, ci ha impiegato "
				+ time/TO_MS + " ms");
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	
    	Map<String, Number> map = new HashMap<>();
    	map.put("Africa", 1_110_635_000);
    	map.put("America", 972_005_000);
    	map.put("Antartica", 0);
    	map.put("Asia", 4_298_723_000L);
    	map.put("Europe", 742_452_000);
    	map.put("Oceania", 38_304_000);
    	
    	long population = 0;
    	
    	for(String i : map.keySet()) {
    		population = population + map.get(i).longValue();
    	}
    	
    	System.out.println("The current world population is: " + population + " people");
    }
}
