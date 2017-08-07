package snowman;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class StarDrawer extends Application {

    Stage window;
    Scene scene1, scene2;
    Button pentagonGen, octagonGen, exit, backToInputs, toDrawing, submit;
    TextField tfX, tfY, tfR;
    int x, y, r;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage myStage){
        window = myStage;

        //Layout1 - user inputs
        GridPane layout1 = new GridPane();
        layout1.setPadding(new Insets(5,5,5,5));
        layout1.setHgap(5);
        layout1.setVgap(5);

        tfX = new TextField("Input x coord of centre, ");
        GridPane.setConstraints(tfX,0,0);
        tfX.setOnAction(event -> x = Integer.parseInt(tfX.getText()));
        layout1.getChildren().add(tfX);

        tfY = new TextField("Input y coord of centre:");
        GridPane.setConstraints(tfY,0,1);
        tfY.setOnAction(event -> y = Integer.parseInt(tfY.getText()));
        layout1.getChildren().add(tfY);

        tfR = new TextField("Input radius of star:");
        GridPane.setConstraints(tfR,0,2);
        tfR.setOnAction(event -> r = Integer.parseInt(tfR.getText()));
        layout1.getChildren().add(tfR);

        submit = new Button("Submit");
        GridPane.setConstraints(submit,1,0);
        submit.setOnAction(event -> {
            x = Integer.parseInt(tfX.getText());
            y = Integer.parseInt(tfY.getText());
            r = Integer.parseInt(tfR.getText());
        });
        layout1.getChildren().add(submit);

        toDrawing = new Button("Go to Drawing");
        GridPane.setConstraints(toDrawing, 0, 3);
        toDrawing.setOnAction(event ->  window.setScene(scene2));
        layout1.getChildren().add(toDrawing);

        scene1 = new Scene(layout1, 250, 150);

        //Layout2 - window for picture
        Pane layout2 = new Pane();

        exit =new Button("Exit");
        exit.setTranslateY(550);
        exit.setTranslateX(550);
        exit.setOnAction(event -> {
            System.exit(0);
        });
        layout2.getChildren().add(exit);

        backToInputs = new Button("Back to Inputs");
        backToInputs.setTranslateX(0);
        backToInputs.setTranslateY(60);
        backToInputs.setOnAction(event -> window.setScene(scene1));
        layout2.getChildren().add(backToInputs);

        pentagonGen = new Button();
        pentagonGen.setTranslateX(0);
        pentagonGen.setTranslateY(0);
        pentagonGen.setText("Pentagram");
        layout2.getChildren().add(pentagonGen);
        pentagonGen.setOnAction(event -> {
            layout2.getChildren().clear();
            layout2.getChildren().add(exit);
            layout2.getChildren().addAll(pentagonGen, octagonGen);
            layout2.getChildren().add(backToInputs);
            layout2.getChildren().addAll(drawPentagram(x, y, r));
        });

        octagonGen = new Button();
        octagonGen.setTranslateX(0);
        octagonGen.setTranslateY(30);
        octagonGen.setText("Octagon");
        layout2.getChildren().add(octagonGen);
        octagonGen.setOnAction(event -> {
            layout2.getChildren().clear();
            layout2.getChildren().add(exit);
            layout2.getChildren().addAll(octagonGen,pentagonGen);
            layout2.getChildren().add(backToInputs);
            layout2.getChildren().addAll(drawOctagon(x, y, r));
        });

        scene2 = new Scene(layout2, 600,600);

        window.setScene(scene1);
        window.setTitle("Let's Draw a Star");
        window.show();
    }


    private  Line[] drawOctagon(int x0, int y0, int r){
        int angle = 270;
        int x1 = (int)(x0 + r/2.6*Math.cos(angle/57.3));
        int y1 = (int)(y0 - r/2.6*Math.sin(angle/57.3));
        int xn,yn;
        int n = 10;
        Line[] octagon = new Line[n];

        for (int i=0; i<n; i++){
            angle += 360/n;
            if (i%2 == 0){
                xn = (int)(x0 + r*Math.cos(angle/57.3));
                yn = (int)(y0 - r*Math.sin(angle/57.3));
            }else{
                xn = (int)(x0 + r/2.6*Math.cos(angle/57.3));
                yn = (int)(y0 - r/2.6*Math.sin(angle/57.3));
            }
            octagon[i] = new Line( x1, y1, xn, yn);
            x1=xn;
            y1=yn;

        }
        return octagon;
    }

    private Line[] drawPentagram(int x0, int y0, int r){
        Line[] pentagram = new Line[5];
        int x1 = x0;
        int y1 = y0 - r;
        int nextX;
        int nextY;
        for (int i=0; i<5; i++){
            nextX = (int)((x1-x0)*Math.cos(144/57.3)
                    -(y1-y0)*Math.sin(144/57.3) + x0);
            nextY = (int)((x1-x0)*Math.sin(144/57.3)
                    +(y1-y0)*Math.cos(144/57.3) + y0);

            pentagram[i] = new Line(x1, y1, nextX, nextY);
            x1 = nextX;
            y1 = nextY;
        }
        return pentagram;
    }

}
