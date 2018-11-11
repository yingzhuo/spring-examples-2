package spring.examples.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam("files") MultipartFile[] uploadFiles) {
        return new ModelAndView("success");
    }

}
