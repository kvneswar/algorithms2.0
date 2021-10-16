package org.example.graph.liveclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.List.of;

/**
 * Graph should have only one connected component
 * No cycles
 *  - How to detect a cycle?
 *
 *  Time Complexity is O(m + n) for DFS & BFS, is it correct?
*/
public class IsValidGraphTree {
    public static void main(String[] args) {
        IsValidGraphTree isValidGraphTree = new IsValidGraphTree();

        isValidGraphTree.isValidGraphTree(buildGraph(of(of(0, 1), of(0, 2), of(0, 3), of(1, 4))));
        isValidGraphTree.isValidGraphTree(buildGraph(of(of(0, 1), of(1, 2), of(2, 3), of(1, 3), of(1, 4))));
    }

    private static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> edge : edges) {
            if (!graph.containsKey(edge.get(0))) {
                graph.put(edge.get(0), new ArrayList<>());
            }

            if (!graph.containsKey(edge.get(1))) {
                graph.put(edge.get(1), new ArrayList<>());
            }

            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        return graph;
    }

    private void isValidGraphTree(Map<Integer, List<Integer>> graph) {
        List<Integer> visitorList = new ArrayList<>();

        int connectedComponentsCount = 0;

        for (Integer node : graph.keySet()) {
            if (dfs(graph, node, visitorList)) {
                connectedComponentsCount++;

                if (connectedComponentsCount > 1) {
                    break;
                }
            }
        }

        System.out.println("IsValidGraph: " + !(connectedComponentsCount > 1));
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int current, List<Integer> visitorList) {
        if (visitorList.contains(current)) {
            return false;
        }

        visitorList.add(current);

        List<Integer> neighbors = graph.get(current);

        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                dfs(graph, neighbor, visitorList);
            }
        }

        return true;
    }


}
