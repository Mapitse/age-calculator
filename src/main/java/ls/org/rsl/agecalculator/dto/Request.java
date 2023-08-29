package ls.org.rsl.agecalculator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Request {
    @NotNull(message = "The Birth year field is required")
    private int birthYear;
    @NotNull(message = "The Current year field is required")
    private int currentYear;
}
