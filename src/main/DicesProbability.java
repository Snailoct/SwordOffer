package main;

import java.util.Arrays;

public class DicesProbability {
	public static final int MAX_DICE = 6;
	
	
	/*
	 * 1. ͨ���ݹ�  �õ�i�����Ӻ�ʣ�µ�n-1��������� һ������
	 * ����ݹ�Ĺ��̻�����Ӧ����һ��6����
	 */
	public void printProbability(int N){
		if(N < 1)
			return ;
		int maxsum = N * MAX_DICE;
		// ÿ�ֵ���֮�ͳ��ֵĴ���ͳ������
		int[] frequency = new int[maxsum - N + 1];
		
		probabilityCore(N, frequency);
		int denominator =  (int)Math.pow((double)MAX_DICE, (double)N);
		System.out.println(Arrays.toString(frequency));
		for(int i=N; i<=maxsum; i++){
			double ratio = ((double)frequency[i-N])/denominator;
			System.out.println("Sum: "+ i +", Ratio: " + ratio);
		}
		
		frequency = null;
	}

	public  void probabilityCore(int N, int[] frequency) {
		// ��i������һ�εݹ��ʱ�����
		for(int i=1; i<=MAX_DICE; i++)
			probabilityCore(N, i, N, 0, frequency);
	}

	public void probabilityCore(int N, int curDiceVal, int numOfDices, int curSum, int[] frequency) {
		if(numOfDices == 1){
			int sum = curDiceVal + curSum;
			frequency[sum-N] ++;
		}else{
			int sum = curDiceVal + curSum;
			for(int i=1; i<=MAX_DICE; i++)
				probabilityCore(N, i, numOfDices-1, sum, frequency);
		}
	}
	
	
	/*
	 * 2.��Ҫ����̬�滮
	 * ����k-1�����ӵĻ����ϣ�������һ�����ӣ�������ӵĵ���ֻ����Ϊ1-6��
	 * ��k�����ӵõ�������Ϊn������У�k-1���ӵĺ�Ϊn-1���ϴ˴ε�1��k-1���ӵĺ�Ϊn-2���ϴ˴ε�2���������ƣ�
	 * ��ʾΪ��f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6) 
	 * Խ���f(k,n)= 0;
	 * ��ʼ������1������ʱ��f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1�� 
     */  
	public void printProbability3(int N){
		if(N < 1)
			return ;
		int maxsum = N * MAX_DICE;
		// not use row=0,col=0
		int[][] f= new int[N+1][maxsum + 1];
		
		for(int i=1; i<=MAX_DICE; i++)
			f[1][i] = 1;
		
		for(int i=2; i<=N; i++){
			// �������п��ܻ���ֺ�
			for(int s= N; s<=maxsum; s++){
				for(int j=1; s-j>=1 && j<=MAX_DICE; j++){
					//System.out.println("i:" + i + "s:" + s + " j: "+j);
					f[i][s] += f[i-1][s-j];
				}
			}
		}
		
		int denominator =  (int)Math.pow((double)MAX_DICE, (double)N);
		for(int i=N; i<=maxsum; i++){
			double ratio = ((double)f[N][i])/denominator;
			System.out.println("Sum: "+ i +", Ratio: " + ratio);
		}
		
		f = null;
	}
	
	
	public static void main(String[] args) {
		int n = 2;
		DicesProbability d = new DicesProbability();
		//d.printProbability(n);
		System.out.println("---------------");
		d.printProbability3(n);
	}

}
