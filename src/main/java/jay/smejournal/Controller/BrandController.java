package jay.smejournal.Controller;

import jay.smejournal.Models.Brand.Brand;
import jay.smejournal.Models.Brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BrandController {


    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    /*LIST OF BRAND*/
    @GetMapping(value = "/brand")
    public String findAll(Model model){
        model.addAttribute("brands",brandService.findAll());

        return "views/modules/brand/index";
    }

    /*ADD PAGE BRAND */
    @GetMapping(value = "/add-brand")
    public String addBrand(Model model, Brand brand){
        model.addAttribute("brands", brand);
        return "views/modules/brand/create";
    }


    @RequestMapping(value = "/brand/findById")
    @ResponseBody
    public Optional<Brand> findById(Long id) {
        return brandService.findById(id);
    }

    /*ADD BRAND*/
    @PostMapping(value = "/save")
    public String addBrand(Brand brand, RedirectAttributes attributes) {
        brandService.save(brand);
        attributes.addFlashAttribute("success", "Register Complete");
        return "redirect:/brand";
    }

    /*Customer update*/
    @GetMapping(value = "/edit-brand/{id}")
    public String updateCustomer(@PathVariable(value = "id") Long id, Model model) {
        Brand brand = brandService.getById(id);
        model.addAttribute("brands", brand);
        return "views/modules/brand/update";
    }

    @RequestMapping(value = "/brand/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Brand brand) {
        brandService.save(brand);
        return "redirect:/brand";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        brandService.delete(id);
        return "redirect:/brand";
    }

}
