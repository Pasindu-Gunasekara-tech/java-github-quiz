/*
 *  ---------------------------------------------------------------------------------------------
 *  Copyright (c) 2021 - present IJSE. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  --------------------------------------------------------------------------------------------
 */


package lk.ijse.crud.controller;

/**
 * @author pasindu kavinda <pasindukavinda67@gmail.com>
 * @since {8/7/21}
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


import java.util.Objects;


public class DashbordController {
    @FXML
    private Button btnCustomer;

    @FXML
    private BorderPane main;

    @FXML
    private Button btnItem;
    @FXML
    void navigateToCustomer(ActionEvent event) {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/lk/ijse/crud/view/Customer.fxml")));

        } catch (Exception e) {
            e.printStackTrace();
        }
        main.setCenter(root);
    }

    @FXML
    void navigateToItem(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/lk/ijse/crud/view/Customer.fxml")));

        } catch (Exception e) {
            e.printStackTrace();
        }
        main.setCenter(root);
    }


}
