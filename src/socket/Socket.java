package socket;

import java.net.MalformedURLException;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;
import java.lang.reflect.Array;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;




public class Socket implements IOCallback {
	
	private SocketIO socket;
     

	public Socket()  {
		socket = new SocketIO();
		
		try {
			socket.connect("http://simpleservice.eu01.aws.af.cm", this);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	} 

	

	public SocketIO getSocket() {
		return socket;
	}

	public void setSocket(SocketIO socket) {
		this.socket = socket;
	}

	@Override
	public void onMessage(JSONObject json, IOAcknowledge ack) {
		
                System.out.println("Server said:" + json.toString());
		
	}

        
        
	@Override
	public void onMessage(String data, IOAcknowledge ack) {
		System.out.println("Server said: " + data);
		
	}

	@Override
	public void onError(SocketIOException socketIOException) {
		System.out.println("an Error occured");
		socketIOException.printStackTrace();
	}

	@Override
	public void onDisconnect() {
		System.out.println("Connection terminated.");
	}

	@Override
	public void onConnect() {
		System.out.println("Connection established");
	}

	@Override
	public void on(String event, IOAcknowledge ack, Object... args) {
		
		if (event.equals("startStorm")){
			try {
				JSONObject json = ((JSONObject) args[0]);
				System.out.println(event + " " + json.getString("cat"));
				try {
					
					String category = json.getString("cat");
					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
                
                else if(event.equals("deleted")){
                    
                    System.out.println("Players deleted");
                }
                
                
		
		
	}
        
        
        
      
    
    public void on(String event, IOAcknowledge ack, Object obj){
            
            if(event.equals("deleted")){
                System.out.println("JSONArray!");
            }
            
     
    }
        
}
	
	