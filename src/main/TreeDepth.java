package main;



public class TreeDepth {
	
	/*
	 * ʹ�õݹ�ܼ� 
	 * ��ʵ���������ڵ��������ֶ�size �������С  �����Ϳ���ֱ�ӻ��
	 */
	public int depth(BinaryTreeNode root){
		if(root == null)
			return 0;
		int nleft = depth(root.left);
		int nright = depth(root.right);
		
		return (nleft > nright) ? (nleft+1) : (nright+1);
	}

}
