package com.company;

public class Main {
    public static void testAirplane(){
        Airplane airplane = new Airplane();
        Airplane.AirplaneEngine airplaneEngine = airplane.new AirplaneEngine(0);
        airplaneEngine.startEngine();
        airplaneEngine.stopEngine();
        airplane.addEngine();
        airplane.addEngine();
        airplane.addEngine();
        airplane.addEngine();
        airplane.startAirplane();
        airplane.stopAirplane();
        airplane.startAirplane();
        airplane.repairAirplane();
        airplane.startAirplane();
        airplane.repairAirplane();
        airplane.stopAirplane();
    }
    public static void testCar(){
        IEngine carEngine = Car.newCarEngine();
        carEngine.startEngine();
        carEngine.stopEngine();
        Car car = new Car();
        car.setCarEngine(Car.newCarEngine());
        car.run();
        car.stop();
    }
    public static void testInnerEngine(){
        Airplane.AirplaneEngine.Engine engine = new Airplane().new AirplaneEngine(12345).new Engine();
        engine.startEngine();
        engine.stopEngine();

    }

    public static void main(String[] args) {
        testAirplane();
        testInnerEngine();
        testCar();
    }
}
