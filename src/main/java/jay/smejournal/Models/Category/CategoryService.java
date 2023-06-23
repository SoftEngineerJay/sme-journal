package jay.smejournal.Models.Category;

import jay.smejournal.Models.Brand.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    /*GET CATEGORY BY ID*/
    public Optional<Category> findById(Long id) {
        return categoryDao.findById(id);
    }

    /*GET UPDATE BY ID*/
    public Category getById(Long id){
        return categoryDao.findById(id).get();
    }

    /*DELETE*/
    public void delete(Long id) {
        categoryDao.deleteById(id);
    }

    /*SAVE*/
    public void save(Category category) {
        categoryDao.save(category);
    }

}
