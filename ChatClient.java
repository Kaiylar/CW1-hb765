import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.UnknownHostException;

public class ChatClient {
  private Socket server;

  //Constructor method for client
  public ChatClient(String address, int port) {
    try {
      server = new Socket(address, port);
    }
    catch (UnknownHostException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    try {
			System.out.println("Client started");

      BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter a string:");
      //String str = userInput.readLine();

      PrintWriter output = new PrintWriter(server.getOutputStream(), true);
      output.println(str);
      
      //Receives input message from server and outputs message received
      BufferedReader input = new BufferedReader(new InputStreamReader(server.getInputStream()));
      //System.out.println(input.printLine);

      while (true) {
        String userIn = userInput.readLine();
				output.println(userIn);
        
				String serverRes = input.readLine();
				System.out.println(serverRes);
      }
		}
    catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				server.close();
			}
      catch (IOException e) {
				e.printStackTrace();
			}
		}
  }

  public static void main(String[] args) {
    /*for (String str: args) {
      if ((str.charAt(0) == "−") || (str.charAt(0) == "-")) {
        int newPort = str;
      }
      else if (str.charAt(3) == ".") {
        int newAddress = str;
      }
      else {
        int firstArg;
        if (args.length > 0) {
          try {
            firstArg = Integer.parseInt(args[0]);
          }
          catch (NumberFormatException e) {
            System.err.println("Argument" + args[0] + " must be an integer.");
            System.exit(1);
          }
        }
      }
    }*/

    new ChatClient("localhost", 14001).run();
  }


}