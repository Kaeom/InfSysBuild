package hu.iit.sule.service;

import hu.iit.sule.dto.DTOCar;
import hu.iit.sule.model.Car;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {


    public List<Car> createCars(int size) {
        List<Car> list;
        DTOCar dtoCar = new DTOCar();
        list = dtoCar.getCars();

        return list;
    }

}