package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.controller.dto.AddressDto;
import blog.surapong.coursespringboot.entity.Person;
import blog.surapong.coursespringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person/search-by-person-id")
    public List<AddressDto> getAddressByPersonIdReturnDto(@RequestParam("personId") String personId ) {
        return personRepository.searchAddressByPersonIdReturnDto(personId);
    }

    @GetMapping("/person/search-by-address-id")
    public List<Person> getPersonByAddressId(@RequestParam("addressId") String addressId) {
        return personRepository.searchPersonByAddressId(addressId);
    }

}
