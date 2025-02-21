package blog.surapong.coursespringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
@Entity
public class Pet {
    @Id
    private String petId;
    private String petName;
}
