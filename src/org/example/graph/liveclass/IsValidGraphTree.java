package org.example.graph.liveclass;

import java.util.*;

import static java.util.List.of;

/**
 * Graph should have only one connected component
 * No cycles
 * - How to detect a cycle?
 * <p>
 * Time Complexity is O(m + n) for DFS & BFS, is it correct?
 */
public class IsValidGraphTree {
    public static void main(String[] args) {
        IsValidGraphTree isValidGraphTree = new IsValidGraphTree();

        //System.out.println("IsValidGraph: " + isValidGraphTree.isValidGraphTree(of(of(0, 1), of(0, 2), of(1, 2))));
        System.out.println("IsValidGraph: " + isValidGraphTree.isValidGraphTree(of(of(0, 1), of(0, 2), of(0, 3), of(1, 4))));
        //System.out.println("IsValidGraph: " + isValidGraphTree.isValidGraphTree(of(of(0, 1), of(1, 2), of(2, 3), of(1, 3), of(1, 4))));
    }

    private Map<Integer, List<Integer>> buildGraph(List<List<Integer>> edges) {
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

    private boolean isValidGraphTree(List<List<Integer>> edges) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        List<Integer> visitorList = new ArrayList<>();

        int connectedComponentsCount = 0;

        Map<Integer, Integer> parentMap = new HashMap<>();

        for (Integer node : graph.keySet()) {
            if (!visitorList.contains(node)) {
                connectedComponentsCount++;

                if (connectedComponentsCount > 1) {
                    break;
                }

                if (dfs(graph, node, visitorList, parentMap)) {
                    return false;
                }
            }
        }

        return connectedComponentsCount == 1;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int current,
                        List<Integer> visitorList, Map<Integer, Integer> parentMap) {
        Stack<Integer> stack = new Stack<>();

        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();

            List<Integer> neighbors = graph.get(current);

            if (neighbors != null) {
                for (Integer neighbor : neighbors) {
                    if (!visitorList.contains(neighbor)) {
                        stack.push(neighbor);

                        visitorList.add(neighbor);

                        parentMap.put(neighbor, current);
                    } else if(!parentMap.get(current).equals(neighbor)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
