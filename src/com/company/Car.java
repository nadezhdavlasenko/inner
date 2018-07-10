package com.company;

public class Car {
    CarEngine carEngine;

    public void setCarEngine(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public static CarEngine newCarEngine(){
        return new CarEngine((int) (Math.random()*8999 + 1000));
    }

    public void run(){
        carEngine.startEngine();
        System.out.println("Car rides");
    }

    public void stop(){
        carEngine.stopEngine();
        System.out.println("Car stopped");
    }

    private static class CarEngine implements IEngine{
        private int engineNumber;
        private boolean isRunning;
        private boolean isWorking;

        public CarEngine(int engineNumber) {
            this.engineNumber = engineNumber;
            this.isRunning = false;
            this.isWorking = true;
        }

        @Override
        public void startEngine() {
            if (!isRunning){
                if(isWorking) {
                    isRunning = true;
                    System.out.println("CarEngine #" + engineNumber + " is running!");
                } else {
                    System.out.println("There is a problem with engine #" + engineNumber + ". CarEngine cannot start.");
                    //isReadyToRide = false;
                }
            } else {
                System.out.println("CarEngine #" + engineNumber + " is already running!");
            }
        }

        @Override
        public void stopEngine() {
            isRunning = false;
            System.out.println("CarEngine #" + engineNumber + " has been stopped!");
        }

        abstract class Engine implements IEngine{

        }
    }
}
