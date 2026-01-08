package se.lexicon.calculator;

import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ExpressInternationalShipping implements ShippingCostCalculator {


    @Value("${shipping.international.express.base:25}")
    private double baseCost;

    @Value("${shipping.international.express.perkg:4.5}")
    private double costPerKg;


    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.EXPRESS;
    }


    public double calculate(ShippingRequest r) {
        return baseCost + costPerKg * r.weightKg();
    }


}