package ls.org.rsl.agecalculator.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ls.org.rsl.agecalculator.dto.Request;
import ls.org.rsl.agecalculator.dto.Response;
import ls.org.rsl.agecalculator.service.AgeCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/calculate/age")
@Slf4j
public class AgeCalculatorController {
    private final AgeCalculatorService ageCalculatorService;

    public AgeCalculatorController(AgeCalculatorService ageCalculatorService) {
        this.ageCalculatorService = ageCalculatorService;
    }

    @PostMapping
    public ResponseEntity<Response> getAge(@RequestBody @Valid Request request, WebRequest webRequest){
        log.info("Birth year: {}", request.getBirthYear());
        log.info("Current year: {}", request.getCurrentYear());
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .path(webRequest.getDescription(false))
                .message(String.format("Your age is: %s", ageCalculatorService.calculate(request.getBirthYear(), request.getCurrentYear())))
                .build());
    }

    @PostMapping("/ma")
    public ResponseEntity<Response> getAgeParams(@RequestParam int birthYear, @RequestParam int currentYear, WebRequest webRequest){
        log.info("Birth year: {}", birthYear);
        log.info("Current year: {}", currentYear);
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .path(webRequest.getDescription(false))
                .message(String.format("Your age is: %s", ageCalculatorService.calculate(birthYear, currentYear)))
                .build());
    }
}
