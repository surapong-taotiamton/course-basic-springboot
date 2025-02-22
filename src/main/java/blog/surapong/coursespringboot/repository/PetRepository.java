package blog.surapong.coursespringboot.repository;

import blog.surapong.coursespringboot.entity.Pet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, String> {

    List<Pet> findByPetName(String petName);
    List<Pet> findByAgeGreaterThanEqual(Integer age);
    List<Pet> findByPetNameAndAge(String petName, Integer age);


    @Query("SELECT t FROM Pet t WHERE t.petName = :petName ")
    List<Pet> searchByJpql(@Param("petName") String petName);

    List<Pet> findByAgeGreaterThanEqual(Integer age, Pageable pageable);
}
