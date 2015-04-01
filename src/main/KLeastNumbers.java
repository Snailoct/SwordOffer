package main;

import java.util.Arrays;
import java.util.TreeSet;


public class KLeastNumbers {
	/*
	 * 1. ����29�е�����λ����˼· �������ҵ���k����  ��Ȼ��ı���������
	 */
	public int[] getKLeast(int[] numbers, int len, int k){
		if(numbers==null || len <= 0)
			return null;  // invalid input
		
		int start = 0;
		int end = len - 1;
		int index = partition(numbers, len, start, end);
		while(index != k-1){
			if(index > k-1){
				end = index - 1;
				index = partition(numbers, len, start, end);
			}else{
				start = index + 1;
				index = partition(numbers, len, start, end);
			}
		}
		
		int[] output = new int[k];
		for(int i=0; i<k; i++)
			output[i]  = numbers[i];
		
		return output;
	}
	public int partition(int[] data, int len, int start, int end){
		if(data == null || len <= 0 || start < 0 || end >= len)
			return -1;  
		int index = end; //randomInRange(start, end);
		swap(data, index, end);
		
		int small = start -1;
		for(index =start; index<end;index++){
			if(data[index] < data[end]){
				++small;
				if(small != index)
					swap(data, index, small);
				
			}
		}
		
		++small;
		swap(data, small, end);
		//System.out.println(Arrays.toString(data));
		return small;
	}

	public void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	/*
	 * 2. O(nlgk) �ڱ����Ĺ�����ά��k����С����
	 * numbers ����ʹ�������� �Ӷ�����ȫ�������ڴ�
	 */
	public TreeSet<Integer> getLeast2(int[] numbers, int len, int k){
		if(numbers==null || len <= 0)
			return null;  
		
		if(k < 1 || len < k)
			return null;
		
		// TreeSet ���� TreeMap �ܱ�֤key�������� 
		TreeSet<Integer> kleast = new TreeSet<Integer>();
		
		for(int i=0; i < len; i++){
			if(kleast.size() < k)
				kleast.add(numbers[i]);
			else{
				if(numbers[i] < kleast.first()){
					kleast.remove(kleast.first());
					kleast.add(numbers[i]);
				}
			}
		}
		
		return kleast;
	}
	
	
	
	public static void main(String[] args) {
		KLeastNumbers kth = new KLeastNumbers();
		int[] a = {4,5,1,6,2,7,3,8};
		int[] res = kth.getKLeast(a, a.length, 4);
		System.out.println(Arrays.toString(res));
		
		TreeSet<Integer> set = kth.getLeast2(a, a.length, 3);
		System.out.println(set.toString());
		
	}
	
}
