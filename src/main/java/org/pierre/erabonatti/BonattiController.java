package org.pierre.erabonatti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BonattiController {

    BonattiCalculator bonattiCalculator;

    @Autowired
    public BonattiController(BonattiCalculator bonattiCalculator) {
        this.bonattiCalculator = bonattiCalculator;
    }


    @GetMapping("/tobonatti/{thedate}")
    public String toBonatti(@PathVariable String thedate) {
        return bonattiCalculator.convertToNewEraAsStringFromString(thedate);
    }
}
