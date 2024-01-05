package com.resoft.ocr_translation.service;

import com.resoft.ocr_translation.utility.ocr.GoogleOCR;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final OcrService ocrService;

    public void handleImage(List<MultipartFile> images) throws IOException {
        saveImage(images.get(0));
    }
    public void saveImage(MultipartFile image) throws IOException {
        String name = image.getOriginalFilename();
        System.out.println(name);

        // 경로를 지정하고 그곳에다가 저장
        String path = "images/";
        File file = new File(path);
        // 저장할 위치의 디렉토리가 존지하지 않을 경우
        if (!file.exists()) {
            // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
            file.mkdirs();
        }
        String originalFileExtension ="";
        String Content_type = image.getContentType();
        if (Content_type.contains("image/jpeg")) {
            originalFileExtension = ".jpg";
        } else if (Content_type.contains("image/png")) {
            originalFileExtension = ".png";
        } else if (Content_type.contains("image/gif")) {
            originalFileExtension = ".gif";
        }
        String new_file_name = System.nanoTime() + originalFileExtension;
        OutputStream out = new FileOutputStream(path+image.getOriginalFilename());
        out.write(image.getBytes());
        out.close();
        ocrService.readImage(path+image.getOriginalFilename());
    }
}
