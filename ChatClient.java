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
    

    new EchoClient("localhost", 14001).run();
  }


}