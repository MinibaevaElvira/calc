
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String string = scanner.nextLine();
        try {
            System.out.println(calc(string));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String calc(String input) throws Exception {
        Pattern patternRom = Pattern.compile("[IVX]");
        Matcher matcherRom = patternRom.matcher(input);
        Pattern patternNumb = Pattern.compile("\\d+");
        Matcher matcherNumb = patternNumb.matcher(input);
        String[] words = input.split("\\W+");
        int number [] = new int [2];

        for (int i = 0; i< words.length;i++) {
            if(matcherRom.find()&& matcherNumb.find()){
                throw new Exception("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно.");
            }
            if (matcherRom.find()) {
                String resultRom = RomanNum(input);
                return resultRom;
            }
                number[i] = Integer.parseInt(words[i]);
            if (number[i]<1 || number[i]>10){
                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            }
        }
                int resultN= 0;
                if (input.contains("+")){
                    resultN= number[0] + number[1];
                } else
                if(input.contains("-")){
                    resultN = number[0] - number[1];
                } else
                if(input.contains("/")){
                    resultN = number[0] / number[1];
                }else
                if(input.contains("*")){
                    resultN= number[0] * number[1];}
                else {throw new Exception("Формат математической операции не удовлетворяет возможностям калькулятора.");}
                String result = Integer.toString(resultN);

            return result;
        }

          public static String RomanNum(String input) throws Exception {

              String[] roman = input.split("\\W+");

              String[] romanNumbers = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                      "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                      "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                      "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                      "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                      "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                      "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                      "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                      "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                      "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
              int[] arabNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                      11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                      21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                      31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                      41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                      51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                      61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
                      71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                      81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                      91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
              String romanNum1 = roman[0];
              String romanNum2 = roman[1];
              int arabNum1 = 0;
              int arabNum2 = 0;
              for (int i = 0; i < romanNumbers.length; i++) {
                   if (romanNumbers[i].equals(romanNum1)) {
                      arabNum1 = arabNumbers[i];
                  }
                   if (romanNumbers[i].equals(romanNum2)) {
                      arabNum2 = arabNumbers[i];
                  }
              }
              int resultR = 0;
              if (input.contains("+")) {
                  resultR = arabNum1 + arabNum2;
              } else if (input.contains("-")) {
                  resultR = arabNum1 - arabNum2;
                  if(resultR<0){
                      throw new Exception("В римской системе счисления нет отрицательных чисел.");
                  }
              } else if (input.contains("/")) {
                  resultR = arabNum1 / arabNum2;

              } else if (input.contains("*")) {
                  resultR = arabNum1 * arabNum2;
              } else {
                  throw new Exception("Формат математической операции не удовлетворяет возможностям калькулятора.");
              }
              String resultRom ="";
              for (int i = 0; i < arabNumbers.length; i++) {
                  if (arabNumbers[i] == resultR) {
                      resultRom = romanNumbers[i];
                  }
              }

              return resultRom;
          }



    }







