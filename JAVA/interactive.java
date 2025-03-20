import java.util.Scanner;

public class interactive{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1");
        int n=1;
        for(;;){
            // System.out.println("n++");
            int count=0;
            n++;
            String temp = String.valueOf(n);
            for(int i=0; i<temp.length(); i++){
                char t = temp.charAt(i);
                if((t=='3') || (t=='6') || (t=='9')){
                    count++;
                }
            }

            if(n%2==1){
                if(count>0){
                    System.out.println("C".repeat(count));
                }
                else{
                    System.out.println(n);
                }
            }
            else{
                //scanner.nextLine(); // buffer
                String user = scanner.nextLine();

                if(count>0){
                    if(user.length() != count || !user.equalsIgnoreCase("C".repeat(count))){
                        System.out.println("Game over!");
                        break;
                    }
                }
                else{
                    if(!user.equals(String.valueOf(n))){
                        System.out.println("Game over!");
                        break;
                    }
                }
            }
        }
    }
}