import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test
{
    public static void main( final String[] args )
    {
        final JFrame frame = new JFrame( "Title" );
        frame.setSize( 400, 500 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        frame.setLayout( new BorderLayout() );
        final JButton b = new JButton( "Click Me" );
        final JLabel l = new JLabel();
        b.addActionListener( new ActionListener() {
            public void actionPerformed( final ActionEvent e )
            {
                l.setText( "You clicked the button" );
            }
        } );
        frame.add( b, BorderLayout.NORTH );
        frame.add( l, BorderLayout.SOUTH );

        final JLabel imgLabel = new JLabel();
        imgLabel.setIcon( new ImageIcon( "/home/nic/steve.jpg" ) );
        frame.add( imgLabel, BorderLayout.CENTER );

        frame.setVisible( true );
    }
}