import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class SILab2Test {

    private final SILab2 timeConvert = new SILab2();
    private List<Time> list(Time... time)
    {
        return new ArrayList<>(Arrays.asList(time));
    }

    @Test
    public void EveryBranchTest(){
        RuntimeException msg;

        //1.{13,30,40;24,0,0}
        assertNotNull(timeConvert.function(list(new Time(13,30,40), new Time(24,0,0))));

        //2.{25,30,40}
        msg = assertThrows(RuntimeException.class, timeConvert.function(list(new Time(25,30,40))));
        assertTrue(msg.getMessage().contains("The hours are grater than the maximum"));

        //3.{-1,30,40}
        msg = assertThrows(RuntimeException.class, timeConvert.function(list(new Time(-1,30,40))));
        assertTrue(msg.getMessage().contains("The hours are smaller than the minimum"));

        //4.{13.62,40}
        msg = assertThrows(RuntimeException.class, timeConvert.function(list(new Time(13,62,40))));
        assertTrue(msg.getMessage().contains("The minutes are not valid!"));

        //5.{12,40,65}
        msg = assertThrows(RuntimeException.class, timeConvert.function(list(new Time(12,40,65))));
        assertTrue(msg.getMessage().contains("The seconds are not valid"));

        //6.{24,60,60}
        msg = assertThrows(RuntimeException.class, timeConvert.function(list(new Time(24,60,60))));
        assertTrue(msg.getMessage().contains("The time is greater than the maximum"));
    }
}
