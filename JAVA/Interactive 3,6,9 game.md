컴퓨터 프로그래밍 과제 1 “Interactive 3,6,9 game” report.

2024-14090 박영민

[알고리즘]

import java.util.Scanner;
Scanner scanner = new Scanner(System.in);
사용자로부터 문자열을 입력하기 위해 Scanner 함수를 import 하였다.
for(;;)
사용자가 잘못 입력하기 전(Game over!) 되기 전 까지, 반복할 수 있도록 무한 루프를 만들었다.
n++;
제일 처음 시작 숫자 n을 이용하여 턴 마다 숫자가 증가할 수 있도록 설계했다.
String temp = String.valueOf(n);
n 에 있는 3,6,9 개수를 파악하기 위한 첫번째 단계로 n을 문자열로 바꾸었고, 임시를 의미하는 temp 변수에 저장했다.
for(int i=0; i<temp.length(); i++){
                char t = temp.charAt(i);
                if((t=='3') || (t=='6') || (t=='9')){
                    count++;
                }
            }
이후 3,6,9의 개수를 파악하기 위해 temp를 각 자리로 잘라서 t에 저장하고 그때마다 비교하여 count에 3,6,9의 개수를 저장했다.


if(n%2==1){
                if(count>0){
                    System.out.println("C".repeat(count));
                }
                else{
                    System.out.println(n);
                }
            }

n 이 홀수인 경우 컴퓨터의 턴 이므로 3,6,9의 개수에 맞게 출력하기 위해 println(“C”.repeat(count));를 사용했다.
else{
                //scanner.nextLine(); // buffer
                String user = scanner.nextLine();
n이 짝수인 경우 사용자의 턴 이므로, user를 선언하고 엔터 전까지 입력받기 위해 scanner.nextLine()을 사용했다.

if(count>0){
                    if(user.length() != count || !user.equalsIgnoreCase("C".repeat(count))){
                        System.out.println("Game over!");
                        break;
                    }
                }

유저가 입력한 C의 개수가 count와 같아야 하는데, 이를 위해서 우선 유저가 입력한 글자수를 확인하고, equalsIgnoreCase와 repeat(count)를 이용하여, 모든 문자가 ‘C’또는 ‘c’로 이루어져있는지 확인했다.


[실행방법]
사용자는 2부터 시작하여, 3,6,9를 포함한 숫자 턴에는 C를 숫자 개수에 맞게 입력하고, 그렇지 않다면 그 턴에 맞는 숫자를 입력하면 된다. 이후 사용자가 잘못 입력하여, Game over!가 출력되기 전까지 무한반복해서 진행하면 된다.
