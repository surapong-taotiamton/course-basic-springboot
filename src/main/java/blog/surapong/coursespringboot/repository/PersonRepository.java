package blog.surapong.coursespringboot.repository;

import blog.surapong.coursespringboot.controller.dto.AddressDto;
import blog.surapong.coursespringboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {

    @Query("SELECT new blog.surapong.coursespringboot.controller.dto.AddressDto(a.addressId, a.houseNo, p.personId, p.personName )  " +
            "FROM Person p " +
            "LEFT JOIN Address a " +
            "ON p.personId = a.person.personId " +
            "WHERE  p.personId = :personId ")
    List<AddressDto> searchAddressByPersonIdReturnDto(@Param("personId") String personId);


    @Query("SELECT p  " +
            "FROM Person p " +
            "LEFT JOIN Address a " +
            "ON p.personId = a.person.personId " +
            "WHERE  a.addressId = :addressId ")
    List<Person> searchPersonByAddressId(@Param("addressId") String addressId);

}
