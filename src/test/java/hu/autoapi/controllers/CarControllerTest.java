package hu.autoapi.controllers;

import hu.autoapi.domain.Car;
import hu.autoapi.dto.NewCarRequest;
import hu.autoapi.services.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    @Test
    public void testGetCars() {
        // Arrange
        List<Car> expectedCarsList = Arrays.asList(
                new Car(),
                new Car()
        );
        when(carService.getCarsList()).thenReturn(expectedCarsList);

        // Act
        List<Car> actualCarsList = carController.getCars();

        // Assert
        assertEquals(expectedCarsList, actualCarsList);
    }

    @Test
    public void testGetCarsId() {
        // Arrange
        int id = 1;

        // Act
        carController.getCar(id);

        // Assert
        verify(carService, times(1)).getCar(id);
    }

    @Test
    public void testGetCarsRendszam() {
        // Arrange
        String rendszam = "JSN901";

        // Act
        carController.getCarByRendszam(rendszam);

        // Assert
        verify(carService, times(1)).getCarByRendszam(rendszam);
    }

    @Test
    public void testAddCars() {
        // Arrange
        NewCarRequest newCarRequest = new NewCarRequest();

        // Act
        carController.addCars(newCarRequest);

        // Assert
        verify(carService, times(1)).addCars(newCarRequest);
    }

    @Test
    public void testUpdateCars_shouldCallUpdateRendszamMethodInServiceWithGivenIdAndRendszam() {
        // Arrange
        int id = 1;
        String rendszam = "XYZ789";
        Car cars = new Car();
        cars.setRendszam(rendszam);

        // Act
        carController.updateCar(id, cars);

        // Assert
        verify(carService, times(1)).updateRendszam(eq(id), eq(rendszam));
    }

    @Test
    public void testDeleteCars_shouldCallDeleteCarsMethodInServiceWithGivenId() {
        // Arrange
        int id = 1;

        // Act
        ResponseEntity<String> response = carController.deleteCar(id);

        // Assert
        verify(carService, times(1)).deleteCar(eq(id));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Car delete successfully.", response.getBody());
    }
}