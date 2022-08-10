package coding.programmers;

// 프로그래머스 : 모의고사

public class P42840 {

	class Solution {
		public int[] solution(int[] answers) {

			int size = answers.length;
			int[] p1 = new int[size];
			int[] p2 = new int[size];
			int[] p3 = new int[size];

			for (int i = 0; i < size; i++) {
				if ((i + 1) % 5 != 0) {
					p1[i] = (i + 1) % 5;
					System.out.print(p1[i]);
				} else {
					p1[i] = 5;
				}
			}
			for (int i = 0; i < size; i++) {
				if (i % 2 == 0) {
					p2[i] = 2;
				} else {

				}

			}

			return p1;
		}
	}

}