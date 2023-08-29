package ls.org.rsl.agecalculator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class Response {
    private String message;
    private HttpStatus status;
    private int statusCode;
    private String path;
    private LocalDateTime timeStamp;
}
