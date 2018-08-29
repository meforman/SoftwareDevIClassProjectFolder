package edu.seminolestate.callbutton;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Michael Forman
 * CallButtonGui class to simulate call buttons on an airliner
 *
 */
public class CallButtonGui extends Application 
{
	Image backGround = new Image("images/callButtonImage.jpg");
	BackgroundImage myBI = new BackgroundImage(new Image("images/callButtonImage.jpg", 1009, 448, true, true), BackgroundRepeat.REPEAT,
			BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	          BackgroundSize.DEFAULT);
	private Button callButtonOne = new Button("  Call  ");
	private Button cancelButtonOne = new Button("  Cancel  ");
	private Button callButtonTwo = new Button("  Call  ");
	private Button cancelButtonTwo = new Button("  Cancel  ");
	private Button callButtonThree = new Button("  Call  ");
	private Button cancelButtonThree = new Button("  Cancel  ");
	private Button callButtonFour = new Button("  Call  ");
	private Button cancelButtonFour = new Button("  Cancel  ");
	private Button callButtonFive = new Button("  Call  ");
	private Button cancelButtonFive = new Button("  Cancel  ");
	private Button cancelAll = new Button("  Cancel All  ");
	private Button lightOne = new Button(" ");
	private Button lightTwo = new Button(" ");
	private Button lightThree = new Button(" ");
	private Button lightFour = new Button(" ");
	private Button lightFive = new Button(" ");
	
	
	
	

	/** Main method only launches GUI
	 * @param args none
	 */
	public static void main(String[] args) {
		launch(args);

	}
	
	/* (non-Javadoc) Start method to create and run GUI
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	public void start (Stage primaryStage) throws Exception{
		
		callButtonOne.setLayoutY(380);
		callButtonOne.setLayoutX(55);
		cancelAll.setLayoutY(380);
		cancelAll.setLayoutX(228);
		callButtonTwo.setLayoutY(380);
		callButtonTwo.setLayoutX(443);
		callButtonThree.setLayoutY(380);
		callButtonThree.setLayoutX(590);
		callButtonFour.setLayoutY(380);
		callButtonFour.setLayoutX(737);
		callButtonFive.setLayoutY(380);
		callButtonFive.setLayoutX(884);
		cancelButtonOne.setLayoutY(403);
		cancelButtonOne.setLayoutX(48);
		cancelButtonTwo.setLayoutY(403);
		cancelButtonTwo.setLayoutX(436);
		cancelButtonThree.setLayoutY(403);
		cancelButtonThree.setLayoutX(583);
		cancelButtonFour.setLayoutY(403);
		cancelButtonFour.setLayoutX(730);
		cancelButtonFive.setLayoutY(403);
		cancelButtonFive.setLayoutX(877);
		lightOne.setLayoutY(25);
		lightOne.setLayoutX(90);
		lightTwo.setLayoutY(25);
		lightTwo.setLayoutX(480);
		lightThree.setLayoutY(25);
		lightThree.setLayoutX(627);
		lightFour.setLayoutY(25);
		lightFour.setLayoutX(773);
		lightFive.setLayoutY(25);
		lightFive.setLayoutX(922);
		lightOne.setStyle("-fx-background-color: None");
		lightTwo.setStyle("-fx-background-color: None");
		lightThree.setStyle("-fx-background-color: None");
		lightFour.setStyle("-fx-background-color: None");
		lightFive.setStyle("-fx-background-color: None");
		
		
		BorderPane thePane = new BorderPane();
		thePane.setPadding(new Insets(5));
		
		Pane drawingPane = new Pane();
		drawingPane.setBackground(new Background(myBI));
		drawingPane.getChildren().setAll(lightOne, lightTwo, lightThree, lightFour, lightFive, callButtonOne, cancelAll, callButtonTwo, 
				callButtonThree, callButtonFour, callButtonFive, cancelButtonOne, 
				cancelButtonTwo, cancelButtonThree, cancelButtonFour, cancelButtonFive);
		
		callButtonOne.setOnAction(e -> lightButton(1));
		callButtonTwo.setOnAction(e -> lightButton(2));
		callButtonThree.setOnAction(e -> lightButton(3));
		callButtonFour.setOnAction(e -> lightButton(4));
		callButtonFive.setOnAction(e -> lightButton(5));
		
		cancelButtonOne.setOnAction(e -> cancelButton(1));
		cancelButtonTwo.setOnAction(e -> cancelButton(2));
		cancelButtonThree.setOnAction(e -> cancelButton(3));
		cancelButtonFour.setOnAction(e -> cancelButton(4));
		cancelButtonFive.setOnAction(e -> cancelButton(5));
		
		cancelAll.setOnAction(e -> cancelAll());
		
		
		Scene scene = new Scene(drawingPane, 1009, 448);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		primaryStage.setTitle("Call Button App");
	}
	
	
/** Method to change button color from none to orange when appropriate button pressed
 * @param buttonNumber number of the button to activate
 */
public void lightButton(int buttonNumber){
	if (buttonNumber == 1) {
		lightOne.setStyle("-fx-background-color: Orange"); 
		java.awt.Toolkit.getDefaultToolkit().beep();
	}
		if (buttonNumber == 2) {
		lightTwo.setStyle("-fx-background-color: Orange");
		java.awt.Toolkit.getDefaultToolkit().beep();
		}
		if (buttonNumber == 3){
		lightThree.setStyle("-fx-background-color: Orange");
		java.awt.Toolkit.getDefaultToolkit().beep();
}
	if (buttonNumber == 4){
		lightFour.setStyle("-fx-background-color: Orange");
	java.awt.Toolkit.getDefaultToolkit().beep();
}
	if (buttonNumber == 5){
		lightFive.setStyle("-fx-background-color: Orange");
	java.awt.Toolkit.getDefaultToolkit().beep();
}
}


/** Method to change button color from orange to none when appropriate button pressed
 * @param buttonNumber number of light to deactivate
 */
public void cancelButton(int buttonNumber){
	if (buttonNumber == 1)
		lightOne.setStyle("-fx-background-color: None");
	if (buttonNumber == 2)
		lightTwo.setStyle("-fx-background-color: None");
	if (buttonNumber == 3)
		lightThree.setStyle("-fx-background-color: None");
	if (buttonNumber == 4)
		lightFour.setStyle("-fx-background-color: None");
	if (buttonNumber == 5)
		lightFive.setStyle("-fx-background-color: None");
}


/** Method to return all lights to background None when Cancel All button pressed
 * 
 */
public void cancelAll() {
	lightOne.setStyle("-fx-background-color: None");
	lightTwo.setStyle("-fx-background-color: None");
	lightThree.setStyle("-fx-background-color: None");
	lightFour.setStyle("-fx-background-color: None");
	lightFive.setStyle("-fx-background-color: None");
}
	
}
