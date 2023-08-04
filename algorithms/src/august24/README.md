# August 2024 LeetCode Notes

## Aug 3: 102. Binary Tree Level Order Traversal
Difficulty: Medium

**My solution**: use a `Queue` to store nodes we have not yet visited. At the end of each level, add a dummy node (whose `val` is `null`) to indicate that we have finished processing this level and a new list needs to be created to store values of the next level.

Key points:
- Use `TreeNode dummy = new TreeNode();` instead of `null` to indicate level change, avoid `NullPointerException`
- When to add a new `dummy` node? Every time we see a `dummy` node, it means that all nodes of the previous level have been processed. This includes queueing the children of nodes of previous level. For example, if the root is 3 and it has 9 and 20 as its child, when we see node 3, we will enqueue 9 and 20, then, the next time we remove an item from the queue, we will get the dummy node. At this point, only 9 and 20 are in the queue, thus, it's a good time to add another dummy node to indicate end of level.
- Only add a node to the queue if we know it's not `null` (i.e. check if the left/right child is not `null` before `add`)

Runtime:
- Time complexity O(n)
  - Must process every single node in the tree to get the result
- Space complexity O(n)
  - In the worst case, the queue must store all nodes in one level, and the leaf level is most likely to have more nodes. The output list of list will also have `n` spots.

## Aug 3: 104. Maximum Depth of Binary Tree
Difficulty: Easy

**My solution**: recursively call `maxDepth` on the left child and right child, at every step, increment depth by 1, return the greater value between the two.

## Aug 2: 1. Two Sum
Difficulty: Easy

**My solution**: create a hash table to store the difference between `nums[i]` and `target` as key, and index `i` as value. At each step, check if the map contains a key that is equal to the current element.

Runtime: O(n), worst case scenario, loop through the entire array. Best case scenario is when the solution is at indices `[0,1]`

## Aug 1: 101. Symmetric Tree
Difficulty: Easy

**My solution**: similar to solution 2 to the previous problem, at each step, compare two nodes (one from the left subtree and one from the right subtree). Then, compare the left child of the left node to the right child of the right node, compare the right child of the left node to the left child of the right node.
Must check if either of the two nodes is `null` before recursively calling the helper function, otherwise will get null pointer exception.

## Aug 1: 100. Same Tree 
Difficulty: Easy

**Solution 1**: Use BFS to traverse both trees simultaneouly and compare at every step.
- Time complexity: O(n) (worst case scenario, must check every single node in both trees)
- Space complexity: two queues used, one for each tree, to implement BFS

**Solution 2**: Recursively call `isSameTree` on left and right children of each node.

Termination condition:
1. If both nodes are `null`, they are the same, return `true`
2. If one of the two nodes is `null`, return `false` because they are different
3. Otherwise, both nodes are not `null`, continue to compare their values and recursively call the function on their left and right children.

Much better space complexity, fewer lines of code.