package hu.autoapi.services;

import java.util.List;
import java.util.Optional;

import hu.autoapi.domain.Car;
import hu.autoapi.dto.NewCarRequest;
import hu.autoapi.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CarService {

    @Autowired
    private CarsRepository repository;

    public List<Car> getCarsList() {
        return repository.nativeFindCars();
    }

    public Car getCar(int id) {
        Optional<Car> cars = repository.findById(id);
        if (cars.isPresent()) {
            return cars.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Car getCarByRendszam(String rendszam) {
        Optional<Car> cars = repository.findCarsRendszam(rendszam);
        if (cars.isPresent()) {
            return cars.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public void deleteCar(int id) {
        Optional<Car> optionalCars = repository.findById(id);
        if (optionalCars.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Car updateRendszam(int id, String rendszam) {
        Optional<Car> optionalCars = repository.findById(id);
        if (optionalCars.isPresent()) {
            Car cars = optionalCars.get();
            cars.setRendszam(rendszam);
            return repository.save(cars);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Car addCars(NewCarRequest newCarRequest) {
        Car cars = newCarRequest.toCar();
        return repository.save(cars);
    }
}
