package se.lexicon.service;

import se.lexicon.model.ShippingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ShippingCalculatorFactory {

    private final List<ShippingCostCalculator> calculators;


    @Autowired
    public ShippingCalculatorFactory(List<ShippingCostCalculator> calculators) {
        this.calculators = calculators;
    }


    public ShippingCostCalculator getCalculator(ShippingRequest req) {
        return calculators.stream()
                .filter(c -> c.supports(req))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No calculator for request: " + req));
    }
}