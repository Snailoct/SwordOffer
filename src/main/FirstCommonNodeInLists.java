package main;

public class FirstCommonNodeInLists {
	/*
	 * 1.Brute ÿ����L1��һ���ڵ� �ͱ���L2���Ƿ񾭹�����ڵ�  O(mn)
	 */
	
	/*
	 * 2. ������������ջ Ȼ�������β����ʼ���� ���һ����ͬ�Ľڵ����
	 * O(m+n) , �ռ临�Ӷ�O(m+n)
	 */
	
	/*
	 * 3. �ȵõ�����������֮��k��Ȼ���ó�������k��  Ȼ��ͬʱ����L1 L2 ��O(m+n)
	 */
	public ListNode firstCommon(ListNode head1, ListNode head2){
		if(head1 == null || head2== null)
			return null;
		int len1 = getListLen(head1);
		int len2 = getListLen(head2);
		
		int dif = len1 - len2;
		
		ListNode fast = head1;
		ListNode slow = head2;
		
		if(len2 > len1){
			fast = head2;
			slow = head1;
			dif = len2 - len1;
		}
		
		// the long list ,go dif steps first
		for(int i=0; i<dif; i++)
			fast = fast.next;
		
		while(fast!=null && slow!=null && fast!=slow){
			fast = fast.next;
			slow = slow.next;
		}
		
		ListNode res = fast;
		return res;
	}

	public int getListLen(ListNode head1) {
		ListNode p = head1;
		int count =0;
		while(p!=null){
			count ++;
			p = p.next;
		}
		return count;
	}

}
