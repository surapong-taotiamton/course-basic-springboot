package blog.surapong.coursespringboot.controller;


import blog.surapong.coursespringboot.redisentity.Country;
import blog.surapong.coursespringboot.redisrepository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/country/{countryId}")
    public Country getCountry(@PathVariable("countryId") String countryId) {
        return countryRepository.findById(countryId).orElseThrow();
    }

    @PostMapping("/country")
    public Country createCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @PatchMapping("/country")
    public Country updateCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @DeleteMapping("/country/{countryId}")
    public void deleteCountry(@PathVariable("countryId") String countryId) {
        countryRepository.deleteById(countryId);
    }

    @GetMapping("/country/search/country-code")
    public List<Country> searchByCountry(@RequestParam("countryCode") String countryCode) {
        return countryRepository.findByCountryCode(countryCode);
    }



//    @GetMapping("/save-country")
//    public Country saveCountry(@RequestParam("countryId") String countryId) {
//        Country country = new Country()
//                .setCountryId(countryId)
//                .setCountryName(UUID.randomUUID().toString())
//                .setCountryCode(UUID.randomUUID().toString());
//        return countryRepository.save(country);
//    }
//
//    @GetMapping("/get-country-all")
//    public List<Country> getAll() {
//        List<Country> allCountry = new ArrayList<>();
//        countryRepository.findAll().iterator().forEachRemaining(allCountry::add);
//        return allCountry;
//    }
//
//    @GetMapping("/get-by-country-name")
//    public List<Country> findByCountryName(@RequestParam("countryName") String countryName) {
//        return countryRepository.findByCountryName(countryName);
//    }


}
