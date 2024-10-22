import java.util.*;

public class rmMethods {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        int n = 3; // Fewer methods
        int k = 0; // Starting with method 0
        int[][] invocations = {
                {0, 1}, // Method 0 invokes Method 1
                {1, 2}  // Method 1 invokes Method 2
                // No external invocation on Method 1 or Method 2
        };
        System.out.println("result: " + solution.remainingMethods(n, k, invocations));  // Should output [3]
    }
}

class Solution5 {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        // Populate the graph with invocation data
        for (int[] invocation : invocations) {
            int a = invocation[0], b = invocation[1];
            graph.get(a).add(b);
            reverseGraph.get(b).add(a);
        }

        // Step 2: Find all suspicious methods using DFS or BFS
        Set<Integer> suspiciousMethods = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        suspiciousMethods.add(k);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!suspiciousMethods.contains(neighbor)) {
                    suspiciousMethods.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // Step 3: Check for external invocations into the suspicious methods
        for (int method : suspiciousMethods) {
            for (int invoker : reverseGraph.get(method)) {
                if (!suspiciousMethods.contains(invoker)) {
                    // Found an external invocation, so we cannot remove suspicious methods
                    return new ArrayList<>();
                }
            }
        }

        // Step 4: Collect all remaining methods
        List<Integer> remainingMethods = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspiciousMethods.contains(i)) {
                remainingMethods.add(i);
            }
        }

        return remainingMethods;
    }
}
