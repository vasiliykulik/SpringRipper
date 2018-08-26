package quoters;

/**
 * Created by Vasiliy Kylik (Lightning) on 27.08.2018.
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
