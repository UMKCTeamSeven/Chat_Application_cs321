package server;

import java.io.Serializable;
import java.util.Calendar;

public class Story{
    public String story;
    public Calendar date;
    public String username;
    public Story(String username,String story,Calendar date){
        this.story=story;
        this.date=date;
        this.username=username;
    }
    public String toString(){
        String str_date=date.get(Calendar.MONTH) + 1 + "/"+date.get(Calendar.DATE)+"  "+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
        return this.username+"("+str_date+"): "+this.story;
    }
}