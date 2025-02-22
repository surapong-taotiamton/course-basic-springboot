package blog.surapong.coursespringboot.redisrepository;


import blog.surapong.coursespringboot.redisentity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, String> {
    List<Country> findByCountryName(String countryName);
    List<Country> findByCountryCode(String countryCode);
}
