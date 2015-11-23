package pers.aron;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// create by Aron zhang
public class In {

	FileInputStream input;
	DataInputStream in;
	public static void main(String[] args) throws IOException{
		init();
	}
	
	public synchronized DataInputStream connect(){
		if(in == null){
			try{
			File file = new File("test.txt");
			in = new DataInputStream(new FileInputStream(file));
			return in;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return in;
	}
	
	public int readInt(){
		connect();
		try {
			int value = in.readInt();
			return value;
		} catch (IOException e) {
			e.printStackTrace();
			try {
				in.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return -1;
	}
	//≥ı ºªØ÷µ
	public static void init(){
		File file;
		DataOutputStream out = null;
		try{
			file = new File("test.txt");
			if(!file.exists()){
				out = new DataOutputStream(new FileOutputStream(file));
				out.writeInt(3); //V
				out.writeInt(2); //E
				out.writeInt(0);
				out.writeInt(1);
				out.writeInt(0);
				out.writeInt(2);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
}
