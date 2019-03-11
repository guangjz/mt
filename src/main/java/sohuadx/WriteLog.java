package sohuadx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteLog {


    /**
     * @param filePath
     * @param isAppend
     */
    public static void writeIntoFile(String logs, String filePath,
                                     boolean isAppend) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                // System.out.println("该文件已经存在");
            } else {
                file.createNewFile();

            }
            // 将logs写入文件
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file, isAppend);
            fileWriter.write(logs);
            fileWriter.write("\r\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
//			log.info(e.getStackTrace());
//			e.printStackTrace();
        }

    }

}