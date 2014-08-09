package ReadSelectedLine;

import java.io.*;
public class Solution {
	static void readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
         
        if (lineNumber < 0 || lineNumber > getTotalLines(sourceFile)) {
            System.out.println("�����ļ���������Χ֮�ڡ�");
        }
 
        {
        while (s != null) {
            System.out.println("��ǰ�к�Ϊ:" + reader.getLineNumber());
             
            System.out.println(s);
            System.exit(0);
            s = reader.readLine();
        }
        }
        reader.close();
        in.close();
    }
 
    // �ļ����ݵ��������� 
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
         
        // ��ȡ�ļ� 
        File sourceFile = new File("d:/11.txt");
        // ��ȡ�ļ������ݵ������� 
        int totalNo = getTotalLines(sourceFile);
        System.out.println("There are "+totalNo+ " lines in the text!");
         
        // ָ����ȡ���к� 
        int lineNumber = 2;
         
        // ��ȡָ������ 
        readAppointedLineNumber(sourceFile, lineNumber);
         
         
         
    }
}
