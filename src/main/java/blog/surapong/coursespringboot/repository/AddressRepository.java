package blog.surapong.coursespringboot.repository;

import blog.surapong.coursespringboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, String> {
}
