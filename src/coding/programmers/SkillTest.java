package coding.programmers;

import java.util.Scanner;

public class SkillTest {
//프로그래머스 : 스킬테스트체크 Level1.굿스타터
}

// 문제1 : 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
class Solution1 {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n ; i++) {
            if(n%i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}


// 문제2 : 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
//		   별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int j = 0; j<b;  j++){
            for(int i = 0; i<a; i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
