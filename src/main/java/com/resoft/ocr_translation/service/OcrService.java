package com.resoft.ocr_translation.service;

import com.resoft.ocr_translation.utility.ocr.GoogleOCR;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class OcrService {
    private final GoogleOCR googleOCR;
    public String readImage(String imgPath) throws IOException {
        return googleOCR.extractText(imgPath);
    }
}
