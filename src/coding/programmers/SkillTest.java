package coding.programmers;

import java.util.Scanner;

public class SkillTest {
//���α׷��ӽ� : ��ų�׽�Ʈüũ Level1.�½�Ÿ��
}

// ����1 : ���� n�� �Է¹޾� n�� ����� ��� ���� ���� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
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


// ����2 : �� �������� ǥ�� �Է����� �� ���� ���� n�� m�� �־����ϴ�.
//		   ��(*) ���ڸ� �̿��� ������ ���̰� n, ������ ���̰� m�� ���簢�� ���¸� ����غ�����.
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
