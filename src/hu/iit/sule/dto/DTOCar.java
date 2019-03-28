package hu.iit.sule.dto;

import hu.iit.sule.model.Car;

import java.util.ArrayList;

public class DTOCar {

    private ArrayList<Car> cars;

    public ArrayList<Car> getCars(){
        cars = new ArrayList<>();
        Car car1 = new Car("1","Brand",1999,"color",12312,true);
        Car car2 = new Car("2","Brand",1999,"color",12312,true);
        Car car3 = new Car("3","Brand",1999,"color",12312,true);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        return cars;
    }

}
