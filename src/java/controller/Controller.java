
package controller;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;

public class Controller
{
    private final Model model;

    public Controller( final Model model )
    {
        this.model = model;
    }

    public ChangeListener getNumSidesChangeListener()
    {
        return new ChangeListener() {
            @Override
            public void stateChanged( final ChangeEvent e )
            {
                if( e.getSource() instanceof JSpinner ) {
                    int v = ((Number)((JSpinner)e.getSource()).getValue()).intValue();
                    model.setNumSides( v );
                }   
            }
        };
    }
}