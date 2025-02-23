package blog.surapong.coursespringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Accessors(chain = true)
@Data
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @Column(name = "address_id")
    private String addressId;

    @Column(name = "house_no")
    private String houseNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
}
