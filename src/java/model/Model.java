package model;

import java.util.ArrayList;
import java.util.List;

public class Model
{
    private int numSides;
    private String color;

    public Model()
    {
        this.numSides = 3;
        this.color = "black";
    }

    public int getNumSides()
    {
        return numSides;
    }

    public void setNumSides( final int numSides )
    {
        this.numSides = numSides;
        notifyListeners();
    }

    public String getColor()
    {
        return color;
    }

    public void setColor( final String color )
    {
        this.color = color;
        notifyListeners();
    }

    private final List<Listener> listeners = new ArrayList<Listener>();

    public void addListener( final Listener listener )
    {
        listeners.add( listener );
    }

    private void notifyListeners()
    {
        for( final Listener listener : listeners ) {
            listener.updated();
        }
    }
}