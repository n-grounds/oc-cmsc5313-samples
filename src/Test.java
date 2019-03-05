import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Test
{
    public static void main( final String[] args )
    {
        final JFrame frame = new JFrame( "Title" );
        frame.setSize( 400, 500 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        frame.setLayout( new BorderLayout() );
        final JButton b = new JButton( "Click Me" );
        final JLabel l = new JLabel( "You haven't clicked the button, yet");
        b.addActionListener( new ActionListener() {
            int counter = 0;

            public void actionPerformed( final ActionEvent e )
            {
                counter++;
                l.setText( "You clicked the button " + counter + " times" );
            }
        } );
        frame.add( b, BorderLayout.NORTH );
        frame.add( l, BorderLayout.SOUTH );

        final JButton open = new JButton( "Open" );
        open.addActionListener( new ActionListener() {
            public void actionPerformed( final ActionEvent e )
            {
                //JOptionPane has lots of basic dialogs
                final JFileChooser chooser = new JFileChooser();
                final int result = chooser.showOpenDialog( frame );
                if( result == JFileChooser.APPROVE_OPTION ) {
                    final File f = chooser.getSelectedFile();
                    JOptionPane.showMessageDialog(
                        frame, f.getAbsolutePath(),
                        "Selection",
                        JOptionPane.INFORMATION_MESSAGE );
                }
            }
        } );
        frame.add( open, BorderLayout.WEST );

        final JLabel imgLabel = new JLabel();
        imgLabel.setIcon( new ImageIcon( "steve.jpg" ) );
        frame.add( imgLabel, BorderLayout.CENTER );

        frame.setVisible( true );
    }
}