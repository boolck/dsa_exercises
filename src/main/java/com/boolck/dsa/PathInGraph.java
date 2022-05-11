package com.boolck.dsa;

/*
        Please design the data structures for a very large social network
        like Tictok, Facebook, etc?
        Please design an algorithm to show the path or link-chain between two people
        (e.g., You –> Jim –> Lily –> David –> Me).
*/

import java.util.*;

public class PathInGraph {

    static class Graph {
        private final Map<String, Set<String>> adjacencyList = new HashMap<>();

        public void addEdge(String node1, String node2) {
            adjacencyList.putIfAbsent(node1, new LinkedHashSet<>());
            adjacencyList.get(node1).add(node2);

            adjacencyList.putIfAbsent(node2, new LinkedHashSet<>());
            adjacencyList.get(node2).add(node1);
        }

        public List<String> getNeighbors(String node) {
            adjacencyList.putIfAbsent(node, new LinkedHashSet<>());
            return new LinkedList<>(adjacencyList.get(node));
        }
    }

     static class Path {

        private final String start, end;
        private final List<List<String>> allPaths;

        public Path(String start, String end) {
            this.start = start;
            this.end = end;
            allPaths = new LinkedList<>();
        }

        public void add(List<String> validPath) {
            allPaths.add(validPath);
        }

        public List<List<String>> getAllPaths() {
            return allPaths;
        }

        public List<String> getMinimumPath(){
            return allPaths.stream().min(Comparator.comparing(List::size)).orElseGet(LinkedList::new);
        }
    }


    private String node1, node2;
    private Path result;

    public Path getPaths(Graph graph, String node1, String node2) {
        this.node1 = node1;
        this.node2 = node2;
        this.result = new Path(node1, node2);
        LinkedList<String> visited = new LinkedList<>();
        visited.add(this.node1);
        dfs(graph,visited);
        return result;
    }

    private void dfs(Graph graph, LinkedList<String> visited) {

        List<String> nodes = graph.getNeighbors(visited.getLast());

        for (String node : nodes) {
            if (node2.equals(node) && !visited.contains(node)) {
                visited.add(node);
                this.result.add(new LinkedList<>(visited));
                visited.removeLast();
                break;
            }
        }

        for (String node : nodes) {
            if (!visited.contains(node) && !node.equals(node2)) {
                visited.addLast(node);
                dfs(graph, visited);
                visited.removeLast();
            }
        }
    }

}
