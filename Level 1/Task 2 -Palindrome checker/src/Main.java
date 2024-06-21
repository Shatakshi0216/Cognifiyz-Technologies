import java.util.Scanner;
class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your word or phrase: ");
        java.lang.String str = sc.nextLine();

        // Removing special characters from string and converting all characters into lowercase
        str = str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int i=0,j=str.length()-1;
        boolean isPalindrome=true;

        // Iterating through string
        while(i<j && isPalindrome){
            if(str.charAt(i)!=str.charAt(j))
                isPalindrome = false;
            i++;
            j--;
        }

        if(isPalindrome==true)
            System.out.println("Given string is Palindrome.");
        else
            System.out.println("Given string is not Palindrome.");
    }
}