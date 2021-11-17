package lesson06;
import com.sun.jna.platform.win32.Sspi;
import org.python.modules.time.Time;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class AutomationListeners implements ITestListener
{
    public void onStart(ITestContext execution){
        // TODO Auto-generated method stub						
    }

    public void onFinish(ITestContext execution){
        // TODO Auto-generated method stub					
    }

    public void onTestStart(ITestResult test){
        // TODO Auto-generated method stub
        try {
            MonteScreenRecorder.startRecord(test.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult test){
        // TODO Auto-generated method stub
        try{
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File("./test-recordings/" + test.getName() + ".avi");
        if(file.delete()){
            System.out.println("Record deleted.");
        }
        else{
            System.out.println("Test success but record wasn't deleted.");
        }
        System.out.println("From listener: Test success");
    }

    public void onTestFailure(ITestResult test){
        // TODO Auto-generated method stub
        try{
            MonteScreenRecorder.stopRecord();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("From listener: Test failed");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        // TODO Auto-generated method stub				   		
    }

    public void onTestSkipped(ITestResult test){
        // TODO Auto-generated method stub					
    }
}