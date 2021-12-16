package ru.vsu.cs.dolzhenkoms;

import ru.vsu.cs.dolzhenkoms.Utils.ArrayUtils;

import java.util.*;

public class Text {
    private String text;
    private String[] sentences;

    public Text(String text) {
        this.text = text;
        sentences = splitTextForSentences();
    }

    public String getLongestSentence() {
        int indexLongestSentence = 0; int maxLength = 1;

        for(int i = 0; i < sentences.length; i++) {
            int currentLength = getCountWordsInSentence(sentences[i]);
            if(currentLength > maxLength) {
                maxLength = currentLength;
                indexLongestSentence = i;
            }
        }

        return sentences[indexLongestSentence];
    }

    private String[] splitTextForSentences() {
        return ArrayUtils.toPrimitive(Arrays.stream(this.text.split("([.!?])+")).map(s -> s.toString().trim()).toArray());
    }

    private int getCountWordsInSentence(String str) {
        return ArrayUtils.toPrimitive(Arrays.stream(str.split("(\\s|[,:;])+")).map(s -> s.toString()).toArray(), false).length;
    }
}
