import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.nio.channels.Pipe.SourceChannel;
import java.util.regex.*;

public class Solution {

	StringBuilder preNumber;
	StringBuilder postNumber;
	
	ArrayList<Integer> diffIndex;
	
	boolean isOdd;
	int midIndex;
	
	
	public int createPalindromic(int d, int k, int len){
		StringBuilder preNumber = this.preNumber;
		StringBuilder postNumber = this.postNumber;
		int diffLen = this.diffIndex.size();
		int numberIndex = 0;
		
		if( d == k){
			for(int i = 0; i < this.diffIndex.size(); i++){
				if(preNumber.charAt(this.diffIndex.get(i)) > postNumber.charAt(this.diffIndex.get(i))){
					postNumber.setCharAt(this.diffIndex.get(i), preNumber.charAt(this.diffIndex.get(i)));
				}else{
					preNumber.setCharAt(this.diffIndex.get(i), postNumber.charAt(this.diffIndex.get(i)));
				}
				d--;
				k--;
			}
		}else if(d < k){
			int i = 0;
			int j = 0;
			while(d != k &&  d < k){
				if(preNumber.charAt(i) != '9'){
					preNumber.setCharAt(i, '9');
					postNumber.setCharAt(i, '9');
					
					if(!this.diffIndex.isEmpty() && (i == this.diffIndex.get(j))){
						this.diffIndex.remove(j);
						d--;
					}else{
						j++;
					}
					
					k -= 2;
				}
				i++;
			}
			if(d > k){
				return -1;
			}
			for(i = 0; i < this.diffIndex.size(); i++){
				if(preNumber.charAt(this.diffIndex.get(i)) > postNumber.charAt(this.diffIndex.get(i))){
					postNumber.setCharAt(this.diffIndex.get(i), preNumber.charAt(this.diffIndex.get(i)));
				}else{
					preNumber.setCharAt(this.diffIndex.get(i), postNumber.charAt(this.diffIndex.get(i)));
				}
				d--;
				k--;
			}
		}else{
			return -1;
		}
		this.preNumber = preNumber;
		this.postNumber = postNumber;
		return k;
	}
		/*
		while(d > 0 && i < this.diffIndex.size()){
			
			preNumber.setCharAt(numberIndex, '9');
			postNumber.setCharAt(numberIndex, '9');
			if(d == k){
				if(preNumber.charAt(this.diffIndex.get(i)) > postNumber.charAt(this.diffIndex.get(i))){
					postNumber.setCharAt(this.diffIndex.get(i), preNumber.charAt(this.diffIndex.get(i)));
				}else{
					preNumber.setCharAt(this.diffIndex.get(i), postNumber.charAt(this.diffIndex.get(i)));
				}
				d--;
				k--;
				i++;
			}else if(d > k){
				return -1;
			}else{
				preNumber.setCharAt(this.diffIndex.get(i), '9');
				postNumber.setCharAt(this.diffIndex.get(i), '9');
				d--;
				k -= 2;
				i++;
			}
		}
		if( k > 0){
			for(int i = 0 ; i < preNumber.length(); i++){
				if(k <= 0)
					break;
				if(preNumber.charAt(i) == preNumber.charAt(i)){
					if(preNumber.charAt(i) != '9'){
						preNumber.setCharAt(i, '9');
						postNumber.setCharAt(i, '9');
						k -= 2;
					}
				}else{
					if(preNumber.charAt(this.diffIndex.get(i)) > postNumber.charAt(this.diffIndex.get(i))){
						postNumber.setCharAt(this.diffIndex.get(i), preNumber.charAt(this.diffIndex.get(i)));
					}else{
						preNumber.setCharAt(this.diffIndex.get(i), postNumber.charAt(this.diffIndex.get(i)));
					}
					k--;
				}
			}
		}
		
		this.preNumber = preNumber;
		this.postNumber = postNumber;
		return k;
	}
	*/
	public int countDiff(){
		int count = 0;
		this.diffIndex = new ArrayList<Integer>();
		for(int i = 0; i < this.preNumber.length(); i++){
			if(this.preNumber.charAt(i) != this.postNumber.charAt(i)){
				diffIndex.add(i);
				count++;
			}
		}
		return count;
	}
	
	public boolean isOdd(int number) {
		if (number % 2 == 0) {
			return false;
		} else
			return true;
	}

	public void initNumber(int n, String number) {

		if (isOdd = isOdd(n)) {
			midIndex = n / 2;
			postNumber = new StringBuilder(number.substring(midIndex + 1));
		} else {
			midIndex = n / 2;
			postNumber = new StringBuilder(number.substring(midIndex));
		}
		preNumber = new StringBuilder(number.substring(0, midIndex));
		postNumber = postNumber.reverse();
	}

	public StringBuilder getPreNumber() {
		return preNumber;
	}

	public StringBuilder getPostNumber() {
		return postNumber;
	}

	public boolean isOdd() {
		return isOdd;
	}

	public int getMidIndex() {
		return midIndex;
	}

	
	public ArrayList<Integer> getDiffIndex() {
		return diffIndex;
	}
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int d;
		int n = in.nextInt();
		int k = in.nextInt();
		int result;
		String number = in.next();
//		BufferedReader read = new BufferedReader(new FileReader("test.txt"));
//		String number = read.readLine();
		Solution solution = new Solution();
		solution.initNumber(n, number);
		d = solution.countDiff();
		
		if(solution.isOdd() && d == 0 && k == 1){
			System.out.println(solution.getPreNumber().append('9').append(solution.getPostNumber().reverse()));
		}else{
			k = solution.createPalindromic(d, k, number.length());
		  
            /*
			System.out.println("result : " + result);
			System.out.println("midIndex : " + solution.getMidIndex());
			System.out.println("preNumber : " + solution.getPreNumber());
			System.out.println("postNumber : " + solution.getPostNumber());
            */
			if(k == -1)
				System.out.println("-1");
			else if(solution.isOdd()){
			if(k > 1){
                System.out.println(solution.getPreNumber().append('9').append(solution.getPostNumber().reverse()));
            }else{
                System.out.println(solution.getPreNumber().append(number.charAt(solution.getMidIndex())).append
                                   (solution.getPostNumber().reverse()));
            }	
			}else
				System.out.println(solution.getPreNumber().append(solution.getPostNumber().reverse()));
		}
	}
}
