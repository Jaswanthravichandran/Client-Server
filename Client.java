//Importing required modules:
import java.net.*;  //Provides the classes for implementing networking applications
import java.util.*; //For input && output function's
import java.io.*;  /*Provides for system input and output through data streams, 
serialization and the file system.Unless otherwise noted, passing a null argument
to a constructor or method in any class or interface in this package
will cause a NullPointerException to be thrown.
*/

public class Client{

	public static void main(String[] args){
		try{ //Code must be inside the try catch block or else it may cause Error message "unreported exception java.io.IOException;" error. 
			String str;

			Socket s = new Socket("localhost",8543);
			//Instance of serversocket is created and assign's port number and localhost to make connection.
			//Here we are using localhost which means only devices inside the server network can connect to the server.(to connect over other network IP address should be assigned)

			System.out.println("Enter The Message To Send:");
			Scanner sc = new Scanner(System.in);
			//Scanner object to get the input. 
			str = sc.nextLine();
			//Storing the data into the str string.

			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println(str);
			//Send's the data to the server.

			s.close();
			//and closes the connection.
		}catch(Exception e){System.out.println(e);}
		

	}
}