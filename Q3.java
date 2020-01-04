import java.io.*;

/**
 * it produce the the output X(*)
   for given value of m,n
  */
public class Q3
{
    /**
     @parm: input String , which is the data fetched by the txt file
     @return : String which holds the output for the file
     */
    private static String getWrecursion(String input)
    {   //extract the m & n form same string using "," as delimiter
        int m = Integer.parseInt(input.substring(0,input.indexOf(",")));
        int n = Integer.parseInt(input.substring(1+input.indexOf(","),input.length()-1));
        //to create O(n) using direct formula derived using the given equations
        double result =  m*(-2567.41)+n*(12568.41);

        return (int)result+".";

    }

    public static void main(String[] args) {
        BufferedReader reader;
        //Store output in Cout
        File file = new File("Cout.txt");
        try {//create the buffer reader for reading input from given file
            reader = new BufferedReader(new FileReader(".\\recursion.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line =  reader.readLine();
            line = reader.readLine();
            while(line != null)
            {
                writer.write(getWrecursion(line) + "\n");
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