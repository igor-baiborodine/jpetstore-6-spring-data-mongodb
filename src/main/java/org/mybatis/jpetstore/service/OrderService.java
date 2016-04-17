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

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.domain.Sequence;
import org.mybatis.jpetstore.repository.ItemRepository;
import org.mybatis.jpetstore.repository.OrderRepository;
import org.mybatis.jpetstore.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Eduardo Macarron
 * @author Igor Baiborodine
 */
public class OrderService {

  @Autowired private ItemRepository itemRepository;
  @Autowired private OrderRepository orderRepository;
  @Autowired private SequenceRepository sequenceRepository;

  //@Transactional - no longer transactional
  public void insertOrder(Order order) {

    order.getLineItems().forEach(lineItem -> {
      Item item = itemRepository.findOne(lineItem.getItemId());
      checkNotNull(item, format("Cannot fetch item with id[%s]", lineItem.getItemId()));
      item.setQuantity(item.getQuantity() - lineItem.getQuantity());
      itemRepository.save(item);
    });
    order.setOrderId(getNextId(Order.SEQUENCE_NAME));
    orderRepository.save(order);
  }

  // @Transactional - no longer transactional
  public Order getOrder(BigInteger orderId) {

    Order order = orderRepository.findOne(orderId);
    // TODO: check if we need to reset item's stock quantity with actual value
    order.getLineItems().forEach(lineItem -> {
      Item item = itemRepository.findOne(lineItem.getItemId());
      lineItem.getItem().setQuantity(item.getQuantity());
    });
    return order;
  }

  public List<Order> getOrdersByUsername(String username) {
    return orderRepository.findByUsername(username);
  }

  public BigInteger getNextId(String name) {

    Sequence sequence = sequenceRepository.findOne(name);
    checkNotNull(sequence, format("Cannot fetch sequence with name[%s]", name));

    sequence.setNextId(sequence.getNextId().add(new BigInteger("1")));
    sequenceRepository.save(sequence);
    return sequence.getNextId();
  }

}
