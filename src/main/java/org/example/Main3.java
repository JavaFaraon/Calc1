package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

    public static void main(String[] args) {
        checkEx();
    }
    public static String getMathExpression() {
        System.out.println("Введите корректное математическое выражение");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();}
    public static void checkEx() {
        String mathEx = getMathExpression();
        String mathExpression = mathEx.trim();//Отсекаем пробелы в начале и в конце

        int counter = 0;
        for (char element : mathExpression.toCharArray()) { //проверка совпадения кол-ва откр. и закр. скобок
            if (element == '(') {
                counter++;
            }
            if (element == ')') {
                counter--;
            }
            if (counter < 0) {
                System.out.println("Закрывающая скобка стоит раньше открывающей");
                checkEx();
                break;
                //return getMathExpression();
            }
        }

        if(isMatch(Pattern.compile("[^[0-9*/+()-]]"), mathExpression)) {
            System.out.println("В выражении присутствуют некорректные символы");
            checkEx();
        }
        else if (mathExpression.contains("+)")) {//проверка подмены местами откр. и закр. скобок
            System.out.println("Не может ) стоять после +");
            checkEx();
        }
        else if (mathExpression.contains("-)")) {
            System.out.println("Не может ) стоять после -");
            checkEx();
        }
        else if (mathExpression.contains("*)")) {
            System.out.println("Не может ) стоять после *");
            checkEx();
        }
        else if (mathExpression.contains("/)")) {
            System.out.println("Не может ) стоять после /");
            checkEx();
        }
        else if (mathExpression.contains("1(")|mathExpression.contains("2(")|mathExpression.contains("3(")|mathExpression.contains("4(")|mathExpression.contains("5(")|mathExpression.contains("6(")|mathExpression.contains("7(")|mathExpression.contains("8(")|mathExpression.contains("9(")|mathExpression.contains("0(")) {
            System.out.println("Не может ( стоять после числа");
            checkEx();
        }
        else if (counter != 0) {
            System.out.println("Скобочная последовательность не правильная");
            checkEx();
        }

        else {
            System.out.println("Скобочная последовательность правильная");
        }
        System.out.println(mathExpression); // проверка результата обработки строки

        //Pattern p = Pattern.compile("");
        //Matcher m = p.matcher(mathExpression);
        //m.find();

//        isMatch(Pattern.compile(""), mathExpression);
//        isMatch("", mathExpression);
    }

//    public static boolean isMatch(String regex, String str) {
//        Pattern p = Pattern.compile(regex);
//        Matcher m = pattern.matcher(str);
//        return m.find();
//    }

    public static boolean isMatch(Pattern ptr, String str) {
        Matcher matcher = ptr.matcher(str);
        return matcher.find();
    }


}
