import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long min;
		long max;
		long sum = 0;
		long[] number = new long[5];
		
		for(int i = 0; i < 5; i++){
			number[i] = in.nextLong();
		}		
		
		for(int i = 1; i < 5; i++){
			sum += number[i];
		}
		min = sum;
		max = min;
		
		for(int i = 1; i < 5; i++){
			sum = 0;
			for(int j = 0; j < 5; j++){
				if(i != j){
					sum = sum + number[j];
				}
			}
			if(min > sum){
				min = sum;
			}else if(max < sum){
				max = sum;
			}
			
		}
		System.out.println(min + " " + max);
		
	}
	
}
