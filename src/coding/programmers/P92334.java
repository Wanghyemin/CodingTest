package coding.programmers;

//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//
//public class P92334 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		String a = "Apple Pie";
//		String[] b = a.split(" ");
//		System.out.println(b[1]);
//		
//		HashSet<String> hs = new HashSet<>();
//		
//		hs.add("me");
//		
//		Iterator<String> iter = hs.iterator();
//		
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//	}
//
//}
//
//class Solution {
//    public int[] solution(String[] id_list, String[] report, int k) {
//        int[] answer = {};
//
//        // ù��° ����� �Ű��� ���̵� ������
//        for(int i = 0; i<id_list.length; i++){
//            for(int j=0; j<report.length; j++){
//                String[] report_new = report[j].split(" ");
//                if(id_list[i] == report_new[0]){
//                    
//                }
//                
//                
//                
//            }
//           
//        }
//        // �Ű��� ���̵� ��ü �� k�� �Ѵ� �Ű���̵� ã��
//        
//        // ù��° ����� �Ű��� ���̵� �� �������� ���̵� ���� ���ϱ�
//        
//        return answer;
//    }
//}



// Stream�� ���
// ���� : [��Ʈ�� ����](https://wakestand.tistory.com/419)

/*
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) { // report ["�Ű��� �Ű���"]
    	
    	// list : �ߺ��� ������ report list
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        
        HashMap<String, Integer> count = new HashMap<>();
        
        // report list�� �Ű���(=target)�� �� �� �Ű���ߴ��� ã�� ����
        for (String s : list) {
            String target = s.split(" ")[1];
            
            // getOrDefault = ���� ������ �� Value���� ��ȯ�ϰ� default�� 0
            // ���⼭ count = {muzi=1}�̶�� �����ϸ�
            // count.put(muzi, count.getOrDefault(target,0)); �� count = {muzi=0} �״�ΰ� �ȴ�. Map�� Key �ߺ����Ұ�
            // count.put(con, count.getOrDefault(target,0)); �� count = {muzi=1, con=0}���� ���� ���Եȴ�.
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
    
    
}

*/


// Java�� ��ü������ ���� �ڵ�
// for���� Ȱ���ϸ� Stream���� �ӵ����鿡�� ����

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>(); // Class User�� ��ü�� List�� ����
        HashMap<String,Integer> suspendedList = new HashMap<>(); // < �Ű� Ȯ����, 1 > : Value�� 1�� �ƹ� �ǹ� ���� 
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <�̸�, �ش� �̸��� User Ŭ���� idx> = {muzi=1, frodo=2, con=3 .. } �̷���
        int idx = 0;

        // idIdx = �̸��� �ε����� �ο� , users�� id_list�� �����ϴµ� reportList, reportedList�� ��
        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }

        // report�� ��� ���� User�� reportList�� reportedList�� ���� : Set�� ����� �ߺ�����
        for(String re : report){
            String[] str = re.split(" "); // {"muzi con"}
            users.get( idIdx.get(str[0])).reportList.add(str[1]); // idIdx = {muzi=0}�̶�� "users�� 0��°�� ã��"(=muzi) �� users�� reportList�� �Ű��� ����
            users.get( idIdx.get(str[1])).reportedList.add(str[0]); // idIdx = {con=1}�̶�� "users�� 1��°�� ã��"(=con) �� users�� reportedList�� �Ű��ڸ� ����
        }

        // �ش� user�� �Ű���� reportedList�� ����� ���� �� �� �Ű� ���ߴ��� ã��
        for(User user : users){
            if(user.reportedList.size() >= k)
            	// suspendedList =  < �Ű� Ȯ����, 1 > : Value�� 1�� �ƹ� �ǹ� ���� 
                suspendedList.put(user.name,1);
        }
        // �ش� user�� reportList�� ���� 
         for(User user : users){
             for(String nameReport : user.reportList){
                 if(suspendedList.get(nameReport) != null){ // user.name�� �Ű��� reportList�� ����Ȯ���ڰ� �ִ��� �����ϰ�
                	 // �ִٸ� answer�� user.name�� �ε�����ġ�� ++�� �ϰԵȴ�.
                     answer[idIdx.get(user.name)]++;
                 }
             }
        }
        return answer;
    }
}

class User{
    String name;
    HashSet<String> reportList; // ���� �Ű��� ����� list
    HashSet<String> reportedList; // ���� �Ű��� ����� list
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}