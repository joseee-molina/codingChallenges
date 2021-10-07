package chap4;
import edu.princeton.cs.algs4.In;

import java.lang.reflect.Array;
import java.util.*;

public class Graph implements Iterable<Integer> {

    private LinkedList<Edge>[] adjLists;
    private int vertexCount;
    int[] distances;

    /* Initializes a graph with NUMVERTICES vertices and no Edges. */
    public Graph(int numVertices) {
        adjLists = (LinkedList<Edge>[]) new LinkedList[numVertices];
        for (int k = 0; k < numVertices; k++) {
            adjLists[k] = new LinkedList<Edge>();
        }
        vertexCount = numVertices;
    }

    /* Adds a directed Edge (V1, V2) to the graph. That is, adds an edge
       in ONE directions, from v1 to v2. */
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, 0);
    }

    /* Adds an undirected Edge (V1, V2) to the graph. That is, adds an edge
       in BOTH directions, from v1 to v2 and from v2 to v1. */
    public void addUndirectedEdge(int v1, int v2) {
        addUndirectedEdge(v1, v2, 0);
    }

    /* Adds a directed Edge (V1, V2) to the graph with weight WEIGHT. If the
       Edge already exists, replaces the current Edge with a new Edge with
       weight WEIGHT. */
    public void addEdge(int v1, int v2, int weight) {
        // TODO: YOUR CODE HERE
        /**Edge temp = new Edge(v1, v2, weight);
         if (adjLists[v1].contains(temp)) {
         for (int index = 0; index < adjLists[v1].size(); index++) {
         if (adjLists[v1].get(index).to == v2) {
         adjLists[v1].set(index, temp);
         }
         }
         }
         adjLists[v1].add(temp);**/
        LinkedList<Edge> pointer = adjLists[v1];
        for(int i=0;i<pointer.size();i++){
            if (pointer.get(i).to==v2){
                pointer.set(i,new Edge(v1,v2,weight));
                return;
            }
        }
        pointer.add(new Edge(v1,v2,weight));
    }

    /* Adds an undirected Edge (V1, V2) to the graph with weight WEIGHT. If the
       Edge already exists, replaces the current Edge with a new Edge with
       weight WEIGHT. */
    public void addUndirectedEdge(int v1, int v2, int weight) {
        // TODO: YOUR CODE HERE
        /**
         Edge thatWay=  new Edge(v1, v2, weight);
         Edge otherWay =  new Edge(v2, v1, weight);
         if (adjLists[v1].contains(thatWay) && adjLists[v2].contains(otherWay)) {
         addEdge(v1, v2, weight);
         addEdge(v2, v1, weight);
         }
         adjLists[v1].add(thatWay);
         adjLists[v2].add(otherWay);**/
        addEdge(v1, v2, weight);
        addEdge(v2, v1, weight);

    }

    /* Returns true if there exists an Edge from vertex FROM to vertex TO.
       Returns false otherwise. */
    public boolean isAdjacent(int from, int to) {
        // TODO: YOUR CODE HERE
        for (int index = 0; index < adjLists[from].size(); index++) {
            if (adjLists[from].get(index).to == to) {
                return true;
            }
        }
        return false;
    }

    /* Returns a list of all the vertices u such that the Edge (V, u)
       exists in the graph. */
    public List<Integer> neighbors(int v) {
        // TODO: YOUR CODE HERE
        /**
         ArrayList neighbors = new ArrayList();
         for (int index = 0; index < adjLists.length; index++) {
         if (isAdjacent(v, index)) {
         neighbors.add(index);
         }
         }
         return neighbors;**/

        List<Integer> output = new ArrayList<>();
        LinkedList<Edge> pointer = adjLists[v];
        for(int i=0;i<pointer.size();i++){
            output.add(pointer.get(i).to);
        }
        return output;

    }
    /* Returns the number of incoming Edges for vertex V. */
    public int inDegree(int v) {
        // TODO: YOUR CODE HERE
        /**int inDegreeCount = 0;
         for (int index = 0; index < adjLists.length; index++) {
         if(isAdjacent(index, v)) {
         inDegreeCount++;
         }
         }
         return inDegreeCount;**/
        int incomingEdges = 0;
        for(int i=0;i<adjLists.length;i++){
            LinkedList<Edge> pointer = adjLists[i];
            for(int j=0; j<pointer.size();j++){
                if(pointer.get(j).to==v){
                    incomingEdges++;
                }
            }
        }
        return incomingEdges;
    }
    public ArrayList<Integer> shortestPath(int start, int stop) {
        // TODO: YOUR CODE HERE
        int[] previousVertex = new int[adjLists.length];
        HashSet visited = new HashSet();
        ArrayList<Integer> reverseOrder = new ArrayList<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new DistanceTo());
        distances = new int[adjLists.length];

        for (int index = 0; index < distances.length; index++) {
            distances[index] =  Integer.MAX_VALUE;
            previousVertex[index] = -1;
        }
        distances[start] = 0;
        minHeap.add(start);

        while (!minHeap.isEmpty()) {
            int temp = minHeap.poll();
            visited.add(temp);
            if (temp == stop) {
                break;
            }
            for (int neighbor : neighbors(temp)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                int edgeWeight = getEdge(temp, neighbor).weight + distances[temp];
                if (edgeWeight < distances[neighbor]) {
                    distances[neighbor] = edgeWeight;
                    previousVertex[neighbor] = temp;
                }
                minHeap.add(neighbor);
            }
        }
        int currentVertex = stop;
        while (currentVertex != start) {
            reverseOrder.add(currentVertex);
            currentVertex = previousVertex[currentVertex];
        }
        reverseOrder.add(start);
        int starting = 0;
        ArrayList output = new ArrayList();
        for (int index = reverseOrder.size() - 1; index >= 0 ; index--) {
            output.add(reverseOrder.get(index));
        }

        return output;
    }





    private class DistanceTo implements Comparator<Integer> {

        @Override
        public int compare(Integer firstVertex, Integer secondVertex) {
            if (distances[firstVertex] > distances[secondVertex]) {
                return 1;
            }
            return -1;
        }
    }

    public Edge getEdge(int u, int v) {
        // TODO: YOUR CODE HERE
        Edge temp = null;
        for (int index = 0; index < adjLists[u].size(); index++) {
            if (isAdjacent(u, v)) {
                if (adjLists[u].get(index).to == v) {
                    temp = adjLists[u].get(index);
                    return temp;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> allVertices (){
        ArrayList<Integer> vertices = new ArrayList<Integer>();
        for(int i= 0 ; i<adjLists.length;i++){
            LinkedList<Edge> pointer = adjLists[i];
            for(int j=0; j<pointer.size();j++){
                if(!vertices.contains(pointer.get(j).from)){
                    vertices.add(pointer.get(j).from);
                }
                if(!vertices.contains(pointer.get(j).to)){
                    vertices.add(pointer.get(j).to);
                }
            }
        }
        return vertices;
    }

    /* Returns an Iterator that outputs the vertices of the graph in topological
       sorted order. */
    public Iterator<Integer> iterator() {
        return new TopologicalIterator();
    }

    /**
     *  A class that iterates through the vertices of this graph,
     *  starting with a given vertex. Does not necessarily iterate
     *  through all vertices in the graph: if the iteration starts
     *  at a vertex v, and there is no path from v to a vertex w,
     *  then the iteration will not include w.
     */
    private class DFSIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        private HashSet<Integer> visited;

        public DFSIterator(Integer start) {
            fringe = new Stack<>();
            visited = new HashSet<>();
            fringe.push(start);
        }

        public boolean hasNext() {
            if (!fringe.isEmpty()) {
                int i = fringe.pop();
                while (visited.contains(i)) {
                    if (fringe.isEmpty()) {
                        return false;
                    }
                    i = fringe.pop();
                }
                fringe.push(i);
                return true;
            }
            return false;
        }

        public Integer next() {
            int curr = fringe.pop();
            ArrayList<Integer> lst = new ArrayList<>();
            for (int i : neighbors(curr)) {
                lst.add(i);
            }
            lst.sort((Integer i1, Integer i2) -> -(i1 - i2));
            for (Integer e : lst) {
                /**if(!visited.contains(e)){
                 fringe.push(e);
                 }**/
                fringe.push(e);
            }
            visited.add(curr);
            return curr;
        }

        //ignore this method
        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    /* Returns the collected result of performing a depth-first search on this
       graph's vertices starting from V. */
    public List<Integer> dfs(int v) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new DFSIterator(v);
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }



    /* Returns true iff there exists a path from START to STOP. Assumes both
       START and STOP are in this graph. If START == STOP, returns true. */

    public boolean pathExists(int start, int stop) {
        // TODO: YOUR CODE HERE
        /**List<Integer> list = new ArrayList<Integer>();
         list = dfs(start);
         if (list.contains(stop)) {
         return true;
         }
         return false;**/
        // TODO: YOUR CODE HERE
        if(start==stop){
            return true;
        }
        List<Integer> checking = dfs(start);
        if(checking.contains(stop)){
            return true;
        }
        return false;

    }


    /* Returns the path from START to STOP. If no path exists, returns an empty
       List. If START == STOP, returns a List with START. */
    public List<Integer> path(int start, int stop) {
        // TODO: YOUR CODE HERE
        // In case error add check for when to stop loop going backwards
        /**List<Integer> visited = new ArrayList<Integer>();
         ArrayList<Integer> path = new ArrayList<Integer>();
         if (!pathExists(start, stop)) {
         return visited;
         }
         for (int index = 0; index < dfs(start).size(); index++) {
         if (dfs(start).get(index) == stop) {
         visited.add(dfs(start).get(index));
         break;
         }
         visited.add(dfs(start).get(index));
         }

         int stopIndex = visited.get(visited.size() - 1);
         path.add(0, stopIndex);
         for (int index2 = visited.size() - 2; index2  >= 0; index2--) {
         if (isAdjacent(visited.get(index2), stopIndex) ) {
         path.add(0, visited.get(index2));
         stopIndex = visited.get(index2);
         }
         }

         return path;**/
        if(!pathExists(start, stop)){
            return new ArrayList<Integer>();
        }
        if(start==stop){
            ArrayList<Integer> out = new ArrayList<>();
            out.add(start);
            return out;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new DFSIterator(start);

        while (iter.hasNext()) {
            int next = iter.next();
            result.add(next);
            if(next==stop){
                break;
            }
        }

        System.out.println(result);
        ArrayList<Integer> path = new ArrayList<Integer>();
        int finish = result.get(result.size()-1);
        path.add(finish);
        for(int i=result.size()-2;i>=0;i--){
            if(!path.contains(result.get(i)) && isAdjacent(result.get(i),finish)){
                path.add(result.get(i));
                finish=result.get(i);
            }
        }
        for(int i=0;i<path.size()/2;i++){
            int temp = path.get(i);
            path.set(i,path.get(path.size()-i-1));
            path.set(path.size()-i-1,temp);
        }
        return path;
    }

    public List<Integer> topologicalSort() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new TopologicalIterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }

    private class TopologicalIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        private HashSet<Integer> visited;

        // TODO: Instance variables here!
        private int inDegree = 0;
        private int[] inDegreeCurrent;

        TopologicalIterator() {
            fringe = new Stack<Integer>();
            // TODO: YOUR CODE HERE
            visited = new HashSet<>();
            inDegreeCurrent = new int[vertexCount];
            int count = 0;
            for (int index = 0; index < vertexCount; index++) {
                count = inDegree(index);
                if (count == 0) {
                    fringe.push(index);
                }
                inDegreeCurrent[index] = count;
            }
        }

        public boolean hasNext() {
            // TODO: YOUR CODE HERE
            return !fringe.isEmpty();
        }

        public Integer next() {
            // TODO: YOUR CODE HERE
            int popped = fringe.pop();
            List<Integer> neighbors  = neighbors(popped);
            for (int index = 0; index < neighbors.size(); index++) {
                inDegreeCurrent[neighbors.get(index)] -= 1;
                if (inDegreeCurrent[neighbors.get(index)] == 0) {
                    fringe.push(neighbors.get(index));
                }
            }
            return popped;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private class Edge {

        private int from;
        private int to;
        private int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return "(" + from + ", " + to + ", weight = " + weight + ")";
        }

    }

    private void generateG1() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(4, 3);
    }

    private void generateG2() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(4, 3);
    }

    private void generateG3() {
        addUndirectedEdge(0, 2);
        addUndirectedEdge(0, 3);
        addUndirectedEdge(1, 4);
        addUndirectedEdge(1, 5);
        addUndirectedEdge(2, 3);
        addUndirectedEdge(2, 6);
        addUndirectedEdge(4, 5);
    }

    private void generateG4() {
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(4, 2);
    }

    private void printDFS(int start) {
        System.out.println("DFS traversal starting at " + start);
        List<Integer> result = dfs(start);
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
    }

    private void printPath(int start, int end) {
        System.out.println("Path from " + start + " to " + end);
        List<Integer> result = path(start, end);
        if (result.size() == 0) {
            System.out.println("No path from " + start + " to " + end);
            return;
        }
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
    }

    private void printTopologicalSort() {
        System.out.println("Topological sort");
        List<Integer> result = topologicalSort();
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.generateG1();
        g1.printDFS(0);
        g1.printDFS(2);
        g1.printDFS(3);
        g1.printDFS(4);

        g1.printPath(0, 3);
        g1.printPath(0, 4);
        g1.printPath(1, 3);
        g1.printPath(1, 4);
        g1.printPath(4, 0);

        Graph g2 = new Graph(5);
        g2.generateG2();
        g2.printTopologicalSort();
    }


    /**
     *
     * ------- 4-1 CTCI
     */
    public boolean pathExistsa4x1(int from, int to){
        if(from> adjLists.length || to>adjLists.length){
            return false;
        }
        Stack<Integer> fringe = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        fringe.push(from);
        while(!fringe.isEmpty()){
            int curr = fringe.pop();
            if(curr==to){
                return true;
            }
            visited.add(curr);
            for(int i : neighbors(curr)){
                if(!visited.contains(i)){
                    fringe.push(i);
                }
            }
        }
        //System.out.println("There is no path from "+from+" to "+to+", since the only reachable vertices are: "+ visited.toString());
        return false;
    }



}
