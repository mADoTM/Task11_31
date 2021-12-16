package ru.vsu.cs.dolzhenkoms;

import ru.vsu.cs.dolzhenkoms.Utils.ArrayUtils;
import ru.vsu.cs.dolzhenkoms.Utils.FileManager;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private String inputFile;
    private String outputFile;

    private ConsoleCommand status = ConsoleCommand.Help;

    public void run() throws IOException {
        switch(status) {
            case Help:
                executeHelpCommand();
                parseArgsFromString();
                break;
            case Exit:
                executeExitCommand();
                break;
            case Error:
                executeErrorCommand();
                break;
            case RunLogic:
                executeRunLogicCommand();
                break;
        }
        run();
    }

    private void parseArgsFromString() {
        System.out.println("Введите команду, которая указана в справке:");
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        String[] args = line.split(" ");

        if(args.length == 0) {
            status = ConsoleCommand.Error;
            return;
        }

        for(int i = 0; i < args.length; i++) {
            if(args[0].equals("--help")) {
                status = ConsoleCommand.Help;
                return;
            }
            if(args[0].equals("--exit")) {
                status = ConsoleCommand.Exit;
                return;
            }
            if(args[i].startsWith("--input-file=")) {
                inputFile = args[i].replace("--input-file=","");
            }
            else if(args[i].startsWith("--output-file=")) {
                outputFile = args[i].replace("--output-file=","");
            }
            else {
                status = ConsoleCommand.Error;
                return;
            }
        }
        if(inputFile != null && outputFile != null) {
            status = ConsoleCommand.RunLogic;
        }
    }

    private void executeHelpCommand() {

        System.out.println("Справка:");
        System.out.println("--help              Справка");
        System.out.println("--exit              Выход из программы");
        System.out.println("--input-file=       Название файла-ввода");
        System.out.println("--output-file=      Название файла-вывода");
    }

    private void executeExitCommand() {
        System.out.println("Выход из программы...");
        System.exit(0);
    }

    private void executeErrorCommand() {
        System.out.println("Вы ввели неправильный формат аргументов, повторите заново.");

        status = ConsoleCommand.Help;
    }

    private void executeRunLogicCommand() throws IOException {
        String fileText = ArrayUtils.concatStringArrayToString(ArrayUtils.toPrimitive(FileManager.readAllLinesFromFile(inputFile)));

        Text text = new Text(fileText);

        String longestSentence = text.getLongestSentence();
        System.out.println(longestSentence);

        FileManager.createFileWithText(outputFile, longestSentence);

        status = ConsoleCommand.Exit;
    }
}
