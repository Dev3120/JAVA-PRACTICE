package JUSPAY;

import java.util.*;

public class Solution {
    static class Edge {
        int to, cost, idx;

        Edge(int to, int cost, int idx) {
            this.to = to;
            this.cost = cost;
            this.idx = idx;
        }
    }

    static List<Edge>[] tree;
    static int[] parent, depth, heavy, head, pos;
    static int[] edgeCost;
    static int curPos;
    static SegmentTree segTree;

    public static void solve(int N, int R, int M, int[][] edges, int Q, int[][] queries) {
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) tree[i] = new ArrayList<>();

        Map<String, Integer> edgeIndex = new HashMap<>();
        edgeCost = new int[N]; // N-1 edges, 1-indexed for position convenience

        for (int i = 0; i < M; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            tree[u].add(new Edge(v, w, i));
            tree[v].add(new Edge(u, w, i));
            edgeIndex.put(Math.min(u, v) + "_" + Math.max(u, v), i);
            edgeCost[i] = w;
        }

        parent = new int[N + 1];
        depth = new int[N + 1];
        heavy = new int[N + 1];
        head = new int[N + 1];
        pos = new int[N + 1];
        Arrays.fill(heavy, -1);

        dfs(R, 0);
        curPos = 0;
        decompose(R, R);

        int[] baseArray = new int[N];
        for (int u = 2; u <= N; u++) {
            int p = parent[u];
            String key = Math.min(u, p) + "_" + Math.max(u, p);
            int id = edgeIndex.get(key);
            baseArray[pos[u]] = edgeCost[id];
        }

        segTree = new SegmentTree(N);
        segTree.build(baseArray);

        long totalSum = 0;

        for (int[] q : queries) {
            if (q[0] == 1) {
                int u = q[1], v = q[2];
                totalSum += query(u, v);
            } else {
                int u = q[1], v = q[2], newCost = q[3];
                int child = depth[u] > depth[v] ? u : v;
                segTree.update(pos[child], newCost);
            }
        }

        System.out.println(totalSum);
    }

    static int dfs(int u, int p) {
        int size = 1, maxSubtree = 0;
        for (Edge e : tree[u]) {
            int v = e.to;
            if (v != p) {
                parent[v] = u;
                depth[v] = depth[u] + 1;
                int subtree = dfs(v, u);
                if (subtree > maxSubtree) {
                    maxSubtree = subtree;
                    heavy[u] = v;
                }
                size += subtree;
            }
        }
        return size;
    }

    static void decompose(int u, int h) {
        head[u] = h;
        pos[u] = curPos++;
        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }
        for (Edge e : tree[u]) {
            int v = e.to;
            if (v != parent[u] && v != heavy[u]) {
                decompose(v, v);
            }
        }
    }

    static int query(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            res += segTree.query(pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        if (pos[u] != pos[v])
            res += segTree.query(pos[u] + 1, pos[v]);
        return res;
    }

    static class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int size) {
            n = size;
            tree = new int[4 * n];
        }

        void build(int[] arr) {
            build(1, 0, n - 1, arr);
        }

        void build(int node, int l, int r, int[] arr) {
            if (l == r) {
                tree[node] = arr[l];
            } else {
                int mid = (l + r) / 2;
                build(2 * node, l, mid, arr);
                build(2 * node + 1, mid + 1, r, arr);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
            } else {
                int mid = (l + r) / 2;
                if (idx <= mid)
                    update(2 * node, l, mid, idx, val);
                else
                    update(2 * node + 1, mid + 1, r, idx, val);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        int query(int L, int R) {
            return query(1, 0, n - 1, L, R);
        }

        int query(int node, int l, int r, int L, int R) {
            if (r < L || l > R)
                return 0;
            if (L <= l && r <= R)
                return tree[node];
            int mid = (l + r) / 2;
            return query(2 * node, l, mid, L, R) + query(2 * node + 1, mid + 1, r, L, R);
        }
    }
}

