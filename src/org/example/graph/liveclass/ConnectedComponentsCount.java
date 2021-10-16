package org.example.graph.liveclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.List.of;

public class ConnectedComponentsCount {
    public static void main(String[] args) {
        ConnectedComponentsCount connectedComponentsCount = new ConnectedComponentsCount();

        connectedComponentsCount.findConnectedComponents(buildGraph(of(of(0, 1), of(1, 2), of(3, 4))));
        connectedComponentsCount.findConnectedComponents(buildGraph(of(of(0, 1), of(1, 2), of(2, 3), of(3, 4), of(4, 5))));
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

    private void findConnectedComponents(Map<Integer, List<Integer>> graph) {
        int connectedComponentsCount = 0;

        List<Integer> visitorList = new ArrayList<>();

        for (Integer node : graph.keySet()) {
            if (dfs(graph, node, visitorList)) {
                connectedComponentsCount++;
            }
        }

        System.out.println("Connected Components: " + connectedComponentsCount);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int currentNode, List<Integer> visitorList) {
        if (visitorList.contains(currentNode)) {
            return false;
        }

        visitorList.add(currentNode);

        List<Integer> neighbors = graph.get(currentNode);

        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                dfs(graph, neighbor, visitorList);
            }
        }

        return true;
    }
}
