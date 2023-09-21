## 206. Reverse Linked List
Date: Sep 21, 2023

### Recursive Solution
Through a series of recursive calls, get to the base case first,
which is either when current node is `null` or the next node of current node is `null`. 
In the first case, the input linked list is empty. In the second case, we have reached the
last node in linked list. When we get to the base case, return current node,
this node is either `null` or the last node in linked list, which will be the
**head of reversed linked list**.

After reaching the base case, we go back step by step, at each step,
set `head.next.next = head;`, because `head.next` is the last node in reversed linked list,
and we want to put current node `head` right after it. Then, set `head.next = null;` because after
the previous operation, we are creating a loop, must manually cut that loop. Finally, return the 
head of reversed linked list, which is what was returned by the
recursive call.

### Iterative Solution
The idea is to reverse the parts we have traversed:
```agsl
1 <- 2 <- 3   4 -> 5
(traversed)   (remaining)
```
Use `prev` to store what the current node's `next` pointer needs to point to,
this is the chain of nodes that originally come before the current node,
after reversing this part, this chain needs to come after current node.

We can't just simply set `curr.next == null;`, because if that's the case, we won't be able
to travel to the following nodes. Thus, must store the next node using a temp variable,
`ListNode next = curr.next;`, and then perform the following operations: (1) make `curr`'s `next` pointer point
to `prev`, (2) move `prev` so that it points to `curr` (`prev = curr;`), (3) move `curr` to the next node (`curr = next;`)

In the end, return `prev` because eventually `curr` will point to an empty node, whereas `prev` will point to the final node
in input linked list, which is now the head of reversed linked list.


