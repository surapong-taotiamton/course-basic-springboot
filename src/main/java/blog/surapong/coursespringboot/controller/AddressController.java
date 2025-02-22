package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.entity.Address;
import blog.surapong.coursespringboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/get-address")
    public Address getAddress() {
        return addressRepository.findById("A1").orElseThrow();
    }


}
