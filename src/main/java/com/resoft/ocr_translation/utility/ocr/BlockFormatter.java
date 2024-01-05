package com.resoft.ocr_translation.utility.ocr;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Block;
import com.google.cloud.vision.v1.Symbol;
import com.google.cloud.vision.v1.TextAnnotation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BlockFormatter {
    public String format(AnnotateImageResponse response) {
        return String.join( "\n", getTextBlocks(response));
    }

    public List<String> getTextBlocks(AnnotateImageResponse response) {
        return response.getFullTextAnnotation().getPagesList()
                .stream().flatMap(page -> page.getBlocksList().stream())
                .map(block -> getTextInBlock(block))
                .toList();
    }

    public String getTextInBlock(Block block) {
        StringBuilder builder = new StringBuilder();
         List<Symbol> symbols = block.getParagraphsList().stream()
                .flatMap(paragraph -> paragraph.getWordsList().stream())
                .flatMap(word -> word.getSymbolsList().stream())
                .toList();
         symbols.forEach(
                 symbol -> {
                     if(TextAnnotation.DetectedBreak.BreakType.SPACE == symbol.getProperty().getDetectedBreak().getType())
                         builder.append(" ");
                     else
                        builder.append(symbol.getText());
                 }

         );

         return builder.toString();
    }
}
