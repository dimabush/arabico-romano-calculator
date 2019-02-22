import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("If you wanna use Arabic numbers enter \"1\" %n" +
                "If you wanna use Roman numbers enter \"2\" %n");

        int num1 = 0;
        int num2 = 0;
        String str1 = null;
        String str2 = null;
        int index = sc.nextInt();

        if (index == 1) {
            System.out.println("Enter first Arabic number");
            num1 = sc.nextInt();
            System.out.println("Enter second Arabic number");
            num2 = sc.nextInt();

        }else if(index == 2){
            System.out.println("Enter first Roman number");
            str1 = sc.next().toUpperCase();
            num1 = romanToArabic(str1);
            if (num1 == 0) {
                System.out.println("Invalid first Roman number");
                System.exit(0);
            }

            System.out.println("Enter second Roman number");
            str2 = sc.next().toUpperCase();
            num2 = romanToArabic(str2);
            if (num2 == 0) {
                System.out.println("Invalid first Roman number");
                System.exit(0);
            }
        }else System.out.println("Invalid input");

        System.out.println("Enter an operator (+, -, *, /):");
            String operator = sc.next();

            int result;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
//                result = ((double) num1) / ((double) num2);
                result = num1 / num2;
                break;
            default:
                System.out.println("Operator is not correct");
                return;
        }

        if (index == 2){
            String romanRes = arabicToRoman(String.valueOf(result));
            System.out.printf("%s %s %s = %s", str1, operator, str2, romanRes);

        }else
        System.out.printf("%d %s %d = %d", num1, operator, num2, result);
    }

    private static int romanToArabic(String romanNumber) {
        switch (romanNumber) {
            case "X":
                return 10;
            case "IX":
            case "VIIII":
                return 9;
            case "VIII":
                return 8;
            case "VII":
                return 7;
            case "VI":
                return 6;
            case "V":
                return 5;
            case "IV":
                return 4;
            case "III":
                return 3;
            case "II":
                return 2;
            case "I":
                return 1;
            default:
                return 0;
        }
    }

    private static String arabicToRoman(String arabicNumber) {
        String romano = null;
        if (arabicNumber.length() == 3) {
            char hundreds = arabicNumber.charAt(arabicNumber.length() - 3);
            if (hundreds == '1')
                return romano = "c";
            else return "Invalid Roman Number";
        }
        if (arabicNumber.length() >= 1) {
            char units = arabicNumber.charAt(arabicNumber.length() - 1);
            switch (units) {
                case '1':
                    romano = "I";
                    break;
                case '2':
                    romano = "II";
                    break;
                case '3':
                    romano = "III";
                    break;
                case '4':
                    romano = "IV";
                    break;
                case '5':
                    romano = "V";
                    break;
                case '6':
                    romano = "VI";
                    break;
                case '7':
                    romano = "VII";
                    break;
                case '8':
                    romano = "VIII";
                    break;
                case '9':
                    romano = "IX";
                    break;
                default:
                    romano = "";
                    break;
            }
        }
        if (arabicNumber.length() == 2) {
            char tens = arabicNumber.charAt(arabicNumber.length() - 2);
            switch (tens) {
                case '1':
                    romano = "X" + romano;
                    break;
                case '2':
                    romano = "XX" + romano;
                    break;
                case '3':
                    romano = "XXX" + romano;
                    break;
                case '4':
                    romano = "XL" + romano;
                    break;
                case '5':
                    romano = "L" + romano;
                    break;
                case '6':
                    romano = "LX" + romano;
                    break;
                case '7':
                    romano = "LXX" + romano;
                    break;
                case '8':
                    romano = "LXXX" + romano;
                    break;
                case '9':
                    romano = "XC" + romano;
                    break;
                default:
                    romano = "" + romano;
                    break;
            }
        }
        return romano;
    }
}
