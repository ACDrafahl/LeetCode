# 622. Design Circular Queue

Constraints:
- 1 <= k <= 1000
- 0 <= value <= 1000
- At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.

Test cases:
```
// 1. Given test case
["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
[[3],[1],[2],[3],[4],[],[],[],[4],[]]
// 2. Tests an overflowed queue and constantly checks front and rear elements
["MyCircularQueue","enQueue","Front","Rear","enQueue","Front","Rear","enQueue","Front","Rear","enQueue","Front","Rear","enQueue","Front","Rear","enQueue","Front","Rear","deQueue","Front","Rear","enQueue","Front","Rear"]
[[5],[1],[],[],[[2],[],[],[3],[],[],[4],[],[],[5],[],[],[6],[],[],[],[],[],[7],[],[]]
3. Given test case
["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
```

Need a way to:
1. Enqueue elements and move the front and rear indices
2. Dequeue elements and move the front and rear indices
3. Return the the front element 
4. Return the the rear element
5. Check if the queue is empty
6. Check if the queue is full
7. Wrap pointers once we get to the end of the queue.

No code:
1. First element: Put an element at the first spot of the queue. Move the front and rear indices to that element since it's the only one in the queue. 

	Subsequent elements: if the queue isn't full, put an element at the last spot of the queue and move the rear indice that spot. 

	Combining first and subsequent steps: Start with the front indice on the first spot. If the queue isn't full, put an element at the last spot of the queue (which would be the first spot on the first run through) and move the rear indice forward one so it's at that element.
2. "Remove" the element at the front indice of the queue by moving the front indice forward to the next element
3. Just use the front indice to access the front element
4. Just use the rear indice to access the rear element
5. If the front and rear pointers are on the same indice and the value there is null, then the queue is empty
6. If abs((front pointer indice - rear pointer indice) % size of queue) == 1, then the queue is full.
7. Set the pointer indice to itself + 1 % size of queue

Big-O space guess: O(n) for array list
Big-O time guess: O(1) for pointers and counters

Big-O space actual: O(n), SPOT ON!
Big-O time actual: O(1), SPOT ON!
