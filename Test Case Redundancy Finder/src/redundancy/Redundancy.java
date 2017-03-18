/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package redundancy;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
/**
 *
 * @author Mubaraka Parekh
 */

public class Redundancy {
    
    public static int[] FindRedundantTests(int totalTests, int lineLength, int[][] array){
        System.out.println("\n\n\nREDUNDANT TEST CASES...");
        int[] reTests = new int[10000]; // redundant test storing array
        int reTestCount = 0; // counts the number of redandant test
        int j,x;
        int flag;
        /* Iterate the array matrix in two for loops one for selecting a test 
         * case that is to be compared and one for selceting the test case the 
         * intial selected test is to be compared with. Camparing m test with n 
         * test.
         */
        for(int m = 0; m< totalTests; m++){
            flag = 0;
            for (int n = 0; n<totalTests; n++){
                j=0;
                
                // Check if the test selected and tobe compared is already in 
                // redudanct tests array.
                for(x=0; x<reTestCount; x++){
                    if(reTests[x] == n){
                        //System.out.println(n+1+"is caught redundant");
                        n++; //select next test
                        //System.out.println(n);
                    }
                }
                //System.out.println(m+1);
                // If the selected test is not already found redundant than 
                // compare them with the rest fo test cases.
                while(j < lineLength && flag==0 && m!=n){
                    if((array [n][j] == 0) && (array [m][j] == 1)){
                        break;}
                    if(j==(lineLength-1)){
                        //System.out.println("reTestCount: "+ reTestCount);
                        //System.out.println("m: "+ m);
                        reTests[reTestCount] = m;
                        //System.out.println(reTests[reTestCount]+1+"is stored in array");
                        reTestCount++;
                        flag = 1;
                        break;
                    }
                    j++;
                }
                //System.out.println("****************");
                if (flag == 1){
                    break;
                }
            }
        }
        
        // print results
        System.out.println("Redundant Test Found: " + reTestCount);
        System.out.println("Total Tests: " + totalTests);
        System.out.print("Redundant Tests: ");
        // If there are no redundant tests then notify it as 0 redudant tests
        if(reTestCount == 0 ){
                System.out.println("There are no redundant tests.");
            }
        // If the redundant tests exists then print them
        for(x=0; x<reTestCount; x++){           
            if(x == reTestCount-1){
                System.out.println(reTests[x]+1);
                continue;
            }
            System.out.print(reTests[x]+1+", ");
        }
        return reTests;
    }
    
    /* InitialCoverage() calculates the statement coverage for the application 
     * and takes in all the test cases for measuring coverage
     */
    public static void InitialCoverage(int[][] array, int codeLength, int totalTests){
        System.out.println("\n\n\nINITIAL STATEMENT COVERAGE...");
        int[] coverageArray = new int[codeLength];
        double sum = 0; // sum of 1's
        double coverage; // percentage
        for(int m=0; m<totalTests; m++){
            for(int n=0; n<codeLength; n++){
                //System.out.print(array[m][n]);
                if((array[m][n]==1) && (coverageArray[n]==0)){
                    coverageArray[n]=1;
                }
            }
            //System.out.println();
        }
        
        for(int x=0; x<codeLength; x++){
            //System.out.print(coverageArray[x]);
            sum = sum+ coverageArray[x];
        }
        System.out.println("Total Instructions Covered: " + (Math.round(sum)));
        coverage = (double) ((sum*100)/codeLength);
        coverage = Math.round(coverage*100.0) / 100.0;
        System.out.println("Initial Total Coverage:" + coverage);
    }
    
    /* FinalCoverage() calculates the statement coverage for the application 
     * and takes in only the minimized set of test cases for while ingonring 
     * the redundant tests from the total set of tests for measuring coverage.
     */
    public static void FinalCoverage(int[] reTests, int[][] array, int codeLength, int totalTests, int reTestCount){
        int[] coverageArray = new int[codeLength];
        double sum = 0; // sum of 1's
        int x;
        double coverage; // percentage
        for(int m=0; m<totalTests; m++){ // goes through all rows
            for(x=0; x<reTestCount; x++){ // goes through all column
                //System.out.println("x: "+ x+"m: "+ m);
                //System.out.println("retest: " + reTests[x]);
                if(reTests[x] == m){
                        //System.out.println(m+1+"is caught redundant");
                        m++; //select next test
                        //System.out.println(n);
                }
            }
            
            //System.out.println(m+1+"is good");
            if(m<totalTests){// make sure m doesnot access more than total tests
                for(int n=0; n<codeLength; n++){
                    //System.out.println("performing coverage for: "+ m);
                    if((array[m][n]==1) && (coverageArray[n]==0)){
                        coverageArray[n]=1;
                    }
                }
            }
        }
        
        for(x=0; x<codeLength; x++){ // counts all 1's that are stored in array
            //System.out.print(coverageArray[x]);
            sum = sum+ coverageArray[x];
        }
        System.out.println("Total Instructions Covered: " + (Math.round(sum)));
        coverage = (double) ((sum*100)/codeLength);
        coverage = Math.round(coverage*100.0) / 100.0;
        System.out.println("Final Total Coverage:" + coverage);
    }
    
    public static void RedundantTestsNames(int reTestCount, int[] reTests, String fileName){
        System.out.println("\n\n\nREDUNDANT TEST CASES NAMES...");
        String line; // This will reference one line at a time
        int count = 0;
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName+"tests");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            // while loop reads each line unitill it reaches null- end of file
            while((line = bufferedReader.readLine()) != null) {
                count++;
                for(int x=0; x<reTestCount; x++){
                //System.out.println("x: "+ x+"m: "+ m);
                //System.out.println("retest: " + reTests[x]);
                    if((reTests[x]+1) == count){
                        System.out.println(count + ": " + line);
                    }
                }
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
    
        public static void PrintCovMatrix(int totalTests, int codeLength, int[][] CovMatrix){
        System.out.println("MATRIX...");
        for(int m=0; m<totalTests; m++){
            for(int n=0; n<codeLength; n++){
                System.out.print(CovMatrix[m][n]);
                }
            System.out.println();
        }
    }
    
    public static int[][] CorrelationMatrix(int totalTests, int lineLength, int[][] array){
        int[][] matrix = new int[1000][1000]; // redundant test storing array
        int j,x;
        int count;
        int count0= 0;
        int count1;
        
        /* Iterate the array matrix in two for loops one for selecting a test 
         * case that is to be compared and one for selceting the test case the 
         * intial selected test is to be compared with. Camparing m test with n 
         * test.
         */
        for(int m = 0; m< totalTests; m++){ // goes through all rows
            for (int n = 0; n<totalTests; n++){ 
                j=0;
                count = 0;
                count1 = 0;
                //System.out.println(m+1);
                while(j < lineLength){// goes through all columns
                    //System.out.print("ARRAY n:"+ array [n][j] +"m: "+ array [n][j]);
                    if((array [n][j] == 1) && (array [m][j] == 1)){
                        count++;
                        count1++;
                    }
                    else if((array [n][j] == 0) && (array [m][j] == 1)){
                        count1++;
                    }
                    if(j==(lineLength-1) && (count1 != 0)){
                        matrix[m][n] = (int) (((double)count/count1)*100);
                        //System.out.print(matrix[m][n]+ "  ");
                    }
                    // if the tests donot cover anything and has all 0's, count1 = 0
                    if(j==(lineLength-1) && (count1 == 0)){
                        matrix[m][n] = 100;
                        //System.out.print(matrix[m][n]+ "  ");
                    }
                    j++;
                }
            }
            //System.out.println();
        }
        return matrix;
    }
    
    
    public static double TestPercentCovByOtherTests(int totalTests, int[][] corMatrix, int low, int high){
        System.out.println("\n\n\nTESTS COVERED BY OTHER TESTS...");
        int countTests = 0;
        int flag = 0;
        for(int m = 0; m< totalTests; m++){ // goes through all rows
            System.out.println((m+1) + " is covered by: ");
            for (int n = 0; n<totalTests; n++){ // goes through all column
                // if test is compared to itself (m=n) then skip it
                if((corMatrix[m][n] <= high) && (corMatrix[m][n] >= low) && (m==n)){
                    continue;
                }
                else if((corMatrix[m][n] <= high) && (corMatrix[m][n] >= low)){
                    flag = 1;
                    System.out.print((n+1) + "(" + corMatrix[m][n] + "%), ");
                }
            }
            // count tests that are covered by other tests between low-high%
            if(flag == 1){
                System.out.println();
                countTests++;
                flag = 0;
            }else{
                System.out.println("None");
            }
        }
        
        double percentage = (double) ((countTests*100)/totalTests);
        percentage = Math.round(percentage*100.0) / 100.0;
        
        System.out.println("Total number of tests: " + totalTests);
        System.out.println("Total tests that are covered " + low + " to " + high + "% by other tests: " + countTests);
        System.out.println("Percentage of Tests: " + percentage + "%");
        return percentage;
    }
    
    public static void PrintCorrelationMatrix(int totalTests, int[][] matrix){
        System.out.println("\n\n\nCORRELATION MATRIX...");
        for(int m=0; m<totalTests; m++){
            for(int n=0; n<totalTests; n++){
                if(matrix[m][n]<10){
                    System.out.print(matrix[m][n]+ "     ");
                }
                else if((matrix[m][n]<100) && (matrix[m][n]>10)){
                    System.out.print(matrix[m][n]+ "    ");
                }
                else if(matrix[m][n]==100){
                    System.out.print(matrix[m][n]+ "   ");
                }
                }
            System.out.println();
        }
    }
    
    public static void OverallRedundancy(int[][] array, int codeLength, int totalTests){
        System.out.println("\n\n\nTOTAL REDUNDANCY OF THE TEST SUITE...");
        int[] coverageArray = new int[codeLength];
        int[] storeOne = new int[codeLength];
        double sum = 0; // sum of 1's
        double coverage; // percentage
        int total = 0;
        for(int m=0; m<totalTests; m++){
            for(int n=0; n<codeLength; n++){
                //System.out.print(array[m][n]);
                if((array[m][n]==1) && (coverageArray[n]==0)){
                    coverageArray[n]=1;
                }
            }
            //System.out.println();
        }
        
        for(int m=0; m<totalTests; m++){
            for(int n=0; n<codeLength; n++){
                //System.out.print(array[m][n]);
                if((array[m][n]==1) && (storeOne[n]<2)){
                    storeOne[n] = storeOne[n] + 1;
                }
            }
            //System.out.println();
        }
        
        for(int x=0; x<codeLength; x++){
            //System.out.print(coverageArray[x]);
                total = total + coverageArray[x];
        }
        
        for(int x=0; x<codeLength; x++){
            //System.out.print(coverageArray[x]);
            if (storeOne[x]==2){
                sum = sum+ 1;
            }
        }
        
        System.out.println(((total-sum)/total)*100+"%");
    }
    
    public static CreateMatrix getParameters(String path){
        return new CreateMatrix(path);
    }

    public static void main(String [] args) {

        //String fileName = "C:\\Users\\PC\\Desktop\\Mubaraka\\CS7010\\workbanch\\matrices\\101_netweaver\\gzoltar-data-evosuite\\matrix";
        String fileName = "C:\\Users\\PC\\Desktop\\Mubaraka\\CS7010\\workbanch\\matrices\\101_netweaver\\gzoltar-data-tests\\matrix";
        //String fileName= "C:\\Users\\PC\\Desktop\\Mubaraka\\CS7010\\example.txt";
        int low = 80;
        int high = 90;
        int[] reTests;
        int[][] correlationMatrix = new int [1000][1000];
        
        CreateMatrix cm = getParameters(fileName);
        int [][] covMatrix = cm.getCovMatrix(); // file names/network name
        int codeLength = cm.getCodeLength();
        int totalTests = cm.getTotalTests();
        
        //PrintCovMatrix(totalTests, codeLength, covMatrix);
        
        System.out.println("Columns(Lines in code) = " + codeLength);
        System.out.println("Rows (Number of tests) = " + totalTests);
        
        // Calculates the total coverage with all tests (no redudant tests excluded)
        InitialCoverage(covMatrix, codeLength, totalTests);
        
        // Calculates redundancy: prints redandant test count and which tests are redandant
        reTests = FindRedundantTests(totalTests, codeLength, covMatrix);
        
        /* Once the redundant tests are found using above method calls, enter 
         * the number of redundant tests from their result to calculare final 
         * coverage after the redundant tests are removed. 
         */
        System.out.println("\n\n\nFINAL STATEMENT COVERAGE...");
        System.out.print("Please enter the number of redandant tests:  ");
        Scanner sc = new Scanner(System.in);
        int reTestCount = sc.nextInt(); 
        
        //Calculates total coverage excluding redandant tests
        FinalCoverage(reTests, covMatrix, codeLength, totalTests, reTestCount);
        
        /*Prints out names of the redundant test cases from the file that 
         *contains all tests names.
         */
        RedundantTestsNames(reTestCount, reTests, fileName);
        
        /* Build correlation matrix i.e the matrix that shows how much one test 
         * is covered by other tests in percentage. Show how much one test case c
         * overs the same part of the code as other test
         */
        correlationMatrix = CorrelationMatrix(totalTests, codeLength, covMatrix);
        
        //Prints the correlation matrix
        PrintCorrelationMatrix(totalTests, correlationMatrix);
        
        //Counts the tests that are covered by other tests within certain percentage
        TestPercentCovByOtherTests(totalTests, correlationMatrix, low, high);
        
        //Overall rudandancy percentage
        OverallRedundancy(covMatrix, codeLength, totalTests);
        
    }
}