package main;

public class GreatestSubarraySum {
	
	/*
	 * 1. brute �õ���������������ĺ�  O(n^2)
	 */
	
	
	/*
	 * 2. һ�α��� ���֮��С��0 �����¿�ʼ�ۻ�
	 */
	public int greatestSum(int[] data, int len){
		if(data == null || len <= 0)
			return 0; //  Exception
		int curSum = 0;
		int greatest = 0x80000000;
		for(int i=0; i<len; i++){
			if(curSum <= 0)
				curSum = data[i];
			else 
				curSum += data[i];
			if(curSum >= greatest)
				greatest = curSum;
		}
		
		return greatest;
	}
	
	/*
	 * 3. �����˼·��ʵ���Ƕ�̬�滮   һ���õݹ���� ��ѭ��ʵ��(��2)
	 */
	public int greatestSum3(int[] data, int len){
		
		int[] f = new int[len];
		f[0] = data[0];
		
		for(int i=1; i<len; i++){
			if(f[i-1] < 0)
				f[i] = data[i];
			else
				f[i] = f[i-1] + data[i];
		}
		// find the max
		int max = f[0];
		for(int i=0; i<len;i++)
			if(f[i] > max)
				max = f[i];
		return max;
	}
	
	
	public static void main(String[] args) {
		GreatestSubarraySum g = new GreatestSubarraySum();
		int[] a = {1,-2,3,10,-4,7,2,-5};
		System.out.println(g.greatestSum(a, a.length));
		System.out.println(g.greatestSum3(a, a.length));
		
	}
}
