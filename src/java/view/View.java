
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import controller.Controller;
import model.Listener;
import model.Model;

public class View
    extends JPanel
    implements Listener
{
    public View( final Model model, final Controller controller )
    {
        setLayout( new BorderLayout() );

        final JPanel controls = new JPanel();
        controls.setLayout( new FlowLayout() );
        final JSpinner spinner = new JSpinner();
        spinner.setModel( new SpinnerNumberModel(
                model.getNumSides(), 3, 10, 1 ) );
        spinner.addChangeListener( controller.getNumSidesChangeListener() );
        controls.add( spinner );
        final JComboBox combo = new JComboBox(
                new String[] { "black", "red", "blue", "green" } );
        combo.setSelectedIndex( 0 );
        combo.addItemListener( controller.getColorItemListener() );
        controls.add( combo );
        add( controls, BorderLayout.NORTH );

        add( new ShapeRenderer( model ), BorderLayout.CENTER );

        model.addListener( this );
    }

    public void updated()
    {
        repaint();
    }
}
