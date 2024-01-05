package com.resoft.ocr_translation.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ManualTranslate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "auto_translate_id")
    private AutoTranslate autoTranslate;

    @OneToOne
    @JoinColumn(name = "translate_request")
    private TranslateRequest translateRequest;

    @Column(nullable = false)
    private String translate_content;

    public ManualTranslate(ManualTranslateRequestDto)
}
