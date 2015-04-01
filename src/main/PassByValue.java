package main;

import java.util.Arrays;

class Dog{
	String name;
	public Dog(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
public class PassByValue {
	public static void main( String[] args ){
	    Dog aDog = new Dog("Max");
	    foo(aDog);
	    if( aDog.getName().equals("Max") ){ //true
	        System.out.println( "Java passes by value." );
	    }else if( aDog.getName().equals("Fifi") ){
	        System.out.println( "Java passes by reference." );
	    }
	    
	    // �������� ͬ����� 
	    char[] s1 = "We are students".toCharArray();
	    System.out.println(s1);
		func(s1);
		System.out.println(s1);
	}
	/*
	 * ����foo�����������õ�ֵ �Զ�����d���������ھ����ڷ�����
	 * ��������ָ��һ���µĶ��� ������ı�֮ǰ�Ķ���״̬
	 */
	public static void foo(Dog d) {
	  d.getName().equals("Max"); // true
	  d = new Dog("Fifi");
	  d.getName().equals("Fifi"); // true
	}
	
	public static void func(char[] a){
		a = "hello".toCharArray();
		System.out.print("in func : ");
		System.out.println(a);
	}
}
