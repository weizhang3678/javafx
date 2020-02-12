package javafx.yf.ch01;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FxDemo extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	public void start(Stage stage) {
		String message = "One afternoon Peter noticed Sheep were running "
				+ "all over and making an ever louder racket. There "
				+ "was a great big hairy wolf, chasing the sheep, "
				+ "Then he started shouting: “Woolf! Woolof! Wooloof!”"
				+ "In the village an old man heard the shouting. “Oh "
				+ "no, not that Peter again”, he said, shaking his "
				+ "head. “What’s going on?” enquired another villager. "
				+ "“It’s that Peter again, he just can’t help himself”. "
				+ "This time, nobody came to help Peter.";

        // Reference to the Text
		Text textRef = new Text(message);
		textRef.setLayoutY(200); // y axis of location
		textRef.setTextOrigin(VPos.TOP);
		textRef.setTextAlignment(TextAlignment.JUSTIFY);
		textRef.setWrappingWidth(400);
		textRef.setFill(Color.rgb(187, 195, 107));
		textRef.setFont(Font.font("SansSerif", FontWeight.BOLD, 24));

        // Provides the animated scrolling behavior for the text
		TranslateTransition transTransition = new TranslateTransition(new Duration(75000), textRef);
		transTransition.setToY(-820);
		transTransition.setInterpolator(Interpolator.LINEAR);//TODO
		transTransition.setCycleCount(Timeline.INDEFINITE);

        // Create an ImageView containing the Image
		Image image = new Image("/images/timg4.jpg");
		ImageView iv = new ImageView(image);

        // Create a Group containing the text
		Group textGroup = new Group(textRef);
		textGroup.setLayoutX(50);
		textGroup.setLayoutY(180);
		textGroup.setClip(new Rectangle(430, 85));

        // Combine ImageView and ScrollPane
		Group root = new Group(iv, textGroup);
		Scene scene = new Scene(root, 516, 387);

		stage.setScene(scene);
		stage.setTitle("Hello JavaFX");
		stage.show();

        // Start the text animation
		transTransition.play();
	}

}
