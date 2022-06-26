package fis.quocdb3.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import fis.quocdb3.utils.DateFormatter;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person extends AbstractEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormatter.DATE_FORMAT)
    @DateTimeFormat(pattern = DateFormatter.DATE_FORMAT)
    @Column(nullable = false)
    private LocalDateTime hiringDate;

}