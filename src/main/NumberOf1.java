package main;

public class NumberOf1 {
	
	/*
	 * 1. ��ֱ�۵ķ�����һ�α��� ͳ��ÿ��������1�ĸ��� O(nlgn)
	 */
	public int numberOf1From1ToN(int n){
		int sum = 0;
		for(int i=1; i<=n; i++)
			sum += number1InN(i);
		return sum;
	}

	public int number1InN(int n) {
		int count = 0;
		while(n!=0){
			if(n % 10 == 1)
				count ++;
			n /= 10;
		}
		return count;
	}
	
	/*
	 *  �ڶ��������� ���ɣ� ��34105�������Ϊ����
	 *  �������λ��3������1�Ĵ����� 10000~19999��10000��
	 *  �ٿ��θ�λ��4������1�Ĵ�����1000~1999��11000~11999��21000-21999��31000~31999������3*1000+1000��
	 *  �ٿ�����λ��1������1�Ĵ�����100~199��1100~1199��2100~2199������34100~34105������34*100+6��
	 *  �ٿ�����λ��0������1�Ĵ�����10~19��110~119��210~219������34010~34019������341*10��
	 *  ���һλ�Ǹ�5������1�Ĵ���������3410*1+1
	 *  ���������������ܽ��nλ������������������1�Ĺ��ɿ��Ա������£�
	 *   ��0~n -1λ��ɵ����ֳ��Կ�ȣ����������ӣ����λ���10000���θ�λ���1000����Ȼ���ٸ��ݵ�ǰλ�Ǵ���1������1��
	 *   ����0������һ���ɱ����ֵ���������ǣ�����ǰλ����1������Ͽ�ȣ�����ǰλ����1������ϸ�λ֮���β��������ǰλ����0�����0
	 *   �������ڸ�λ��ʱ��Щ��ͬ��
	 */
	//������λ��
	public int digitsN(int n){
	    int k = 0; 
	    for(int m = n; m != 0; m /=10)
	        k ++;
	    return k;
	}
	//���n�ĵ�kλ���� , ��1234 ��0λ��1����3λ��4
	public int  kthDigit(int n, int k)	{
	    int num = digitsN(n);
	    if(k < 0 || k > (num-1))
	        return 0;
	    int res = ((int)(n/Math.pow(10,num-k-1)));
	    return res % 10 ;
	}
	
	public int numberOf1From1ToN2(int n)
	{
	    //digits of n
	    int num = digitsN(n);
	    int scale = (int)Math.pow(10, num-1);
	    int factor = 0;
	    int remainder = 0;
	    
	    int digit = 0;
	    int count = 0; 

	    for(int k = 0; k < num; k++)
	    {
	        count += factor * scale;
	        digit = kthDigit(n,k);
	        if(digit > 1)
	            count += scale;
	        else if(digit == 1)
	        {
	        	// ��λ��1
	            if(k == num-1)
	                remainder = 1;
	            else
	                remainder = n % scale + 1;
	            
	            count += remainder;
	        }
	        
	        factor = (int)(n/scale);
	        scale /= 10;
	    }
	    return count;
	}
	
	
	/*
	 * 3. �������� ����������ϳ��ַ���  �Ӷ�ͳ�������ַ�1���ֵ�����   �ռ俪���ܴ�  ??
	 */
	
	
	public static void main(String[] args) {
		NumberOf1 test = new NumberOf1();
		//System.out.println(test.number1InN(111));
		System.out.println(test.numberOf1From1ToN(4));
		System.out.println(test.numberOf1From1ToN2(4));
		//System.out.println(test.kthDigit(1234, 3));
	}

}
