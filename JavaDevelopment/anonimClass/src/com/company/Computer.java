package com.company;

public class Computer {
    class Processor {
        private boolean isStart = false;

        public void start() {
            isStart = true;
        }

        public void shutdown() {
            isStart = false;
        }
    }

    class RAM {
        private boolean isStart = false;

        public void start() {
            isStart = true;
            System.out.println("isStart = " + isStart);
        }

        public void shutdown() {
            isStart = false;
            System.out.println("isStart = " + isStart);
        }
    }

    Processor i7 = new Processor();
    RAM transfer = new RAM();
}
























