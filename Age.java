import java.util.Scanner;
public class Age
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter age of a person");
int age = sc.nextInt();
if(age >= 18)
System.out.println("Eligible to cast vote");
else
System.out.println("Not eligible to cast vote");
}
}