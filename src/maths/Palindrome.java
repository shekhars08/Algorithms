package maths;

import java.util.Scanner;

public class Palindrome {

    static boolean palindrome(int n){
        int rev = 0;
        int temp = n;
        while (temp != 0){
            int ld = temp%10;
            rev = rev*10 + ld;
            temp = temp/10;
        }
        return (rev == n);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :   ");
        int n = sc.nextInt();
        boolean res = palindrome(n);
        System.out.println("number is palindrome :"  +res );
    }
}
