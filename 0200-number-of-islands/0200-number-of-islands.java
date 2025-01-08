class Solution {
    static class Pair {
        int row;
        int col;

        Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;  // Cast to Pair
            return row == pair.row && col == pair.col;  // Compare the fields
        }

        public int hashCode() {
            return 31 * row + col;  // Generate a hash code based on r and c
        }

        //Just for testing
        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }

    public int numIslands(char[][] grid) {
        Queue<Pair> nodeQueue = new LinkedList<>();
        HashSet<Pair> visited = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        int c = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Pair currentNode = new Pair(i, j);
                // If the character is 1 and the pair isn't in the visited set
                if (grid[i][j] == '1' && !visited.contains(currentNode)) {
                    // Add it to the queue, then run BFS on it
                    nodeQueue.add(currentNode);
                    BFS(grid, nodeQueue, visited, m, n);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    public void BFS(char[][] grid, Queue<Pair> nodeQueue, HashSet<Pair> visited, int m, int n) {
        int c = 0;
        while (!nodeQueue.isEmpty()) {
            Pair currentNode = nodeQueue.poll();
            int row = currentNode.row;
            int col = currentNode.col;
            Pair neighbor = new Pair(row, col);

            visited.add(currentNode);

            // Checking above
            if (row - 1 > -1 && grid[row - 1][col] == '1') {
                neighbor.row = row - 1;
                neighbor.col = col;
                if (!visited.contains(neighbor)) {
                    nodeQueue.add(new Pair(row - 1, col));
                    visited.add(new Pair(row - 1, col));
                }
            }
            // Checking below
            if (row + 1 < m && grid[row + 1][col] == '1') {
                neighbor.row = row + 1;
                neighbor.col = col;
                if (!visited.contains(neighbor)) {
                    nodeQueue.add(new Pair(row + 1, col));
                    visited.add(new Pair(row + 1, col));
                }
            }
            // Checking to the left
            if (col - 1 > -1 && grid[row][col - 1] == '1') {
                neighbor.row = row;
                neighbor.col = col - 1;
                if (!visited.contains(neighbor)) {
                    nodeQueue.add(new Pair(row, col - 1));
                    visited.add(new Pair(row, col - 1));
                }
            }
            // Checking to the right
            if (col + 1 < n && grid[row][col + 1] == '1') {
                neighbor.row = row;
                neighbor.col = col + 1;
                if (!visited.contains(neighbor)) {
                    nodeQueue.add(new Pair(row, col + 1));
                    visited.add(new Pair(row, col + 1));
                }
            }
        };
    }
}