package com.utc.q34;

import edu.princeton.cs.algs4.*;

import java.util.NoSuchElementException;

public class EdgeWeightedDigraph {
  private static final String NEWLINE = System.getProperty("line.separator");
  
  private final int V;                // number of vertices in this digraph
  private int E;                      // number of edges in this digraph
  private Bag<DirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v
  private int[] indegree;             // indegree[v] = indegree of vertex v
  
  /**
   * Initializes an empty edge-weighted digraph with {@code V} vertices and 0 edges.
   *
   * @param V the number of vertices
   * @throws IllegalArgumentException if {@code V < 0}
   */
  public EdgeWeightedDigraph(int V) {
    if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
    this.V = V;
    this.E = 0;
    this.indegree = new int[V];
    adj = (Bag<DirectedEdge>[]) new Bag[V];
    for (int v = 0; v < V; v++)
      adj[v] = new Bag<DirectedEdge>();
  }
  
  /**
   * Initializes a random edge-weighted digraph with {@code V} vertices and <em>E</em> edges.
   *
   * @param V the number of vertices
   * @param E the number of edges
   * @throws IllegalArgumentException if {@code V < 0}
   * @throws IllegalArgumentException if {@code E < 0}
   */
  public EdgeWeightedDigraph(int V, int E) {
    this(V);
    if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be non-negative");
    for (int i = 0; i < E; i++) {
      int v = StdRandom.uniformInt(V);
      int w = StdRandom.uniformInt(V);
      double weight = 0.01 * StdRandom.uniformInt(100);
      DirectedEdge e = new DirectedEdge(v, w, weight);
      addEdge(e);
    }
  }
  
  /**
   * Initializes an edge-weighted digraph from the specified input stream.
   * The format is the number of vertices <em>V</em>,
   * followed by the number of edges <em>E</em>,
   * followed by <em>E</em> pairs of vertices and edge weights,
   * with each entry separated by whitespace.
   *
   * @param in the input stream
   * @throws IllegalArgumentException if {@code in} is {@code null}
   * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
   * @throws IllegalArgumentException if the number of vertices or edges is negative
   */
  public EdgeWeightedDigraph(In in) {
    if (in == null) throw new IllegalArgumentException("argument is null");
    try {
      this.V = in.readInt();
      if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be non-negative");
      indegree = new int[V];
      adj = (Bag<DirectedEdge>[]) new Bag[V];
      for (int v = 0; v < V; v++) {
        adj[v] = new Bag<DirectedEdge>();
      }
      
      int E = in.readInt();
      if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");
      for (int i = 0; i < E; i++) {
        int v = in.readInt();
        int w = in.readInt();
        validateVertex(v);
        validateVertex(w);
        double weight = in.readDouble();
        addEdge(new DirectedEdge(v, w, weight));
      }
    } catch (NoSuchElementException e) {
      throw new IllegalArgumentException("invalid input format in EdgeWeightedDigraph constructor", e);
    }
  }
  
  /**
   * Initializes a new edge-weighted digraph that is a deep copy of {@code G}.
   *
   * @param G the edge-weighted digraph to copy
   */
  public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
    this(G.V());
    this.E = G.E();
    for (int v = 0; v < G.V(); v++)
      this.indegree[v] = G.indegree(v);
    for (int v = 0; v < G.V(); v++) {
      // reverse so that adjacency list is in same order as original
      Stack<DirectedEdge> reverse = new Stack<DirectedEdge>();
      for (DirectedEdge e : G.adj[v]) {
        reverse.push(e);
      }
      for (DirectedEdge e : reverse) {
        adj[v].add(e);
      }
    }
  }
  
  /**
   * Returns the number of vertices in this edge-weighted digraph.
   *
   * @return the number of vertices in this edge-weighted digraph
   */
  public int V() {
    return V;
  }
  
  /**
   * Returns the number of edges in this edge-weighted digraph.
   *
   * @return the number of edges in this edge-weighted digraph
   */
  public int E() {
    return E;
  }
  
  // throw an IllegalArgumentException unless {@code 0 <= v < V}
  private void validateVertex(int v) {
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
  }
  
  /**
   * Adds the directed edge {@code e} to this edge-weighted digraph.
   *
   * @param e the edge
   * @throws IllegalArgumentException unless endpoints of edge are between {@code 0}
   *                                  and {@code V-1}
   */
  public void addEdge(DirectedEdge e) {
    int v = e.from();
    int w = e.to();
    validateVertex(v);
    validateVertex(w);
    adj[v].add(e);
    indegree[w]++;
    E++;
  }
  
  
  /**
   * Returns the directed edges incident from vertex {@code v}.
   *
   * @param v the vertex
   * @return the directed edges incident from vertex {@code v} as an Iterable
   * @throws IllegalArgumentException unless {@code 0 <= v < V}
   */
  public Iterable<DirectedEdge> adj(int v) {
    validateVertex(v);
    return adj[v];
  }
  
  /**
   * Returns the number of directed edges incident from vertex {@code v}.
   * This is known as the <em>outdegree</em> of vertex {@code v}.
   *
   * @param v the vertex
   * @return the outdegree of vertex {@code v}
   * @throws IllegalArgumentException unless {@code 0 <= v < V}
   */
  public int outdegree(int v) {
    validateVertex(v);
    return adj[v].size();
  }
  
  /**
   * Returns the number of directed edges incident to vertex {@code v}.
   * This is known as the <em>indegree</em> of vertex {@code v}.
   *
   * @param v the vertex
   * @return the indegree of vertex {@code v}
   * @throws IllegalArgumentException unless {@code 0 <= v < V}
   */
  public int indegree(int v) {
    validateVertex(v);
    return indegree[v];
  }
  
  /**
   * Returns all directed edges in this edge-weighted digraph.
   * To iterate over the edges in this edge-weighted digraph, use foreach notation:
   * {@code for (DirectedEdge e : G.edges())}.
   *
   * @return all edges in this edge-weighted digraph, as an iterable
   */
  public Iterable<DirectedEdge> edges() {
    Bag<DirectedEdge> list = new Bag<DirectedEdge>();
    for (int v = 0; v < V; v++) {
      for (DirectedEdge e : adj(v)) {
        list.add(e);
      }
    }
    return list;
  }
  
  /**
   * Returns a string representation of this edge-weighted digraph.
   *
   * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
   * followed by the <em>V</em> adjacency lists of edges
   */
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(V + " " + E + NEWLINE);
    for (int v = 0; v < V; v++) {
      s.append(v + ": ");
      for (DirectedEdge e : adj[v]) {
        s.append(e + "  ");
      }
      s.append(NEWLINE);
    }
    return s.toString();
  }
  
  /**
   * Returns a string representation of this edge-weighted digraph in DOT format,
   * suitable for visualization with Graphviz.
   * <p>
   * To visualize the graph, install Graphviz (e.g., "brew install graphviz").
   * Then use one of the graph visualization tools
   * - dot    (hierarchical or layer drawing)
   * - neato  (spring model)
   * - fdp    (force-directed placement)
   * - sfdp   (scalable force-directed placement)
   * - twopi  (radial layout)
   * <p>
   * For example, the following commands will create graph drawings in SVG
   * and PDF formats
   * - dot input.dot -Tsvg -o output.svg
   * - dot input.dot -Tpdf -o output.pdf
   * <p>
   * To change the digraph attributes (e.g., vertex and edge shapes, arrows, colors)
   * in the DOT format, see https://graphviz.org/doc/info/lang.html
   *
   * @return a string representation of this edge-weighted digraph in DOT format
   */
  public String toDot() {
    StringBuilder s = new StringBuilder();
    s.append("digraph {" + NEWLINE);
    s.append("node[shape=circle, style=filled, fixedsize=true, width=0.3, fontsize=\"10pt\"]" + NEWLINE);
    s.append("edge[arrowhead=normal, fontsize=\"9pt\"]" + NEWLINE);
    for (int v = 0; v < V; v++) {
      for (DirectedEdge e : adj[v]) {
        int w = e.to();
        s.append(v + " -> " + w + " [label=\"" + e.weight() + "\"]" + NEWLINE);
      }
    }
    s.append("}" + NEWLINE);
    return s.toString();
  }
  
  /**
   * Unit tests the {@code EdgeWeightedDigraph} data type.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
    StdOut.println(G);
  }
  
}