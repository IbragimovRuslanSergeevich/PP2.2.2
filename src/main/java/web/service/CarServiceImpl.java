package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", 5, "black"));
        carList.add(new Car("Audi", 2, "white"));
        carList.add(new Car("Kia", 8, "pink"));
        carList.add(new Car("Toyota", 1, "yellow"));
        carList.add(new Car("Lada", 99, "gray"));
    }

    @Override
    public List<Car> getCountCars(int count) {
        if (count >= 5) {
            return carList;
        }
        if (count <= 0) {
            return null;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
