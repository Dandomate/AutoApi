package hu.autoapi.services;

import java.util.List;
import java.util.Optional;

import hu.autoapi.domain.Cars;
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

    public List<Cars> getCarsList() {
        return repository.nativeFindCars();
    }

    public Cars getCars(int id) {
        Optional<Cars> cars = repository.findById(id);
        if (cars.isPresent()) {
            return cars.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Cars getCarsRendszam(String rendszam) {
        Optional<Cars> cars = repository.findCarsRendszam(rendszam);
        if (cars.isPresent()) {
            return cars.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public void deleteCars(int id) {
        Optional<Cars> optionalCars = repository.findById(id);
        if (optionalCars.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Cars updateRendszam(int id, String rendszam) {
        Optional<Cars> optionalCars = repository.findById(id);
        if (optionalCars.isPresent()) {
            Cars cars = optionalCars.get();
            cars.setRendszam(rendszam);
            return repository.save(cars);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Cars addCars(NewCarRequest newCarRequest) {
        Cars cars = newCarRequest.toCar();
        return repository.save(cars);
    }
}
