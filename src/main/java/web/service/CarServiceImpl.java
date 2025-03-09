package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    private final ArrayList<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Tesla", "silver", 2022));
        cars.add(new Car("Toyota", "black", 2001));
        cars.add(new Car("Nissan", "silver", 2005));
        cars.add(new Car("Volvo", "yellow", 2015));
        cars.add(new Car("Reno", "black", 2017));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0 || count >= 5) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
