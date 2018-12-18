package IP;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
public class CV_ReadWrite {
	public static void main( String[] args )
	   {
	      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	      Imgcodecs imageCodecs = new Imgcodecs(); 
	      
	      //Reading the Image from the file  
	      String file ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elon.jpg"; 
	      Mat matrix = imageCodecs.imread(file); 
	     
	      String file2 = "C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elon1.jpg"; 

	      //Writing the image 
	      imageCodecs.imwrite(file2, matrix);
	      
	   }
}
