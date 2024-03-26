import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Random;
import java.io.File;

/**
* ColorGame Application.
* @author Madison Schlaff
* @version 1.0
*/

public class ColorGame extends Application {
    /**
    * Colors enum.
    */
    public enum Colors { RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, AQUA, GRAY, PINK, TAN };
    public static String[] colorsNames =
        {"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE", "AQUA", "GRAY", "PINK", "TAN"};
    private static String name = "None";
    private static int score = 0;
    private static String answerStr = "Choose an answer to begin!";
    public static Button questionButton = new Button(randColorsNames());
    public static Button try1 = new Button(randColorsNames());
    public static Button try2 = new Button(randColorsNames());
    public static Button try3 = new Button(randColorsNames());

    /**
    * Stage setting and event handling method.
    * @param stage stage to set.
    */
    @Override
    public void start(Stage stage) {



        Media correctV = new Media(new File("Correct.mp3").toURI().toString());
        MediaPlayer correct = new MediaPlayer(correctV);
        MediaView correct2 = new MediaView(correct);

        Media gameOverV = new Media(new File("GameOver.mp3").toURI().toString());
        MediaPlayer gameOver = new MediaPlayer(gameOverV);
        MediaView gameOver2 = new MediaView(gameOver);

        //title screen
        //title screen label
        Label titleLabel = new Label("Welcome to Color Game!");
        titleLabel.setStyle(
            "-fx-text-fill: linear-gradient(from 0% 0% to 100% 200%, "
            + "repeat, red 0%, orange 20%, yellow 40%, "
            + "green 60%, blue 80%, purple 100%);"
            + " -fx-font-weight: bold; -fx-font-size: 24");
        //button to enter game
        Button enterGame = new Button("Enter Game");
        enterGame.setStyle("-fx-font-size: 16");
        //vbox
        VBox startBox = new VBox();
        startBox.setSpacing(40);
        startBox.setAlignment(Pos.CENTER);
        startBox.getChildren().add(titleLabel);
        startBox.getChildren().add(enterGame);
        //stackpane
        StackPane startPane = new StackPane();
        startPane.getChildren().add(startBox);



        //game over screen
        Label gameOverLabel = new Label("Game Over!");
        gameOverLabel.setStyle("-fx-font-fill: red; -fx-font-weight: bold; "
            + "-fx-font-size: 24");
        //try again button
        Button tryAgainButton = new Button("Try Again?");
        tryAgainButton.setStyle("-fx-font-size: 16");
        VBox overBox = new VBox();
        overBox.setSpacing(40);
        overBox.setAlignment(Pos.CENTER);
        overBox.getChildren().add(gameOverLabel);
        overBox.getChildren().add(tryAgainButton);
        //StackPane
        StackPane overPane = new StackPane();
        overPane.getChildren().add(overBox);
        Scene overScene = new Scene(overPane, 300, 200);



        //actual game after title screen
        //make all buttons/labels/etc
        Label nameLabel = new Label("Name: " + getName());
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name here");
        Button enterButton = new Button("Enter");
        Label scoreLabel = new Label("Score: " + getScore());
        questionButton.setStyle("-fx-background-color: " + randColors());
        Button resetButton = new Button("Reset");
        try1.setStyle("-fx-background-color: " + randColors());
        try2.setStyle("-fx-background-color: " + randColors());
        try3.setStyle("-fx-background-color: " + randColors());
        Button noneButton = new Button("None");
        Label answerLabel = new Label(getAnswerStr());

        //set borderPane and arrange elements into window
        BorderPane borderPane = new BorderPane();
        //right is resetButton/noneButton
        VBox rightBox = new VBox();
        rightBox.setSpacing(75);
        rightBox.setPadding(new Insets(10, 10, 10, 10));
        rightBox.setAlignment(Pos.CENTER);
        rightBox.getChildren().add(resetButton);
        rightBox.getChildren().add(noneButton);
        borderPane.setRight(rightBox);
        //center is namefield, enter, score, question button, and options
        VBox centerBox = new VBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setSpacing(10);
        //name field and enter
        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER);
        nameBox.getChildren().add(nameField);
        nameBox.getChildren().add(enterButton);
        //question box
        HBox questionBox = new HBox();
        questionBox.setAlignment(Pos.CENTER);
        questionBox.getChildren().add(questionButton);
        //choice boxes
        HBox choiceBox = new HBox();
        choiceBox.setSpacing(10);
        choiceBox.setAlignment(Pos.CENTER);
        choiceBox.getChildren().add(try1);
        choiceBox.getChildren().add(try2);
        choiceBox.getChildren().add(try3);
        //add all to center box
        centerBox.getChildren().add(nameLabel);               //name label
        centerBox.getChildren().add(nameBox);                 //name field and enter
        centerBox.getChildren().add(scoreLabel);              //score Label
        centerBox.getChildren().add(questionBox);             //question box
        centerBox.getChildren().add(choiceBox);               //choice boxes
        centerBox.getChildren().add(answerLabel);             //answer t/f label
        borderPane.setCenter(centerBox);                      //set center pane

        //set action events and handlers
        enterButton.setOnAction(e -> {                        //name enter
            nameLabel.setText("Name: " + nameField.getText());
            nameField.clear();
        });
        nameLabel.requestFocus();

        resetButton.setOnAction(e -> {
            setName("None");
            nameLabel.setText("Name: " + getName());
            setScore(0);
            scoreLabel.setText("Score: " + getScore());
            nameField.clear();
            resetColors();
            setAnswerStr("Choose an answer to begin!");
            answerLabel.setText(getAnswerStr());
        });
        nameLabel.requestFocus();
        scoreLabel.requestFocus();

        try1.setOnAction(e -> {
            if (try1.getStyle().substring(22).equals(questionButton.getText())) {
                score += 1;
                scoreLabel.setText("Score: " + getScore());
                setAnswerStr("Correct!");
                MediaPlayer mp = new MediaPlayer(correctV);
                mp.play();
                answerLabel.setText(getAnswerStr());
                resetColors();
            } else {
                setScore(0);
                scoreLabel.setText("Score: " + getScore());
                setAnswerStr("Incorrect :(");
                MediaPlayer mpo = new MediaPlayer(gameOverV);
                mpo.play();
                answerLabel.setText(getAnswerStr());
                resetColors();
                stage.setTitle("Game Over!");
                stage.setScene(overScene);
                stage.show();
            }
        });

        try2.setOnAction(e -> {
            if (try2.getStyle().substring(22).equals(questionButton.getText())) {
                score += 1;
                scoreLabel.setText("Score: " + getScore());
                setAnswerStr("Correct!");
                MediaPlayer mp = new MediaPlayer(correctV);
                mp.play();
                answerLabel.setText(getAnswerStr());
                resetColors();
            } else {
                setScore(0);
                scoreLabel.setText("Score: " + getScore());
                setAnswerStr("Incorrect :(");
                MediaPlayer mpo = new MediaPlayer(gameOverV);
                mpo.play();
                answerLabel.setText(getAnswerStr());
                resetColors();
                stage.setTitle("Game Over!");
                stage.setScene(overScene);
                stage.show();
            }
        });

        try3.setOnAction(e -> {
            if (try3.getStyle().substring(22).equals(questionButton.getText())) {
                score += 1;
                scoreLabel.setText("Score: " + getScore());
                setAnswerStr("Correct!");
                MediaPlayer mp = new MediaPlayer(correctV);
                mp.play();
                answerLabel.setText(getAnswerStr());
                resetColors();
            } else {
                setScore(0);
                scoreLabel.setText("Score: " + getScore());
                setAnswerStr("Incorrect :(");
                MediaPlayer mpo = new MediaPlayer(gameOverV);
                mpo.play();
                answerLabel.setText(getAnswerStr());
                resetColors();
                stage.setTitle("Game Over!");
                stage.setScene(overScene);
                stage.show();
            }
        });

        noneButton.setOnAction(e -> {
            if (!try1.getStyle().substring(22).equals(questionButton.getText())
                && !try2.getStyle().substring(22).equals(questionButton.getText())
                && !try3.getStyle().substring(22).equals(questionButton.getText())) {
                score += 1;
                scoreLabel.setText("Score: " + getScore());
                setAnswerStr("Correct!");
                MediaPlayer mp = new MediaPlayer(correctV);
                mp.play();
                answerLabel.setText(getAnswerStr());
                resetColors();
            } else {
                setScore(0);
                scoreLabel.setText("Score: " + getScore());
                setAnswerStr("Incorrect :(");
                MediaPlayer mpo = new MediaPlayer(gameOverV);
                mpo.play();
                answerLabel.setText(getAnswerStr());
                resetColors();
                stage.setTitle("Game Over!");
                stage.setScene(overScene);
                stage.show();
            }
        });

        Scene scene1 = new Scene(borderPane, 300, 200);

        tryAgainButton.setOnAction(e -> {
            setAnswerStr("Choose an answer to begin!");
            answerLabel.setText(getAnswerStr());
            stage.setTitle("Color Game!");
            stage.setScene(scene1);
            stage.show();
        });

        //set scene
        Scene scene = new Scene(startPane, 300, 200);
        stage.setTitle("Color Game!");
        stage.setScene(scene);
        stage.show();

        Media startMusic1 = new Media(new File("newAgeRythm.wav").toURI().toString());
        MediaPlayer startMusic = new MediaPlayer(startMusic1);
        startMusic.setAutoPlay(true);
        MediaView startMusic2 = new MediaView(startMusic);

        enterGame.setOnAction(e -> {
            stage.setTitle("Color Game!");
            stage.setScene(scene1);
            stage.show();
            startMusic.pause();
        });
    }

    /**
    * Method to use to reset button colors after a button has been pressed.
    */
    public void resetColors() {
        questionButton.setText(randColorsNames());
        questionButton.setStyle("-fx-background-color: " + randColors());
        try1.setText(randColorsNames());
        try1.setStyle("-fx-background-color: " + randColors());
        try2.setText(randColorsNames());
        try2.setStyle("-fx-background-color: " + randColors());
        try3.setText(randColorsNames());
        try3.setStyle("-fx-background-color: " + randColors());
    }

    /**
    * Generates a random number for color array index.
    * @return returns int index.
    */
    public static String randColorsNames() {
        Random gen = new Random();
        int i = gen.nextInt(colorsNames.length);
        return colorsNames[i];
    }

    /**
    * Generates a random number for color array index.
    * @return returns Color at rand index.
    */
    public static Colors randColors() {
        Random gen = new Random();
        int len = Colors.values().length;
        int i = gen.nextInt(len);
        return Colors.values()[i];
    }

    /**
    * Main function.
    * @param args arguments.
    */
    public static void main(String[] args) {
        launch();
    }
    /**
    * Name setter method.
    * @param n name.
    */
    public void setName(String n) {
        name = n;
    }
    /**
    * Name getter method.
    * @return returns name.
    */
    public String getName() {
        return name;
    }

    /**
    * Score setter method.
    * @param s score.
    */
    public void setScore(int s) {
        score = s;
    }
    /**
    * Score getter method.
    * @return returns score.
    */
    public int getScore() {
        return score;
    }

    /**
    * AnswerStr setter method.
    * @param a answer.
    */
    public void setAnswerStr(String a) {
        answerStr = a;
    }
    /**
    * AnswerStr getter method.
    * @return returns answer.
    */
    public String getAnswerStr() {
        return answerStr;
    }
}
