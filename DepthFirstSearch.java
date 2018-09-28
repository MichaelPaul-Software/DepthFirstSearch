package DepthFirstSearch;

import java.util.List;
import java.util.Stack;

public class DFS {
	
	
	private Stack<Vertex> stack;
	
	public DFS() {
		
		this.stack = new Stack();
	}
	
	
	
	public void dfs(List<Vertex> vertexList) {
		
		for(Vertex v : vertexList) {
			
			if (!v.isVisited()) {
				v.setVisited(true);
			
				dfsRecursive(v);
			}
			
		}
	}

	
	private void dfsRecursive(Vertex v) {
		
		System.out.print(v + " ");
		
		for(Vertex vertex : v.getNeighborList()) {
			
			if (!vertex.isVisited()) {
				
				//OS uses a stack
				vertex.setVisited(true);
				dfsRecursive(vertex);
				
			}
		}
		
	}
	
	
	
	
	
	private void dfsWithStack(Vertex rootVertex) {
		
		//LIFO
		this.stack.add(rootVertex);
		rootVertex.setVisited(true);
		
		while( !stack.isEmpty()) {
			
			Vertex actualVertex = this.stack.pop();
			System.out.print(actualVertex + " ");
			
			for(Vertex v: actualVertex.getNeighborList()) {
				
				if(!v.isVisited()) {
					v.setVisited(true);
					this.stack.push(v);
				}
			}
		}
		
	}

}

-----------------------------------------------------------------------------

package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	
	private String name;
	private boolean visited;
	private List<Vertex> neighborList;
	
	public Vertex(String name) {
		this.name = name;
		this.neighborList = new ArrayList<>();
	}
	
	public void addNeighbor(Vertex vertex) {
		this.neighborList.add(vertex);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeighborList() {
		return neighborList;
	}

	public void setNeighborList(List<Vertex> neighborList) {
		this.neighborList = neighborList;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}

---------------------------------------------------------------------------

package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
	
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		
		List<Vertex> list = new ArrayList<>();
		
		
		v1.addNeighbor(v2);
		v1.addNeighbor(v3);
		v3.addNeighbor(v4);
		v4.addNeighbor(v5);
		
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		
		
		
		DFS dfs = new DFS();
		
		dfs.dfs(list);
		
	}

}
