package ru.job4j.chapter002.multithreading.threads;

/**
 * This class describes work with interrupts.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id
 * @since 10.02.2018
 */
public class ThreadInterrupt {
    /**
     * This class describes counter of time.
     */
    public static class Time implements Runnable {
        /**
         * parameter time is how long the thread will work until stay interrupt flag.
         */
        private final long time;

        /**
         * constructor of Time class.
         *
         * @param waitingTime is time until interrupt flag will stay
         */
        public Time(final long waitingTime) {
            this.time = waitingTime;
        }

        /**
         * method execute in new thread.
         */
        @Override
        public void run() {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                return;
            } finally {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * This class describes counter of chars in the text.
     */
    public static class CountChar implements Runnable {
        /**
         * parameter contains input text.
         */
        private final String text;
        /**
         * parameter contains count of chars of the text.
         */
        private int length;

        /**
         * constructor of class CountChar.
         *
         * @param text is input text to calculate the count of chars.
         */
        public CountChar(final String text) {
            this.text = text;
        }

        /**
         * method return calculated count of chars of the text.
         *
         * @return integer number
         */
        public int getLength() {
            return length;
        }

        /**
         * method calculate count of chars of the text in new thread.
         */
        @Override
        public void run() {
            for (int i = 0; i < text.length(); i++) {
                length++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * method start the program.
     *
     * @param args input arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Time time = new Time(10000);
        String text = "sf j ds sdfa gagrasfvf rsr v s avdsvsv";
        CountChar chars = new CountChar(text);

        Thread counter = new Thread(chars);
        Thread timer = new Thread(time);

        counter.start();
        timer.start();

        while (counter.isAlive()) {
            if (timer.isInterrupted()) {
                System.out.println("program is interrupt for " + (System.currentTimeMillis() - startTime) + " ms");
                return;
            }
        }
        System.out.println("length of text - " + chars.getLength());
        System.out.println("program ends for " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
