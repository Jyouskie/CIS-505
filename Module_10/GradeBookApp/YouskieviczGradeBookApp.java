package Module_10.GradeBookApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class YouskieviczGradeBookApp extends Application {

    // Labels
    private Label lblTitle;
    private Label lblFirstName;
    private Label lblLastName;
    private Label lblCourse;
    private Label lblGrade;
    private Label lblHint;
    private Label lblResultsHeader;

    // Inputs
    private TextField txtFirstName;
    private TextField txtLastName;
    private TextField txtCourse;
    private ComboBox<String> cbGrade;

    // Output
    private TextArea txtResults;

    // Buttons
    private Button btnSave;
    private Button btnView;
    private Button btnClear;

    @Override
    public void start(Stage stage) {
        // ----- Title -----
        lblTitle = new Label("GradeBookApp (UI – Sprint 1)");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // ----- Form Labels -----
        lblFirstName = new Label("First Name:");
        lblLastName  = new Label("Last Name:");
        lblCourse    = new Label("Course:");
        lblGrade     = new Label("Grade (A–F):");

        // Small hint under Grade field to match instructor expectations
        lblHint = new Label("Choose a letter grade A–F");
        lblHint.setTextFill(Color.GRAY);

        // ----- Inputs -----
        txtFirstName = new TextField();
        txtLastName  = new TextField();
        txtCourse    = new TextField();

        cbGrade = new ComboBox<>();
        cbGrade.getItems().addAll("A", "B", "C", "D", "F");
        cbGrade.setPromptText("Select…");

        // ----- Buttons -----
        btnSave = new Button("Save");
        btnView = new Button("View Grades");
        btnClear = new Button("Clear");
        btnSave.setDefaultButton(true);

        HBox buttons = new HBox(10, btnSave, btnView, btnClear);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        // ----- Results area -----
        lblResultsHeader = new Label("Results:");
        txtResults = new TextArea();
        txtResults.setEditable(false);
        txtResults.setWrapText(true);
        txtResults.setPromptText("(Saved grades will display here in Module 11)");

        // ----- Grid layout -----
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(16));
        grid.setHgap(10);
        grid.setVgap(10);

        int r = 0;

        // Title row
        grid.add(lblTitle, 0, r, 2, 1);
        GridPane.setMargin(lblTitle, new Insets(0,0,10,0));

        // First Name
        r++;
        grid.add(lblFirstName, 0, r);
        grid.add(txtFirstName, 1, r);

        // Last Name
        r++;
        grid.add(lblLastName, 0, r);
        grid.add(txtLastName, 1, r);

        // Course
        r++;
        grid.add(lblCourse, 0, r);
        grid.add(txtCourse, 1, r);

        // Grade
        r++;
        grid.add(lblGrade, 0, r);
        grid.add(cbGrade, 1, r);

        // Hint under grade
        r++;
        grid.add(lblHint, 1, r);

        // Buttons row
        r++;
        grid.add(buttons, 1, r);

        // Results header + box
        r++;
        grid.add(lblResultsHeader, 0, r);
        grid.add(txtResults, 1, r);

        // Width for results box
        txtResults.setPrefColumnCount(28);
        txtResults.setPrefRowCount(8);

        // Scene
        BorderPane root = new BorderPane();
        root.setCenter(grid);
        root.setPadding(new Insets(12));

        Scene scene = new Scene(root, 520, 520);
        stage.setTitle("GradeBookApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
