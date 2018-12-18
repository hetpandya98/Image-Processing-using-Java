package IP;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

public class ipbasic {
	public static void main(String []args) {
	int width=900;
	int height=600;
	BufferedImage image=null;
	File f = null;
	try {
		f=new File("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\Untitled.jpg");
		image=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		image=ImageIO.read(f);
		System.out.println("Reading completed");
	}catch(IOException e) {
		System.out.println("Error:"+e);
	}
	try {
		/*f=new File("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\Output.jpg");
		ImageIO.write(image,"jpg",f);
		System.out.println("Writing complete.");*/
		
	}
	catch(Exception e) {
		System.out.println("Error:"+e);
	}	
	}
}
