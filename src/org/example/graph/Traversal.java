package org.example.graph;

import java.util.*;

import static java.util.List.of;

public class Traversal {
    /**
     * <h1>Topics covered</h1>
     * <ol>
     *     <li>DFS</li>
     *     <li>DFS using Recursion</li>
     *     <li>BFS</li>
     *     <li>has Path</li>
     * </ol>
     */
    public static void main(String[] args) {
        Traversal traversal = new Traversal();

        traversal.dfs(buildCompleteDirectedGraph(), "a");

        System.out.println("\n");

        System.out.print("DFS using recursion: ");

        traversal.dfsUsingRecursion(buildCompleteDirectedGraph(), "a");

        System.out.println("\n");

        traversal.bfs(buildCompleteDirectedGraph(), "a");

        System.out.println("\n");

        System.out.println("hasPath: " + traversal.hasPathUsingRecursion(buildCompleteDirectedGraph(), "a", "f"));
        System.out.println("hasPath: " + traversal.hasPathUsingRecursion(buildBrokenDirectedGraph(), "a", "f"));

        System.out.println("hasPath: " + traversal.hasPathUsingDfs(buildCompleteDirectedGraph(), "a", "f"));
        System.out.println("hasPath: " + traversal.hasPathUsingDfs(buildBrokenDirectedGraph(), "a", "f"));

        System.out.println("hasPath: " + traversal.hasPathUsingBfs(buildCompleteDirectedGraph(), "a", "f"));
        System.out.println("hasPath: " + traversal.hasPathUsingBfs(buildBrokenDirectedGraph(), "a", "f"));

        System.out.println("Directed Graph");

        System.out.println("hasPath: " + traversal.hasPath(buildCompleteUndirectedGraph(), "j", "m", new ArrayList<>()));
        System.out.println("hasPath: " + traversal.hasPath(buildBrokenUndirectedGraph(), "i", "o", new ArrayList<>()));

        System.out.println("hasPath: " + traversal.hasPathUsingDfs(buildCompleteUndirectedGraph(), "j", "m", new ArrayList<>()));
        System.out.println("hasPath: " + traversal.hasPathUsingDfs(buildBrokenUndirectedGraph(), "i", "o", new ArrayList<>()));

        System.out.println("hasPath: " + traversal.hasPathUsingBfs(buildCompleteUndirectedGraph(), "j", "m", new ArrayList<>()));
        System.out.println("hasPath: " + traversal.hasPathUsingBfs(buildBrokenUndirectedGraph(), "i", "o", new ArrayList<>()));

        System.out.println("Connected Components");

        System.out.println("hasComponentsConnected: " + traversal.hasComponentsConnected(buildCompleteUndirectedGraph(), new ArrayList<>()));
        System.out.println("hasComponentsConnected: " + traversal.hasComponentsConnected(buildBrokenUndirectedGraph(), new ArrayList<>()));

    }

    private static Map<String, List<String>> buildCompleteDirectedGraph() {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("a", of("b", "c"));
        graph.put("b", of("d"));
        graph.put("c", of("e"));
        graph.put("d", of("f"));

        return graph;
    }

    private static Map<String, List<String>> buildBrokenDirectedGraph() {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("a", of("b", "c"));
        graph.put("c", of("e"));
        graph.put("d", of("f"));

        return graph;
    }

    private static Map<String, List<String>> buildCompleteUndirectedGraph() {
        List<List<String>> edgeList = of(of("i", "j"), of("k", "i"), of("m", "k"), of("k", "l"), of("o", "n"), of("o", "m"));

        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> strings : edgeList) {
            graph.computeIfAbsent(strings.get(0), k -> new ArrayList<>());
            graph.computeIfAbsent(strings.get(1), k -> new ArrayList<>());

            graph.get(strings.get(0)).add(strings.get(1));
            graph.get(strings.get(1)).add(strings.get(0));
        }

        /*graph.put("i", of("j", "k"));
        graph.put("j", of("i"));
        graph.put("k", of("i", "m", "l"));
        graph.put("m", of("k", "o"));
        graph.put("l", of("k"));
        graph.put("o", of("m", "n"));
        graph.put("n", of("o"));*/

        return graph;
    }

    private static Map<String, List<String>> buildBrokenUndirectedGraph() {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("i", of("j", "k"));
        graph.put("j", of("i"));
        graph.put("k", of("i", "m", "l"));
        graph.put("m", of("k"));
        graph.put("l", of("k"));
        graph.put("o", of("n"));
        graph.put("n", of("o"));

        return graph;
    }

    private void dfs(Map<String, List<String>> graph, String current) {
        System.out.print("DFS: ");

        Stack<String> stack = new Stack<>();

        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();

            System.out.print(current + ", ");

            List<String> neighbors = graph.get(current);

            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    stack.push(neighbor);
                }
            }
        }
    }

    private void dfsUsingRecursion(Map<String, List<String>> graph, String current) {
        System.out.print(current + ", ");

        List<String> neighbors = graph.get(current);

        if (neighbors != null) {
            for (String neighbor : neighbors) {
                dfsUsingRecursion(graph, neighbor);
            }
        }
    }

    private void bfs(Map<String, List<String>> graph, String current) {
        System.out.print("BFS: ");

        Queue<String> queue = new LinkedList<>();

        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();

            System.out.print(current + ", ");

            List<String> neighbors = graph.get(current);

            if (neighbors != null) {
                queue.addAll(neighbors);
            }
        }
    }

    /**
     * Time complexity: O(edges)
     * Space complexity: O(nodes)
     * <p>
     * nodes = n
     * edges = n^2
     * <p>
     * Time: O(n^2)
     * Space: O(n)
     */
    private boolean hasPathUsingRecursion(Map<String, List<String>> graph, String current, String destination) {
        if (current.equals(destination)) {
            return true;
        }

        List<String> neighbors = graph.get(current);

        if (neighbors != null) {
            for (String neighbor : neighbors) {
                return hasPathUsingRecursion(graph, neighbor, destination);
            }
        }

        return false;
    }

    private boolean hasPathUsingDfs(Map<String, List<String>> graph, String current, String destination) {
        Stack<String> stack = new Stack<>();

        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();

            if (current.equals(destination)) {
                return true;
            }

            List<String> neighbors = graph.get(current);

            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }

    private boolean hasPathUsingBfs(Map<String, List<String>> graph, String current, String destination) {
        Queue<String> queue = new LinkedList<>();

        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.equals(destination)) {
                return true;
            }

            List<String> neighbors = graph.get(current);

            if (neighbors != null) {
                queue.addAll(neighbors);
            }
        }

        return false;
    }

    private boolean hasPathUsingDfs(Map<String, List<String>> graph, String current, String destination, List<String> visitorList) {
        Stack<String> stack = new Stack<>();

        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();

            if (current.equals(destination)) {
                return true;
            }

            visitorList.add(current);

            List<String> neighbors = graph.get(current);

            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visitorList.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return false;
    }

    private boolean hasPath(Map<String, List<String>> graph, String current, String destination, List<String> visitorList) {
        if (current.equals(destination)) {
            return true;
        }

        if (visitorList.contains(current)) {
            return false;
        }

        visitorList.add(current);

        List<String> neighbors = graph.get(current);

        if (neighbors != null) {
            for (String neighbor : neighbors) {
                if (hasPath(graph, neighbor, destination, visitorList)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathUsingBfs(Map<String, List<String>> graph, String current, String destination, List<String> visitorList) {
        Queue<String> queue = new LinkedList<>();

        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.equals(destination)) {
                return true;
            }

            visitorList.add(current);

            List<String> neighbors = graph.get(current);

            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visitorList.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return false;
    }

    private boolean hasComponentsConnected(Map<String, List<String>> graph, List<String> visitorList) {
        int count = 0;

        for (String key : graph.keySet()) {
            /*if (visitTheNeighbors(graph, key, visitorList)) {
                count++;
            }*/

            if (visitNeighborsUsingRecursion(graph, key, visitorList)) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }

    private boolean visitTheNeighbors(Map<String, List<String>> graph, String current, List<String> visitorList) {
        /*List<String> neighbors = graph.get(current);

        visitorList.add(current);

        if (neighbors != null) {
            for (String neighbor : neighbors) {
                if(!visitorList.contains(neighbor)){
                    visitTheNeighbors(graph, neighbor, visitorList);
                }
            }
        }

        return false;*/

        Queue<String> queue = new LinkedList<>();

        queue.add(current);

        boolean visited = false;

        while (!queue.isEmpty()) {
            current = queue.poll();

            visitorList.add(current);

            List<String> neighbors = graph.get(current);

            for (String neighbor : neighbors) {
                if (!visitorList.contains(neighbor)) {
                    visited = true;

                    queue.add(neighbor);
                }
            }
        }

        return visited;
    }

    private boolean visitNeighborsUsingRecursion(Map<String, List<String>> graph, String current, List<String> visitorList) {
        if (visitorList.contains(current)) {
            return false;
        }

        visitorList.add(current);

        List<String> visitors = graph.get(current);

        if (visitors != null) {
            for (String visitor : visitors) {
                visitNeighborsUsingRecursion(graph, visitor, visitorList);
            }
        }

        return true;
    }
}
