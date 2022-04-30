package com.boolck.programs;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathInGraphTest {

    private static PathInGraph.Graph graph ;

    @BeforeClass
    public static void initGraph() {
        graph = new PathInGraph.Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "F");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("D", "Z");
        graph.addEdge("E", "F");
    }

    @Test
    public void testPathFound(){
        PathInGraph.Path result = new PathInGraph().getPaths(graph,"A","F");
        List<List<String>> allPathsAsList = result.getAllPaths();
        Assert.assertEquals(3,allPathsAsList.size());
    }

    @Test
    public void testMinimumPathFound(){
        PathInGraph.Path result = new PathInGraph().getPaths(graph,"A","F");
        List<String> minPath = result.getMinimumPath();
        Assert.assertEquals(new LinkedList<String>(Arrays.asList("A","B","F")),minPath);
    }

    @Test
    public void testPathNotFound(){
        PathInGraph.Path result = new PathInGraph().getPaths(graph,"A","D");
        List<List<String>> allPathsAsList = result.getAllPaths();
        Assert.assertTrue(allPathsAsList.isEmpty());
    }



}
