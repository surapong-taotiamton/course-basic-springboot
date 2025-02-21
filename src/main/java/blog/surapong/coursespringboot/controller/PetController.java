package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.entity.Pet;
import blog.surapong.coursespringboot.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @Autowired
    PetRepository petRepository;

    @GetMapping("/pet/{id}")
    public Pet getPet(@PathVariable String id) {
        return petRepository.findById(id).orElseThrow();
    }

}
