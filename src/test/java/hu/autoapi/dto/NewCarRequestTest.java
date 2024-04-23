package hu.autoapi.dto;

import hu.autoapi.domain.Cars;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class NewCarRequestTest {

    @Test
    public void testToCar() {
        // Arrange
        NewCarRequest request = new NewCarRequest();
        request.setRendszam("ABC123");
        request.setMarka("Toyota");
        request.setModel("Corolla");
        request.setTipusjel("Sedan");
        request.setEvjarat(2020);
        request.setUzemanyag("Benzin");
        request.setHengerurtartalom(1600);
        request.setTeljesitmeny(120);

        // Act
        Cars car = request.toCar();

        // Assert
        assertEquals("ABC123", car.getRendszam());
        assertEquals("Toyota", car.getMarka());
        assertEquals("Corolla", car.getModel());
        assertEquals("Sedan", car.getTipusjel());
        assertEquals(2020, car.getEvjarat());
        assertEquals("Benzin", car.getUzemanyag());
        assertEquals(1600, car.getHengerurtartalom());
        assertEquals(120, car.getTeljesitmeny());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        NewCarRequest request = new NewCarRequest();

        // Act
        request.setRendszam("ABC123");
        request.setMarka("Toyota");
        request.setModel("Corolla");
        request.setTipusjel("Sedan");
        request.setEvjarat(2020);
        request.setUzemanyag("Benzin");
        request.setHengerurtartalom(1600);
        request.setTeljesitmeny(120);

        // Assert
        assertEquals("ABC123", request.getRendszam());
        assertEquals("Toyota", request.getMarka());
        assertEquals("Corolla", request.getModel());
        assertEquals("Sedan", request.getTipusjel());
        assertEquals(2020, request.getEvjarat());
        assertEquals("Benzin", request.getUzemanyag());
        assertEquals(1600, request.getHengerurtartalom());
        assertEquals(120, request.getTeljesitmeny());
    }

    @Test
    public void testToString() {
        // Arrange
        NewCarRequest request = new NewCarRequest();
        request.setRendszam("ABC123");
        request.setMarka("Toyota");
        request.setModel("Corolla");
        request.setTipusjel("Sedan");
        request.setEvjarat(2020);
        request.setUzemanyag("Benzin");
        request.setHengerurtartalom(1600);
        request.setTeljesitmeny(120);

        // Act
        String result = request.toString();

        // Assert
        assertEquals("NewClassRoomRequest{Rendszám='ABC123'Márka='Toyota'Model='Corolla'Típusjel='Sedan'Évjárat='2020'Üzemanyag='Benzin'Hengerűrtartalom='1600', Teljesítmény=120}", result);
    }
}