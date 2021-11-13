package com.wiktor.WebApp;

import com.wiktor.WebApp.models.OfferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public void saveOffer(OfferModel offer){
        offerRepository.save(offer);
    }

    public List<OfferModel> getAllActiveOffers() {
        return offerRepository.findAll();
    }

    public Optional<OfferModel> getOfferById(Integer id) {
        return offerRepository.findById(id);
    }

    public OfferModel getImages(Integer id) {
        Optional findById = offerRepository.findById(id);
        if (findById.isPresent()) {
            OfferModel getImageDetails = (OfferModel) findById.get();
            return getImageDetails;
        } else {
            return null;
        }
    }
}
