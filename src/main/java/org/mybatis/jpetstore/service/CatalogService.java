/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.mybatis.jpetstore.service;

import static com.google.common.collect.Lists.newArrayList;

import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.repository.CategoryRepository;
import org.mybatis.jpetstore.repository.ItemRepository;
import org.mybatis.jpetstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduardo Macarron
 * @author Igor Baiborodine
 */
public class CatalogService {

  @Autowired private CategoryRepository categoryRepository;
  @Autowired private ItemRepository itemRepository;
  @Autowired private ProductRepository productRepository;

  public List<Category> getCategoryList() {
    return newArrayList(categoryRepository.findAll());
  }

  public Category getCategory(String categoryId) {
    return categoryRepository.findOne(categoryId);
  }

  public Product getProduct(String productId) {
    return productRepository.findOne(productId);
  }

  public List<Product> getProductListByCategory(String categoryId) {
    return productRepository.findByCategoryId(categoryId);
  }

  // TODO: re-implement with full-text search
  public List<Product> searchProductList(String keywords) {
    List<Product> products = new ArrayList<>();
    for (String keyword : keywords.split("\\s+")) {
      // TODO: fix me
      //products.addAll(productRepository.searchProductList("%" + keyword.toLowerCase() + "%"));
    }
    return products;
  }

  public List<Item> getItemListByProduct(Product product) {
    return newArrayList(itemRepository.findByProduct(product));
  }

  public Item getItem(String itemId) {
    return itemRepository.findOne(itemId);
  }

  public boolean isItemInStock(String itemId) {
    Item item = itemRepository.findOne(itemId);
    return item != null && item.getQuantity() > 0;
  }

}