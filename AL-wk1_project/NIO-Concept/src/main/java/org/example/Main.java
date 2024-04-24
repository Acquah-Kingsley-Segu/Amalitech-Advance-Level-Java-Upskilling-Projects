package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputStream = new Scanner(System.in);
        String prompt;

        File inputFile = new File(args[0]);
        if (!inputFile.exists() || inputFile.isDirectory()){
            do {
                System.out.printf("%n%nFile provided(%s) does not exist.%nDo you want to use our default file (y/n).%n", inputFile.getAbsolutePath());
                System.out.print("$: ");
                prompt = inputStream.nextLine();
                if (prompt.equalsIgnoreCase("y")) {
                    inputFile = new File("../reader_file.txt");
                    break;
                }
                else if (prompt.equalsIgnoreCase("n"))
                    break;
                else {
                    inputStream.reset();
                }
            }while (true);
        }

        File outputFile = new File(args[1]);

        System.out.println();
        try(FileChannel inputChannel = FileChannel.open(inputFile.toPath(), StandardOpenOption.READ)){
            ByteBuffer inputBuffer = ByteBuffer.allocate(200);

            try(FileChannel outputChannel = FileChannel.open(outputFile.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
                int bytesReadInBuffer;

                do {
                    bytesReadInBuffer = inputChannel.read(inputBuffer);
                    if (bytesReadInBuffer > 0){
                        inputBuffer.flip();
                        while (inputBuffer.hasRemaining()){
                            outputChannel.write(inputBuffer);
                        }
                        inputBuffer.clear();
                    }
                }while (bytesReadInBuffer > 0);
            }catch (NoSuchFileException exception){
                System.err.printf("Oops something went wrong%n\tProblem => %s%n", exception);
            }
            System.out.printf("File copied from (%s) into (%s) successfully.%n", inputFile.getName(), outputFile.getName());

        } catch (IOException exception) {
            System.err.printf("Oops something went wrong%n\tProblem => %s%n", exception);
        }
    }
}