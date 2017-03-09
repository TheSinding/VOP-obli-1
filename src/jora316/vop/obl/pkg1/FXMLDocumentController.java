/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jora316.vop.obl.pkg1;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import ancient_encryption.AtbashCipher;
import ancient_encryption.CeasarCipher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.*;
import javafx.scene.text.Text;
import rock_scissors_paper.RockPaperScissors;

/**
 *
 * @author alsle
 */
public class FXMLDocumentController implements Initializable {

    AtbashCipher at = new AtbashCipher();
    CeasarCipher ce;
    RockPaperScissors game = new RockPaperScissors();

    Image rockImage     = new Image("Rock.png");
    Image paperImage    = new Image("Paper.png");
    Image scissorsImage = new Image("Scissors.png");

    HashMap<Integer,Image> hands = new HashMap<>();

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

    @FXML
    private ImageView computerImageView;
    @FXML
    private ImageView playerImageView;
    @FXML
    private Text playerString;

    @FXML
    private Text computerString;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Sets the spinners initial value
        SpinnerValueFactory<Integer> v = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 452);
        cKey.setValueFactory(v);
        ce = new CeasarCipher(cKey.getValue());
        atbashEn.setSelected(true); // Preselects the atbash encryption
        status.setText("WELCOME TO RPS");
        hands.put(1,rockImage);
        hands.put(2,paperImage);
        hands.put(3,scissorsImage);

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
            String winnerStatus = game.play(caller.getId());
            int[] playedHands = game.getHands();

            // This is abit messy, but it works.
            // the player string is set to the pressed button string
            playerString.setText(caller.getText());
            computerString.setText(game.getComputerString());

            playerImageView.setImage(this.hands.get(playedHands[0]));
            computerImageView.setImage(this.hands.get(playedHands[1]));

            status.setText(winnerStatus);

        } catch (ClassCastException err){
            System.out.println("Something bad happend");
        }
    }
}
