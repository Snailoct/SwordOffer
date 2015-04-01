package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * ˼������Ϊ�ڷ����ڲ����ص��Ƕ��󣬷�����JVM���ϣ�������OK�� ���� 
 * ����ڷ����ڲ����䣨malloc�����ǿ��Ե�
 * ���������� ????????????
 */
public class ConstructBinaryTree {
	
	public static BinaryTreeNode construct(int[] preorder, int[] inorder, int len){
		// validate the args
		if(preorder == null || inorder == null || len <= 0)
			return null;
		
		return constructCore(preorder, 0, len-1, inorder, 0, len-1);
	}
	// ��Ҫ��һ�������в��ϵĻ��ָ�������������Ľڵ㣬�Ӷ��ݹ�
	private static BinaryTreeNode constructCore(int[] preorder, int preStart, int preEnd,
			int[] inorder, int inStart, int inEnd) {
		if(preStart > preEnd || inStart > inEnd)
			return null;
		
		int rootVal = preorder[preStart];
		int rootInorder = -1;
		BinaryTreeNode root = new BinaryTreeNode(rootVal);
		for(int i=inStart; i <= inEnd; i++){
			if(inorder[i] == rootVal){
				rootInorder = i;
				break;
			}
		}
		
		// if rootInorder==-1 throw exception
		int subLen = rootInorder - inStart;
		root.left = constructCore(preorder, preStart+1, preStart+subLen, inorder, inStart, rootInorder-1);
		root.right = constructCore(preorder, preStart+subLen+1, preEnd, inorder, rootInorder+1, inEnd);
		
		return root;
	}
	
	public static List<List<Integer>> levelOrder(BinaryTreeNode root) {
		  Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		  List<List<Integer>> res = new ArrayList<List<Integer>>();
		  List<Integer> level ; // deal with every level
		  
		  if(root == null)
			  return res;  // Ҫ��յ�ʱ�򷵻� "[]"������null
		  
		  queue.offer(root);
		  while(!queue.isEmpty()){
			  level = new ArrayList<Integer>();
			  // ÿһ���ʱ����һ�δ�С���������ڴ���Ĺ����У�����for(int i = 0; i < queue.size(); i++)
			  int size = queue.size();
			  for(int i = 0; i < size; i++){
				  BinaryTreeNode cur = queue.remove();
				  //Retrieves and removes the head of this queue.
				  //This method differs from poll only in that it throws an 
				  //exception if this queue is empty.

				  if(cur.left != null)
					  queue.add(cur.left);
				  if(cur.right != null)
					  queue.add(cur.right);
				  level.add(cur.val);
			  }
			  System.out.println(level);
			  res.add(level); // get one level iterated
		  }
		  
		  return res;
	  }      

	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		BinaryTreeNode tree = construct(pre, in, pre.length);
		levelOrder(tree);
	}
}
