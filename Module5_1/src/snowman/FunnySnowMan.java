package snowman;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;

import java.util.Random;

public class FunnySnowMan extends Application {

    int rounds, minR, maxR;
    Circle[] circles;

    public static void main(String[] args){
        //start the javafx app
        launch(args);
    }

    @Override
    public void start (Stage myStage){
        //give title
        myStage.setTitle("Funny Snowman");
        int myStageH = 800;
        int myStageW = 800;
        myStage.setHeight(myStageH);
        myStage.setWidth(myStageW);
        //root node
        Pane rootNode = new Pane();

        TextField roundQtity = new TextField();
        roundQtity.setPromptText("Q-tity of Rounds (1-7)");
        roundQtity.setTranslateX(0);
        roundQtity.setTranslateY(0);
        rootNode.getChildren().add(roundQtity);
        roundQtity.setOnAction(event -> rounds = Integer.parseInt(roundQtity.getText()));

        TextField minRadius = new TextField();
        minRadius.setPromptText("Min Radius (>=5)");
        minRadius.setTranslateX(0);
        minRadius.setTranslateY(20);
        rootNode.getChildren().add(minRadius);
        minRadius.setOnAction(event -> minR = Integer.parseInt(minRadius.getText()));

        TextField maxRadius = new TextField();
        maxRadius.setPromptText("Max Radius (<=50)");
        maxRadius.setTranslateX(0);
        maxRadius.setTranslateY(40);
        rootNode.getChildren().add(maxRadius);
        maxRadius.setOnAction(event -> maxR = Integer.parseInt(maxRadius.getText()));

        Button submit = new Button("Submit");
        submit.setTranslateX(0);
        submit.setTranslateY(80);
        rootNode.getChildren().add(submit);
        submit.setOnAction(event -> {
            rounds = Integer.parseInt(roundQtity.getText());
            minR = Integer.parseInt(minRadius.getText());
            maxR = Integer.parseInt(maxRadius.getText());
            Label label = new Label("Tech specifications of snowman:");
            String s = ("Snowman Tech Specs:\nRounds = "+rounds+"\nminR = "+minR+" \nmax R = "+maxR);
            label.setText(s);
            label.setTranslateX(0);
            label.setTranslateY(200);
            rootNode.getChildren().add(label);
        });

        Button drawSnowMan = new Button("Draw");
        drawSnowMan.setTranslateX(0);
        drawSnowMan.setTranslateY(110);
        rootNode.getChildren().add(drawSnowMan);
        drawSnowMan.setOnAction(event -> {
            rootNode.getChildren().addAll(genSnowMan(rounds, myStageW, myStageH));
        });

        Button allRed = new Button("All Red");
        allRed.setTranslateX(60);
        allRed.setTranslateY(110);
        rootNode.getChildren().add(allRed);
        allRed.setOnAction(event -> {
            paintAllRed(Color.color(1, 0, 0));
        });

        Button gradient = new Button("Gradient");
        gradient.setTranslateX(0);
        gradient.setTranslateY(150);
        rootNode.getChildren().add(gradient);
        gradient.setOnAction(event -> {
            gradientColor();
        });

        Button sort = new Button("Sort");
        sort.setTranslateX(60);
        sort.setTranslateY(150);
        rootNode.getChildren().add(sort);
        sort.setOnAction(event -> {
            Label l = new Label("In progress");
            l.setTranslateX(100);
            l.setTranslateY(150);
            rootNode.getChildren().add(l);
        });

        Button clear = new Button("Clear all");
        clear.setTranslateX(60);
        clear.setTranslateY(80);
        rootNode.getChildren().add(clear);
        clear.setOnAction(event -> {
            rootNode.getChildren().clear();
            rootNode.getChildren().addAll(drawSnowMan, clear, submit, allRed, gradient, sort);
            rootNode.getChildren().addAll(roundQtity, maxRadius, minRadius);
        });


        //scene
        Scene myScene = new Scene(rootNode);
        //set scene on stage
        myStage.setScene(myScene);

        //show the stage with scene
        myStage.show();


    }


    private Circle[] genSnowMan(int rounds, int myStageW, int myStageH){
        Random random = new Random();
        circles = new Circle[rounds+3];
        int initR = 0;
        int initY = myStageH-50;
        int coorX = myStageW/2;
        for(int i=0; i<circles.length-3; i++){
            int r = random.nextInt(maxR-minR)+minR;
            int coorY = initY-initR-r;
            initR = r;
            initY = coorY;
            circles[i] = new Circle(coorX, coorY, r, randomColor());
            }

        Circle[] face =drawFace(coorX, initY, initR);
        for (int i=circles.length-3, j=0; i<circles.length; i++, j++){
            circles[i] = face[j];
        }
        return circles;
        }

        private Circle[] drawFace (int x, int y, int r) {
            Random random = new Random();
            int count = r/4;
            double dx = r/2;
            double dy = r/3;
            Circle nose = new Circle(x, y+dy, random.nextInt(count), randomColor());
            Circle eyeL = new Circle(x+dx, y-dy, random.nextInt(count),randomColor());
            Circle eyeR = new Circle(x-dx, y-dy, random.nextInt(count), randomColor());

            Circle[] face = new Circle[] {nose, eyeL, eyeR};
            return face;
        }


        private Paint randomColor(){
            Random random = new Random();
            Color color = Color.color(random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble(),
                    1.0f);
            return Paint.valueOf(color.toString());
        }

        private void paintAllRed(Color color) {
            if (circles == null) return;
            for(int i = 0; i < circles.length; i++)
                circles[i].setFill(Paint.valueOf(color.toString()));
        }

        private void gradientColor(){
            if (circles == null) return;
            Color c;
            double index = 1.0/(rounds+3);
            for(int i = 0; i < circles.length; i++){
                c = Color.color(index*i,index*i,index*i);
                circles[i].setFill(Paint.valueOf(c.toString()));
            }
        }

}


