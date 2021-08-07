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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.crud.db.DBConnection;
import lk.ijse.crud.model.Item;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemController implements Initializable {
    @FXML
    private TextField txtItemPrice;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtItemExpDate;

    @FXML
    private TextField txtItemQty;

    @FXML
    void btnSave(ActionEvent event) {
        Item cust=new Item(txtItemName.getText(),txtItemPrice.getText(),txtItemExpDate.getText(),txtItemQty.getText());
        try {
            Connection con = DBConnection.getInstance().getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
            stm.setString(1, cust.getName());
            stm.setString(2, cust.getPrice());
            stm.setString(3, cust.getExpDate());
            stm.setString(4, cust.getQty());
            boolean saved = stm.executeUpdate() > 0;
            if (saved) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Item");
                alert.setHeaderText("Item Saved !");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Customer");
                alert.setHeaderText("Please  Check your Values");
                alert.show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        clearAll();


    }
    private void clearAll() {
        txtItemName.setText(null);
        txtItemPrice.setText(null);
        txtItemExpDate.setText(null);
        txtItemQty.setText(null);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
