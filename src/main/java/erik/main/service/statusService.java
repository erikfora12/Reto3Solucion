package erik.main.service;

public class statusService {
    private int completed;
    private int canceled;

    public statusService(int completed,int canceled) {
        this.completed = completed;
        this.canceled = canceled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCanceled() {
        return canceled;
    }

    public void setCanceled(int canceled) {
        this.canceled = canceled;
    }
}
