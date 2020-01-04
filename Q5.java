import java.io.*;
       /**
        * compute the pattern
        * using the given f(n) formula
        * based upon if n is odd ,even or 1
        *
        */
public class Q5
{   /**
 @parm: input String , which is the data fetched by the txt file
 @return : String which holds the output for the file
 */
    private static String getSequence(String input)
    {   //extracting the data from String
        int n = Integer.parseInt(input.substring(0,input.indexOf(".")));
        //counter to keep track of of cases
        int count=0;

        //iterate untill n is greater than 0 and not break if its equal to 1
        while (n>0){
            if(n==1){
                count++;
                break;
            }
            else if(n%2==0){
                n = n/2;
                count++;
            }else if (n%2!=0){
                n =3*(n)+1;
                count++;
            }
        }

        return count+".";

    }

    public static void main(String[] args) {


        BufferedReader reader;
        //Store output in Sequence
        File file = new File("O.Sequence.txt");
        try {//create the buffer reader for reading input from given file
            reader = new BufferedReader(new FileReader(".\\sequence.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line =  reader.readLine();
            line = reader.readLine();
            while(line != null)
            {
                writer.write(getSequence(line) + "\n");
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