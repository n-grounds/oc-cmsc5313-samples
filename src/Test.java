import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
        final Menu file = new Menu( "File" );
        final MenuBar bar = new MenuBar( file );
        // bar.getMenus().add( file );
        final MenuItem exit = new MenuItem( "Exit" );
        file.getItems().add( exit );
        exit.setOnAction( e -> {
            primaryStage.close();
        } );

        final Button b = new Button( "Click me" );
        final Pane bPane = new HBox( b );
        bPane.setPadding( new Insets( 50, 0, 30, 50 ) );
        final Label l = new Label();
        b.setOnAction( e -> {
            l.setText( "You clicked the button" );
        } );
        
        primaryStage.setScene( new Scene(
            new VBox( bar, bPane, l ),
            500, 400 ) );
        primaryStage.show();
    }
}