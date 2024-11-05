package com.patasSolidarias.api.controllers;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final ResourceLoader resourceLoader;

    public ImageController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/images/{filename:.+}")
    public Resource getImage(@PathVariable String filename) {
        Path filePath = Paths.get(uploadDir).resolve(filename);
        return resourceLoader.getResource("file:" + filePath.toString());
    }
}
