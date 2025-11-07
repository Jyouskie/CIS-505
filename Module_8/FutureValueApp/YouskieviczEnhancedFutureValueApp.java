package Module_8.FutureValueApp;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class YouskieviczEnhancedFutureValueApp extends Application {

    // UI controls
    private TextField txtMonthlyPayment;
    private TextField txtInterestRate;
    private ComboBox<Integer> cbYears;
    private TextArea txtResults;
    private Label lblMonthlyPayment, lblInterestRate, lblYears, lblFutureValue, lblHint, lblFutureValueDate;
    private Button btnCalculate, btnClear;

    @Override
    public void start(Stage stage) {
        // labels
        lblMonthlyPayment = new Label("Monthly Payment:");
        lblInterestRate  = new Label("Interest Rate:");
        lblYears         = new Label("Years:");
        lblFutureValue   = new Label("Future Value:");
        lblHint          = new Label("Enter 11.1% as 11.1");
        lblHint.setTextFill(Color.RED);
        lblFutureValueDate = new Label(""); // will show: Calculation as of <today>

        // fields
        txtMonthlyPayment = new TextField();
        txtInterestRate   = new TextField();
        txtResults        = new TextArea();
        txtResults.setEditable(false);
        txtResults.setPrefRowCount(4);

        cbYears = new ComboBox<>();
        for (int i = 1; i <= 10; i++) cbYears.getItems().add(i);
        cbYears.setValue(1);

        // buttons
        btnCalculate = new Button("Calculate");
        btnClear     = new Button("Clear");

        // layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(12));
        grid.setHgap(6);
        grid.setVgap(6);

        int r = 0;
        grid.add(lblMonthlyPayment, 0, r);
        grid.add(txtMonthlyPayment, 1, r++);

        grid.add(lblInterestRate, 0, r);
        grid.add(txtInterestRate, 1, r++);
        grid.add(lblHint, 1, r++); // <-- move hint just below interest rate box

        grid.add(lblYears, 0, r);
        grid.add(cbYears, 1, r++);

        grid.add(lblFutureValue, 0, r);
        grid.add(txtResults, 1, r++);

        grid.add(lblFutureValueDate, 1, r++); // <-- move date label right below results

        HBox buttons = new HBox(10, btnCalculate, btnClear);
        buttons.setPadding(new Insets(10, 0, 0, 0));
        grid.add(buttons, 1, r);


        // wire events (assignment requirement)
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        Scene scene = new Scene(grid, 440, 360);
        stage.setTitle("Youskievicz Enhanced Future Value App");
        stage.setScene(scene);
        stage.show();
    }

    // clear form
    private void clearFormFields() {
        txtMonthlyPayment.clear();
        txtInterestRate.clear();
        txtResults.clear();
        lblFutureValueDate.setText("");
        cbYears.setValue(0);
    }

    // collect input, call FinanceCalculator, set date + results text
    private void calculateResults() {
        try {
            double monthly = Double.parseDouble(txtMonthlyPayment.getText());
            double ratePct = Double.parseDouble(txtInterestRate.getText());
            Integer years  = cbYears.getValue();

            if (years == null || years <= 0) {
                txtResults.setText("Please choose years (1–10).");
                return;
            }

            double fv = FinanceCalculator.calculateFutureValue(monthly, ratePct, years);

            lblFutureValueDate.setText("Calculation as of " + getTodayDate());
            txtResults.setText(String.format("The future value is $%,.2f", fv));
        } catch (NumberFormatException ex) {
            txtResults.setText("Invalid input. Please check your numbers.");
        }
    }

    // today’s date in MM/dd/yyyy
    private String getTodayDate() {
        return new SimpleDateFormat("MM/dd/yyyy").format(new Date());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
