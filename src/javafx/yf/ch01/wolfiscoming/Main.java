package javafx.yf.ch01.wolfiscoming;

import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
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

public class Main extends Application {

	private String[] message = new String[5];
	private static int index = 0;
	private Text text;
	private Image image;
	private Stage stage;

	public void start(Stage stage) {
		this.stage = stage;
		message[0] = "A boy called Peter lived with his parents " 
		        + "in a village on the hillside. His parents, "
				+ "like most of the other people in the village, " 
		        + "were sheep farmers. Everybody in the village "
				+ "took turns to look after the sheep, and when " 
		        + "Peter was 10 years old, he was considered old "
				+ "enough to take his turn at shepherding. But " 
		        + "Peter was too easily bored, and he found it "
				+ "very tiresome being on the hillside with only " 
		        + "sheep for company. ";
		message[1] = "So he’d find ways to amuse himself,  "
				+ "running up rocks, climbing trees, chasing "
				+ "sheep, but nothing really kept him amused "
				+ "for very long. Then he hit upon a brilliant "
				+ "idea. He climbed to the top of the tallest "
				+ "tree, and started shouting towards the "
				+ "village: “Wolf! Wolf! Wooolf! Woohoolf!” ";
		message[2]= "One of the villagers heard him, and got "
				+ "all the other men together, and armed with "
				+ "axes, hoes and forks, they ran out of the "
				+ "village to chase away the wolf and save their "
				+ "herd. Of course when they got there, they merely "
				+ "found Peter perched high up in his tree, laughing, "
				+ "and the sheep grazing peacefully. They were very "
				+ "annoyed with him.";
		message[3]= "For a while life went on again as normal, "
				+ "and people forgot about the incident. Peter "
				+ "got really bored again. he shouting again: "
				+ "“Wolf! Wolf! Wooolf! Woohoolf! Woohoohoooolf!” "
				+ "Somebody in the village heard and before long "
				+ "the men all come running up the hill armed "
				+ "with their sticks and axes and hoes and "
				+ "shovels, ready to chase away the big bad wolf."
				+ "Imagine their consternation when they arrived "
				+ "in the field to see their herd grazing peacefully" ;
		message[4] = "One afternoon Peter noticed Sheep were running "
				+ "all over and making an ever louder racket. There "
				+ "was a great big hairy wolf, chasing the sheep, "
				+ "Then he started shouting: “Woolf! Woolof! Wooloof!”"
				+ "In the village an old man heard the shouting. “Oh "
				+ "no, not that Peter again”, he said, shaking his "
				+ "head. “What’s going on?” enquired another villager. "
				+ "“It’s that Peter again, he just can’t help himself”. "
				+ "This time, nobody came to help Peter.";
		

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {

					public void run() {
						updateUi();
					}

				});
			}
		}, 0, 30000);
	}

	public void updateUi() {
		if (index <= 4) {
			// Reference to the Text
			text = new Text(message[index]);
			text.setLayoutY(200); // y axis of location
			text.setTextOrigin(VPos.TOP);
			text.setTextAlignment(TextAlignment.JUSTIFY);
			text.setWrappingWidth(400);
			text.setFill(Color.rgb(255, 255, 255));
			text.setFont(Font.font("SansSerif", FontWeight.BOLD, 24));

			// Provides the animated scrolling behavior for the text
			TranslateTransition transTransition = new TranslateTransition(new Duration(30000), text);
			transTransition.setToY(-720);
			transTransition.setInterpolator(Interpolator.LINEAR);// TODO
			transTransition.setCycleCount(Timeline.INDEFINITE);

			// Create an ImageView containing the Image
			image = new Image("/images/timg" + index + ".jpg");
			ImageView iv = new ImageView(image);

			// Create a Group containing the text
			Group textGroup = new Group(text);
			textGroup.setLayoutX(50);
			textGroup.setLayoutY(180);
			textGroup.setClip(new Rectangle(430, 85));

			// Combine ImageView and ScrollPane
			Group root = new Group(iv, textGroup);
			Scene scene = new Scene(root, 516, 387);

			stage.setScene(scene);
			stage.setTitle("Wolf is coming!");
			stage.show();

			// Start the text animation
			transTransition.play();
			index++;
		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
