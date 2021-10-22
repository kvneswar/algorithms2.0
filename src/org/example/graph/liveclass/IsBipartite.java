package org.example.graph.liveclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsBipartite {
    public static void main(String[] args) {
        IsBipartite isBipartite = new IsBipartite();

    }

    private static Map<Integer, List<Integer>> buildTree(List<List<Integer>> nodeList) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> node : nodeList) {
            graph.computeIfAbsent(node.get(0), k -> new ArrayList<>());
            graph.computeIfAbsent(node.get(1), k -> new ArrayList<>());

            graph.get(node.get(0)).add(node.get(1));
            graph.get(node.get(1)).add(node.get(0));
        }

        return graph;
    }
}
