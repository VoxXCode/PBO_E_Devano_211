// Import semua library JavaFX dan Java standar yang diperlukan
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.effect.Glow;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.animation.*;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*; // Untuk file I/O (baca dan tulis highscore)
import java.util.*; // Untuk Random dan utilitas lainnya

public class TebakAngkaApp extends Application {
    // Variabel global untuk menyimpan status permainan
    private int targetNumber; // Angka yang harus ditebak
    private int attempts = 0; // Jumlah percobaan
    private int score = 0; // Skor saat ini
    private int difficultyRange = 100; // Rentang angka tergantung tingkat kesulitan
    private boolean gameOver = false; // Menandai apakah game selesai

    // Objek audio
    private MediaPlayer correctSound;
    private MediaPlayer wrongSound;
    private MediaPlayer backgroundMusic;

    // Komponen UI
    private Label feedbackLabel;
    private Label scoreLabel;
    private Label attemptsLabel;
    private Label highScoreLabel;
    private int highScore = 0; // High score tersimpan

    private Timeline timer; // Timer untuk menghitung waktu permainan
    private int timeLeft = 30;
    private Label timerLabel;
    private TextField inputField;
    private Button guessBtn;

    @Override
    public void start(Stage primaryStage) {
        loadHighScore(); // Baca high score dari file jika ada
        setupGame(primaryStage); // Siapkan tampilan awal (menu kesulitan)
    }

    // Menyusun tampilan utama dan menu tingkat kesulitan
    private void setupGame(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #f0f8ff; -fx-padding: 20;");

        // Tombol tingkat kesulitan
        HBox difficultyBox = new HBox(10);
        Button easyBtn = new Button("Easy (1-50)");
        Button mediumBtn = new Button("Medium (1-100)");
        Button hardBtn = new Button("Hard (1-200)");

        // Event handler untuk masing-masing tingkat kesulitan
        easyBtn.setOnAction(e -> startGame(primaryStage, 50));
        mediumBtn.setOnAction(e -> startGame(primaryStage, 100));
        hardBtn.setOnAction(e -> startGame(primaryStage, 200));

        difficultyBox.getChildren().addAll(easyBtn, mediumBtn, hardBtn);

        // Tambahkan elemen ke root
        root.getChildren().add(new Label("🎮 Pilih Tingkat Kesulitan:"));
        root.getChildren().add(difficultyBox);

        // Buat UI permainan (sembunyi dulu)
        VBox gameUI = createGameUI();
        gameUI.setVisible(false);
        root.getChildren().add(gameUI);

        // Atur dan tampilkan jendela
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setTitle("🎮 Tebak Angka Pro Max");
        primaryStage.show();
    }

    // Membuat tampilan antarmuka permainan
    private VBox createGameUI() {
        VBox gameBox = new VBox(15);
        gameBox.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("🎯 Tebak Angka");
        titleLabel.setFont(Font.font(24));
        titleLabel.setTextFill(Color.DARKBLUE);

        feedbackLabel = new Label(""); // Label umpan balik
        feedbackLabel.setFont(Font.font(18));

        inputField = new TextField(); // Input angka
        inputField.setPromptText("Masukkan angka (1-" + difficultyRange + ")");
        inputField.setPrefWidth(200);

        // Tombol tebakan
        guessBtn = new Button("Coba Tebak!");
        guessBtn.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-weight: bold;");

        // Efek cahaya saat mouse hover
        Glow glow = new Glow(0.8);
        guessBtn.setOnMouseEntered(e -> guessBtn.setEffect(glow));
        guessBtn.setOnMouseExited(e -> guessBtn.setEffect(null));

        // Label info skor, percobaan, timer, highscore
        HBox infoBox = new HBox(20);
        scoreLabel = new Label("Skor: 0");
        attemptsLabel = new Label("Percobaan: 0");
        highScoreLabel = new Label("High Score: " + highScore);
        timerLabel = new Label("Waktu: 30s");
        infoBox.getChildren().addAll(scoreLabel, attemptsLabel, highScoreLabel, timerLabel);
        infoBox.setAlignment(Pos.CENTER);

        // Action tombol
        guessBtn.setOnAction(e -> handleGuess());

        // Susun semua komponen
        gameBox.getChildren().addAll(titleLabel, feedbackLabel, inputField, guessBtn, infoBox);
        return gameBox;
    }

    // Memulai ulang permainan dengan rentang baru (berdasarkan tingkat kesulitan)
    private void startGame(Stage primaryStage, int range) {
        this.difficultyRange = range;
        this.targetNumber = new Random().nextInt(range) + 1;
        this.attempts = 0;
        this.score = 0;
        this.gameOver = false;
        this.timeLeft = 30;

        VBox root = (VBox) primaryStage.getScene().getRoot();
        VBox gameUI = (VBox) root.getChildren().get(2);
        gameUI.setVisible(true); // Tampilkan UI permainan

        // Reset tampilan
        scoreLabel.setText("Skor: 0");
        attemptsLabel.setText("Percobaan: 0");
        highScoreLabel.setText("High Score: " + highScore);
        timerLabel.setText("Waktu: 30s");
        feedbackLabel.setText("");
        feedbackLabel.setTextFill(Color.BLACK);
        inputField.setDisable(false);
        inputField.clear();
        guessBtn.setText("Coba Tebak!");
        guessBtn.setDisable(false);
        guessBtn.setOnAction(e -> handleGuess());

        // Atur timer countdown
        if (timer != null) timer.stop();
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            timerLabel.setText("Waktu: " + timeLeft + "s");
            if (timeLeft <= 0) {
                timer.stop();
                gameOver = true;
                setFeedback("⏰ Waktu habis! Coba lagi ya!", Color.RED);
                inputField.setDisable(true);
                guessBtn.setText("Main Lagi");
                guessBtn.setOnAction(ev -> startGame(primaryStage, difficultyRange));
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    // Logika saat tombol "Coba Tebak" ditekan
    private void handleGuess() {
        if (gameOver) return;

        String input = inputField.getText();
        if (input.isEmpty()) {
            setFeedback("⚠ Masukkan angka terlebih dahulu!", Color.RED);
            return;
        }

        int guess;
        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            setFeedback("⚠ Input harus berupa angka!", Color.RED);
            return;
        }

        if (guess < 1 || guess > difficultyRange) {
            setFeedback("⚠ Angka harus antara 1 sampai " + difficultyRange + "!", Color.RED);
            return;
        }

        attempts++;
        attemptsLabel.setText("Percobaan: " + attempts);

        if (guess < targetNumber) {
            setFeedback("⬇ Terlalu kecil!", Color.ORANGE);
            playWrongSound();
        } else if (guess > targetNumber) {
            setFeedback("⬆ Terlalu besar!", Color.ORANGE);
            playWrongSound();
        } else {
            setFeedback("✅ Tebakan benar!", Color.GREEN);
            playCorrectSound();
            score += 10;
            scoreLabel.setText("Skor: " + score);
            if (score > highScore) {
                highScore = score;
                highScoreLabel.setText("High Score: " + highScore);
                saveHighScore();
            }
            gameOver = true;
            timer.stop();
            inputField.setDisable(true);
            guessBtn.setText("Main Lagi");
            guessBtn.setOnAction(e -> startGame((Stage) guessBtn.getScene().getWindow(), difficultyRange));
        }
        inputField.clear();
    }

    // Menampilkan umpan balik dengan animasi
    private void setFeedback(String message, Color color) {
        feedbackLabel.setText(message);
        feedbackLabel.setTextFill(color);

        // Efek fade in
        FadeTransition ft = new FadeTransition(Duration.millis(500), feedbackLabel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    // Suara saat tebakan benar
    private void playCorrectSound() {
        // TODO: Tambahkan file audio dan path
        // Example:
        // Media sound = new Media(new File("correct.mp3").toURI().toString());
        // correctSound = new MediaPlayer(sound);
        // correctSound.play();
    }

    // Suara saat tebakan salah
    private void playWrongSound() {
        // TODO: Tambahkan file audio dan path
        // Example:
        // Media sound = new Media(new File("wrong.mp3").toURI().toString());
        // wrongSound = new MediaPlayer(sound);
        // wrongSound.play();
    }

    // Membaca highscore dari file
    private void loadHighScore() {
        try (BufferedReader br = new BufferedReader(new FileReader("highscore.txt"))) {
            highScore = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            highScore = 0; // Jika file tidak ada, highscore = 0
        }
    }

    // Menyimpan highscore ke file
    private void saveHighScore() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("highscore.txt"))) {
            bw.write(String.valueOf(highScore));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Fungsi utama
    public static void main(String[] args) {
        launch(args);
    }
}
