package blog.surapong.coursespringboot.repository;

import blog.surapong.coursespringboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
