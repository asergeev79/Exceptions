package Exceptions.Seminar_03;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Record {
    private String lastname;
    private String name;
    private String fathername;
    private Date birthdate;
    private long phone;
    private char gender;

    private static final int COUNT_PARAMS = 6;
    private static final String REGEXP_NAME = "^[A-Z][a-z]*$";
    private static final String REGEXP_DATE = "^\\d{2}\\.\\d{2}\\.\\d{4}$";
    private static final String REGEXP_NUMBER = "^\\d+$";
    private static final String REGEXP_GENDER = "^[fm]$";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.mm.yyyy");

    public Record(Map<String,String> map) {
        this.lastname = map.get("lastname");
        this.name = map.get("name");
        this.fathername = map.get("fathername");
        try {
            this.birthdate = DATE_FORMAT.parse(map.get("birthdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.phone = Long.parseLong(map.get("phone"));
        this.gender = map.get("gender").charAt(0);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.lastname);
        sb.append(" ");
        sb.append(this.name);
        sb.append(" ");
        sb.append(this.fathername);
        sb.append(" ");
        sb.append(DATE_FORMAT.format(this.birthdate));
        sb.append(" ");
        sb.append(this.phone);
        sb.append(" ");
        sb.append(this.gender);
        return sb.toString();
    }

    public void writeToFile(){
        try(FileWriter fw = new FileWriter(this.lastname, true)){
            fw.write(this.toString() + "\n");
            fw.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static Map<String,String> getData(String message){
        boolean isCorrect = false;
        Map<String,String> map = new HashMap<>();

        while (!isCorrect){
            try {
                String input = readFromConsole(message);
                String[] params = splitData(input);
                map = arrayToMap(params);
                isCorrect = true;
            } catch (WrongLengthStringException e) {
                System.out.println(e.getMessage());
            } catch (WrongCountParamsException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCount());
            } catch (ParsePersonException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return map;
    }

    public static Map<String,String> getData(){
        return getData("");
    }

    private static String readFromConsole(String message) throws WrongLengthStringException, IOException{
        System.out.println(message);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = br.readLine();
        if (str.isEmpty() || str == null){
            throw new WrongLengthStringException("Пустая строка", 0);
        }
        return str;
    }

    private static String[] splitData(String data){
        String[] params = data.split(" ");
        int countParams = checkCountParams(params);
        if (countParams != 0){
            throw new WrongCountParamsException("Количество параметров записи неверно", countParams + COUNT_PARAMS);
        }
        return params;
    }

    private static int checkCountParams(String[] data){
        return data.length - COUNT_PARAMS;
    }

    private static Map<String,String> arrayToMap(String[] params) throws ParsePersonException{
        if (!isParseCorrect(params[0], REGEXP_NAME)) throw new ParsePersonException("Неверный формат фамилии\nЛатиницей, первая буква заглавная", 0);
        if (!isParseCorrect(params[1], REGEXP_NAME)) throw new ParsePersonException("Неверный формат имени\nЛатиницей, первая буква заглавная", 1);
        if (!isParseCorrect(params[2], REGEXP_NAME)) throw new ParsePersonException("Неверный формат отчества\n Латиницей, первая буква заглавная", 2);
        if (!isParseCorrect(params[3], REGEXP_DATE)) throw new ParsePersonException("Неверный формат даты\n dd.mm.yyyy", 3);
        if (!isParseCorrect(params[4], REGEXP_NUMBER)) throw new ParsePersonException("Неверный формат номера\nТолько цифры", 4);
        if (!isParseCorrect(params[5], REGEXP_GENDER)) throw new ParsePersonException("Неверный формат пола\nлибо символ f, либо m", 5);
        Map<String,String> map = new HashMap<>();
        map.put("lastname", params[0]);
        map.put("name", params[1]);
        map.put("fathername", params[2]);
        map.put("birthdate", params[3]);
        map.put("phone", params[4]);
        map.put("gender", params[5]);
        return map;
    }

    private static boolean isParseCorrect(String param, String regexpString){
        return param.matches(regexpString);
    }    
}
