package blog.surapong.coursespringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_id")
    private String addressId;

    @Column(name = "house_no")
    private String houseNo;

    @JoinColumn(name = "person_id")
    @ManyToOne
    private Person person;
}
