package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.entity.Pet;
import blog.surapong.coursespringboot.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    PetRepository petRepository;

    @GetMapping("/pet/search-by-id")
    public Pet getPet(@RequestParam("id") String id) {
        return petRepository.findById(id).orElseThrow();
    }


    @GetMapping("/pet/search-by-name")
    public List<Pet> searchByName(
            @RequestParam("name") String name
    ) {
        return petRepository.findByPetName(name);
    }

    @GetMapping("/pet/search-by-age")
    public List<Pet> searchByAge(
            @RequestParam("age") Integer age
    ) {
        return petRepository.findByAgeGreaterThanEqual(age);
    }

    @GetMapping("/pet/combo-search")
    public List<Pet> comboSearch(
            @RequestParam("name") String petName,
            @RequestParam("age") Integer age
    ) {
        return petRepository.findByPetNameAndAge(petName, age);
    }

    @GetMapping("/pet/search-by-jpql")
    public List<Pet> searchByJpql(
            @RequestParam("name") String petName
    ) {
        return petRepository.searchByJpql(petName);
    }

    @GetMapping("/pet/limit-search")
    public List<Pet> limitSearch(
            @RequestParam("age") Integer age,
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize
    ) {
        Sort.Order orderByAgeDesc = Sort.Order.desc("age");
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(orderByAgeDesc));
        return petRepository.findByAgeGreaterThanEqual(age, pageable);
    }

}
