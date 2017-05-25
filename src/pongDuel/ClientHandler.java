package pongDuel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket socket;
    private DuelWorld caller;
    private BufferedReader input;

    public ClientHandler(Socket socket, DuelWorld caller) throws IOException {
        this.socket = socket;
        this.caller = caller;
        this.input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void run() {
        String message = " ";
        while (message != null && !message.equals("")) {
            try {
                message = this.input.readLine();
                this.caller.escreverMensagem(message);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
