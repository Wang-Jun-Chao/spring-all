package wjc.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-25 15:23
 **/
public class PageDelete {
    public static void main(String[] args) {
        File file = new File("/Users/wangjunchao/Downloads/Flink_2018-08-01.pdf");
        PDDocument document = new PDDocument();
        try {
            document = PDDocument.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int noOfPages = document.getNumberOfPages();
        System.out.println(noOfPages);
        document.removePage(noOfPages - 1);

        try {
            document.save("/Users/wangjunchao/Downloads/Flink-update.pdf");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
