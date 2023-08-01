package Exceptions.Seminar_02.Task_02;

public class Main {
    /*
     * try {
     *    int d = 0;
     *    double catchedRes1 = intArray[8] / d;
     *    System.out.println("catchedRes1 = " + catchedRes1);
     * } catch (ArithmeticException e) {
     *    System.out.println("Catching exception: " + e);
     * }
     */
    public static void main(String[] args) {
        /*
         * Здесь деление на 0 и обращение к элементу массива.
         * В данном случае оптимальней сделать проверку через if 
         */

        int d = 0;
        int index = 8;
        int[] intArray = {23, 34, 5, 32, 456, 87};
        if (d != 0){
            if (index < intArray.length){
                double catchedRes1 = intArray[index] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
            } else{
                System.out.println("Индекс за пределами массива");
            }   
        } else{
            System.out.println("Делить на 0 нельзя");
        }
    
    }
}
