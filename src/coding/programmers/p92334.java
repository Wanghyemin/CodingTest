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
        int[] BB = new int[id_list.length]; // �ߺ����� �ʴ� �Ű���� Ƚ��
        int[] AB = new int[id_list.length];
        
        for(int i = 0; i<report.length; i++){
        	report_sep = report[i].split(" ");
            A[i] = report_sep[0]; // �Ű��� 
            B[i] = report_sep[1]; // �Ű���
            
            report_sep=null;
        }
        
        System.out.println(B[1] + B[0]);
        
        
        for(int i = 0; i<report.length; i++){
        	for (int j=0; j<A.length; j++) {
            	if( id_list[i] == A[j]) { // i���� == j�Ű��� : �Ű���
            		B_new.add(B[j]); // i������ ���� j�Ű��� �ߺ�����
            		 System.out.println(B_new.size() + i + "a"); 
            	}
        	}
        }
        	
//        	//id_list[i]�� �ش��ϴ� B_new�� ���ͷ����ͷ� �о String[] BB�� ����
//        	Iterator<String> iter = B_new.iterator();
//        	while(iter.hasNext()) {
//        		for(int kk=0; kk<id_list.length; kk++) {
//        			if(id_list[kk] == iter.next()) { // kk���� == k�Ű���
//        				BB[kk] += 1; // id_list[kk]��°�� �Ű� Ƚ���� BB�� ����
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




