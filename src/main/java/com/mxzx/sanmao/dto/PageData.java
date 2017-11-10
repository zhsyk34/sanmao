package com.mxzx.sanmao.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@RequiredArgsConstructor(staticName = "of")
public class PageData<T> {

    private final List<T> content;
    private final int number;
    private final int size;

    private static <T> PageData from(Page<T> page) {
        return PageData.of(page.getContent(), page.getNumber(), page.getTotalPages());
    }
}
