package blog.surapong.coursespringboot.repository;

import blog.surapong.coursespringboot.controller.dto.AddressDto;
import blog.surapong.coursespringboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository  extends JpaRepository<Address, String> {

    @Query("SELECT t From Address t WHERE t.person.personId = :personId")
    List<Address> searchAddressByPersonId(@Param("personId") String personId);

    @Query("SELECT new blog.surapong.coursespringboot.controller.dto.AddressDto(t.addressId, t.houseNo, t.person.personId, t.person.personName ) From Address t WHERE t.person.personId = :personId")
    List<AddressDto> searchAddressByPersonIdReturnDto(@Param("personId") String personId);

}
