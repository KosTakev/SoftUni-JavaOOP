package Logger_EXERCISE.ClassesImplementations.Appenders;

import Logger_EXERCISE.Enums.ReportLevel;
import Logger_EXERCISE.Interfaces.File;
import Logger_EXERCISE.Interfaces.Layout;


public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, String fileName) {
        this(layout);
        this.file = new LogFile(fileName);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        String output = this.layout.format(time, message, reportLevel);
        file.append(output);
    }

    public void setFile(File file) {
        this.file = file;
    }
}
