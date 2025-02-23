package blog.surapong.coursespringboot.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String addressId;
    private String houseNo;
    private String personId;
    private String personName;

}
