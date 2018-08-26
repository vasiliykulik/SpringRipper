package quoters;

/**
 * Created by Vasiliy Kylik (Lightning) on 26.08.2018.
 */
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++)
            System.out.println("message = " + message);
    }
}
