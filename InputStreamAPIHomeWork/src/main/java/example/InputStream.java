package example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class InputStream {
    public ArrayList<String[]> reader(String filePath){
        try {
            FileReader fr = new FileReader(filePath);
            ArrayList<String[]> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(fr);
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line.split(";"));
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
/*
        try(FileInputStream fin=new FileInputStream("Attendance.csv")){
            byte[] buffer = new byte[256];
            System.out.println("File data:");
            int count;
            ArrayList<String[]> lines = new ArrayList<>();
            while((count=fin.read(buffer))!=-1){
                String str = "";
                for(int i=0; i<count;i++){
                    if((char)buffer[i] == '\n' || buffer[i] == 13) {
                        lines.add(str.split(";"));
                    }else{
                        str+= (char)buffer[i];
                    }
                }
            }
            return lines;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;

         */
