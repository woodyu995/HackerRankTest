import java.io.*;
import java.util.*;

public class TimeConversion {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		 Scanner in = new Scanner(System.in);
		 String[] time = in.next().split(":");
		 
		 
		 if(time[0].contains("12")){
			 if(time[2].contains("AM"))
				 time[0] = "00";
		 }else
			 if(time[2].contains("PM")){
				 time[0] = Integer.toString(Integer.parseInt(time[0]) + 12);
			 }
		 
		 System.out.println(time[0] + ":" + time[1] + ":" + time[2].substring(0,2));
	    }
}
