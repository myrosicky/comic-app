package com.example.comic.service.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.comic.service.LLRestTemplate;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageServiceImpl {
    private LLRestTemplate restTemplate = new LLRestTemplate();

    public ImageServiceImpl() {
    }

    protected String[] prepareHeaders(){
        return new String[]{
                "Content-Type", MediaType.APPLICATION_JSON_VALUE,
                ":authority", "www.manhuadb.com",
                ":method", "GET",
                ":path", "/cartoon/162_title_zqorzfhq.jpg",
                ":scheme", "https",
                "accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
                "accept-encoding", "gzip, deflate, br",
                "accept-language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6,zh-TW;q=0.5,ja;q=0.4",
                "cache-control", "max-age=0",
                "cookie", "_ga=GA1.2.1897763570.1654422061; PHPSESSID=norim6eq21rfd5pvu9b2ksjjfn; Hm_lvt_b09a6e73b4faec9edd5935dc45604b5b=1656486020,1656506593,1656506842,1656811191; Hm_lpvt_b09a6e73b4faec9edd5935dc45604b5b=1656811268",
                "if-modified-since", "Mon, 13 Sep 2021 09:36:24 GMT",
                "if-none-match", "\"613f1b98-e17f\"",
                "sec-ch-ua", "\" Not;A Brand\";v=\"99\", \"Microsoft Edge\";v=\"103\", \"Chromium\";v=\"103\"",
                "sec-ch-ua-mobile", "?0",
                "sec-ch-ua-platform", "\"Windows\"",
                "sec-fetch-dest", "document",
                "sec-fetch-mode", "navigate",
                "sec-fetch-site", "none",
                "sec-fetch-user", "?1",
                "upgrade-insecure-requests", "1",
                "user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.66 Safari/537.36 Edg/103.0.1264.44"
        };
    }
    protected String prepareBody(){
        return null;
    }

    public Bitmap loadImg() throws IOException {
        return loadImg("https://www.manhuadb.com/cartoon/162_title_zqorzfhq.jpg");
    }
    public Bitmap loadImg(String url) throws IOException {
//        return restTemplate.getForImg(url, prepareHeaders());
        return BitmapFactory.decodeStream(new URL(url).openStream());
    }

}
