/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redundancy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class CreateMatrix {
    private int [][] covMatrix;
    private int codeLength;
    private int totalTests;
    
    public CreateMatrix(String fileName) {
        // This will reference one line at a time
        String line;
        covMatrix = new int [ 500 ][20000]; //satement-coverage matrix
        totalTests = 0;
        int lineLength;
        codeLength = 0;
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // while loop reads each line unitill it reaches null- end of file
            while((line = bufferedReader.readLine()) != null) {
                codeLength = 0;
                lineLength = line.length()-1; // "-1" removes "+" form the text file

                /* for loop makes a 2D array of the entire txt file. It reads 
                 * each character in a line and fills up the columns of the 2D 
                 * matrix. Each line i.e each test case is read one by one 
                 * filling up the whole array.
                 */
                for(int x = 0; x<lineLength; x++){ 
                    if ((line.charAt(x) != '1') && (line.charAt(x) != '0')){
                        x++;
                    }
                    if(x!=lineLength){
                        if(line.charAt(x) == '1'){
                            covMatrix[totalTests][codeLength] = 1;
                            codeLength++;
                        }
                        else if(line.charAt(x) == '0'){
                            covMatrix[totalTests][codeLength] = 0;
                            codeLength++;
                        }
                    }
                    //System.out.print(test[totalTests][x]);
                }
                totalTests++;
               //System.out.println("\n"+totalTests);
            }
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    /**
     * @return the covMatrix
     */
    public int[][] getCovMatrix() {
        return covMatrix;
    }

    /**
     * @return the codeLength
     */
    public int getCodeLength() {
        return codeLength;
    }

    /**
     * @return the totalTests
     */
    public int getTotalTests() {
        return totalTests;
    }
}
