package ru.vsu.cs.pavlenkodm;

import java.util.Objects;

public class Date {
    public static String sum(String strDate1, String strDate2) throws Exception {
        int date1 = parsingString(strDate1);
        int date2 = parsingString(strDate2);
        int date3 = date1 + date2;
        return formatting(date3,"ДД.ММ.ГГГГ");
    }

    public static String difference(String strDate1, String strDate2) throws Exception {
        int date1 = parsingString(strDate1);
        int date2 = parsingString(strDate2);
        int date3=0;
        if (date1 > date2) {
            date3 = date1 - date2;
        } else {
            date3 = date2 - date1;
        }
        return formatting(date3,"ДД.ММ.ГГГГ");
    }

    public static boolean comparison(String strDate1, String strDate2) throws Exception {// Проверяем на схожесть дат
        int date1 = parsingString(strDate1);
        int date2 = parsingString(strDate2);
        return date1 == date2;
    }

    public static String formatting(int date, String pattern) {//форматирование дат по шаблону
        int[] arr = new int[3];
        arr[2]=date/365;
        date=date%365;
        int k=0;
        while(date>30){
            if(k%2==0){
                arr[1]+=1;
                k++;
                date-=31;
            }else{
                arr[1]+=1;
                k++;
                date-=30;
            }
        }

        arr[0]=date;
        String str="";String str1="";String str2="";String str3="";
        if(arr[0]<10){//Проверяем, сколько надо записать нулей перед числами для шаблона
            str1+="0";
        }
        if(arr[1]<10){
            str2+="0";
        }
        if(arr[2]<1000){
            str3+="0";
        }
        if(arr[2]<100){
            str3+="0";
        }
       if((Objects.equals(pattern, "ДД.ММ.ГГГГ"))||(Objects.equals(pattern, "DD.MM.YYYY"))){
            str=str1+arr[0]+"."+str2+arr[1]+"."+str3+arr[2];
       }else if((Objects.equals(pattern, "ДД.ММ"))||(Objects.equals(pattern, "DD.MM"))){
            str=str1+arr[0]+"."+str2+arr[1];
       }else if((Objects.equals(pattern, "ММ.ДД.ГГГГ"))||(Objects.equals(pattern, "MM.DD.YYYY"))){
            str=str2+arr[1]+"."+str1+arr[0]+"."+str3+arr[2];
       }
       return str;
    }

    public static int parsingString(String strDate) throws Exception{ //этот метод делает разбор даты из строки и представляет дату в виде целого числа дней
        String[] subStr;
        int numberDate = 0;
        String delimeter = "\\."; // Разделитель
        subStr = strDate.split(delimeter); // Разделения строки
        if ((subStr.length != 3)||(!subStr[0].matches("[-+]?\\d+"))||(!subStr[1].matches("[-+]?\\d+"))||(!subStr[2].matches("[-+]?\\d+"))) {
            throw new Exception("Неправильное указание даты");
        }
            int[] arr = new int[3];//создаём массив для хранения чисел из строки
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(subStr[i].trim());//переводим строки в int для операций над ними
            }
        if (arr[0]>31||arr[1]>12) {
            throw new Exception("Неправильное указание даты");
        }
            if (arr[1] % 2 == 1) {//Так как в месяце может быть 30 дней или 31, мы проверяем, какой месяц: четный или нечетный
                numberDate = arr[0] + 31 * ((arr[1] / 2) + 1) + 30 * (arr[1] / 2) + 365 * arr[2];
            } else {
                numberDate = arr[0] + 30 * (arr[1] / 2) + 31 * (arr[1] / 2) + 365 * arr[2];
            }



        return numberDate;
    }
}
