package testCases;

import java.util.Arrays;

import org.testng.annotations.Test;

public class FifthHighestNumber {

	public static void main(String []args) {
		int [] array={564,120,478,1235,41,2,568,102,365,185,210};
		int[]array1= {1,2,3,4};
		int[]array2= {1,2,3,4,5};
		int[]array3= {1,2,3,4,5,5,6,6};
		nthHighest(array,5);
		nthHighest(array1,5);
		nthHighest(array2,5);
		nthHighest(array3,5);
		
	}
	
	public static void nthHighest(int[] array,int x) {
		Arrays.sort(array);
		int y=1;
		for(int i=array.length-1;i>0;i--) {
			
			if(array[i-1]!=array[i]) {
				y=y+1;
				if(y==x) {
					System.out.println(array[i-1]);
					break;
				}
			}
			
		}
		if(y!=x) {
			System.out.println("Array doesnot contain 5 highest numbers");
		}
	}
	
	
}
