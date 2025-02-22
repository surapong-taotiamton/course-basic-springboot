package blog.surapong.coursespringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_person")
public class Person {

    @Id
    @Column(name = "person_id")
    private String personId;

    @Column(name = "person_name")
    private String personName;
}
