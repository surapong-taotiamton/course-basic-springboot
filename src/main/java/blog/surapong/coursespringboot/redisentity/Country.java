package blog.surapong.coursespringboot.redisentity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;


@Accessors(chain = true)
@Data
@RedisHash("Country")
public class Country implements Serializable {

    @Id
    private String countryId;

    @Indexed
    private String countryName;

    @Indexed
    private String countryCode;
}
