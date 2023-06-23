package jay.smejournal.Models.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    /*GET ALL BRAND*/
    public List<Brand> findAll() {
        return brandDao.findAll();
    }

    /*GET BRAND BY ID*/
    public Optional<Brand> findById(Long id) {
        return brandDao.findById(id);
    }

    // get id update
    public Brand getById(Long id){
        return brandDao.findById(id).get();
    }

    /*DELETE*/
    public void delete(Long id) {
        brandDao.deleteById(id);
    }

    /*SAVE*/
    public void save(Brand brand) {
        brandDao.save(brand);
    }
}
