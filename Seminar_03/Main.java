package Exceptions.Seminar_03;

public class Main {
    /*
     * ФИО вводятся латиницей
     */
    public static void main(String[] args) {
        Record person = new Record(Record.getData("Введите данные человека:"));
        person.writeToFile();
    }
}
