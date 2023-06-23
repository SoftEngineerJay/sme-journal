package jay.smejournal;

import jay.smejournal.Models.Brand.BrandDao;
import jay.smejournal.Models.Category.CategoryDao;
import jay.smejournal.Models.Customer.CustomerDao;
import jay.smejournal.Models.Product.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CustomerDao customerDao;

    /*Dashboard*/
    @GetMapping(value = "/dashboard")
    public String index(Model model) {
        model.addAttribute("brands",brandDao.countById());
        model.addAttribute("category",categoryDao.countById());
        model.addAttribute("product",productDao.countById());
        model.addAttribute("customers", customerDao.countById());
        return "views/modules/dashboard/index";
    }

    /*Home*/
    @GetMapping(value = "/")
    public String getHome(){
        return "views/modules/home/index";
    }

    @GetMapping(value = "/partners")
    public String getPartner(){
        return "views/modules/partners/index";
    }
}
