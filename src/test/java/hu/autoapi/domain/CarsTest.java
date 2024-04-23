package hu.autoapi.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    public void testCarsConstructor() {
        // Arrange
        int id = 1;
        String rendszam = "ABC123";
        String marka = "Toyota";
        String model = "Corolla";
        String tipusjel = "Sedan";
        int evjarat = 2020;
        String uzemanyag = "Benzin";
        int hengerurtartalom = 1600;
        int teljesitmeny = 120;

        // Act
        Cars cars = new Cars(id, rendszam, marka, model, tipusjel, evjarat, uzemanyag, hengerurtartalom, teljesitmeny);

        // Assert
        assertEquals(id, cars.getId());
        assertEquals(rendszam, cars.getRendszam());
        assertEquals(marka, cars.getMarka());
        assertEquals(model, cars.getModel());
        assertEquals(tipusjel, cars.getTipusjel());
        assertEquals(evjarat, cars.getEvjarat());
        assertEquals(uzemanyag, cars.getUzemanyag());
        assertEquals(hengerurtartalom, cars.getHengerurtartalom());
        assertEquals(teljesitmeny, cars.getTeljesitmeny());
    }
    @Test
    public void testCarsSetters() {
        // Arrange
        Cars cars = new Cars();

        // Act
        cars.setId(1);
        cars.setRendszam("ABC123");
        cars.setMarka("Toyota");
        cars.setModel("Corolla");
        cars.setTipusjel("Sedan");
        cars.setEvjarat(2020);
        cars.setUzemanyag("Benzin");
        cars.setHengerurtartalom(1600);
        cars.setTeljesitmeny(120);

        // Assert
        assertEquals(1, cars.getId());
        assertEquals("ABC123", cars.getRendszam());
        assertEquals("Toyota", cars.getMarka());
        assertEquals("Corolla", cars.getModel());
        assertEquals("Sedan", cars.getTipusjel());
        assertEquals(2020, cars.getEvjarat());
        assertEquals("Benzin", cars.getUzemanyag());
        assertEquals(1600, cars.getHengerurtartalom());
        assertEquals(120, cars.getTeljesitmeny());
    }

    @Test
    public void testCarsGetters() {
        // Arrange
        Cars cars = new Cars();
        cars.setId(1);
        cars.setRendszam("ABC123");
        cars.setMarka("Toyota");
        cars.setModel("Corolla");
        cars.setTipusjel("Sedan");
        cars.setEvjarat(2020);
        cars.setUzemanyag("Benzin");
        cars.setHengerurtartalom(1600);
        cars.setTeljesitmeny(120);

        // Assert
        assertEquals(1, cars.getId());
        assertEquals("ABC123", cars.getRendszam());
        assertEquals("Toyota", cars.getMarka());
        assertEquals("Corolla", cars.getModel());
        assertEquals("Sedan", cars.getTipusjel());
        assertEquals(2020, cars.getEvjarat());
        assertEquals("Benzin", cars.getUzemanyag());
        assertEquals(1600, cars.getHengerurtartalom());
        assertEquals(120, cars.getTeljesitmeny());
    }
}

