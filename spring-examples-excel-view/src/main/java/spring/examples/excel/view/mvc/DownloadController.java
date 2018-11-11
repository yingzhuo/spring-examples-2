package spring.examples.excel.view.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {

    @GetMapping(path = {"/download", "/d"})
    public ModelAndView modelAndView() {
        return new ModelAndView("excelView");
    }

}
