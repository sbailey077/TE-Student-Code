package com.techelevator;

import java.io.*;

public class BufferedWriterExample {

    public static void main(String[] args) {

        /*
         * Create a file and PrintWriter
         */
        File newFile = new File("bufferedfile.txt");

        try ( PrintWriter printWriter = new PrintWriter(newFile);
              BufferedWriter bufferedWriter = new BufferedWriter( printWriter )
            ) {
                for (int i = 100; i <= 200; i++) {
                    bufferedWriter.write( String.valueOf(i) );
                    bufferedWriter.newLine();
                }

        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + e.getMessage());
        }

        /*
         * To add buffering a Print Writer is still needed and will still do the writing.
         * A BufferedWriter is added and passed the Print Writer.  The Print Writer will still
         * write to the file and the buffered writer will provide buffering.
         */

    }
}
