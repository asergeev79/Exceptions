package Exceptions.Seminar_02.Task_01;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    /*
     * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
     * и возвращает введенное значение. 
     * Ввод текста вместо числа не должно приводить к падению приложения, 
     * вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */
        userAsk();
    }

    private static void userAsk(){
        Scanner sc = new Scanner(System.in);
        boolean isFloat = false;
        while (!isFloat) {
            try {
                float num = textToFloat(textEnter(sc));
                System.out.println("Введённое число " + num + " является дробным");
                isFloat = true;
            } catch (NumberFormatException e) {
                System.out.println("Введённый текст не является дробным числом");
            }
        }  
        sc.close();
    }

    private static String textEnter(Scanner sc){
        System.out.println("Введите дробное число: ");
        String str = sc.nextLine();
        return str;
    }

    private static float textToFloat(String str) throws NumberFormatException{
        try {
            float num = Float.parseFloat(str);
            return num;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Это не дробное число");
        }
    }
}
