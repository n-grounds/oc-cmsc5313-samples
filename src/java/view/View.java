
package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class View
    extends JPanel
{
    public View()
    {
        setLayout( new BorderLayout() );
        add( new ShapeRenderer(), BorderLayout.CENTER );
    }
}
