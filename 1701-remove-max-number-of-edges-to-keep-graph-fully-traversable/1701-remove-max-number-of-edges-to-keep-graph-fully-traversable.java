class Solution {
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int components;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                components--;
                return true;
            }
            return false;
        }

        public int getComponents() {
            return components;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);

        int removableEdges = 0;

        // Type 3 edges
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean aliceConnected = ufAlice.union(edge[1] - 1, edge[2] - 1);
                boolean bobConnected = ufBob.union(edge[1] - 1, edge[2] - 1);
                if (!aliceConnected && !bobConnected) {
                    removableEdges++;
                }
            }
        }

        // Type 1 edges for Alice
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!ufAlice.union(edge[1] - 1, edge[2] - 1)) {
                    removableEdges++;
                }
            }
        }

        // Type 2 edges for Bob
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (!ufBob.union(edge[1] - 1, edge[2] - 1)) {
                    removableEdges++;
                }
            }
        }

        // Check if both graphs are fully traversable
        if (ufAlice.getComponents() > 1 || ufBob.getComponents() > 1) {
            return -1;
        }

        return removableEdges;
    }
}