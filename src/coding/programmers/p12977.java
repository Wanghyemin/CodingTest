package coding.programmers;

public class p12977 {
	
	
	// 프로그래머스 : 소수 만들기 (12977)
	
	class Solution {
    
    public int isPrime(int n){

        for (int m = 2; m<=(int)Math.sqrt(n); m++) {
            if (n % m == 0) {
                return 0;
            }
        }
        return 1;
    }          
    
    
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;

        for(int i =0; i<nums.length-2 ; i++){
            for(int j =i+1; j<nums.length-1 ; j++){
                for(int k =j+1; k<nums.length ; k++){
                    
                    sum = nums[i]+nums[j]+nums[k];       
                    answer += this.isPrime(sum);   
             
                    }
                }
            }
        return answer;
    }
}

}
