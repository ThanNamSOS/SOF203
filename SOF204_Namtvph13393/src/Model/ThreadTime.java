package Model;

import Polypro.MainFrame;
import java.util.Calendar;

public class ThreadTime extends Thread{

    @Override
    public void run() {
             while(true) {
        Calendar h = Calendar.getInstance(); 
        int ho = h.get(Calendar.HOUR_OF_DAY); 
        int mi = h.get(Calendar.MINUTE); 
        int se = h.get(Calendar.SECOND); 

        String tem = "  " + ho +  ":" + mi + ":" + se; 
         MainFrame.lblTime.setText(tem); 
        try {
              Thread.sleep(1000);
        }catch(Exception ex) {
              ex.printStackTrace();
        }
    }
    }
    
    
}
