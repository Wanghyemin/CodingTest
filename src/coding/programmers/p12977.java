package coding.programmers;

public class p12977 {

	
	class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        int sum = 0;

	        for(int i =0; i<nums.length-2 ; i++){
	            for(int j =i+1; j<nums.length-1 ; j++){
	                for(int k =j+1; k<nums.length ; k++){
	                    
	                    sum = nums[i]+nums[j]+nums[k];
	                        
	                        
	                    for (int p = 2; p<=(int)Math.sqrt(sum); p++) {
	                          if (sum % p == 0) { answer++; System.out.print(answer); }
	                        
	                    }
	                }
	            }
	        }
	        return answer;
	    }
	}
	
	
	public static void main(String[] args) {


	}

}
