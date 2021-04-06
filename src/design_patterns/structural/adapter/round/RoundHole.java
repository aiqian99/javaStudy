package design_patterns.structural.adapter.round;

/**
 * 圆孔
 */
public class RoundHole {

    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg roundPeg){
        return this.getRadius() >= roundPeg.getRadius();
    }
}
