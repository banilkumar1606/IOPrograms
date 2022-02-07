package com.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BufferReaderExample {
	static Map<String, Integer> hashmap = new HashMap<>();
	public static void main(String[] args) throws IOException {
		logMemory();
		BufferedReader br = null;
		try {
			 br = new BufferedReader(new FileReader("C://Users/Z003y8ed/Desktop/logs-from-artifactuploaderservice-in-artifactuploaderservice-79f8797d66-dwj27.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(br!=null) {
			 String line = br.readLine();
			 String words[] = line.replace(" +"," ").split(" ");
			 for(int i = 0; i < words.length; i++) {
				if(hashmap.containsKey(words[i])) 
					hashmap.put(words[i], hashmap.get(words[i])+1);
				else
					hashmap.put(words[i], 1);
			 }
		}
		logMemory();
		hashmap.entrySet().forEach(e->System.out.println(e.getKey()+"-->"+e.getValue()));
		logMemory();
	}
	
	private static final void logMemory() {
        System.out.println("Max Memory: "+Runtime.getRuntime()
            .maxMemory() / 1048576);
        System.out.println("Total Memory:"+ Runtime.getRuntime()
            .totalMemory() / 1048576);
        System.out.println("Free Memory:"+ Runtime.getRuntime()
            .freeMemory() / 1048576);
    }
}
