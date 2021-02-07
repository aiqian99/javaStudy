package design_patterns.creational.builder.builders;

import design_patterns.creational.builder.cars.CarType;
import design_patterns.creational.builder.cars.Manual;
import design_patterns.creational.builder.components.Engine;
import design_patterns.creational.builder.components.GPSNavigator;
import design_patterns.creational.builder.components.Transmission;
import design_patterns.creational.builder.components.TripComputer;

/**
 * 汽车手册生成器
 * @date 2021/2/5
 */
public class CarManualBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult() {
        return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
