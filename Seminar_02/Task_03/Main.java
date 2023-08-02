package Exceptions.Seminar_02.Task_03;

public class Main {
    /*
     * public static void main(String[] args) throws Exception {
     *    try {
     *        int a = 90;
     *        int b = 3;
     *        System.out.println(a / b);
     *        printSum(23, 234);
     *        int[] abc = { 1, 2 };
     *        abc[3] = 9;
     *    } catch (Throwable ex) {
     *        System.out.println("Что-то пошло не так...");
     *    } catch (NullPointerException ex) {
     *        System.out.println("Указатель не может указывать на null!");
     *    } catch (IndexOutOfBoundsException ex) {
     *        System.out.println("Массив выходит за пределы своего размера!");
     *    }
     * }
     * public static void printSum(Integer a, Integer b) throws FileNotFoundException {
     *    System.out.println(a + b);
     * }
     * 
     */

    // В объявлении метода main нельзя использовать trhows
    public static void main(String[] args) {//throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArithmeticException ex) { // Добавим обработку деления на ноль
            System.out.println("Делить на ноль нельзя!");
        } catch (NullPointerException ex) { // Эта обработка не обязательна
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) { // Самая общая обработка должна быть в конце
            System.out.println("Что-то пошло не так...");
        }
    }

    // В этом методе нет операций с файлами
    public static void printSum(Integer a, Integer b) {//throws FileNotFoundException {
        System.out.println(a + b);
    }
}
