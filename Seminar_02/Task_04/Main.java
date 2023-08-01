package Exceptions.Seminar_02.Task_04;

import java.util.Scanner;

public class Main {
    /*
     * Разработайте программу, которая выбросит Exception, 
     * когда пользователь вводит пустую строку. 
     * Пользователю должно показаться сообщение, 
     * что пустые строки вводить нельзя.
     */
    public static void main(String[] args) {
        userAsk();
    }

    private static void userAsk(){
        Scanner sc = new Scanner(System.in);
        boolean isEmpty = false;
        while (!isEmpty) {
            try {
                String str = textEnter(sc);
                System.out.println("Введённая строка не является пустой");
                isEmpty = true;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }  
        sc.close();
    }

    private static String textEnter(Scanner sc) throws StringIndexOutOfBoundsException {
        System.out.println("Введите текст: ");
        String str = sc.nextLine();
        if (str.isEmpty() || str == null){
            throw new StringIndexOutOfBoundsException("Строка не должна быть пустой");
        }
        return str;
    }
}    

