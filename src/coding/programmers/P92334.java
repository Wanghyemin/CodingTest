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
//        // 첫번째 사람이 신고한 아이디 모으기
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
//        // 신고한 아이디 전체 중 k가 넘는 신고아이디 찾기
//        
//        // 첫번째 사람이 신고한 아이디 중 정지당한 아이디 숫자 구하기
//        
//        return answer;
//    }
//}



// Stream을 사용
// 참고 : [스트림 사용법](https://wakestand.tistory.com/419)

/*
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) { // report ["신고자 신고대상"]
    	
    	// list : 중복을 제거한 report list
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        
        HashMap<String, Integer> count = new HashMap<>();
        
        // report list의 신고대상(=target)이 몇 번 신고당했는지 찾기 위함
        for (String s : list) {
            String target = s.split(" ")[1];
            
            // getOrDefault = 값이 있으면 그 Value값을 반환하고 default는 0
            // 여기서 count = {muzi=1}이라고 가정하면
            // count.put(muzi, count.getOrDefault(target,0)); 은 count = {muzi=0} 그대로가 된다. Map은 Key 중복허용불가
            // count.put(con, count.getOrDefault(target,0)); 은 count = {muzi=1, con=0}으로 값이 삽입된다.
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


// Java의 객체지향을 통한 코딩
// for문을 활용하면 Stream보다 속도측면에서 빠름

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>(); // Class User를 객체로 List를 만듬
        HashMap<String,Integer> suspendedList = new HashMap<>(); // < 신고 확정자, 1 > : Value의 1은 아무 의미 없음 
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx> = {muzi=1, frodo=2, con=3 .. } 이런식
        int idx = 0;

        // idIdx = 이름과 인덱스를 부여 , users에 id_list를 생성하는데 reportList, reportedList는 빈값
        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }

        // report된 모든 값을 User의 reportList와 reportedList에 넣음 : Set을 사용한 중복제거
        for(String re : report){
            String[] str = re.split(" "); // {"muzi con"}
            users.get( idIdx.get(str[0])).reportList.add(str[1]); // idIdx = {muzi=0}이라면 "users의 0번째를 찾고"(=muzi) 그 users에 reportList에 신고대상를 넣음
            users.get( idIdx.get(str[1])).reportedList.add(str[0]); // idIdx = {con=1}이라면 "users의 1번째를 찾고"(=con) 그 users에 reportedList에 신고자를 넣음
        }

        // 해당 user가 신고당한 reportedList의 사이즈를 통해 몇 번 신고를 당했는지 찾기
        for(User user : users){
            if(user.reportedList.size() >= k)
            	// suspendedList =  < 신고 확정자, 1 > : Value의 1은 아무 의미 없음 
                suspendedList.put(user.name,1);
        }
        // 해당 user의 reportList를 도출 
         for(User user : users){
             for(String nameReport : user.reportList){
                 if(suspendedList.get(nameReport) != null){ // user.name이 신고한 reportList에 정지확정자가 있는지 검증하고
                	 // 있다면 answer에 user.name의 인덱스위치에 ++를 하게된다.
                     answer[idIdx.get(user.name)]++;
                 }
             }
        }
        return answer;
    }
}

class User{
    String name;
    HashSet<String> reportList; // 내가 신고한 사람의 list
    HashSet<String> reportedList; // 나를 신고한 사람의 list
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}