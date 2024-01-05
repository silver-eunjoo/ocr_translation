package com.resoft.ocr_translation.controller;

import com.resoft.ocr_translation.service.ImageService;
import com.resoft.ocr_translation.service.OcrService;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.commons.io.IOUtils;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class OTController {
    private final ImageService imageService;
    private final OcrService ocrService;

    @PostMapping("/api/image")
    public void saveImage(@RequestParam List<MultipartFile> images) throws IOException {
        imageService.handleImage(images);
    }

    @GetMapping(value ="/api/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> showImage(@RequestParam String imgPath) throws IOException {
        InputStream imageStream = new FileInputStream(imgPath); //absolute한 URL을 입력해야 함.
        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
        imageStream.close();
        return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
    }


}