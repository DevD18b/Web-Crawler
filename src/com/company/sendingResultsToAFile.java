package com.company;

import java.io.*;

public class sendingResultsToAFile {
    public static void main(String[] args) throws IOException {

        try {

            // Create an instance of InputStreamReader class, it is used to read user input from command line console.
            InputStreamReader isr = new InputStreamReader(System.in);

            // Create an instance of OutputStreamWriter class, it is used to write text to command line console.
            OutputStreamWriter osw = new OutputStreamWriter(System.out);


            // Create a BufferedReader object and use this object to connect to the system.in(command line console) to get user input text.
            BufferedReader br = new BufferedReader(isr);

            // Create a BufferedWriter object to write text to system.out.
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("Please input a valid email address.\r\n");
            bw.flush();
            // Get user input text line from the command line console.
            String line = br.readLine();
            if(isValidEmail(line))
            {
                // If user input valid email address.
                String text = line + " is a valid email address.\r\n";

                // Print the text to system.out command line console.
                bw.write(text);
                bw.flush();

                // Print the user input email address to a text file.
                FileWriter fw = new FileWriter("out.txt");
                PrintWriter pw = new PrintWriter(fw);
                pw.println(text);
                // Do not forget close the above writers to close the file pointer.
                pw.close();
            }else {

                // If user input invalid email address.
                String text = line + " is not a valid email address.\r\n";

                // Print the error text to system.out command line console.
                bw.write(text);
                bw.flush();

                // Print the error text to an out.txt file.
                FileWriter fw = new FileWriter("err.txt");
                PrintWriter pw = new PrintWriter(fw);
                pw.println(text);
                // Close the above writer object to close the file.
                pw.close();
            }
        }catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }


    }
    private static boolean isValidEmail(String email)
    {
        boolean ret = true;

        if(email==null || email.trim().length()==0)
        {
            ret = false;
        }else
        {
            int index = email.indexOf("@");
            if(index == -1)
            {
                ret = false;
            }
        }

        return ret;
    }
}
