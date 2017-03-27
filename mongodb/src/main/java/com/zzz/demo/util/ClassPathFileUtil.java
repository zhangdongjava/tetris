package com.zzz.demo.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * Created by zd on 2017/3/24.
 */
public class ClassPathFileUtil {

    public static String getFileContent(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        return new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
    }
}
