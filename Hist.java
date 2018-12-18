package IP;
//import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.calcHist;
import static org.junit.Assert.assertNotNull;

import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;

import org.opencv.core.CvType;

public class Hist {
	public static void main(String args[]) {
		 System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	      Imgcodecs imageCodecs = new Imgcodecs(); 
	      
	      //Reading the Image from the file  
	      String file ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\g1.jpg"; 
	      org.opencv.core.Mat matrix = Imgcodecs.imread(file); 
	//final Mat image = imread("data/waves.jpg");
   // assertNotNull(image);

    // Compute histogram
    final int[] channels = new int[]{0, 1, 2};
    final Mat mask = new Mat();
    final Mat hist = new Mat();
    final int[] histSize = new int[]{8, 8, 8};
    final float[] histRange = new float[]{0f, 255f};
    IntPointer intPtrChannels = new IntPointer(channels);
    IntPointer intPtrHistSize = new IntPointer(histSize);
    final PointerPointer<FloatPointer> ptrPtrHistRange = new PointerPointer<>(histRange, histRange, histRange);
    Mat image;
	//calcHist(matrix, 1, intPtrChannels, mask, hist, 3, intPtrHistSize, ptrPtrHistRange, true, false);
	}
}
