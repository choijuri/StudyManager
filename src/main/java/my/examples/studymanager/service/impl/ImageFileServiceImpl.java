package my.examples.studymanager.service.impl;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.ImageFile;
import my.examples.studymanager.repository.ImageFileRepository;
import my.examples.studymanager.service.ImageFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageFileServiceImpl implements ImageFileService {
    private final ImageFileRepository imageFileRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ImageFile> getImageFiles(Long studyContentId) {
        return imageFileRepository.getImageFilesByStudyConetentId(studyContentId);
    }

    @Override
    @Transactional
    public void deleteImageFile(Long imageFileId) {
        imageFileRepository.deleteById(imageFileId);
    }
}
