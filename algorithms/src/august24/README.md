# August 2024 LeetCode Notes
## Aug 1: 100. Same Tree
**Solution 1**: Use BFS to traverse both trees simultaneouly and compare at every step.
- Time complexity: O(n) (worst case scenario, must check every single node in both trees)
- Space complexity: two queues used, one for each tree, to implement BFS

**Solution 2**: Recursively call `isSameTree` on left and right children of each node.

Termination condition:
1. If both nodes are `null`, they are the same, return `true`
2. If one of the two nodes is `null`, return `false` because they are different
3. Otherwise, both nodes are not `null`, continue to compare their values and recursively call the function on their left and right children.

Much better space complexity, fewer lines of code.