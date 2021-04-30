package java_assignments.asgn5;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Asgn5 {
    public static void main (String args[]) {
        String filename = new String("java_assignments/asgn5/delilah.txt");
        File f = new File(filename);    // opening the file for reading
        if (f.exists()) {   // checking if the file exists
            try {
                Scanner s = new Scanner(f); // scanner to read from the file
                int lineno = 0;
                HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>(); // hashmap to store line no.s
                while (s.hasNext()) {   // while file reading is not finished
                    ++lineno;
                    String line = s.nextLine(); // read next line
                    StringTokenizer st = new StringTokenizer(line, " ");    // separate words separated by space
                    while (st.hasMoreTokens()) {    // going through every words
                        String word = st.nextToken();
                        if (hm.containsKey(word)) { // if word is already inserted in hashmap
                            ArrayList<Integer> temp = hm.get(word);
                            temp.add(lineno);   // append the line no.
                        } else {
                            ArrayList<Integer> list = new ArrayList<Integer>(); 
                            list.add(lineno);   
                            hm.put(word, list); // insert the word in hashmap
                        }
                    }
                }
                // sort the hashmap in alphabetic order of key
                TreeMap<String, ArrayList<Integer>> tm = new TreeMap<String, ArrayList<Integer>>();
                tm.putAll(hm);  // storing all <key, value> pairs of the hashmap in a treemap

                Set<Entry<String, ArrayList<Integer>>> est = tm.entrySet();
                for (Entry<String, ArrayList<Integer>> m : est) {
                    System.out.println(m.getKey() + ": " + m.getValue());   // printing the words
                }

            } catch (IOException e) {   // if any exception arises
                System.out.println(e.getMessage()); // show the error message
            }
        }
    }
}
