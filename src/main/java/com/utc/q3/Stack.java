package com.utc.q3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
  private Node<Item> first;     // top of stack
  private int n;                // size of the stack
  
  // helper linked list class
  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }
  
  /**
   * Initializes an empty stack.
   */
  public Stack() {
    first = null;
    n = 0;
  }
  
  /**
   * Returns true if this stack is empty.
   *
   * @return true if this stack is empty; false otherwise
   */
  public boolean isEmpty() {
    return first == null;
  }
  
  /**
   * Returns the number of items in this stack.
   *
   * @return the number of items in this stack
   */
  public int size() {
    return n;
  }
  
  /**
   * Adds the item to this stack.
   *
   * @param item the item to add
   */
  public void push(Item item) {
    Node<Item> oldfirst = first;
    first = new Node<Item>();
    first.item = item;
    first.next = oldfirst;
    n++;
  }
  
  /**
   * Removes and returns the item most recently added to this stack.
   *
   * @return the item most recently added
   * @throws NoSuchElementException if this stack is empty
   */
  public Item pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = first.item;        // save item to return
    first = first.next;            // delete first node
    n--;
    return item;                   // return the saved item
  }
  
  
  /**
   * Returns (but does not remove) the item most recently added to this stack.
   *
   * @return the item most recently added to this stack
   * @throws NoSuchElementException if this stack is empty
   */
  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return first.item;
  }
  
  /**
   * Returns a string representation of this stack.
   *
   * @return the sequence of items in this stack in LIFO order, separated by spaces
   */
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Item item : this) {
      s.append(item);
      s.append(' ');
    }
    return s.toString();
  }
  
  
  /**
   * Returns an iterator to this stack that iterates through the items in LIFO order.
   *
   * @return an iterator to this stack that iterates through the items in LIFO order
   */
  public Iterator<Item> iterator() {
    return new LinkedIterator(first);
  }
  
  // the iterator
  private class LinkedIterator implements Iterator<Item> {
    private Node<Item> current;
    
    public LinkedIterator(Node<Item> first) {
      current = first;
    }
    
    // is there a next item?
    public boolean hasNext() {
      return current != null;
    }
    
    // returns the next item
    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
  
  
  /**
   * Unit tests the {@code Stack} data type.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream(new File("tobe.txt")));
    Stack<String> stack = new Stack<String>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-"))
        stack.push(item);
      else if (!stack.isEmpty())
        StdOut.print(stack.pop() + " ");
    }
    StdOut.println("(" + stack.size() + " left on stack)");
  }
}
