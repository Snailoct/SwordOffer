package main;



public class SubstructureInTree {
	
	public boolean hasSubstree(BinaryTreeNode origin, BinaryTreeNode input){
		boolean res = false;
		if(origin!= null && input != null){
			if(origin.val == input.val)
				res = isSameTree(origin, input);
			if(!res)
				res = hasSubstree(origin.left, input);
			if(!res)
				res = hasSubstree(origin.left, input);
		}
		
		return false;
	}

	// �ҵ�����ͬ�ĸ��ڵ�֮�� ���ж��������Ƿ�һ����
	public boolean isSameTree(BinaryTreeNode origin, BinaryTreeNode input) {
		//
		if(input == null)
			return true;
		if(origin == null)
			return false;
		if(origin.val != input.val)
			return false;
		
		return isSameTree(origin.left, input.left) && isSameTree(origin.right, input.right);
	}

}
