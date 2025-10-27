package Module_7.FutureValueApp;


import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class YouskieviczFutureValueApp extends Application {

    // --- Required UI controls ---
    private TextField txtMonthlyPayment;
    private TextField txtInterestRate;
    private TextArea txtResult;
    private Label lblMonthlyPayment;
    private Label lblInterestRate;
    private Label lblYears;
    private Label lblFutureValue;
    private Label lblInterestRateFormat;
    private ComboBox<Integer> cboYears;
    private Button btnCalculate;
    private Button btnClear;

    @Override
    public void start(Stage primaryStage) {

        // labels
        lblMonthlyPayment = new Label("Monthly Payment:");
        lblInterestRate = new Label("Interest Rate:");
        lblYears = new Label("Years:");
        lblFutureValue = new Label("Future Value:");
        lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
        lblInterestRateFormat.setTextFill(Color.RED);

        // text fields
        txtMonthlyPayment = new TextField();
        txtInterestRate = new TextField();
        txtResult = new TextArea();
        txtResult.setEditable(false);
        txtResult.setPrefRowCount(4);

        // combo box 1–10 years
        cboYears = new ComboBox<>();
        for (int i = 1; i <= 10; i++) cboYears.getItems().add(i);
        cboYears.setValue(1);

        // buttons
        btnCalculate = new Button("Calculate");
        btnClear = new Button("Clear");

        // --- layout ---
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);

        // add controls
        grid.add(lblMonthlyPayment, 0, 0);
        grid.add(txtMonthlyPayment, 1, 0);
        grid.add(lblInterestRate, 0, 1);
        grid.add(txtInterestRate, 1, 1);
        grid.add(lblYears, 0, 2);
        grid.add(cboYears, 1, 2);
        grid.add(lblFutureValue, 0, 3);
        grid.add(txtResult, 1, 3);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        grid.add(lblInterestRateFormat, 1, 4);

        // button container (Exhibit F)
        HBox actionBtnContainer = new HBox(10);
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.getChildren().addAll(btnCalculate, btnClear);
        grid.add(actionBtnContainer, 1, 5);

        // --- event handling ---
        btnCalculate.setOnAction(e -> calculateFutureValue());
        btnClear.setOnAction(e -> clearForm());

        // --- scene & stage ---
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Youskievicz Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateFutureValue() {
        try {
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
            double interestRate = Double.parseDouble(txtInterestRate.getText()) / 100;
            int years = cboYears.getValue();
            double months = years * 12;
            double monthlyRate = interestRate / 12;

            double futureValue = monthlyPayment * (Math.pow(1 + monthlyRate, months) - 1) / monthlyRate;
            txtResult.setText(String.format("$%,.2f", futureValue));
        } catch (NumberFormatException ex) {
            txtResult.setText("Invalid input. Please check your numbers.");
        }
    }

    private void clearForm() {
        txtMonthlyPayment.clear();
        txtInterestRate.clear();
        txtResult.clear();
        cboYears.setValue(1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
