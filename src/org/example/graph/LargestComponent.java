package org.example.graph;

import java.util.*;

import static java.util.List.of;

public class LargestComponent {
    public static void main(String[] args) {
        LargestComponent largestComponent = new LargestComponent();

        largestComponent.findLargestComponent(buildGraph());
    }

    private static Map<String, List<String>> buildGraph() {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("0", of("8", "1", "5"));
        graph.put("1", of("0"));
        graph.put("5", of("0", "8"));
        graph.put("8", of("0", "5"));
        graph.put("2", of("3", "4"));
        graph.put("3", of("2", "4"));
        graph.put("4", of("3", "2"));

        return graph;
    }

    private void findLargestComponent(Map<String, List<String>> graph) {
        List<String> visitorList = new ArrayList<>();

        int largestComponentSize = 0;

        for (String key : graph.keySet()) {
            int currentComponentSize = componentCount(graph, key, visitorList);

            if(currentComponentSize > largestComponentSize){
                largestComponentSize = currentComponentSize;
            }
        }

        System.out.println("Largest Component: " + largestComponentSize);
    }

    private int componentCount(Map<String, List<String>> graph, String current, List<String> visitorList) {
        Queue<String> queue = new LinkedList<>();

        queue.add(current);

        int visitorCount = 0;

        while (!queue.isEmpty()) {
            current = queue.poll();

            visitorList.add(current);

            List<String> neighbors = graph.get(current);

            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visitorList.contains(neighbor)) {
                        visitorCount++;

                        queue.add(neighbor);
                    }
                }
            }
        }

        return visitorCount;
    }
}
