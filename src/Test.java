import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test
    extends Application
{
    public static void main( final String[] args )
    {
        launch( args );
    }

    @Override
    public void start( final Stage primaryStage )
        throws Exception
    {
        primaryStage.setTitle( "JavaFX Test" );
        primaryStage.setScene( new Scene(
            new VBox(),
            500, 400 ) );
        primaryStage.show();
    }
}