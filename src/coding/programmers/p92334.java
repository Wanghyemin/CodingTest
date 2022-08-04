package ch01;

import java.util.HashSet;

public class p92334 {

	public static void main(String[] args) {


		String[] report = {"1 3", "2 4"};
		String [] id_list = {"1","2"};
		int k = 1;
		////////////////////////////////////// 
		
        String[] report_sep = new String[2]; 
        String[] A = new String[report.length];
        String[] B = new String[report.length];
        HashSet<String> B_new = new HashSet<String>();
        int[] BB = new int[id_list.length]; // 중복되지 않는 신고당한 횟수
        int[] AB = new int[id_list.length];
        
        for(int i = 0; i<report.length; i++){
        	report_sep = report[i].split(" ");
            A[i] = report_sep[0]; // 신고자 
            B[i] = report_sep[1]; // 신고대상
            
            report_sep=null;
        }
        
        System.out.println(B[1] + B[0]);
        
        
        for(int i = 0; i<report.length; i++){
        	for (int j=0; j<A.length; j++) {
            	if( id_list[i] == A[j]) { // i유저 == j신고자 : 신고자
            		B_new.add(B[j]); // i유저에 대한 j신고대상 중복제거
            		 System.out.println(B_new.size() + i + "a"); 
            	}
        	}
        }
        	
//        	//id_list[i]에 해당하는 B_new를 이터레이터로 읽어서 String[] BB를 만듬
//        	Iterator<String> iter = B_new.iterator();
//        	while(iter.hasNext()) {
//        		for(int kk=0; kk<id_list.length; kk++) {
//        			if(id_list[kk] == iter.next()) { // kk유저 == k신고대상
//        				BB[kk] += 1; // id_list[kk]번째의 신고 횟수를 BB에 저장
//        			}	
//        		}
//        	}
//        	B_new = null;
//        }
//
//
//    	for(int j=0; j<id_list.length; j++) {
//            for(int i=0; i<id_list.length; i++) {
//        		if(BB[j] >=k && id_list[j] == B[i]) {
//        			AB[i] += 1;
//        		}
//        	}
//        }
//        
//    	//////////
//        for(int i=0; i<id_list.length; i++) {
//        	System.out.println(AB[i]);
//        }
        

	}

	
}




