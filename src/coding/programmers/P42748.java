package coding.programmers;

// 프로그래머스 : K번째수

public class P42748 {
	
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int comlen = commands.length;
	        int temp = 0;
	        int[] arr = {};
	        int[] answer = new int [comlen];
	        
	        for(int i=0; i<comlen; i++){
	             int arrlen = commands[i][1] - commands[i][0] + 1;
	             // arr의 사이즈
	             arr = new int[arrlen];

	             for(int j=0; j<arrlen; j++){
	                 arr[j] = array[j + commands[i][0]-1]; 
	             }      
	            
	             for(int k=0; k<arr.length-1; k++){
	                for(int h=k+1; h<arr.length; h++) {
	                 if(arr[k]>arr[h]){
	                    temp = arr[k];
	                    arr[k] = arr[h];
	                    arr[h] = temp;
	                    }
	                }
	             }
	             answer[i] = arr[commands[i][2]-1];   
	        }
	        return answer;
	    }
	}

}
