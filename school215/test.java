package yahoo;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.*;

public class test {

	public static void main(String[] args) throws Exception {
		new test().s();
	}
private void s () throws Exception{
	String imageUrl = 
			"http://tw-autos.zenfs.com/MMT/car/67e4a06eb12e878cb1bf917141b0034f_1200.jpg";
    URL url = new URL(imageUrl);
    DataInputStream dis = new DataInputStream(url.openStream());
    
    String newImageName="DATA/pics/1.jpg";
    
    FileOutputStream fos = new FileOutputStream(new File(newImageName));
    
    byte[] buffer = new byte[1024];
    
    int length;
    while((length = dis.read(buffer))>0){
    
    fos.write(buffer,0,length);
    
    }
    
    dis.close();
    
    fos.close();
}
}
