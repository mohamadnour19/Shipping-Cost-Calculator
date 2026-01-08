package se.lexicon;

import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Shipping Cost Calculator with Spring ===\n");


        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        ShippingService shippingService =
                context.getBean(ShippingService.class);

        System.out.println("=== Test Cases ===\n");


        ShippingRequest domesticStandardRequest =
                new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 10.0);
        System.out.println("Domestic Standard (10kg): " +
                shippingService.quote(domesticStandardRequest));

        ShippingRequest internationalExpressRequest =
                new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 15.0);
        System.out.println("International Express (15kg): " +
                shippingService.quote(internationalExpressRequest));

        ShippingRequest lightDomesticRequest =
                new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 5.0);
        System.out.println("Light Domestic (5kg): " +
                shippingService.quote(lightDomesticRequest));

        ShippingRequest heavyInternationalExpressRequest =
                new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 20.0);
        System.out.println("Heavy International Express (20kg): " +
                shippingService.quote(heavyInternationalExpressRequest));
    }
}