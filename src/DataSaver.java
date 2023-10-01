import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class DataSaver {
    private DataSaver(){}

    public static void SaveTextOnFileWithPath(String text, String filePath) throws IOException {
        File file = new File(filePath);
        FileUtils.writeStringToFile(file, text, StandardCharsets.UTF_8);
    }
}
