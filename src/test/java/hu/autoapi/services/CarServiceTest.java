package hu.autoapi.services;

import hu.autoapi.domain.Car;
import hu.autoapi.dto.NewCarRequest;
import hu.autoapi.repositories.CarsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarsRepository carsRepository;

    @Test
    public void testGetCars() {
        // Arrange
        int id = 1;
        Car expectedCars = new Car();
        expectedCars.setRendszam("ABC123");
        expectedCars.setMarka("Toyota");
        expectedCars.setModel("Corolla");
        expectedCars.setTipusjel("Sedan");
        expectedCars.setEvjarat(2020);
        expectedCars.setUzemanyag("Benzin");
        expectedCars.setHengerurtartalom(1600);
        expectedCars.setTeljesitmeny(120);

        when(carsRepository.findById(id)).thenReturn(Optional.of(expectedCars));

        // Act
        Car actualCars = carService.getCar(id);

        // Assert
        assertEquals(expectedCars, actualCars);
        assertEquals("ABC123", actualCars.getRendszam());
        assertEquals("Toyota", actualCars.getMarka());
        assertEquals("Corolla", actualCars.getModel());
        assertEquals("Sedan", actualCars.getTipusjel());
        assertEquals(2020, actualCars.getEvjarat());
        assertEquals("Benzin", actualCars.getUzemanyag());
        assertEquals(1600, actualCars.getHengerurtartalom());
        assertEquals(120, actualCars.getTeljesitmeny());
    }

    @Test
    void testGetCars2() {
        // Arrange
        int id = 1;
        when(carsRepository.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResponseStatusException.class, () -> carService.getCar(id));
    }

    @Test
    public void testGetCarsList() {
        // Arrange
        Car car1 = new Car();
        car1.setRendszam("ABC123");
        car1.setMarka("Toyota");
        car1.setModel("Corolla");
        car1.setTipusjel("Sedan");
        car1.setEvjarat(2020);
        car1.setUzemanyag("Benzin");
        car1.setHengerurtartalom(1600);
        car1.setTeljesitmeny(120);

        Car car2 = new Car();
        car2.setRendszam("XYZ789");
        car2.setMarka("Ford");
        car2.setModel("Focus");
        car2.setTipusjel("Hatchback");
        car2.setEvjarat(2018);
        car2.setUzemanyag("Dízel");
        car2.setHengerurtartalom(2000);
        car2.setTeljesitmeny(150);

        List<Car> expectedCarsList = Arrays.asList(car1, car2);

        // Defining behavior for repository mock
        when(carsRepository.nativeFindCars()).thenReturn(expectedCarsList);

        // Act
        List<Car> actualCarsList = carService.getCarsList();

        // Assert
        assertEquals(expectedCarsList.size(), actualCarsList.size());
        assertEquals(expectedCarsList.get(0), actualCarsList.get(0));
        assertEquals(expectedCarsList.get(1), actualCarsList.get(1));
    }

    @Test
    public void testGetCarsRendszam() {
        // Arrange
        String rendszam = "ABC123";
        Car expectedCars = new Car();
        expectedCars.setRendszam(rendszam);
        expectedCars.setMarka("Toyota");
        expectedCars.setModel("Corolla");
        expectedCars.setTipusjel("Sedan");
        expectedCars.setEvjarat(2020);
        expectedCars.setUzemanyag("Benzin");
        expectedCars.setHengerurtartalom(1600);
        expectedCars.setTeljesitmeny(120);

        when(carsRepository.findCarsRendszam(rendszam)).thenReturn(Optional.of(expectedCars));

        // Act
        Car actualCars = carService.getCarByRendszam(rendszam);

        // Assert
        assertEquals(expectedCars, actualCars);
    }

    @Test
    public void testGetCarsRendszam2() {
        // Arrange
        String rendszam = "XYZ789";
        when(carsRepository.findCarsRendszam(rendszam)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> carService.getCarByRendszam(rendszam));
    }

    @Test
    public void testDeleteCar() {
        // Arrange
        int id = 1;
        Car car = new Car();
        car.setId(id);
        when(carsRepository.findById(id)).thenReturn(Optional.of(car));

        // Act
        carService.deleteCar(id);

        // Assert
        verify(carsRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteCars2() {
        // Arrange
        int id = 1;
        when(carsRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> carService.deleteCar(id));
    }
    @Test
    public void testUpdateRendszam() {
        // Arrange
        int id = 1;
        String newRendszam = "ABC123";
        Car existingCars = new Car();
        existingCars.setId(id);
        existingCars.setRendszam("XYZ789");
        when(carsRepository.findById(id)).thenReturn(Optional.of(existingCars));
        when(carsRepository.save(existingCars)).thenReturn(existingCars);

        // Act
        Car updatedCars = carService.updateRendszam(id, newRendszam);

        // Assert
        assertEquals(newRendszam, updatedCars.getRendszam());
    }

    @Test
    public void testUpdateRendszam2() {
        // Arrange
        int id = 1;
        String newRendszam = "ABC123";
        when(carsRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> carService.updateRendszam(id, newRendszam));
    }

    @Test
    public void testAddCars() {
        // Arrange
        NewCarRequest newCarRequest = new NewCarRequest();
        newCarRequest.setRendszam("ABC123");
        newCarRequest.setMarka("Toyota");
        newCarRequest.setModel("Corolla");
        newCarRequest.setTipusjel("Sedan");
        newCarRequest.setEvjarat(2020);
        newCarRequest.setUzemanyag("Benzin");
        newCarRequest.setHengerurtartalom(1600);
        newCarRequest.setTeljesitmeny(120);

        Car cars = new Car();
        cars.setRendszam("ABC123");
        cars.setMarka("Toyota");
        cars.setModel("Corolla");
        cars.setTipusjel("Sedan");
        cars.setEvjarat(2020);
        cars.setUzemanyag("Benzin");
        cars.setHengerurtartalom(1600);
        cars.setTeljesitmeny(120);

        when(carsRepository.save(any())).thenReturn(cars);

        // Act
        carService.addCars(newCarRequest);

        // Assert
        verify(carsRepository, times(1)).save(any());
    }
}