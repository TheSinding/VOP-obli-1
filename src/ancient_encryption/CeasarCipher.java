/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

/**
 *
 * @author alsle
 */
public class CeasarCipher extends AbstractCipher {

    private int rotFactor;

    public CeasarCipher(int rot){
        this.rotFactor = rot;
    }
    
    @Override
    public String encrypt(String original) {
        String newString = "";
        for (char c : original.toCharArray()){
            if(c == ' '){
                newString += c;
                continue;
            }
            // Below is a complicated way of saying  this.rotFactor % 51, which will work in most other languages
            // but for fucking Java, i cant do it with negative numbers.. So I have to use a fucking method!
            // Modulus takes care of numbers higher then the length of the ALPHABETH
            int pos = Math.floorMod((findCharIndex(c) + this.rotFactor), (CipherInterface.ALPHABETH.length - 1));
            newString += CipherInterface.ALPHABETH[pos];
        }
        return newString;
    }

    @Override
    public String decrypt(String encrypted) {
        this.rotFactor *= -1; // Inverting the rotation factor
        return encrypt(encrypted);
    }

    /**
     * Sets the rotation factor
     * @param rot int
     */
    public void setRotFactor(int rot){
        this.rotFactor = rot;
    }
    
}
