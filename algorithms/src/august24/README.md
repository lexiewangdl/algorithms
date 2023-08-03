# August 2024 LeetCode Notes

## Aug 2: 1. Two Sum
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