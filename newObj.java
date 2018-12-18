package IP;

import java.lang.Object;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_objdetect.CascadeClassifier;
import com.googlecode.javacv.cpp.opencv_objdetect.CvHaarClassifierCascade;

import org.bytedeco.javacpp.Pointer;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;
import org.opencv.imgproc.Imgproc;

import org.opencv.imgcodecs.Imgcodecs;
import org.bytedeco.javacpp.opencv_core.Size;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

public class newObj {
	static {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	}
	public static void main(String args[]) {
		Imgcodecs imageCodecs = new Imgcodecs();
		String file ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\g1.jpg"; 
	    Mat matrix = imageCodecs.imread(file); 
    	//Mat image=Imgcodecs.imread("elon.jpg");
    	Mat process = new Mat();
    	Size a = new Size();
    	
    	Imgproc.cvtColor(matrix,process,Imgproc.COLOR_BGR2GRAY);
    	String file2 = "C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\g2.jpg"; 
    	imageCodecs.imwrite(file2, process);
    	CascadeClassifier classifier1 = new CascadeClassifier("haarcascade_frontalface_alt.xml");
    	MatOfRect faces = new MatOfRect();
		classifier1.detectMultiScale(process,faces);	
    	for(Rect rect : faces.toArray()) {
    		Imgproc.rectangle(process,rect.tl(),rect.br(),new Scalar(0,255,0),2);
    	}
	}
    
}
