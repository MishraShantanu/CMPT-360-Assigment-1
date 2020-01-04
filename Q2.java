import java.io.*;

/**
 * it produce the position at which the
 * beer would be given
 */
public class Q2
{   /**
    @parm: input String , which is the data fetched by the txt file
    @return : String which holds the output for the file
     */
    private static String beerTime(String input)
    {
        //extracting the data from String
        String s1 = input.substring(0,input.length()-1);

        int num = Integer.parseInt(s1);
        boolean flag = true;int n=0;
        //using While loop calculating the closet value of 2^n which would satisify the equn

        while (flag==true){
            double num2 = num - Math.pow(2,n);

            //if the num2 become -ve  make flag false
            //and decrement the value of n
            if(num2<0){
                flag = false;
                --n;
            }
            else {
                ++n;
            }


        }
        //finding the value of x (f(y)=2^n+x)
        Double x= num - Math.pow(2,n);

        return (int)(2*x +1)+".";
    }

    public static void main(String[] args) {
        BufferedReader reader;
        //Store output in BOutput
        File file = new File("BOutput.txt");
        try {
            //create the buffer reader for reading input from given file
            reader = new BufferedReader(new FileReader(".\\beer.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null)
            {
                writer.write(beerTime(line) + "\n");
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