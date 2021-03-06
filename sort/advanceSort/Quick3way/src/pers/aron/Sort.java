package pers.aron;

import java.util.Random;

@SuppressWarnings("all")
public abstract class Sort {

	public static Comparable[] a;
	
	public static void generate(int number){
		Random random = new Random(7);
		a = new Integer[number];
		for(int i = 0;i<number;i++){
			a[i] = random.nextInt();
		}
	}
	
	public abstract void sort(Comparable[] a);
	
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a,int i,int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(){
		for(int i = 0; i < a.length;i++){
			System.out.print(a[i] + " ");
		}	
	}
	
	public static void printTime(Sort sort){
		Long start = System.currentTimeMillis();
		sort.sort(a);
		long end = System.currentTimeMillis();
		System.out.printf("Time is %d %n",end-start);
	}
	
	public static void isSorted(){
		for(int i = 1;i<a.length;i++){
			if(less(a[i],a[i-1])){
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
	}
	
	public static void main(String[] args){
		Sort quick = new Quick3way();
		generate(10000000);
		printTime(quick);
		isSorted();
	}
	
}
