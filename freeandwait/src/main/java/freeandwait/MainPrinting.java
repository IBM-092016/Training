package freeandwait;

public class MainPrinting {

	public static void main(String[] args) {
		FileResource fr = new FileResource();
		NetworkResource nr = new NetworkResource();
		
		PrintWorker printW[] = new PrintWorker[5];
		
		for (int i = 0; i < printW.length; i++) {
			printW[i] = new PrintWorker(fr, nr);
		}
		
		for (PrintWorker printWorker : printW) {
			printWorker.start();
		}
		
		
	}

}
