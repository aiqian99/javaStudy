package design_patterns.structural.adapter;


import design_patterns.structural.adapter.adapters.SquarePegAdapter;
import design_patterns.structural.adapter.round.RoundHole;
import design_patterns.structural.adapter.round.RoundPeg;
import design_patterns.structural.adapter.square.SquarePeg;

public class AdapterDemo {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg peg = new RoundPeg(5);
        if (hole.fits(peg)) {
            System.out.println("圆钉r5适合圆孔r5。");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);

        // hole.fits(smallSqPeg);

        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("方钉w2适合圆孔r5。");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("方钉w20不适合圆孔r5。");
        }
    }
}
