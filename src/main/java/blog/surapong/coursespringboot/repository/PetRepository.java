package blog.surapong.coursespringboot.repository;

import blog.surapong.coursespringboot.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
}
