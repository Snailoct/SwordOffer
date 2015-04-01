package main;

public class KthNodeFromEnd {
	
	// ����Ȼ���뵽 ����������� Ȼ���������
	public static ListNode findKthFromTailBrute(ListNode list, int k){
		return null;
	}
	
	// 
	public static ListNode findKthFromTail(ListNode list, int k){
		if(list == null || k == 0)
			return null;
		ListNode slow = null;
		ListNode fast = list;
		
		// the fast pointer will before k steps
		for(int i=0; i < k-1; i++){
			if(fast.next != null)
				fast = fast.next;
			else return null;
		}
		// then move the slow pointer
		slow = list;
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,};
		ListNode list = ListUtil.createListFromArray(arr);
		ListNode kth = findKthFromTail(list, 2);
		System.out.println(kth.val);
	}
	
}
