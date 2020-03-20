import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ChatServer {
  private ServerSocket input;

  public ChatServer(int port) {
    try {
      input = new ServerSocket(port);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    try {
			System.out.println("Server listening for clients");
      Socket clientSoc = input.accept();
      System.out.println("Connection established on " + input.getLocalPort() + " ; " + clientSoc.getPort());

      InputStreamReader r = new InputStreamReader(clientSoc.getInputStream());
      BufferedReader clientIn = new BufferedReader(r);
      //String str = clientIn.readLine();

      PrintWriter output = new PrintWriter(clientSoc.getOutputStream(), true);
      //output.println("Server says: " + str);

      while (true) {
				String userInput = clientIn.readLine();
				output.println("Server says: " + userInput);
			}	
		}
    catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				input.close();
			}
      catch (IOException e) {
				e.printStackTrace();
			}
		}
  }

  public static void main(String[] args) {


    new ChatServer(14001).run();
  }
}

