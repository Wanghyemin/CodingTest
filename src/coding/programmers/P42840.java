package coding.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 프로그래머스 : 모의고사 (42820번)



//	class MySolution {
//		public int[] solution(int[] answers) {
//
//			int size = answers.length;
//			int[] p1 = new int[size];
//			int[] p2 = new int[size];
//			int[] p3 = new int[size];
//			int[] answer;
//
//			int[] array = { 0, 0, 0 };
//
//			for (int i = 0; i < size; i++) {
//				if ((i + 1) % 5 != 0) {
//					p1[i] = (i + 1) % 5;
//
//				} else {
//					p1[i] = 5;
//				}
//			}
//			for (int i = 0; i < size; i++) {
//				if (i % 2 == 0) {
//					p2[i] = 2;
//				} else if (i % 8 == 1) {
//					p2[i] = 1;
//				} else if (i % 8 == 3) {
//					p2[i] = 3;
//				} else if (i % 8 == 5) {
//					p2[i] = 4;
//				} else if (i % 8 == 7)
//					p2[i] = 5;
//			}
//			for (int i = 0; i < size; i++) {
//				if (i % 10 == 0 || i % 10 == 1) {
//					p3[i] = 3;
//				} else if (i % 10 == 2 || i % 10 == 3) {
//					p3[i] = 1;
//				} else if (i % 10 == 4 || i % 10 == 5) {
//					p3[i] = 2;
//				} else if (i % 10 == 6 || i % 10 == 7) {
//					p3[i] = 4;
//				} else if (i % 10 == 8 || i % 10 == 9) {
//					p3[i] = 5;
//				}
//			}
//
//			for (int i = 0; i < size; i++) {
//				if (answers[i] == p1[i]) {
//					array[0]++;
//				}
//				if (answers[i] == p2[i]) {
//					array[1]++;
//				}
//				if (answers[i] == p3[i]) {
//					array[2]++;
//				}
//			}
//
//			int max = 0;
//
//			for (int i = 0; i < 3; i++) {
//				if (array[i] > max) {
//					max = array[i];
//				}
//			}
//			int k = 0;
//			for (int i = 0; i < 3; i++) {
//				if (array[i] == max) {
//					k++;
//				}
//			}
//			answer = new int[k];
//			int a = 0;
//			for (int i = 0; i < 3; i++) {
//				if (array[i] == max) {
//
//					answer[a] = i + 1;
//					a++;
//				}
//			}
//
//			return answer;
//		}
//	}

class OtherSolution {
	public static int[] solution(int[] answers) {
		int[][] patterns = { { 1, 2, 3, 4, 5 }, 
							 { 2, 1, 2, 3, 2, 4, 2, 5 }, 
							 { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

		int[] hit = new int[3];
		for (int i = 0; i < hit.length; i++) {
			for (int j = 0; j < answers.length; j++) {
				if (patterns[i][j % patterns[i].length] == answers[j])
					hit[i]++;
			}
		}

		int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < hit.length; i++)
			if (max == hit[i])
				list.add(i + 1);

		int[] answer = new int[list.size()];
		int cnt = 0;
		for (int num : list)
			answer[cnt++] = num;
		return answer;
	}
}

