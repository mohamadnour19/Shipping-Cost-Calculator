package se.lexicon.model;

public class ShippingRequest {
    private Destination destination;
    private Speed speed;
    private double weight;


    public ShippingRequest(Destination destination, Speed speed, double weight) {
        this.destination = destination;
        this.speed = speed;
        this.weight = weight;
    }


    public Destination destination() {
        return destination;
    }

    public Speed speed() {
        return speed;
    }

    public double weightKg() {
        return weight;
    }


    public Destination getDestination() {
        return destination;
    }

    public Speed getSpeed() {
        return speed;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "ShippingRequest{" +
                "destination=" + destination +
                ", speed=" + speed +
                ", weight=" + weight + '}';
    }
}