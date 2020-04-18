package utilites;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class DateOperations {

    public Date parseDateFromGMTtoDate(String dateGMT) throws ParseException {
        SimpleDateFormat formatter=new SimpleDateFormat("E MMM dd yyyy HH:mm:ss 'GMT'");
        Date date=formatter.parse(dateGMT);
        return date;
    }

    public long getDateDiffSec(Date date1, Date date2) {
        long diffInMillies = date1.getTime() - date2.getTime();

        return diffInMillies;
    }



}
