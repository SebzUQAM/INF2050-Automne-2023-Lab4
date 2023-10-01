import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class DataLoader {
    private DataLoader(){}

    public static String LoadTextFileWithPath(String filePath) throws IOException {
        return IOUtils.toString(new FileInputStream(filePath), StandardCharsets.UTF_8);
    }
}
