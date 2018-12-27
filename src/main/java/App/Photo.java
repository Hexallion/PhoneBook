package App;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@EnableAutoConfiguration
public class Photo {

    @Id
    @NotNull
    private String uuid;

    @NotNull
    private String fileName;

    private int size;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_uuid")
    @JsonIgnore
    @NotNull
    private User uploader;*/
}
