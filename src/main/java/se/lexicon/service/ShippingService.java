package se.lexicon.service;

import se.lexicon.model.ShippingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    private final ShippingCalculatorFactory factory;

    @Autowired
    public ShippingService(ShippingCalculatorFactory factory) {
        this.factory = factory;
    }


    public double quote(ShippingRequest req) {
        ShippingCostCalculator calc = factory.getCalculator(req);
        return calc.calculate(req);
    }
}