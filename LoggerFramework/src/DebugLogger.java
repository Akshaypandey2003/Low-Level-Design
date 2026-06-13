public class DebugLogger extends AbstractLogger {

    DebugLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void display(String msg, LoggerSink loggerSubject) {

        loggerSubject.notifyAllObserver(1,"DEBUG : "+msg);
    }
}