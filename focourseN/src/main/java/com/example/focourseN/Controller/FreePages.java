package com.example.focourseN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/other")
@Controller
public class FreePages {

    public FreePages(){

    }

    @GetMapping("/contactUs")
    public String getContactUsPage(){
        return "contactUs";
    }

    @GetMapping("/faq")
    public String getFaqPage(){
        return "faq";
    }

    @GetMapping("/practice")
    public String getHome(){
        return "practice";
    }

    @GetMapping("/galleryPage")
    public String getGalleryPage(){
       return "galleryPage";
    }

    @GetMapping("/gallery")
    public String getGallery(){
        return "gallery";
    }

    @GetMapping("about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/forgotPassword")
    public String getforgotPassword(){
        return "forgotPassword";
    }

   
    @GetMapping("/studentsPage")
    public String getstudentsPage(){
        return "studentsPage";
    }


}
