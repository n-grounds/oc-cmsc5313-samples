
package view;

import java.awt.Color;
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
        g.setColor( model.getColor().equals( "black" )
                ? Color.BLACK
                : model.getColor().equals( "red" )
                ? Color.RED
                : model.getColor().equals( "green" )
                ? Color.GREEN
                : Color.BLUE );

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
