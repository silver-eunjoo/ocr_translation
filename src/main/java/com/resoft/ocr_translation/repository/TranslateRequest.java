package com.resoft.ocr_translation.repository;

import com.resoft.ocr_translation.dto.TranslateRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TranslateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "translator_id")
    private Long translatorId;

    @OneToOne
    @JoinColumn(name = "auto_translate_id")
    private AutoTranslate autoTranslate;

    @JoinColumn(name = "child_id")
    private Long childId;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(nullable = false, length = 25)
    private String userType;

    public TranslateRequest(TranslateRequestDto translateRequestDto) {
        this.id = translateRequestDto.getId();
        this.translatorId = translateRequestDto.getTranslate_result_Id();
        this.childId = translateRequestDto.getChildId();
        this.status = translateRequestDto.getStatus();
    }
}
