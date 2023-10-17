import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.util.Scanner;

public class Calculater {
    public static void main(String[] args) {
        System.out.println("Введите математическое выражение");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int l = input.length();
        if (l < 5){
            try {
                String res = calc(input);
                System.out.println(res);
            } catch (Exception exx) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }

        } else try {
            String res = calc(input);
            System.out.println(res);
        } catch (CharacterCodingException exct) {
            System.out.println("throws Exception");
        } catch (IOException exc) {
            System.out.println("throws Exception //т.к. формат операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } catch (Exception ex) {
            System.out.println("throws Exception //т.к. введены недопустимые числа или операнд");
        }
    }

    public static String calc(String input) throws Exception {
        int a, b; char op;

        String[] strings = input.split(" ");
        String c = strings[0];
        String e = strings[1];
        String d = strings[2];

        a = Integer.parseInt(c);
        b = Integer.parseInt(d);
        op = e.charAt(0);

        char ch = ' ';
        int count = input.length() - input.replace(String.valueOf(ch), "").length();

        if (count > 3) {
            throw new IOException();
        }

        if (count == 3) {
            throw new CharacterCodingException();
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new Exception();
        }
            switch (op) {
                case '+':
                    return String.valueOf(a + b);
                case '-':
                    return String.valueOf(a - b);
                case '*':
                    return String.valueOf(a * b);
                case '/':
                    return String.valueOf(a / b);
                default:
                    throw new CharacterCodingException();
            }
        }
    }
