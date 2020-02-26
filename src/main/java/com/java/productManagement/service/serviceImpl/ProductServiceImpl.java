package com.java.productManagement.service.serviceImpl;

import com.java.productManagement.dao.ImagesDao;
import com.java.productManagement.dao.ProductDao;
import com.java.productManagement.dao.ProductMerchantDao;
import com.java.productManagement.dto.CategoryDTO;
import com.java.productManagement.dto.ImagesDTO;
import com.java.productManagement.dto.ProductDto;
import com.java.productManagement.dto.ProductRequestDTO;
import com.java.productManagement.entities.Category;
import com.java.productManagement.entities.Images;
import com.java.productManagement.entities.Product;
import com.java.productManagement.entities.ProductMerchant;
import com.java.productManagement.service.ProductService;
import org.hibernate.Criteria;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ImagesDao imagesDao;

    @Autowired
    private ProductMerchantDao productMerchantDao;

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void saveAll(List<ProductRequestDTO> requestDTOList) throws Exception {
        for (ProductRequestDTO productRequestDTO : requestDTOList){
            List<Product> productList = new ArrayList<>();
            Product product = new Product();
//            BeanUtils.copyProperties(productRequestDTO, product);
            product.setCategory(productRequestDTO.getCategory());
            product.setCategoryId(productRequestDTO.getCategoryId());
            product.setDescription(productRequestDTO.getDescription());
            product.setId(productRequestDTO.getId());
            product.setLabel(productRequestDTO.getLabel());
            product.setPrice(productRequestDTO.getPrice());
            product.setTitle(productRequestDTO.getTitle());
            productList.add(product);
            productDao.saveAll(productList);
            ProductMerchant productMerchant = new ProductMerchant();

            productMerchant.setProductId(productRequestDTO.getId());
            productMerchant.setMerchantId(productRequestDTO.getMerchantId());
            productMerchant.setAvailable(productRequestDTO.isAvailable());

            productMerchantDao.save(productMerchant);

            List<Images> imagesList = new ArrayList<>();
            for (ImagesDTO imagesDTO: productRequestDTO.getImagesDTOList()){
                Images images = new Images();
//                BeanUtils.copyProperties(imagesDTO, images);
                images.setId(imagesDTO.getId());
                images.setProductId(productRequestDTO.getId());
                images.setUrl(imagesDTO.getUrl());
                imagesList.add(images);
                imagesDao.saveAll(imagesList);
            }

        }
    }

    @Override
    public ProductDto findById(Long id) throws Exception {
        Optional<Product> product = productDao.findById(id);
        product.orElseThrow(() -> new Exception("Product not found."));

        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(product.get(), dto);

        List<ProductDto.ProductImage> images = new ArrayList<>();
        product.get().getProductImages().stream().forEach(p -> {
            images.add(new ProductDto.ProductImage(p.getId(), p.getUrl()));
        });
        dto.setProductImages(images);
        return dto;
    }

    @Override
    public List<ProductDto> searchProducts(ProductDto productDto) {
//        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny();
//
//        if (null != productDto.getLabel()) {
//            customExampleMatcher.withMatcher("label", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
//        }
////                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
////                .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
//
//        Example<Product> example = Example.of(Product.class);
//        productDao.findAll()

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        List<ProductDto> productDtoList= new ArrayList<>();
        ProductDto productDto1 = new ProductDto();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Product> productExample = Example.of(product, matcher);

        List<Product> products = productDao.findAll(productExample);

            products.forEach(product1 -> {
//                BeanUtils.copyProperties(product1, productDto1);
                productDto.setId(product1.getId());
                productDto.setLabel(product1.getLabel());
                productDto.setTitle(product1.getTitle());
                productDto.setPrice(product1.getPrice());
                productDto.setDescription(product1.getDescription());
                productDto.setCategoryId(product1.getCategoryId());

                Category category = product1.getCategory();
//                List<Category> categoryList1 = new ArrayList<>();
//                categoryList1.add(category);
                productDto.setCategory(category);



//                BeanUtils.copyProperties(category, productDto);
//                List<Category> categoryList1 = new ArrayList<>();
//                categoryList1.add(category);



                List<Images> imagesList = product1.getProductImages();
                List<ProductDto.ProductImage> productImages = new ArrayList<>();

                imagesList.forEach(images -> {


                    product1.getProductImages().stream().forEach( images1 -> {
                        productImages.add(new ProductDto.ProductImage(images1.getId(), images1.getUrl()));
                        productDto.setProductImages(productImages);
                    });



//                    ProductDto.ProductImage productImage = null;
//                    productImages.forEach(images1 -> {
//                        productImage.setId(images1.getId());
//                        productImage.setUrl(images1.getUrl());
//
//
//                        List<ProductDto.ProductImage> productImages1 = new ArrayList<>();
//                        productImages1.add(productImage);
//                        productDto.setProductImages(productImages1);
//                    });

                });
            });

                productDtoList.add(productDto);

        return productDtoList;
    }
}
