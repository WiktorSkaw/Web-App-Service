package com.wiktor.WebApp;

import com.wiktor.WebApp.models.MyUserDetails;
import com.wiktor.WebApp.models.OfferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Controller
public class OfferController {

    @Value("${uploadDir}")
    private String uploadFolder;

    @Autowired
    OfferRepository offerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private OfferService offerService;

    @RequestMapping(path = "/AddOfferForm", method = RequestMethod.POST)
    public String addOffer(@ModelAttribute("addofferform") AddOfferForm offerform) {
        return "addofferpage";
    }

    @RequestMapping(path = "/saveOfferDetails")
    public String createOffer(@ModelAttribute("addofferform") AddOfferForm offerform, Model model, @RequestParam("image") MultipartFile multipartFile, HttpServletRequest request) {
        if (offerform.getName() != null) {
            OfferModel offer = new OfferModel();

            String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
            String fileName = multipartFile.getOriginalFilename();
            String filePath = Paths.get(uploadDirectory, fileName).toString();
            String[] names = offerform.getName().split(",");
            String[] descriptions = offerform.getDescription().split(",");
            try {
                File dir = new File(uploadDirectory);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                stream.write(multipartFile.getBytes());
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte[] imageData = new byte[0];
            try {
                imageData = multipartFile.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            OfferModel offerModel = new OfferModel();
            offerModel.setName(names[0]);
            offerModel.setImage(imageData);
            offerModel.setDescription(descriptions[0]);
            offerService.saveOffer(offerModel);


//            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            String userName;
//            if (principal instanceof MyUserDetails) {
//                userName = ((MyUserDetails)principal).getUsername();
//            } else {
//               userName = principal.toString();
//            }
//
//            offer.setName(offerform.getName());
//            offer.setDescription(offerform.getDescription());
//            byte[] image = new byte[0];
//            try {
//                 image = offerform.getImage().getBytes();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            offer.setImage(image);
//
//            offer.setUser(userRepository.findByUserName(userName));
//            offerService.saveOffer(offer);
//            model.addAttribute("message", "Offer Created " + offerform.getName());
      }
            return "addofferpage";
        }


    @RequestMapping(path = "/LoginSuccess", produces = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
    public String index(Model model) {
        Integer offerID = 49;//test

        //String generatedImage = Base64.getMimeEncoder().encodeToString(offerRepository.findById(offerID).get().getImage());
        String encode = Base64.getEncoder().encodeToString(offerService.getOfferById(offerID).get().getImage());
        model.addAttribute("img", encode);//new String(encode,"UTF-8")
        String description = offerService.getOfferById(offerID).get().getDescription();
        model.addAttribute("description",description);

        return "index";
    }

    @RequestMapping(path = "/BrowseOffers", method = RequestMethod.POST)
    public String showFavOffers(Model model) {
        List<OfferModel> images = offerService.getAllActiveOffers();
        model.addAttribute("images", images);

        return "favofferpage";
    }
}
