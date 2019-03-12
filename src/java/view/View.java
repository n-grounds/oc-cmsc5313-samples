
package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.Model;

public class View
    extends JPanel
{
    public View( final Model model )
    {
        setLayout( new BorderLayout() );
        add( new ShapeRenderer( model ), BorderLayout.CENTER );
    }
}
