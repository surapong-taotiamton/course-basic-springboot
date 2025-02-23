package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.controller.dto.AddressDto;
import blog.surapong.coursespringboot.entity.Address;
import blog.surapong.coursespringboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/get-address")
    public Address getAddress(@RequestParam("addressId") String addressId ) {
        return addressRepository.findById(addressId).orElseThrow();
    }

    @GetMapping("/get-address-by-person-id")
    public List<Address> getAddressByPersonId(@RequestParam("personId") String personId ) {
        return addressRepository.searchAddressByPersonId(personId);
    }

    @GetMapping("/get-address-by-person-id-return-dto")
    public List<AddressDto> getAddressByPersonIdReturnDto(@RequestParam("personId") String personId ) {
        return addressRepository.searchAddressByPersonIdReturnDto(personId);
    }


}
