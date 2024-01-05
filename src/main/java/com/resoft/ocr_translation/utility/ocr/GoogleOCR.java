package com.resoft.ocr_translation.utility.ocr;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature.Type;
import java.io.IOException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.cloud.spring.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GoogleOCR {
    @Autowired
    private final ResourceLoader resourceLoader;
    private final CloudVisionTemplate cloudVisionTemplate;

    private final BlockFormatter blockFormatter;

    public String extractText(String imgPath) throws IOException {
        StringBuilder builder = new StringBuilder();
        Resource imageResource = this.resourceLoader.getResource(imgPath);
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource, Type.TEXT_DETECTION);
        builder.append(handleResponse(response));

        return builder.toString();
    }

    public String handleResponse(AnnotateImageResponse response) {
        return blockFormatter.format(response);
    }

}