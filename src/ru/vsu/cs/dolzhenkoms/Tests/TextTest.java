package ru.vsu.cs.dolzhenkoms.Tests;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.dolzhenkoms.Text;
import ru.vsu.cs.dolzhenkoms.Utils.ArrayUtils;
import ru.vsu.cs.dolzhenkoms.Utils.FileManager;

import java.io.IOException;

public class TextTest {
    @Test
    public void getLongestSentence1() throws IOException {
        Text text = new Text(ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile("src/ru/vsu/cs/dolzhenkoms/Tests/TestFiles/test1.txt"))));
        String expectedSentence = ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile("src/ru/vsu/cs/dolzhenkoms/Tests/TestFiles/answer1.txt")));


        Assert.assertEquals(text.getLongestSentence(), expectedSentence);
    }

    @Test
    public void getLongestSentence2() throws IOException {
        Text text = new Text(ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile("src/ru/vsu/cs/dolzhenkoms/Tests/TestFiles/test2.txt"))));
        String expectedSentence = ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile("src/ru/vsu/cs/dolzhenkoms/Tests/TestFiles/answer2.txt")));


        Assert.assertEquals(text.getLongestSentence(), expectedSentence);
    }

    @Test
    public void getLongestSentence3() throws IOException {
        Text text = new Text(ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile("src/ru/vsu/cs/dolzhenkoms/Tests/TestFiles/test3.txt"))));
        String expectedSentence = ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile("src/ru/vsu/cs/dolzhenkoms/Tests/TestFiles/answer3.txt")));


        Assert.assertEquals(text.getLongestSentence(), expectedSentence);
    }

    @Test
    public void getLongestSentence4() throws IOException {
        Text text = new Text(ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile("src/ru/vsu/cs/dolzhenkoms/Tests/TestFiles/test4.txt"))));
        String expectedSentence = ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile("src/ru/vsu/cs/dolzhenkoms/Tests/TestFiles/answer4.txt")));


        Assert.assertEquals(text.getLongestSentence(), expectedSentence);
    }
}
