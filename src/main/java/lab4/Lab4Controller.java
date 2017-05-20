package lab4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

/**
 * Created on 18.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class Lab4Controller implements Initializable{

    @FXML
    private TextField textFieldA;
    @FXML
    private TextField textFieldB;
    @FXML
    private TextField textFieldConst;
    @FXML
    private LineChart<?, ?> chart;
    @FXML
    private TableView<Point> table;
    @FXML
    private ChoiceBox<String> choiceBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calculate(1, 1, 1, "x(y, z)");
    }

    @FXML
    protected void handleA(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case ENTER:
                textFieldB.requestFocus();
                break;
        }
    }

    @FXML
    protected void handleB(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case ENTER:
                textFieldConst.requestFocus();
                break;
        }
    }

    @FXML
    protected void handleConst(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case ENTER:
                calculate(
                        Double.parseDouble(textFieldA.getText().trim()),
                        Double.parseDouble(textFieldB.getText().trim()),
                        Double.parseDouble(textFieldConst.getText().trim()),
                        choiceBox.getSelectionModel().getSelectedItem()
                );
                break;
        }
    }

    private void calculate(double a, double b, double constant, String mode) {
        table.getItems().clear();
        chart.getData().clear();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series1.setName("x < a");
        series2.setName("x > a");
        ArrayList<Point> list1 = new ArrayList<>();
        ArrayList<Point> list2 = new ArrayList<>();
        double y;
        double z;
        switch (mode){
            case "x(y, z)" :
                y = -5;
                while (y <= 5) {
                    z = (y - b) * (y - b) / b;
                    while (z < 2*(y - b) * (y - b) / b) {
                        double buf = Math.sqrt(a * z - a / b * (y - b) * (y - b));
                        table.getItems().add(new Point(a - buf, y, z));
                        table.getItems().add(new Point(a + buf, y, z));
                        z += 0.2;
                    }
                    y += 0.2;
                }
                table.getItems().sort(Comparator.comparingDouble(Point::getX));
                chart.getData().clear();
                break;
            case "x(y, const)" :
                y = b + Math.sqrt(b * constant);
                while (y > 0) {
                    double buf = Math.sqrt(a * constant - a / b * (y - b) * (y - b));
                    list1.add(new Point(a - buf, y, constant));
                    list2.add(new Point(a + buf, y, constant));
                    y -= 0.2;
                }
                table.getItems().addAll(list1);
                table.getItems().addAll(list2);
                table.getItems().sort(Comparator.comparingDouble(Point::getX));
                list1.forEach(point -> series1.getData().add(new XYChart.Data(point.getY(), point.getX())));
                list2.forEach(point -> series2.getData().add(new XYChart.Data(point.getY(), point.getX())));
                break;
            case "x(const, z)" :
                z = (constant - b) * (constant - b) / b;
                while (z < 2 * (constant - b) * (constant - b) / b) {
                    double buf = Math.sqrt(a * z - a / b * (constant - b) * (constant - b));
                    list1.add(new Point(a - buf, constant, z));
                    list2.add(new Point(a + buf, constant, z));
                    z += 0.2;
                }
                table.getItems().addAll(list1);
                table.getItems().addAll(list2);
                table.getItems().sort(Comparator.comparingDouble(Point::getX));

                list1.forEach(point -> series1.getData().add(new XYChart.Data(point.getZ(), point.getX())));
                list2.forEach(point -> series2.getData().add(new XYChart.Data(point.getZ(), point.getX())));
                break;
        }
        chart.getData().addAll(series1);
        chart.getData().addAll(series2);
    }


    public void handleButton(ActionEvent actionEvent) {
        calculate(
                Double.parseDouble(textFieldA.getText().trim()),
                Double.parseDouble(textFieldB.getText().trim()),
                Double.parseDouble(textFieldConst.getText().trim()),
                choiceBox.getSelectionModel().getSelectedItem()
        );
    }
}
