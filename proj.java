package IP;

import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2HSV;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;

import java.util.ArrayList;
import java.util.List;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.opencv.core.Core;

import com.googlecode.javacv.cpp.opencv_core.IplImage;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.*;
import org.opencv.core.CvType;

public class proj {
	/*public static Mat imitate(Mat m) {
		return new Mat(m.Height(),m.width(),m.type());
	}*/
	public static void main(String []args) {
		
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	    Imgcodecs imageCodecs = new Imgcodecs(); 
	      
		/*IplImage img = cvLoadImage("images.jpg");
		IplImage hsvimg = cvCreateImage(cvGetSize(img),IPL_DEPTH_8U,3);
		
		cvCvtColor(img,hsvimg,CV_BGR2HSV);
		
		
		ArrayList<Mat> channels = new ArrayList<Mat>();
		Core.split(hsvimg,channels);*/
		
		String file1 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elon.jpg"; 
		org.opencv.core.Mat matHSV1 = Imgcodecs.imread(file1);
		String file ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elon.jpg"; 
		org.opencv.core.Mat matHSV = Imgcodecs.imread(file);
		
		Imgproc.cvtColor(matHSV1,matHSV,CV_BGR2HSV);
		List<org.opencv.core.Mat> channels=new ArrayList<org.opencv.core.Mat>();
		Core.split(matHSV,channels);
		
		org.opencv.core.Mat H = channels.get(0);
		org.opencv.core.Mat S = channels.get(1);
		org.opencv.core.Mat V = channels.get(2);
		
		org.opencv.core.Mat HM = channels.get(0);
		org.opencv.core.Mat SM = channels.get(1);
		org.opencv.core.Mat VM = channels.get(2);
		
		String file2 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elonH.jpg";
		String file3 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elonS.jpg";
		String file4 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elonV.jpg";
		
		imageCodecs.imwrite(file2,H);
		imageCodecs.imwrite(file3,S);
		imageCodecs.imwrite(file4,V);
		
		//cvThreshold(colorDst, threshold, 155, 255, CV_THRESH_BINARY);
		Imgproc.threshold(H,HM, 155, 255, Imgproc.THRESH_TRIANGLE);
		Imgproc.threshold(S,SM, 155, 255, Imgproc.THRESH_TRIANGLE);
		Imgproc.threshold(V,VM, 155, 255, Imgproc.THRESH_TRIANGLE);
		
		String file5 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elonHM.jpg";
		String file6 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elonSM.jpg";
		String file7 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elonVM.jpg";
		
		imageCodecs.imwrite(file5,HM);
		imageCodecs.imwrite(file6,SM);
		imageCodecs.imwrite(file7,VM);
		

	}
}
