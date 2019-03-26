import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test
    extends Application
{
    public static void main( final String[] args )
    {
        launch( args );
    }

    XYChart.Series<Number,Number> s;

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

        final Node n = new Rectangle( 40, 40, Color.BLUE );

        final TranslateTransition tt = new TranslateTransition(
            Duration.millis( 5000 ), n );
        tt.byXProperty().set( 400.0 );
        tt.setAutoReverse( true );
        tt.setCycleCount( TranslateTransition.INDEFINITE );
        final RotateTransition rt = new RotateTransition(
            Duration.seconds( 1.0 ), n );
        rt.setByAngle( 360.0 );
        rt.setCycleCount( RotateTransition.INDEFINITE );
        final ParallelTransition pt = new ParallelTransition( tt, rt );

        final LineChart c = new LineChart<Number,Number>(
            new NumberAxis( "X", 0.0, 400.0, 20.0 ),
            new NumberAxis( "Y", 0.0, 500.0, 20.0 ) );
        c.setTitle( "Where You've Clicked" );
        c.setAnimated( false );
        c.setLegendVisible( false );
        final XYChart.Series<Number,Number> series = new XYChart.Series<>();
        series.setName( "Clicks" );
        c.getData().add( series );
        final XYChart.Series<Number,Number> series2 = new XYChart.Series<>();
        series2.setName( "More Clicks" );
        c.getData().add( series2 );
        s = series;

        b.setOnAction( e -> {
            l.setText( "You clicked the button" );
            s = (s == series) ? series2 : series;
        } );
        n.setOnMouseClicked( e -> {
            double x = e.getSceneX(), y = e.getSceneY();
            l.setText( String.format(
                "You clicked the square at location %.0f,%.0f",
                x, y ) );
            s.getData().add( new Data<Number,Number>( x, y ) );
        } );

        primaryStage.setScene( new Scene(
            new VBox( bar, bPane, l, n, c ),
            500, 400 ) );
        primaryStage.show();

        pt.play();
    }
}