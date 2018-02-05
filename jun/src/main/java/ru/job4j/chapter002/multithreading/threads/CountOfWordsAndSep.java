package ru.job4j.chapter002.multithreading.threads;

/**
 * This class describes simple multithreading task.
 *
 * @author Kutsyih Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 06.02.2018
 */
public class CountOfWordsAndSep {
    /**
     * method print count of words of the text.
     *
     * @param text is input text
     */
    private void countOfWords(String text) {
        int words = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }
        words++;
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count of words - " + words);
    }

    /**
     * method count of separators of the text.
     *
     * @param text is input text
     * @param separator is input separator we need to count
     */
    private void countOfSeparators(String text, char separator) {
        int sep = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == separator) {
                sep++;
            }
        }
        System.out.println("count of separator - " + sep);
    }

    /**
     * main method to start the program.
     *
     * @param args is input arguments
     */
    public static void main(String[] args) {
        CountOfWordsAndSep counter = new CountOfWordsAndSep();
        String text = "this is the simple text.";

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.countOfWords(text);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.countOfSeparators(text, ' ');
            }
        }).start();

        System.out.println("main thread");
    }
}
