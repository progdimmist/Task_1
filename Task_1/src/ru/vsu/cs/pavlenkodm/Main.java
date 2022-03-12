package ru.vsu.cs.pavlenkodm;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("**********ПРОВЕРКА НА СЛОЖЕНИЕ ДАТ**********");
        System.out.println("02.05.1901 + 21.04.2022 = "+Date.sum("02.05.1901","21.04.2022"));
        System.out.println("24.01.1921 + 08.03.1082 = "+Date.sum("24.01.1921","08.03.1082"));
        System.out.println();

        System.out.println("**********ПРОВЕРКА НА РАЗНОСТЬ ДАТ**********");
        System.out.println("21.04.2021 - 18.02.0022 = "+Date.difference("21.04.2021","18.02.0022"));
        System.out.println("24.09.1981 - 28.04.1902 = "+Date.difference("24.09.1981","28.04.1902"));
        System.out.println();

        System.out.println("**********ПРОВЕРКА НА СХОЖЕСТЬ ДАТ**********");
        System.out.println("Схожесть дат 02.03.1982 и 02.03.1982: "+Date.comparison("02.03.1982","02.03.1982"));
        System.out.println("Схожесть дат 24.12.2022 и 15.03.0022: "+Date.comparison("04.12.2022","15.03.0022"));
        System.out.println();

        System.out.println("**********ПРОВЕРКА НА ФОРМАТИРОВАНИЕ ДАТ ПО ШАБЛОНУ**********");
        System.out.println("26.04.2021 ~ "+Date.formatting(Date.parsingString("26.04.2021"),"ДД.ММ"));
        System.out.println("26.04.2021 ~ "+Date.formatting(Date.parsingString("26.04.2021"),"ММ.ДД.ГГГГ"));
        System.out.println();

        System.out.println("**********ПРЕОБРАЗОВАНИЕ ДАТ В ЦЕЛОЕ ЧИСЛО ДНЕЙ**********");
        System.out.println("26.04.2021 ~ "+Date.parsingString("26.04.2021")+" дней");
        System.out.println("03.12.821 ~ "+Date.parsingString("03.12.821")+" дней");
    }
}
