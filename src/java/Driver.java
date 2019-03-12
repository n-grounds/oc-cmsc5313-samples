import javax.swing.JFrame;

import controller.Controller;
import model.Model;
import view.View;

public class Driver
{
    public static void main( final String[] args )
    {
        //is the Frame really part of the View? or outside it?
        JFrame frame = new JFrame( "MVC Demo" );
        frame.setSize( 500, 500 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //first, construct Model
        final Model model = new Model();

        //next, construct Controller (or View)
        final Controller controller = new Controller( model );

        //next, constuct View (or Controller)
        final View view = new View( model, controller );
        frame.setContentPane( view );

        frame.setVisible( true );
    }
}