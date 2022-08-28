//Simple chat server using socket 

/*Concept of socket:
A socket is one endpoint of a two way communication link between two programs running on the network. 
The socket mechanism provides a means of inter-process communication (IPC) by establishing named contact
points between which the communication take place.

In Simple Word:
Using socket more than two computers can communicate with each other in the network.(two computers talk's with each other using socket)
*/

//Importing required modules:
import java.net.*;  //Provides the classes for implementing networking applications
import java.util.*; //For input && output function's
import java.io.*;  /*Provides for system input and output through data streams, 
serialization and the file system.Unless otherwise noted, passing a null argument
to a constructor or method in any class or interface in this package
will cause a NullPointerException to be thrown.
*/

public class Server{

	public static void main(String[] args){
		try{ //Code must be inside the try catch block or else it may cause Error message "unreported exception java.io.IOException;" error. 
			String str;

			ServerSocket ss = new ServerSocket(8543);//Instance of serversocket is created and open's the "8543" port for incoming connection.
			//Here we are using localhost which means only devices inside your network can connect with your server.(to connect over other network IP address should be assigned).
			//Here we can use any port under 65,535 port's,but make sure that port is not used by anyother service's.(Ex:Don't use standard port number)
			
			Socket s = ss.accept(); //Establishes connection and waits for the incoming connection (client).

			Scanner fromclient = new Scanner(s.getInputStream()); //Scanner object is created to read the message.
			str = fromclient.nextLine(); //It recive's the message and stores it in a variable "str".

			System.out.println("From Client:"+str); //It print's the recived message.

			ss.close();
			s.close(); //After the message recived socket connection is closed. 
		}catch(Exception e){System.out.println(e);} 
		

	}
}
