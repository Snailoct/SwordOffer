package main;

public class DeleteNodeInList {
	
	public void delteNode(ListNode list, ListNode pToBeDeleted){
		if(list==null || pToBeDeleted==null)
			return;
		
		// ȷ��Ҫɾ���Ľڵ�ȷʵ����
		
		// not the last node
		if(pToBeDeleted.next != null){
			ListNode after = pToBeDeleted.next;
			pToBeDeleted.val = after.next.val;
			pToBeDeleted.next = after.next;
			after = null;
		}
		else if(list == pToBeDeleted){
			// only one node in the List
			pToBeDeleted = null;
			list = null;
		}
		else{
			//to be delte is the last node 
			ListNode p = list;
			while(p.next != pToBeDeleted){
				p = p.next;
			}
			p.next = null;
			pToBeDeleted = null;
		}
	}

}
