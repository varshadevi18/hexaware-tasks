import java.util.*;

public class Task3_Graph {

    static class Graph {

        HashMap<String, ArrayList<String>> adj =
                new HashMap<>();

        void addService(String service) {
            adj.putIfAbsent(service, new ArrayList<>());
        }

        // Service depends on dependency
        void addEdge(String service, String dependency) {

            addService(service);
            addService(dependency);

            adj.get(service).add(dependency);
        }

        // DFS topological sort
        void dfs(String node, Set<String> visited,
                 Stack<String> stack) {

            visited.add(node);

            for (String next : adj.get(node)) {

                if (!visited.contains(next)) {
                    dfs(next, visited, stack);
                }
            }

            stack.push(node);
        }

        void deploymentDFS() {

            Set<String> visited = new HashSet<>();
            Stack<String> stack = new Stack<>();

            for (String node : adj.keySet()) {

                if (!visited.contains(node)) {
                    dfs(node, visited, stack);
                }
            }

            System.out.print("DFS Deployment Order: ");

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }

            System.out.println();
        }

        // BFS topological sort using Kahn's algorithm
        void deploymentBFS() {

            HashMap<String, ArrayList<String>> reverse =
                    new HashMap<>();

            HashMap<String, Integer> indegree =
                    new HashMap<>();

            for (String node : adj.keySet()) {
                reverse.put(node, new ArrayList<>());
                indegree.put(node, 0);
            }

            for (String service : adj.keySet()) {

                for (String dependency : adj.get(service)) {

                    reverse.get(dependency).add(service);

                    indegree.put(service,
                            indegree.get(service) + 1);
                }
            }

            Queue<String> queue = new LinkedList<>();

            for (String node : indegree.keySet()) {

                if (indegree.get(node) == 0) {
                    queue.add(node);
                }
            }

            ArrayList<String> order = new ArrayList<>();

            while (!queue.isEmpty()) {

                String current = queue.poll();
                order.add(current);

                for (String next : reverse.get(current)) {

                    indegree.put(next,
                            indegree.get(next) - 1);

                    if (indegree.get(next) == 0) {
                        queue.add(next);
                    }
                }
            }

            if (order.size() != adj.size()) {
                System.out.println("BFS: Circular dependency detected!");
            } else {
                System.out.println("BFS Deployment Order: " + order);
            }
        }

        // Cycle detection using DFS
        boolean cycleDFS(String node, Set<String> visited,
                         Set<String> path) {

            if (path.contains(node)) {
                return true;
            }

            if (visited.contains(node)) {
                return false;
            }

            visited.add(node);
            path.add(node);

            for (String next : adj.get(node)) {

                if (cycleDFS(next, visited, path)) {
                    return true;
                }
            }

            path.remove(node);

            return false;
        }

        boolean hasCycle() {

            Set<String> visited = new HashSet<>();
            Set<String> path = new HashSet<>();

            for (String node : adj.keySet()) {

                if (cycleDFS(node, visited, path)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addEdge("cart", "pricing");
        graph.addEdge("pricing", "inventory");
        graph.addEdge("cart", "notification");
        graph.addEdge("pricing", "tax");
        graph.addEdge("inventory", "database");

        System.out.println("MICROSERVICE DEPENDENCIES");

        graph.deploymentDFS();
        graph.deploymentBFS();

        System.out.println("Circular Dependency: "
                + graph.hasCycle());

        System.out.println("\nAdding circular dependency...");

        graph.addEdge("database", "cart");

        System.out.println("Circular Dependency: "
                + graph.hasCycle());

        graph.deploymentBFS();
    }
}