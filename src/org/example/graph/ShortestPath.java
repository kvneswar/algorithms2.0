package org.example.graph;

import java.util.*;

import static java.util.List.of;

public class ShortestPath {
    public static void main(String[] args) {
        ShortestPath shortestPath = new ShortestPath();

        shortestPath.findShortestPath(buildGraph(), "w", "z");
    }

    private static Map<String, List<String>> buildGraph() {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("w", of("x", "v"));
        graph.put("x", of("y"));
        graph.put("y", of("z"));
        graph.put("v", of("z"));

        return graph;
    }

    /**
     * will use DFS
     * Take the root and find the path
     */
    private void findShortestPath(Map<String, List<String>> graph, String source, String destination) {
        System.out.println(bfs(graph, new ArrayList<>(), source, destination));
    }

    /*private int dfs(Map<String, List<String>> graph, List<String> visitorList,
                    String current, String destination, List<Integer> stepsList) {
        if (current.equals(destination) || visitorList.contains(current)) {
            return 0;
        }

        int totalSteps = 1;

        visitorList.add(current);

        List<String> neighbors = graph.get(current);

        if (neighbors != null) {
            for (String neighbor : neighbors) {
                int steps = dfs(graph, visitorList, neighbor, destination, stepsList);

                if (steps == 0) {
                    stepsList.add(totalSteps);
                } else {
                    totalSteps += steps;
                }
            }
        }

        return totalSteps;
    }*/

    private int bfs(Map<String, List<String>> graph, List<String> visitorList,
                    String current, String destination) {
        Queue<Node> queue = new LinkedList<>();

        Node node = new Node(current, 0);

        node.getNeighbors().add(current);

        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.getNodeId().equals(destination)) {
                System.out.println("Found Destination, edgeCount: " + currentNode.getEdgeCount() + ", nodes: " +
                        String.join(", ", currentNode.getNeighbors()));
            }

            visitorList.add(currentNode.getNodeId());

            List<String> neighbors = graph.get(currentNode.getNodeId());

            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visitorList.contains(neighbor)
                            || neighbor.equals(destination)) {
                        Node visitorNode = new Node(neighbor, currentNode.getEdgeCount() + 1);

                        visitorNode.getNeighbors().addAll(currentNode.getNeighbors());
                        visitorNode.getNeighbors().add(neighbor);

                        queue.add(visitorNode);
                    }
                }
            }
        }

        return 0;
    }

    static class Node {
        private final int edgeCount;

        private final String nodeId;

        private final List<String> neighbors;

        public Node(String nodeId, int edgeCount) {
            this.nodeId = nodeId;
            this.edgeCount = edgeCount;

            this.neighbors = new ArrayList<>();
        }

        public int getEdgeCount() {
            return edgeCount;
        }

        public String getNodeId() {
            return nodeId;
        }

        public List<String> getNeighbors() {
            return neighbors;
        }
    }
}
