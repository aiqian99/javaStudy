package design_patterns.structural.adapter.adapters;

import design_patterns.structural.adapter.round.RoundPeg;
import design_patterns.structural.adapter.square.SquarePeg;

/**
 * 方钉到圆孔的适配器
 */
public class SquarePegAdapter extends RoundPeg {

    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        // 返回能放下该方孔的最小圆的半径 即方孔对角线为最小圆的直径
        return Math.sqrt(Math.pow((this.squarePeg.getWidth() / 2), 2) * 2);
    }
}
