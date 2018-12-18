package IP;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class newObj1 {
	static {
        Runtime.getRuntime().loadLibrary(Core.NATIVE_LIBRARY_NAME);
              
}
public static void main(String args[]){
    Mat image = Imgcodecs.imread("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elon.jpg");
    Mat processed = new Mat();
    Imgproc.cvtColor(image,processed,Imgproc.COLOR_BGR2GRAY);
    
    /*Imgproc.Canny(processed,processed,100,200);
    ArrayList<MatOfPoint> contours = new ArrayList<>();
    Imgproc.findContours(processed.clone(),contours,new Mat(),Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_NONE);
    Mat*/
    CascadeClassifier classifier1 = new CascadeClassifier("C:\\Users\\Het Pandya\\Downloads\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_alt.xml");
    //CascadeClassifier classifier2 = new CascadeClassifier("E:\\MP1\\cas2.xml");
    //CascadeClassifier classifier3 = new CascadeClassifier("E:\\MP1\\cas3.xml");
    
    
    
           if(!classifier1.load("C:\\Users\\Het Pandya\\Downloads\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_alt.xml")) {
		System.out.println("Error Loading XML File");
	} else {
		System.out.println("Success Loading XML");
	}
    MatOfRect faces = new MatOfRect();
    classifier1.detectMultiScale(image,faces);
   // classifier1.detectMultiScale(image,faces);
   // classifier1.detectMultiScale(image,faces);
    
    
    for(Rect rect : faces.toArray()){
     Imgproc.rectangle(processed, rect.tl(), rect.br(), new Scalar(0,255,0));
    }
    
   // */
   Imgcodecs.imwrite("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\elon1.jpg",processed);

                    
                    
              }
}