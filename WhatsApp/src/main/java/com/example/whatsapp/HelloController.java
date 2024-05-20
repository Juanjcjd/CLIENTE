package com.example.whatsapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField ipField;

    @FXML
    private TextField portField;

    // Método para conectarse al servidor de chat
    @FXML
    private void connect() {
        String name = nameField.getText();
        String ip = ipField.getText();
        int port = Integer.parseInt(portField.getText());

        try {
            // Cargar la vista del chat desde el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatView.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del chat y inicializar la conexión
            ChatController chatController = loader.getController();
            chatController.initialize(name, ip, port);

            // Crear una nueva ventana para el chat y mostrarla
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("JavaFX Chat - " + name);
            stage.show();

            // Cerrar la ventana actual (la ventana de conexión)
            Stage currentStage = (Stage) nameField.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
