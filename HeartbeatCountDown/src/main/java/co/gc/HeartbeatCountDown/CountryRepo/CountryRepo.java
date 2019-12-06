package co.gc.HeartbeatCountDown.CountryRepo;

import co.gc.HeartbeatCountDown.countriesmodel.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Integer> {
	
}
