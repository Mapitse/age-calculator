package ls.org.rsl.agecalculator.service.impl;

import lombok.extern.slf4j.Slf4j;
import ls.org.rsl.agecalculator.exception.InvalidInputException;
import ls.org.rsl.agecalculator.service.AgeCalculatorService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AgeCalculatorServiceImpl implements AgeCalculatorService {
    @Override
    public int calculate(int b_year, int c_year) {
        if(b_year > c_year) {
            log.info("Birth year is Greater ({}) that Current year ({})", b_year, c_year);
            throw new InvalidInputException("Invalid birth year. Please enter a valid year and ensure that it's not later than the current year");
        }
        if(b_year == 0) {
            log.info("Birth year ({}) is zero", b_year);
            throw new InvalidInputException("Invalid birth year. The birth year cannot be 0 (zero)");
        }
        if(c_year == 0) {
            log.info("Current year ({}) is zero", c_year);
            throw new InvalidInputException("Invalid current year. The current year cannot be 0 (zero)");
        }

        return (c_year - b_year);
    }
}
