/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jora316.vop.obl.pkg1;

import java.net.InterfaceAddress;
import java.net.URL;
import java.util.ResourceBundle;

import ancient_encryption.AtbashCipher;
import ancient_encryption.CeasarCipher;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author alsle
 */
public class FXMLDocumentController implements Initializable {

    AtbashCipher at = new AtbashCipher();
    CeasarCipher ce;

    @FXML
    private Label label;
    @FXML
    private ToggleGroup encryptRadio;
    @FXML
    private RadioButton atbashEn;
    @FXML
    private RadioButton ceasarEn;
    @FXML
    private Button enBtn;
    @FXML
    private Button deBtn;
    @FXML
    private TextArea msg;
    @FXML
    private Spinner<Integer> cKey = new Spinner<>();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Sets the spinners initial value
        SpinnerValueFactory<Integer> v = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 452);
        cKey.setValueFactory(v);
        ce = new CeasarCipher(cKey.getValue());
        atbashEn.setSelected(true); // Preselects the atbash encryption
    }




    @FXML
    public void enBtnHandler(){
        if(atbashEn.isSelected()){
            msg.setText(at.encrypt(msg.getText()));
        }
        if(ceasarEn.isSelected()){
            ce.setRotFactor(cKey.getValue());
            msg.setText(ce.encrypt(msg.getText()));
        }

    }

    @FXML
    public void deBtnHandler(){
        if(atbashEn.isSelected()){
            msg.setText(at.decrypt(msg.getText()));
        }
        if(ceasarEn.isSelected()){
            ce.setRotFactor(cKey.getValue());
            msg.setText(ce.decrypt(msg.getText()));
        }
    }

    
}
