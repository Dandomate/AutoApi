package hu.autoapi.controllers;

import java.util.List;

import hu.autoapi.domain.Cars;
import hu.autoapi.dto.NewCarRequest;
import hu.autoapi.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping("/cars")
    public List<Cars> getCars() {
        return service.getCarsList();
    }

    @GetMapping("/cars/{id}")
    public Cars getCars(@PathVariable("id") int id) {
        return service.getCars(id);
    }

    @GetMapping("/cars/rendszam/{rendszam}")
    public Cars getCarsRendszam(@PathVariable("rendszam") String rendszam) {
        return service.getCarsRendszam(rendszam);
    }

    @PatchMapping("/cars/update/rendszam/{id}")
    public Cars updateCars(@PathVariable("id") int id, @RequestBody Cars cars) {
        String rendszam = cars.getRendszam();
        return service.updateRendszam(id, rendszam);
    }

    @DeleteMapping("/cars/delete/{id}")
    public ResponseEntity<String> deleteCars(@PathVariable("id") int id) {
        service.deleteCars(id);
        return ResponseEntity.ok("Car delete successfully.");
    }

    @PostMapping("/cars/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Cars addCars(@RequestBody NewCarRequest newCarRequest) {
        return service.addCars(newCarRequest);
    }
}
