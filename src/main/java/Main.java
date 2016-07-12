import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String absPath = new File("${project.basedir}/target/surefire-reports/html/overview.html").getAbsolutePath().replace("${project.basedir}/", "");
        File file = new File(absPath);
        Document doc = Jsoup.parse(file, "UTF-8");
        Elements el = doc.getElementsByTag("tr");
        Element e = el.get(el.size()-1);
        String passed = e.child(1).text();
        String skipped = e.child(2).text();
        String failed = e.child(3).text();
        String total = String.valueOf(Integer.parseInt(passed) + Integer.parseInt(skipped) + Integer.parseInt(failed));
        String result = "Total: " + total
                + "; Passed: " + passed
                + "; Skipped: " + skipped
                + "; Failed: " + failed;

        File target = new File("target");

        File output = new File("TestResults.txt");
        FileWriter fw = new FileWriter(output);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(result);
        bw.close();

        FileUtils.moveFile(output, new File(target.getAbsolutePath(), "TestResults.txt"));
    }
}