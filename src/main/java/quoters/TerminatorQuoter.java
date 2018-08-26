package quoters;

import javax.annotation.PostConstruct;

/**
 * Created by Vasiliy Kylik (Lightning) on 26.08.2018.
 */
@Profiling
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    private String message;

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("3 Phase");
        for (int i = 0; i < repeat; i++)
            System.out.println("message = " + message);
    }
}
