/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

import java.util.zip.CheckedInputStream;

/**
 *
 * @author alsle
 */
public class AtbashCipher extends AbstractCipher{

    @Override
    public String encrypt(String original) {
        String newString = "";
        for(char c : original.toCharArray()){
            if(c == ' '){
                newString += c;
                continue;
            }
            char lengthFromRight = CipherInterface.ALPHABETH[(CipherInterface.ALPHABETH.length - findCharIndex(c)) - 1];
            newString += lengthFromRight;
        }
        return newString;
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
    
}
