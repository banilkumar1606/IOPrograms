package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingLargeFile {
	static Map<String, Integer> hashmap = new HashMap<>();
	public static void main(String[] args) throws IOException {
		FileInputStream fis =null;
		Scanner sc = null;
		logMemory();
		try {
			 fis=new FileInputStream("C://Users/Z003y8ed/Desktop/logs-from-artifactuploaderservice-in-artifactuploaderservice-79f8797d66-dwj27.txt");
			 sc = new Scanner(fis, "UTF-8");
			 
			 while(sc.hasNextLine()) {
				 String line = sc.nextLine();
				 String words[] = line.replace(" +"," ").split(" ");
				 for(int i = 0; i < words.length; i++) {
					if(hashmap.containsKey(words[i])) 
						hashmap.put(words[i], hashmap.get(words[i])+1);
					else
						hashmap.put(words[i], 1);
				 }
			 }
			 if(sc.ioException() != null) {
				throw sc.ioException(); 
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
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
	
	private Set<String> listFilesUsingJavaIO(String dir){
		return Stream.of(new File(dir).listFiles())
				.filter(file->!file.isDirectory())
				.map(File::getName)
				.collect(Collectors.toSet());
	}
}
