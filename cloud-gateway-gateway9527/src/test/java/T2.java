import java.time.ZonedDateTime;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-13 15:56
 **/
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime time= ZonedDateTime.now();//默认时区
        System.out.println(time);
//        2021-01-13T15:58:19.581+08:00[Asia/Taipei]
    }
}
