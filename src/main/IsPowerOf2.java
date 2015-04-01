package main;


/*
 * ��Ȼ������ n & (n-1) �����������ұߵ�1  ��2^N ��ֻ��һ��λΪ1
 */
public class IsPowerOf2 {
	public static int isPowerOf2(int n){
		if(n <= 0)
			return 0;
		
		int res = n & (n - 1);
		
		return res==0 ? 1 : 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf2(-32));
	}
}
