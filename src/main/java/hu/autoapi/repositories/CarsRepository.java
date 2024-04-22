package hu.autoapi.repositories;

import java.util.List;
import java.util.Optional;

import hu.autoapi.domain.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM auto")
    List<Cars> nativeFindCars();

    @Query(value = "SELECT * FROM auto WHERE rendszam = :rendszam ;", nativeQuery = true)
    Optional<Cars> findCarsRendszam(@Param("rendszam") String rendszam);
}
