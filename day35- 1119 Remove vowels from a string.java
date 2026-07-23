import java.util.Scanner;

Class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String result = str.replaceAll("[AEIOUaeiou]", "");

        System.out.println("After removing vowels: " + result);
    }
}
