package coding.programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class P92334 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "Apple Pie";
		String[] b = a.split(" ");
		System.out.println(b[1]);
		
		HashSet<String> hs = new HashSet<>();
		
		hs.add("me");
		
		Iterator<String> iter = hs.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        // 첫번째 사람이 신고한 아이디 모으기
        for(int i = 0; i<id_list.length; i++){
            for(int j=0; j<report.length; j++){
                String[] report_new = report[j].split(" ");
                if(id_list[i] == report_new[0]){
                    
                }
                
                
                
            }
           
        }
        // 신고한 아이디 전체 중 k가 넘는 신고아이디 찾기
        
        // 첫번째 사람이 신고한 아이디 중 정지당한 아이디 숫자 구하기
        
        return answer;
    }
}