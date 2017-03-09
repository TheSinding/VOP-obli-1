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
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import rock_scissors_paper.RockPaperScissors;

/**
 *
 * @author alsle
 */
public class FXMLDocumentController implements Initializable {

    AtbashCipher at = new AtbashCipher();
    CeasarCipher ce;
    RockPaperScissors game = new RockPaperScissors();

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

    @FXML
    private Button paper;

    @FXML
    private Button scissors;

    @FXML
    private Button rock;

    @FXML
    private Text status;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Sets the spinners initial value
        SpinnerValueFactory<Integer> v = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 452);
        cKey.setValueFactory(v);
        ce = new CeasarCipher(cKey.getValue());
        atbashEn.setSelected(true); // Preselects the atbash encryption
        status.setText("WELCOME TO RPS");
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


    public void play(ActionEvent actionEvent) {
        try {
            Button caller = (Button) actionEvent.getSource();
            status.setText(game.play(caller.getId()));
        } catch (ClassCastException err){
            System.out.println("Something bad happend");
        }
    }
}
