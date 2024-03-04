package networkManager;
import java.io.*;
import java.net.*;

public class NetworkManager {
	public Socket socket;
	public DataInputStream inPut;
	public DataOutputStream outPut;
	public URL url;
	public URLConnection urlConnection;
	
	public NetworkManager(Socket socket, DataInputStream input, DataOutputStream out,  URL url, URLConnection urlConnection) {
		this.socket = socket;
		this.inPut = input;
		this.outPut = out;
		this.url = url;
		this.urlConnection = urlConnection;
	}

	public void setInput(DataInputStream input) {
		this.inPut = input;
	}


	public void setOut(DataOutputStream out) {
		this.outPut = out;
	}


	public void setUrl(URL url) {
		this.url = url;
	}


	public void setUrlConnection(URLConnection urlConnection) {
		this.urlConnection = urlConnection;
	}
}