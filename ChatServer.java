import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ChatServer {
  private ServerSocket input;

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
    new EchoServer(14001).run();
  }
}

