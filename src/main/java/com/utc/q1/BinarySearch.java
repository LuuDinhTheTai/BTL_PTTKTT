package com.utc.q1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * The {@code BinarySearch} class provides a static method for binary
 * searching for an integer in a sorted array of integers.
 * <p>
 * The <em>indexOf</em> operations takes logarithmic time in the worst case.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class BinarySearch {
  
  /**
   * This class should not be instantiated.
   */
  private BinarySearch() {
  }
  
  /**
   * Returns the index of the specified key in the specified array.
   *
   * @param a   the array of integers, must be sorted in ascending order
   * @param key the search key
   * @return index of key in array {@code a} if present; {@code -1} otherwise
   */
  public static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }
  
  /**
   * Returns the index of the specified key in the specified array.
   * This function is poorly named because it does not give the <em>rank</em>
   * if the array has duplicate keys or if the key is not in the array.
   *
   * @param key the search key
   * @param a   the array of integers, must be sorted in ascending order
   * @return index of key in array {@code a} if present; {@code -1} otherwise
   * @deprecated Replaced by {@link #indexOf(int[], int)}.
   */
  @Deprecated
  public static int rank(int key, int[] a) {
    return indexOf(a, key);
  }
  
  /**
   * Reads in a sequence of integers from the allowlist file, specified as
   * a command-line argument; reads in integers from standard input;
   * prints to standard output those integers that do <em>not</em> appear in the file.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) throws IOException {
    
//    System.setIn(new FileInputStream(new File("largeT.txt")));
    System.setIn(new FileInputStream(new File("tinyT.txt")));
    //System.setOut(new PrintStream("blacklist.txt"));
    // read the integers from a file
    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();
    // sort the array
    Arrays.sort(whitelist);
    
    
    // read integer key from standard input; print if not in whitelist
    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (BinarySearch.indexOf(whitelist, key) == -1)
        StdOut.println(key);
    }
  }
}