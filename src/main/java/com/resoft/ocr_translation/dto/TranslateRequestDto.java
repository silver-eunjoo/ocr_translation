package com.resoft.ocr_translation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TranslateRequestDto {
    private Long id;
    private Long translate_result_Id;
    private Long childId;
    private String status;
    private String userType;

    public TranslateRequestDto(Long id, Long translate_result_Id, Long childId, String status, String userType) {
        this.id = id;
        this.translate_result_Id = translate_result_Id;
        this.childId = childId;
        this.status = status;
        this.userType = userType;
    }
}
