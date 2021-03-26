package com.practica1.morse.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InvalidPropertiesFormatException;
import java.util.Set;

@Data
@NoArgsConstructor
@Setter
public class Morse {

    private StringBuilder morseCode;
    private String original;

    public Morse(String code){
        this.original = code;
    }

    public static Hashtable<String, String> getMorse() {
        Hashtable<String, String> morse = new Hashtable<>();
        morse.put("A", ".-");
        morse.put("B", "-...");
        morse.put("C", "-.-.");
        morse.put("CH", "----");
        morse.put("D", "-..");
        morse.put("E", ".");
        morse.put("F", "..-.");
        morse.put("G", "--.");
        morse.put("H", "....");
        morse.put("I", "..");
        morse.put("J", ".---");
        morse.put("K", "-.-");
        morse.put("L", ".-..");
        morse.put("M", "--");
        morse.put("N", "-.");
        morse.put("Ñ", "--.--");
        morse.put("O", "---");
        morse.put("P", ".--.");
        morse.put("Q", "--.-");
        morse.put("R", ".-.");
        morse.put("S", "...");
        morse.put("T", "-");
        morse.put("U", "..-");
        morse.put("V", "...-");
        morse.put("W", ".--");
        morse.put("X", "-..-");
        morse.put("Y", "-.--");
        morse.put("Z", "--..");
        morse.put("0", "-----");
        morse.put("1", ".----");
        morse.put("2", "..---");
        morse.put("3", "...--");
        morse.put("4", "....-");
        morse.put("5", ".....");
        morse.put("6", "-....");
        morse.put("7", "--...");
        morse.put("8", "---..");
        morse.put("9", "----.");
        morse.put(".", ".-.-.-");
        morse.put(",", "--..--");
        morse.put(":", "---...");
        morse.put("?", "..--..");
        morse.put("'", ".----.");
        morse.put("-", "-....-");
        morse.put("/", "-..-.");
        morse.put("\"", ".-..-.");
        morse.put("@", ".--.-.");
        morse.put("=", "-...-");
        morse.put("!", "−.−.−−");
        return morse;
    }

    private boolean isValid(String code) {
        return code.matches("[.-]{1,5}(?> [.-]{1,5})*(?>   [.-]{1,5}(?> [.-]{1,5})*)*");

    }

    public static String morseCharacter(String searchMorse) {
        Hashtable<String, String> equivalences = getMorse();
        Set<String> keys = equivalences.keySet();
        for (String key : keys) {
            String morse = equivalences.get(key);
            if (morse.equals(searchMorse)) {
                return key;
            }
        }
        return "";
    }

    public void decodeMorse() throws Exception {
        try {
            if(isValid(this.original)) {
                StringBuilder character = new StringBuilder();
                StringBuilder word = new StringBuilder();
                StringBuilder phrase = new StringBuilder();
                int count = 0;

                for (int i = 0; i < this.original.length(); i++) {
                    if (this.original.charAt(i) != ' ') {
                        character.append(this.original.charAt(i));
                        if (count > 0) count = 0;
                    } else {
                        word.append(morseCharacter(character.toString()));
                        character = new StringBuilder();
                        count++;
                    }

                    if (count == 3) {
                        phrase.append(word).append(" ");
                        word = new StringBuilder();
                        count = 0;
                    }
                }
                word.append(morseCharacter(character.toString()));
                phrase.append(word);
                this.morseCode = phrase;
            }
        } catch (Exception e) {
            throw new Exception("Datos invalidos");
        }
    }
}
