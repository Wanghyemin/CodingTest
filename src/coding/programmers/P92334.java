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

        // ù��° ����� �Ű��� ���̵� ������
        for(int i = 0; i<id_list.length; i++){
            for(int j=0; j<report.length; j++){
                String[] report_new = report[j].split(" ");
                if(id_list[i] == report_new[0]){
                    
                }
                
                
                
            }
           
        }
        // �Ű��� ���̵� ��ü �� k�� �Ѵ� �Ű���̵� ã��
        
        // ù��° ����� �Ű��� ���̵� �� �������� ���̵� ���� ���ϱ�
        
        return answer;
    }
}