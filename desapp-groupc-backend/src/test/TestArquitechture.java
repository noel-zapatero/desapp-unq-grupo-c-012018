package test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class TestArquitechture {
  @Test
  public void TestArquetectureNoSystemOut() {
    boolean contains = false;
    String msg = "";
    for (String javaFile: allJavaFiles(System.getProperty("user.dir"))) {
      FileReader fr = null;
      BufferedReader br = null;
      try {
        fr = new FileReader(javaFile);
        br = new BufferedReader(fr);
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
          if (sCurrentLine.contains("System.out")) {
            contains = true;
            msg = "Found in file: " + javaFile;
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (br != null)
            br.close();
          if (fr != null)
            fr.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
    assertFalse(msg, contains);
  }

  public List<String> allJavaFiles(String path) {
    List<String> ret = new ArrayList<>();
    File file = new File(path);
    if (file.isDirectory()) {
      for (String subfilepath: file.list()) {
        ret.addAll(allJavaFiles(path + "/" + subfilepath));
      }
    } else if (path.endsWith(".java") && !path.contains("TestArquitechture.java")) {
      ret.add(path);
    }
    return ret;
  }
}
