package com.wiktor.WebApp;

import com.wiktor.WebApp.models.OfferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OfferRepository extends JpaRepository<OfferModel, Integer> {

}
