package com.microservice.language.service;

import java.util.List;
import com.microservice.language.repository;
import com.microservice.language.exceptions;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageDao;

    @Override
    public Language acceptLanguageDetails(Language language) {
        return languageDao.save(language);
    }

    @Override
    public Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException {
        return languageDao.findById(id).orElseThrow(()->new LanguageDetailsNotFoundException("Language not found bu id: "+id));
    }

    @Override
    public Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException {
        return languageDao.findByLanguageName(languageName).orElseThrow(() -> new LanguageDetailsNotFoundException("Language not found by languageName: "+languageName));
    }

    @Override
    public boolean deleteLanguage(int id) throws LanguageDetailsNotFoundException {
        Language language = getLanguageDetails(id);
        languageDao.delete(language);
        return true;
    }

    @Override
    public List<Language> getAllLanguageDetails() {
        return languageDao.findAll();
    }
