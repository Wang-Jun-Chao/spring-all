package wjc.springboot.music;

import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-05-28 15:23
 **/
@RestController
@RequestMapping("/music")
public class MusicPlayController implements InitializingBean {

    public static class MP3 {
        private String name;
        private long   length;
    }

    private byte[] data;
    private MP3    mp3;

    @PostMapping("/file")
    public MP3 file(HttpServletRequest request, HttpServletResponse response) {
        return mp3;
    }

    /**
     * video请求位置
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public void play(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestHeader(required = false) String range) {
        //开始下载位置
        int startByte = 0;
        //结束下载位置
        int endByte = data.length - 1;

        //有range的话
        if (range != null && range.contains("bytes=") && range.contains("-")) {
            range = range.substring(range.lastIndexOf("=") + 1).trim();
            String[] ranges = range.split("-");
            try {
                //判断range的类型
                if (ranges.length == 1) {
                    //类型一：bytes=-2343
                    if (range.startsWith("-")) {
                        endByte = Integer.parseInt(ranges[0]);
                    }
                    //类型二：bytes=2343-
                    else if (range.endsWith("-")) {
                        startByte = Integer.parseInt(ranges[0]);
                    }
                }
                //类型三：bytes=22-2343
                else if (ranges.length == 2) {
                    startByte = Integer.parseInt(ranges[0]);
                    endByte = Integer.parseInt(ranges[1]);
                }
            } catch (NumberFormatException e) {
                startByte = 0;
                endByte = data.length - 1;
            }
        }

        //要下载的长度（为啥要加一问小学数学老师去）
        int contentLength = endByte - startByte + 1;
        //文件名
        String fileName = mp3.name;

        //文件类型
        String contentType = request.getServletContext().getMimeType(fileName);


        //各种响应头设置
        //参考资料：https://www.ibm.com/developerworks/cn/java/joy-down/index.html
        //坑爹地方一：看代码
        response.setHeader("Accept-Ranges", "bytes");
        //坑爹地方二：http状态码要为206
        response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
        response.setContentType(contentType);
        response.setHeader("Content-Type", contentType);
        //这里文件名换你想要的，inline表示浏览器直接实用（我方便测试用的）
        //参考资料：http://hw1287789687.iteye.com/blog/2188500
        response.setHeader("Content-Disposition", "inline;filename=test.mp3");
        response.setHeader("Content-Length", String.valueOf(contentLength));
        //坑爹地方三：Content-Range，格式为
        // [要下载的开始位置]-[结束位置]/[文件总大小]
        response.setHeader("Content-Range", "bytes " + startByte + "-" + endByte + "/" + data.length);


        //已传送数据大小
        long transmitted = 0;
        try {
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(data, startByte, contentLength);
            outputStream.flush();
            System.out.println("下载完毕：" + startByte + "-" + endByte + "：" + transmitted);

        } catch (ClientAbortException e) {
            System.out.println("用户停止下载：" + startByte + "-" + endByte + "：" + transmitted);
            //捕获此异常表示拥护停止下载
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        ClassPathResource resource = new ClassPathResource("voa.mp3");
        File file = resource.getFile();
        file.length();
        InputStream inputStream = resource.getInputStream();

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ClassPathResource resource = new ClassPathResource("voa.mp3");
        File file = resource.getFile();
        mp3 = new MP3();
        mp3.length = file.length();
        mp3.name = "voa.mp3";

        data = new byte[(int) mp3.length];
        byte[] buffer = new byte[4096];
        InputStream stream = resource.getInputStream();
        int length;
        int index = 0;
        while ((length = stream.read(buffer, 0, buffer.length)) > 0) {
            System.arraycopy(buffer, 0, data, index, length);
            index += length;
        }

    }
}
