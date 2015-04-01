package main;

public class NumberOf1InBinary {
	
	//  original 
	public static int bit1Number1(int n){
		int count = 0;
		while(n != 0){
			if((n & 1) != 0)
				count ++;
			n = n >> 1;
		}
		
		return count;
	}
	
	//  �����߼�����  IN  JAVA
	public static int bit1Number2(int n){
		int count = 0;
		while(n != 0){
			if((n & 1) != 0)
				count ++;
			n = n >>> 1;
		}
		
		return count;
	}
	
	//  ������������ ����������λ��  ����ǰ���Ƕ�������λ֪����   ��C������ƽ̨��ص� ��
	public static int bit1Number1My(int n){
		int count = 0;
		for(int i=0; i < 32;i++){
			if((n & 1) != 0)
				count ++;
			n = n >>> 1;
		}
		
		return count;
	}
	
	// �����ķ���
	public static int bit1Number4(int n){
		int count = 0;
		while(n!=0){
			count ++;
			n = (n-1) & n; // ����n���ұߵ�һ��1
		}
		
		return count;
	}
	
	
	
	public static void main(String[] args) {
		//System.out.println(bit1Number1(0x0044));
		//System.out.println(bit1Number1(0x80000000));  // dead loop
		
		/*
		System.out.println(bit1Number2(0x0044));
		System.out.println(bit1Number2(0x80000000));  
		System.out.println("----------------");
		System.out.println(bit1Number1My(0x0044));
		System.out.println(bit1Number1My(0x80000000)); 
		
		
		System.out.println(1<<31);  // = -2147483648
		System.out.println(1<<32);   // =1
		
		System.out.println(bit1Number3(0x0044));
		System.out.println(bit1Number3(0x80000000)); 
		*/
		System.out.println(bit1Number4(100));
		System.out.println(bit1Number4(0x80000000));
		
	}

}
