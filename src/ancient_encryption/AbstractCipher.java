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
public abstract class AbstractCipher implements CipherInterface {

    private int index = -1;

    public int findCharIndex(char ch) {
        for (int i = 0; i < CipherInterface.ALPHABETH.length; i++) {
            if (ch == CipherInterface.ALPHABETH[i]) {
                index = i;
                break;
            }
        }
        return index;

    }

}
