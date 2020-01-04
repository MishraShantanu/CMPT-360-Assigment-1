import java.io.*;
/**
 * it compute the no of possible case
 * in which loss can occur in the given 3 servers
 */
public class Q4
{   /**
 @parm: input String , which is the data fetched by the txt file
 @return : String which holds the output for the file
 */
    private static String softwareTesting(String input)
    {  //extracting the (n)number of loss by input using  as f(n)= 2n+2
        int n = Integer.parseInt(input.substring(0,input.indexOf(".")))*2+2;
        //the
        int secondLastCount;
        int lastCount =0;
        int currentCount = 1;
        //keep looping until reached n to get the total no of cases

            for(int i=1;i<n;i++){
                secondLastCount = lastCount;
                lastCount = currentCount;
                currentCount= secondLastCount+lastCount;
            }

            return currentCount+".";
    }


    public static void main(String[] args) {

        BufferedReader reader;
        //Store output in Testing.txt
        File file = new File("Testing.txt");
        try { //create the buffer reader for reading input from given file

            reader = new BufferedReader(new FileReader(".\\software.txt"));

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line =  reader.readLine();
            line = reader.readLine();

            while(line != null)
            {
                writer.write(softwareTesting(line) + "\n");
                line = reader.readLine();

            }//closing reader & writer
            reader.close();
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Could not locate input file.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}