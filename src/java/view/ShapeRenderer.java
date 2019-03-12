
package view;

import java.awt.Graphics;

import javax.swing.JComponent;

public class ShapeRenderer
    extends JComponent
{
    public ShapeRenderer()
    {

    }

    @Override
    protected void paintComponent( final Graphics g )
    {
        g.drawLine( 0, 0, g.getClipBounds().width, g.getClipBounds().height );
    }
}
