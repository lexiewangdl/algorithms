package may;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer {
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
    public Node connect(Node root) {
        
    	if (root == null)
    		return root;
    	                                           
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	
    	while (!q.isEmpty()) {
    		int s = q.size();
    		for (int i = 0; i < s; i++) {
    			Node tempRoot = q.poll();
    			if (tempRoot.left != null) 
    				q.offer(tempRoot.left);
    			if (tempRoot.right != null)
    				q.offer(tempRoot.right);
    			if (i == s -1)
    				tempRoot.next = null;
    			else tempRoot.next = q.peek();
    	
    		}
    	}
    	return root;
    }

}
