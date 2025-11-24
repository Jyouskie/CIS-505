package Module_11.GradeBookApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class GradeBookApp extends Application {

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

    // CSV file name
    private static final String GRADES_FILE = "grades.csv";

    @Override
    public void start(Stage stage) {
        // ----- Title -----
        lblTitle = new Label("GradeBookApp");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // ----- Form Labels -----
        lblFirstName = new Label("First Name:");
        lblLastName  = new Label("Last Name:");
        lblCourse    = new Label("Course:");
        lblGrade     = new Label("Grade (A–F):");

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
        btnSave  = new Button("Save");
        btnView  = new Button("View Grades");
        btnClear = new Button("Clear");
        btnSave.setDefaultButton(true);

        HBox buttons = new HBox(10, btnSave, btnView, btnClear);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        // ----- Results -----
        lblResultsHeader = new Label("Results:");
        txtResults = new TextArea();
        txtResults.setEditable(false);
        txtResults.setWrapText(true);
        txtResults.setPromptText("(Saved grades will display here)");

        // ----- Layout -----
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(16));
        grid.setHgap(10);
        grid.setVgap(10);

        int r = 0;

        // Title
        grid.add(lblTitle, 0, r, 2, 1);
        GridPane.setMargin(lblTitle, new Insets(0, 0, 10, 0));

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

        // Grade + hint
        r++;
        grid.add(lblGrade, 0, r);
        grid.add(cbGrade, 1, r);

        r++;
        grid.add(lblHint, 1, r);

        // Buttons
        r++;
        grid.add(buttons, 1, r);

        // Results area
        r++;
        grid.add(lblResultsHeader, 0, r);
        grid.add(txtResults, 1, r);
        txtResults.setPrefColumnCount(28);
        txtResults.setPrefRowCount(8);

        BorderPane root = new BorderPane();
        root.setCenter(grid);
        root.setPadding(new Insets(12));

        Scene scene = new Scene(root, 520, 520);
        stage.setTitle("Youskievicz GradeBookApp");
        stage.setScene(scene);
        stage.show();

        // ----- EVENT HANDLERS -----
        btnClear.setOnAction(e -> clearForm());
        btnSave.setOnAction(e -> saveGrade());
        btnView.setOnAction(e -> viewGrades());
    }

    // Clear the form and results area
    private void clearForm() {
        txtFirstName.clear();
        txtLastName.clear();
        txtCourse.clear();
        cbGrade.setValue(null);
        txtResults.clear();
    }

    // Save a grade to CSV and show it in the results area
    private void saveGrade() {
        String firstName = txtFirstName.getText().trim();
        String lastName  = txtLastName.getText().trim();
        String course    = txtCourse.getText().trim();
        String grade     = cbGrade.getValue();

        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || grade == null) {
            txtResults.setText("Please fill in all fields and select a grade before saving.");
            return;
        }

        Student student = new Student(firstName, lastName, course, grade);

        Path path = Paths.get(GRADES_FILE);
        boolean fileExists = Files.exists(path);

        try (BufferedWriter writer = Files.newBufferedWriter(
                path,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            // Write header if file is new
            if (!fileExists) {
                writer.write("firstName,lastName,course,grade");
                writer.newLine();
            }

            // Write student CSV line
            writer.write(student.toCsv());
            writer.newLine();

            txtResults.setText("Saved: " + student.toString());

            // Optionally clear fields after save
            clearForm();

        } catch (IOException ex) {
            txtResults.setText("Error saving grade: " + ex.getMessage());
        }
    }

    // Read grades.csv and show contents in the results area
    private void viewGrades() {
        Path path = Paths.get(GRADES_FILE);
        if (!Files.exists(path)) {
            txtResults.setText("No grades saved yet. The file 'grades.csv' does not exist.");
            return;
        }

        try {
            List<String> lines = Files.readAllLines(path);
            if (lines.isEmpty()) {
                txtResults.setText("Grades file is empty.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line).append(System.lineSeparator());
            }
            txtResults.setText(sb.toString());

        } catch (IOException ex) {
            txtResults.setText("Error reading grades: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
