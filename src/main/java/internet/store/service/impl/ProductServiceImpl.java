package internet.store.service.impl;

import internet.store.dao.ProductDao;
import internet.store.lib.Inject;
import internet.store.lib.Service;
import internet.store.model.Product;
import internet.store.service.ProductService;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Optional<Product> get(Long id) {
        return productDao.get(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(Product product) {
        return productDao.delete(product);
    }
}
