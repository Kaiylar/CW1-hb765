import java.io.BufferedReader;

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

  public static void main(String[] args) {
    new EchoClient("localhost", 14001).go();
  }


}