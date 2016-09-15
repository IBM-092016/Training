/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package echoserver;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author dragos
 *
 */
public class EchoMultiServerThread extends Thread {

	private Socket socket = null;
	private DataOutputStream out = null;

	public EchoMultiServerThread(Socket socket) {
		super(((InetSocketAddress) socket.getRemoteSocketAddress()).toString());
		System.out.println("New connection from: " + this.getName());

		this.socket = socket;
	}

	public synchronized void sendMessage(String message) {
		try {
			if (!socket.isClosed()){
				out.writeUTF(message);
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(this.getName() + " crashed while writing to server ...");
			e.printStackTrace();
		}
	}

	public void run() {
		DataInputStream in = null;
		String userName = "";
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String inputLine;
			//Get nickname first the user must send a command like nik:userName
			do{
				inputLine = in.readUTF();
				if (inputLine.startsWith("nik:") &&
					(userName = inputLine.substring(4)).length()>0 ){
					MessageBoard.broadcastMessage(userName + " joined the chat!!!", this);
					out.writeUTF(userName + " welcome to our echo chat server!");
					out.flush();
					break;					
				}
				out.writeUTF("Please select your user name with command nik:username e.g. nik:Dragos");
				out.flush();
			}while(true);
			
			//Process messages until Bye command is received
			do {
				inputLine = in.readUTF();
				if (inputLine.equalsIgnoreCase("Bye")) {
					MessageBoard.broadcastMessage(userName + " is leaving the chat!!!", this);
					System.out.println(this.getName() + " disconnecting.");
					out.writeUTF("Connection closing, bye!");
					out.flush();
					break;
				}
				//broadcast messages to all clients but yourself
				MessageBoard.broadcastMessage(userName + ": " + inputLine, this);
			} while (true);
			//remove yourself from the client list
			MessageBoard.allClientConnections.remove(this);

			if (out != null) out.close();
			if (in != null) in.close();
			if (socket != null) socket.close();
		} catch (IOException e) {
			MessageBoard.broadcastMessage(userName + " disconnected!!!", this);
			System.out.println("Connection closed by client" + this.getName() + " !");
			//e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
