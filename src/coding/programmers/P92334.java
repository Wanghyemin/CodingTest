package coding.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class p92334 {

	public static void main(String[] args) {


		String[] report = {"1 3", "2 4"};
		String [] id_list = {"1","2","3","4"};
		int k = 1;
//		////////////////////////////////////// 

		String[] report_sep = new String[2]; 
        String[] A = new String[report.length];
        String[] B = new String[report.length];
        HashSet<String> B_new = new HashSet<String>();
        int[] BB = new int[id_list.length]; // 중복되지 않는 신고당한 횟수
        int[] AB = new int[id_list.length];
        Iterator<String> iter;
//        
//        for(int i = 0; i<report.length; i++){
//        	report_sep = report[i].split(" ");
//            A[i] = report_sep[0]; // 신고자 
//            B[i] = report_sep[1]; // 신고대상
//            
//            report_sep=null;
//        }
//
//        for(int i = 0; i<id_list.length; i++){
//        	for (int j=0; j<A.length; j++) {
//            	if( id_list[i].equals(A[j])) { // i유저 == j신고자 : 신고자
//            		B_new.add(B[j]); // i유저에 대한 j신고대상 중복제거
//            		System.out.println(B_new.size());  ////////////////
//
//            	}
//        	}        	
//        	//id_list[i]에 해당하는 B_new를 이터레이터로 읽어서 String[] BB를 만듬
//        	for(int kk=0; kk<id_list.length; kk++) {
//            	iter = B_new.iterator();
//    			while(iter.hasNext()) {
//        			if(id_list[kk].equals(iter.next())) { // kk유저 == k신고대상
//        				
//        				BB[kk] += 1; // id_list[kk]번째의 신고 횟수를 BB에 저장
//        			}	
//        		}
//        	}
//        	B_new = new HashSet<String>();
//        	System.out.println("eee");
//        }
//        
//        for (int i=0; i<id_list.length; i++) {
//        	for(int j=0; j<id_list.length; j++) {
//        		for(int kk=0; kk<A.length; kk++) {
//        			if(BB[i]>=k && id_list[j].equals(A[kk]) && id_list[i].equals(B[kk])) {
//        				AB[j] +=1;
//        			}
//        		}
//        	}
//        }

		List<Integer> blist = new ArrayList<Integer>();
		Map<String, List<Integer>> mappingAB = new HashMap<>();
		
		//report 반으로 나누기
	    for(int i = 0; i<report.length; i++){
	    	report_sep = report[i].split(" ");
	        A[i] = report_sep[0]; // 신고자 
	        B[i] = report_sep[1]; // 신고대상
	        report_sep=null;
	    }
		
System.out.println(A[1] + B [0]);
	    
	    // [신고자, [신고대상 유무]]
		for(int i = 0; i<id_list.length;i++) {
			for(int ii=0;ii<id_list.length ; ii++) {
				blist.add(ii,0);
			}
			
			for(int j=0; j<report.length;j++) {
				for(int kk=0; kk<id_list.length;kk++) {
					if(id_list[i].equals(A[j]) && B[j].equals(id_list[kk]) && blist.get(kk) == 0) {
						blist.set(kk,1);
					}


					
				}
			}
			mappingAB.put(id_list[i], blist);
			blist =new ArrayList<Integer>();
		}
		
		int sum = 0;
		for(int j=0; j<report.length;j++) {
			for(int i = 0; i<id_list.length;i++) {

				sum += mappingAB.get(id_list[i]).get(j);
			}
			
			if(sum < k ) {
				for(int i = 0; i<id_list.length;i++) {
			
				mappingAB.get(id_list[i]).set(j, 0);
				
				}
			}
		}
		
		int bb = 0;
		int [] result = new int[id_list.length];
		for(int i = 0; i<id_list.length;i++) {
			for(int j = 0; j<id_list.length;j++) {
				bb += mappingAB.get(id_list[i]).get(j);
			}
			result[i] = bb;

			bb = 0;
		}
		System.out.println("aa");
		//return result;
	}
}

