import java.util.Scanner;

public class interactive{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1");
        int n=1;
        for(;;){
            // System.out.println("n++");
            n++;
            String temp = String.valueOf(n);
            if(n%2==1){
                if((temp.contains("3")) || (temp.contains("6")) || (temp.contains("9"))){
                    System.out.println("C");
                }
                else{
                    System.out.println(n);
                }
            }
            else{
                //scanner.nextLine(); // buffer
                String user = scanner.nextLine();

                if((temp.contains("3")) || (temp.contains("6")) || (temp.contains("9"))){
                    if(user.equalsIgnoreCase("C")){
                        // System.out.println("input C");
                        continue;
                    }
                    else{
                        System.out.println("Game over!");
                        break;
                    }
                }
                else{
                    if(user.equals(String.valueOf(n))){
                        // System.out.println("input Num");
                        continue;
                    }
                    else{
                        System.out.println("Game over!");
                        break;
                    }
                }

            }
        }
    }
}