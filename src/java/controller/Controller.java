
package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

    public ItemListener getColorItemListener()
    {
        return new ItemListener() {
            @Override
            public void itemStateChanged( final ItemEvent e )
            {
                model.setColor( e.getItem().toString() );
            }
        };
    }
}