package blog.surapong.coursespringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@Table(name = "tab_person")
@Accessors(chain = true)
@Data
public class Person implements Serializable {

    @Id
    @Column(name = "person_id")
    private String personId;

    @Column(name = "person_name")
    private String personName;
}
