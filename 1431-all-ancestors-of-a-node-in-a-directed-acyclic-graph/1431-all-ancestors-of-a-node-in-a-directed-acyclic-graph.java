class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(to).add(from);
        }

        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> nodeAncestors = new ArrayList<>();
            boolean[] visited = new boolean[n];
            dfs(i, graph, visited, nodeAncestors);
            Collections.sort(nodeAncestors); 
            ancestors.add(nodeAncestors);
        }

        return ancestors;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> ancestors) {
        visited[node] = true;

        for (int parent : graph.get(node)) {
            if (!visited[parent]) {
                ancestors.add(parent);
                dfs(parent, graph, visited, ancestors);
            }
        }
    }
}