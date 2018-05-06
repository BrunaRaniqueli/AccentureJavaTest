package com.accenture.javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KingSort
{
    public static final String DELIMITER = " ";

    public String[] getSortedList(String[] kings){
        if (kings == null || kings.length == 0) {
            System.out.println("Kings possui valor nulo ou está vazio.");
            return kings;
        }
        List<String> kingsList = Arrays.asList(kings);
        if (validateKingsList(kingsList)){
            List<String> kingsNames = sortKingsNames(kingsList);
            return kingsNames.toArray(new String[0]);
        }
        System.out.println("Kings não está no formato esperado.");
        return kings;
    }

    private boolean validateKingsList(List<String> kingsList) {
        for(int i=0; i < kingsList.size(); i++){
            String s = kingsList.get(i);
            if (s == null){
                System.out.println(String.format("Erro na posicao %s. O valor é nulo.", i + 1));
                return false;
            }
            if (!s.contains(DELIMITER)){
                System.out.println(String.format("Erro na posicao %s. O valor não possui espaço.", i + 1));
                return false;
            }
            if (s.indexOf(DELIMITER) != s.lastIndexOf(DELIMITER)){
                System.out.println(String.format("Erro na posicao %s. O valor possui mais de um espaço.", i + 1));
                return false;
            }
            if (s.indexOf(DELIMITER) == 0){
                System.out.println(String.format("Erro na posicao %s. O valor não possui o nome do rei.", i + 1));
                return false;
            }

            if (s.indexOf(DELIMITER) == s.length() - 1){
                System.out.println(String.format("Erro na posicao %s. O valor não possui numeral romano.", i + 1));
                return false;
            }

            String o = s.split(DELIMITER)[1];
            if (convertRomanNumeralToOrdinal(o) == 0){
                System.out.println(String.format("Erro na posicao %s. Não foi possível converter o numeral romano.", i + 1));
                return false;
            }
        }
        return true;
    }

    private static List<String> sortKingsNames(List<String> kingsNames){
        List<String> kings = new ArrayList<>(kingsNames);
        kings.sort((s1, s2)->{
            String[] strings1 = s1.split(DELIMITER);
            String[] strings2 = s2.split(DELIMITER);

            String kingName1 = strings1[0];
            String kingName2 = strings2[0];

            int compare = kingName1.compareTo(kingName2);
            if(compare != 0){
                return compare;
            }
            int ordinal1 = convertRomanNumeralToOrdinal(strings1[1]);
            int ordinal2 = convertRomanNumeralToOrdinal(strings2[1]);
            return ordinal1 - ordinal2;

        });
        return kings;
    }

    private static int convertRomanNumeralToOrdinal(String romanNumeral) {
        int n = 0;
        int rightNumeral = 0;
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            int value = (int) convertRomanNumeralToOrdinal(romanNumeral.charAt(i));
            if(value == 0) return 0;
            n += value * Math.signum(value + 0.5 - rightNumeral);
            rightNumeral = value;
        }
        return n;
    }
    private static double convertRomanNumeralToOrdinal(char character) {
        return Math.floor(Math.pow(10, "IXCM".indexOf(character))) + 5 * Math.floor(Math.pow(10, "VLD".indexOf(character)));
    }
}
