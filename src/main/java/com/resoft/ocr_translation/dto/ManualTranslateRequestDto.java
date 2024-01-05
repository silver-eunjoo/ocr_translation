package com.resoft.ocr_translation.dto;

import com.resoft.ocr_translation.repository.AutoTranslate;
import com.resoft.ocr_translation.repository.TranslateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ManualTranslateRequestDto {
    private Long id;
//    private TranslateRequest translateRequest;
//    private AutoTranslate autoTranslate;
    private String translate_content;

    public ManualTranslateRequestDto(Long id, String translate_content){
        this.id = id;
        this.translate_content = translate_content;
    }
}
