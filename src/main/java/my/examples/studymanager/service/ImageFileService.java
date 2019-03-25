package my.examples.studymanager.service;

import my.examples.studymanager.domain.ImageFile;

import java.util.List;

public interface ImageFileService {
    public List<ImageFile> getImageFiles(Long studyContentId);
}
