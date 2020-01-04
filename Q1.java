import java.io.*;


/**
 * this progrsm check if given no is a palindrome and if its not then its
 * produces a palindrome
 */
public class Q1
{
    /**
    function Which Create the and check for Palindrome
     @param  input String the data fetched from text file
     @return newF+d+newB+"." which is a String to be written in output file
     */
    private static String make_palindrome(String input)
    {   //removing the "." from input
        input = input.substring(0,input.length()-1);
        //check will hold the mirror image
        String check="";
        int lenght = input.length();
        //while loop used to create reverse the input number
        while(lenght!=0){

            check += input.charAt(lenght-1);
            --lenght;
        }
        //d stores the last char of the number as string
        String d = input.substring(input.length()-1);

        //if its not palindrome then create it
        if(input.compareTo(check)!=0)
        {
            char str;
            //d stores the last char of the number as char
            str = input.charAt(input.length()-1);

            for(int i=input.length()-2;i>=0;i--){
                //check if the last char is repeated or not
                if(str!=input.charAt(i))break;

                else d+=str;
            }

        }
        //newF store the starting part of input except the last digit(also consecutive repeating)
        String newF = input.substring(0,input.length()-d.length());
        //newB store the reversed string of input except the last digit(also consecutive repeating)
        String newB = check.substring(d.length());


        return newF+d+newB+".";
    }

    public static void main(String[] args) {

        BufferedReader reader;

        //Store output in Aoutput
        File file = new File("Aoutput.txt");


        try {

            //create the buffer reader for reading input from given file
            reader = new BufferedReader(new FileReader(".\\palindrome.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null)
            {
                writer.write(make_palindrome(line) + "\n");
                line = reader.readLine();



            }
            //closing reader & writer
            reader.close();
            writer.close();


        } catch (FileNotFoundException e) {
            System.out.println("Could not locate input file.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
