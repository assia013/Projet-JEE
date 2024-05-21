package ma.xproce.ecommerce.service;

import ma.xproce.ecommerce.dao.entity.Category;
import ma.xproce.ecommerce.dao.entity.Product;
import ma.xproce.ecommerce.dao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements ProductManager{
    @Autowired
    ProductRepository productRepository;
//    private String FOLDER_PATH="C:\\Users\\DELL\\Documents\\uploadedimage";
//
//
//    @Override
//    public Product addNewProduct(String name, Category category,int quantity,double price,String description, MultipartFile fileImage) {
//        Product product=new Product();
//        product.setName(name);
//        product.setCategory(category);
//        product.setQuantity(quantity);
//        product.setPrice(price);
//        product.setDescription(description);
//        product.setImage(uploadImageToFileSystem(fileImage));
//        return productRepository.save(product);
//    }
    @Override
    public Product addNewProduct(Product product){
        return productRepository.save(product);
    }


    @Override
    public Page<Product> getAllProducts(int page, int taille) {
        return productRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<Product> searchProducts(String keyword, int page, int taille) {
        return productRepository.findByNameContains(keyword,PageRequest.of(page,taille));
    }

    @Override
    public List<Product> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduit(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Integer id) {
        try{
            productRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            return false;
        }
    }
//    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
//        String filePath=FOLDER_PATH+file.getOriginalFilename();
//
//        FileData fileData=fileDataRepository.save(FileData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .filePath(filePath).build());
//
//        file.transferTo(new File(filePath));
//
//        if (fileData != null) {
//            return "file uploaded successfully : " + filePath;
//        }
//        return null;
//    }
}
