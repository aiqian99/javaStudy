package design_patterns.creational.builder;

import design_patterns.creational.builder.builders.CarBuilder;
import design_patterns.creational.builder.builders.CarManualBuilder;
import design_patterns.creational.builder.cars.Car;
import design_patterns.creational.builder.cars.Manual;
import design_patterns.creational.builder.director.Director;

/**
 * @author snail
 * @date 2021/2/5
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        System.out.println("Car built:" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
