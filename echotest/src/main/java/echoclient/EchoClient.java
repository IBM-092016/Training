
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
package echoclient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author dragos
 *
 */
public class EchoClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String hostName = "127.0.0.1";
		int portNumber = 7777;
		Socket echoSocket = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		BufferedReader stdIn = null;
		ClientReader cr = new ClientReader();

		try {
			// 1. Open socket connection to server
			echoSocket = new Socket(hostName, portNumber);
			// 2. Open output and input communication channels to and from server
			out = new DataOutputStream(echoSocket.getOutputStream());
			in = new DataInputStream(new BufferedInputStream(echoSocket.getInputStream()));
			// 3. User input stream from keyboard
			stdIn = new BufferedReader(new InputStreamReader(System.in));

			cr.setDataInputStream(in);
			cr.start();

			String userInput = "";
			do {
				// Read user input
				userInput = stdIn.readLine();
				// send it to the server
				if (userInput.length() > 0) {
					out.writeUTF(userInput);
					out.flush();
				}

			} while (!userInput.equalsIgnoreCase("bye"));
			cr.running = false;
			// cr = null;
			// If user type Bye the chat sessions ends
			out.writeUTF("Bye");
			out.flush();
			System.out.println("Connection to server closed");
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		} finally {
			try {
				// cleanup - close all I/O
				if (stdIn != null)
					stdIn.close();
				if (stdIn != null)
					in.close();
				if (stdIn != null)
					out.close();
				if (stdIn != null)
					echoSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
