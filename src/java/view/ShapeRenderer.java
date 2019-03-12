
package view;

import java.awt.Graphics;

import javax.swing.JComponent;

import model.Model;

public class ShapeRenderer
    extends JComponent
{
    private final Model model;

    public ShapeRenderer( final Model model )
    {
        this.model = model;
    }

    @Override
    protected void paintComponent( final Graphics g )
    {
        final int numSides = model.getNumSides();
        final int width = Math.min( g.getClipBounds().width,
                g.getClipBounds().height ) / 2 - 10;
        int x = g.getClipBounds().width / 2,
                y = 5;
        for( int n = 1; n <= numSides; n++ ) {
            int newX = (int)(Math.sin( 2 * Math.PI * n / numSides ) * width
                    + g.getClipBounds().width / 2);
            int newY = g.getClipBounds().height / 2 -
                    (int)(Math.cos( 2 * Math.PI * n / numSides ) * width);
            g.drawLine( x, y, newX, newY );
            x = newX;
            y = newY;
        }
    }
}
