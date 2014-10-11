package com.tanghao.algo.study.graphic.basic;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import com.tanghao.algo.study.datastructure.linklist.Bag;

public class Graph implements IGraph {
	/**
	 * Number of vertices in the graph, will be finalized at construction time
	 */
	private final int V;

	/**
	 * Number of edges in the graph, this number may be changed when add adge
	 * method is called
	 */
	private int E;

	/**
	 * list to store all the vertices and edge, each bag in array will maintain
	 * relationships amount a Vertex and all of its adjacent nodes
	 */
	private Bag<Integer>[] adjList;

	/**
	 * create an Graph without any edges
	 * 
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.adjList = (Bag<Integer>[]) new Bag[V];
		for(int i=0; i < V ; i++){
			adjList[i] = new Bag<Integer>();
		}
		this.E = 0;
		this.V = V;
	}
	
	public Graph(Scanner in) throws IOException {	
		this(in.nextInt());
        int E = in.nextInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
	}

	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}

	@Override
	public void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v);
		E++;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("");
		sb.append("\n------- Adjacency-List  --------\n\n");
		for(int i= 0 ; i< V(); i++){
			Iterator<Integer> iterator = adjIterator(i);
			sb.append(String.format("%-2s", i) + " | ");
			while (iterator.hasNext()) {
				int next = iterator.next();
				sb.append(String.format("%-2s", next) + " ");
			}
			sb.append("\n");
		}
		sb.append("\n");
		sb.append("\n------- Transtive Matrix --------\n\n");
		//print output looks like "   | 0  1  2  3  4 .... "
		sb.append(String.format("%-2s", " ") + " | ");
		for(int i= 0 ; i< V(); i++){
			sb.append(String.format("%-2s", i) + " ");
		}
		sb.append("\n");
		//print output looks like "-- | -- -- -- -- -- -- ..... "
		sb.append(String.format("%-2s", "--") + " | ");
		for(int i= 0 ; i< V(); i++){
			sb.append(String.format("%-2s", "--") + " ");
		}
		sb.append("\n");
		//print output looks like "0  | -  C  C        C  C........."; c for connected
		for(int i= 0 ; i< V(); i++){
			sb.append(String.format("%-2s", i) + " | ");
			for(int j=0; j < V(); j++){
				if(i == j){
					sb.append(String.format("%-2s", "-") + " ");
				}else if(adjList[i].contains(j)){
					sb.append(String.format("%-2s", "C") + " ");
				}else{
					sb.append(String.format("%-2s", " ") + " ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public Iterator<Integer> adjIterator(int v) {
		return adjList[v].iterator();
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adjList[v];
	}
}
