package main;

import main.controller.*;
import main.view.*;
import main.model.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        ContentController contentCtrl = new ContentController();
        UserController userCtrl = new UserController();
        MainView view = new MainView(contentCtrl, userCtrl);

        // Crear usuarios de prueba
        userCtrl.registerUser("admin", "Luis", "luis@uvg.edu.gt");

        // Crear contenido de ejemplo
        Map<String, Object> data = new HashMap<>();
        data.put("title", "Ejemplo de artículo");
        data.put("author", "Luis G.");
        data.put("text", "Este es un artículo de ejemplo.");
        contentCtrl.createContent("article", data);

        view.showMainMenu();
        view.showReport();
    }
}
