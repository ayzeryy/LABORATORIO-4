package main.view;

import java.util.*;
import main.controller.*;
import main.model.*;

public class MainView {
    private ContentController contentController;
    private UserController userController;

    public MainView(ContentController contentCtrl, UserController userCtrl) {
        this.contentController = contentCtrl;
        this.userController = userCtrl;
    }

    public void showMainMenu() {
        System.out.println("==== Sistema de Gestión de Contenidos ====");
        System.out.println("1. Crear contenido");
        System.out.println("2. Buscar contenido");
        System.out.println("3. Ver todos los contenidos");
        System.out.println("4. Generar reporte");
    }

    public void showContentList() {
        for (Content c : contentController.getAllContents()) {
            System.out.println("- " + c.getTitle() + " (" + c.getClass().getSimpleName() + ")");
        }
    }

    public void showReport() {
        System.out.println(contentController.generateReport());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
