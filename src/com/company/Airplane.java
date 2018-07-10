package com.company;

import java.util.ArrayList;

public class Airplane {
    private ArrayList<AirplaneEngine> airplaneEngines = new ArrayList<>();
    private static int countEngines = 0;
    boolean isReadyToFly = true;

    public void addEngine(){
        airplaneEngines.add(new AirplaneEngine(++countEngines));
    }

    public void startAirplane(){
        for (AirplaneEngine aE: airplaneEngines
             ) {
            aE.startEngine();
        }
        if (isReadyToFly){
            System.out.println("Airplane is flying!");
        }else {
            System.out.println("Aiplane need to be repaired!");
        }

    }

    public void stopAirplane(){
        for (AirplaneEngine aE: airplaneEngines
                ) {
            aE.stopEngine();
            aE.setWorking((int) (Math.random()*10) > 2);
        }
    }

    public void repairAirplane(){
        if (!isReadyToFly) {
            for (AirplaneEngine eE : airplaneEngines
                    ) {
                eE.setWorking(true);
            }
            isReadyToFly = true;
            System.out.println("Airplan was repaired!");
        }else {
            System.out.println("Airplane doesn't need to be repaired!");
        }


    }

    class AirplaneEngine implements IEngine{
        private int engineNumber;
        private boolean isRunning;
        private boolean isWorking;

        public AirplaneEngine(int engineNumber) {
            this.engineNumber = engineNumber;
            this.isRunning = false;
            this.isWorking = true;
        }

        @Override
        public void startEngine() {
            if (!isRunning){
                if(isWorking) {
                    isRunning = true;
                    System.out.println("AirplaneEngine #" + engineNumber + " is running!");
                } else {
                    System.out.println("There is a problem with engine #" + engineNumber + ". AirplaneEngine cannot start.");
                    isReadyToFly = false;
                }
            } else {
                System.out.println("AirplaneEngine #" + engineNumber + " is already running!");
            }
        }

        @Override
        public void stopEngine() {
            isRunning = false;
            System.out.println("AirplaneEngine #" + engineNumber + " has been stopped!");
        }


        public void setWorking(boolean working) {
            isWorking = working;
        }


        class Engine implements IEngine{

            @Override
            public void startEngine() {
                System.out.println("Engine Started");
            }

            @Override
            public void stopEngine() {
                System.out.println("Engine stopped");
            }
        }
    }
}
