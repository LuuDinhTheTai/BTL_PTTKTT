package com.utc.q19;

import edu.princeton.cs.algs4.DirectedEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ReverseEdgeWeightedDigraph {
    
    private final int v; // số đỉnh
    private int e; // số cạnh
    private final List<DirectedEdge>[] adj; // danh sách kề của đỉnh
    private final int[] outDegree;

    // tạo một đồ thị có hướng thô
    public ReverseEdgeWeightedDigraph(int v) {
        this.v = v;
        this.e = 0;
        this.outDegree = new int[v];
        adj = new List[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // tạo một đồ thị có hướng từ một đồ thị có sẵn
    public ReverseEdgeWeightedDigraph(ReverseEdgeWeightedDigraph graph) {
        this(graph.getV());
        this.e = graph.e;
        for (int i = 0; i < graph.v; i++) {
            this.outDegree[i] = graph.getOutDegree(v);
        }
        for (int i = 0; i < graph.v; i++) {
            Stack<DirectedEdge> reverse = new Stack<>();
            reverse.addAll(graph.adj[v]);
            for (var e : reverse) {
                adj[v].add(e);
            }
        }
    }

    public ReverseEdgeWeightedDigraph(Scanner scanner) {
        this(scanner.nextInt());
        int e = scanner.nextInt();

        for (int i = 0; i < e; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            double w = scanner.nextDouble();
            validateVertex(from);
            validateVertex(to);
            addEdge(new DirectedEdge(to, from, w));
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= this.v)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (v - 1));
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public int getOutDegree(int v) {
        validateVertex(v);
        return outDegree[v];
    }

    public void addEdge(DirectedEdge edge) {
        int from = edge.from();
        int to = edge.to();
        validateVertex(from);
        validateVertex(to);
        adj[to].add(edge); // thêm vào danh sách của đỉnh nguồn
        outDegree[from]++; //tăng thêm một bậc cho đỉnh nguồn
        this.e++; // tăng thêm 1 cạnh
    }

    // lấy danh sách cạnh từ một đỉnh
    public List<DirectedEdge> adj(int to) {
        validateVertex(to);
        return adj[to];
    }

    // lấy số lượng cạnh đi ra từ một đỉnh
    public int inDegree(int from) {
        validateVertex(from);
        return adj[from].size();
    }

    public List<DirectedEdge> edges() {
        List<DirectedEdge> list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.addAll(adj(i));
        }

        return list;
    }
}
