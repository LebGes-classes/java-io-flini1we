package example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class OutputStream {
    public static void deSerialization(ArrayList<Student> students) {
        try (FileOutputStream fos = new FileOutputStream("OutputData.json");
             Writer writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String formattedJson = gson.toJson(students);
            writer.write(formattedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
