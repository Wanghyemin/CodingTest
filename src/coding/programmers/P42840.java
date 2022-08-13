package coding.programmers;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 : 모의고사

public class P42840 {

	class Solution {
		public int[] solution(int[] answers) {

			int size = answers.length;
			int[] p1 = new int[size];
			int[] p2 = new int[size];
			int[] p3 = new int[size];
			int[] answer;

			int[] array = { 0, 0, 0 };

			for (int i = 0; i < size; i++) {
				if ((i + 1) % 5 != 0) {
					p1[i] = (i + 1) % 5;

				} else {
					p1[i] = 5;
				}
			}
			for (int i = 0; i < size; i++) {
				if (i % 2 == 0) {
					p2[i] = 2;
				} else if (i % 8 == 1) {
					p2[i] = 1;
				} else if (i % 8 == 3) {
					p2[i] = 3;
				} else if (i % 8 == 5) {
					p2[i] = 4;
				} else if (i % 8 == 7)
					p2[i] = 5;
			}
			for (int i = 0; i < size; i++) {
				if (i % 10 == 0 || i % 10 == 1) {
					p3[i] = 3;
				} else if (i % 10 == 2 || i % 10 == 3) {
					p3[i] = 1;
				} else if (i % 10 == 4 || i % 10 == 5) {
					p3[i] = 2;
				} else if (i % 10 == 6 || i % 10 == 7) {
					p3[i] = 4;
				} else if (i % 10 == 8 || i % 10 == 9) {
					p3[i] = 5;
				}
			}

			for (int i = 0; i < size; i++) {
				if (answers[i] == p1[i]) {
					array[0]++;
				}
				if (answers[i] == p2[i]) {
					array[1]++;
				}
				if (answers[i] == p3[i]) {
					array[2]++;
				}
			}

			int max = 0;

			for (int i = 0; i < 3; i++) {
				if (array[i] > max) {
					max = array[i];
				}
			}
			int k = 0;
			for (int i = 0; i < 3; i++) {
				if (array[i] == max) {
					k++;
				}
			}
			answer = new int[k];
			int a = 0;
			for (int i = 0; i < 3; i++) {
				if (array[i] == max) {

					answer[a] = i + 1;
					a++;
				}
			}

			return answer;
		}
	}

}