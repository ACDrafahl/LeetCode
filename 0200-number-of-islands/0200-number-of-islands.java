
        // System.out.println("m = " + m + " n = " + n);

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         nodeQueue.add(new Pair(i, j));
        //         visited.add(new Pair(i, j));
        //     }
        // }

        // // Adding three of the "same" item to make sure the hash set is working
        // visited.add(new Pair(1,1));
        // visited.add(new Pair(1,1));
        // visited.add(new Pair(1,1));

        // System.out.println("Queue: " + nodeQueue);
        // System.out.println("HashSet" + visited);

        // // Test if the hashset and queue are adding properly
        // for (int p = 0; p < 5; p++) {
        //     // If the pair isn't in the visited set,
        //     if (visited.add(new Pair(1, 1))) {
        //         // add it to the queue
        //         nodeQueue.add(new Pair(1, 1));
        //     }
        // }
        // System.out.println("Queue:    " + nodeQueue);
        // System.out.println("HashSet : " + visited);

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
                System.out.println();
                System.out.println("Checking node: " + currentNode);
                System.out.println("Not in visited: " + (!visited.contains(currentNode)));
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
            System.out.println("Step " + ++c + " queue: " + nodeQueue);
            Pair currentNode = nodeQueue.poll();
            int row = currentNode.row;
            int col = currentNode.col;

            visited.add(currentNode);

            
            System.out.println("Step " + c + " visted: " + visited);
            //System.out.println("currentNode: " + currentNode + ", row: " + row + ", col: " + col);

            // Checking above
            if (row - 1 > -1 && grid[row - 1][col] == '1') {
                Pair neighbor = new Pair(row - 1, col);
                if (!visited.contains(neighbor)) {
                    nodeQueue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            // Checking below
            if (row + 1 < m && grid[row + 1][col] == '1') {
                Pair neighbor = new Pair(row + 1, col);
                if (!visited.contains(neighbor)) {
                    nodeQueue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            // Checking to the left
            if (col - 1 > -1 && grid[row][col - 1] == '1') {
                Pair neighbor = new Pair(row, col - 1);
                if (!visited.contains(neighbor)) {
                    nodeQueue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            // Checking to the right
            if (col + 1 < n && grid[row][col + 1] == '1') {
                Pair neighbor = new Pair(row, col + 1);
                if (!visited.contains(neighbor)) {
                    nodeQueue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        };
    }

    
}