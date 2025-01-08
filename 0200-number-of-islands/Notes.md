# 200. Number of Islands
### Constraints
* m == grid.length
* n == grid[i].length
* 1 <= m, n <= 300
* grid[i][j] is '0' or '1'.

### Test Cases
```
// 1. Given test case
[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
// 2. Given test case
[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
// 3. Bigger grid
[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"],["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
// 4. All 1s
[["1","1","1","1","1"],["1","1","1","1","1"],["1","1","1","1","1"],["1","1","1","1","1"]]
// 5. All 0s
[["0","0","0","0","0"],["0","0","0","0","0"],["0","0","0","0","0"],["0","0","0","0","0"]]
// 6. From comments
[["1","1","1"],["0","1","0"],["0","1","0"]]
// 7. From comments
[["1"],["0"],["1"],["0"],["1"],["1"]]
// 8. From comments
[["1","0","1","1","0","1","1"]]
// 9. From comments
[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
```

### Need a way to:
1. Use BFS on a root node to determine how far an island goes
2. Efficiently check for the number of islands
Which means: 
a. Starting from a root node and stretching out as far as possible, finding all of the land pieces that are adjacent
b. Making sure that the 1 nodes in that island won't be checked again, since the whole island is already covered. 
c. Once finished finding all of the nodes in that island, adding 1 to the island counter
d. Traversing the grid until finding a node from a new island, then repeating steps a-c. 
e. Repeat steps a-d until there are no more new root nodes to consider. 

### No code:
1. Traverse through the grid until hitting an unvisited 1, then add it to the queue to start performing BFS there. 
2. a. Start checking the neighbors of an unvisited 1 node by checking the indices above, below, to the left, and to the right. If it's a zero, ignore it. (I think, at least. Maybe you need to add them to visited, but that would break later BFS are far as I can tell). If it's an unvisited 1, add it to the queue. Once you've checked all neighbors, remove the root node from the queue.
	b. This is covered by the visited set.
	c. Once all neighbors's neighbors are visited, they should be removed from the queue. When the queue is empty, that should mean that all of the nodes in the island have been found, and you can increment the counter. 
	d. Starting from the root index + 1, continue traversing the array. Any given island might only have one node, and so you should just assume we'll continue traversal from the root to avoid missing anything. We'll know the next 1 node we find is from a new island if it's not in the visited set, and we'll just ignore it otherwise (I think).
	e. Loops

### Edge cases to consider:
* If the nodes we're checking would go out of bounds, make a case so that they are ignored instead of trying to access their value. 
* If it's all 1s, will it work?
* If it's all 0s, will it work?


#### Big-O Time Guess
O(n^2) for n elements in the 2D array
#### Big-O Time Actual
The time complexity is O(m * n) since each cell is processed a limited number of times (once for the initial check and potentially once during BFS). Better luck next time!
#### Big-O Space Guess
O(n) for queue and hashset
#### Big-O Space Actual
The overall space complexity is O(m * n) due to the storage requirements of both the visited set and the BFS queue. Better luck next time!

### What could I have done better?
This one just took me a really, really long time. For the most part, I don't regret that. It forced me to really understand queues better. What I do regret is not switching over to a boolean array for visited values. I suspect I did so poorly on space because I was creating new pairs so often for the queue and visited hashset. If I had done everything with arrays, I wouldn't even need the pair class and I could have dodged the hash set altogether. I don't know though, it seems weird that it would be so inefficient; on paper accessing a hashset should take just as long as a boolean array. Oh well. The lesson I took on Leetcode suggested a hashset, so I went with it. Next time I'll take the simpler route. 
