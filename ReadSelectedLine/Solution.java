package ReadSelectedLine;

import java.io.*;
public class Solution {
	static void readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
         
        if (lineNumber < 0 || lineNumber > getTotalLines(sourceFile)) {
            System.out.println("不在文件的行数范围之内。");
        }
 
        {
        while (s != null) {
            System.out.println("当前行号为:" + reader.getLineNumber());
             
            System.out.println(s);
            System.exit(0);
            s = reader.readLine();
        }
        }
        reader.close();
        in.close();
    }
 
    // 文件内容的总行数。 
    static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }
     
    public static void main(String[] args) throws IOException {
         
        // 读取文件 
        File sourceFile = new File("d:/11.txt");
        // 获取文件的内容的总行数 
        int totalNo = getTotalLines(sourceFile);
        System.out.println("There are "+totalNo+ " lines in the text!");
         
        // 指定读取的行号 
        int lineNumber = 2;
         
        // 读取指定的行 
        readAppointedLineNumber(sourceFile, lineNumber);
         
         
         
    }
}
