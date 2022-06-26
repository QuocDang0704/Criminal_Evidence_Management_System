package fis.quocdb3.config.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ErrorMessager {
    private String code;
    private String messager;
}
