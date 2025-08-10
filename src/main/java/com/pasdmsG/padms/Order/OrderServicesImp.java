package com.pasdmsG.padms.Order;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import com.pasdmsG.padms.Order.Dto.AddOrderRequest;
import com.pasdmsG.padms.User.User;
import com.pasdmsG.padms.User.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServicesImp implements OrderServices{
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    public OrderServicesImp(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order addOrder(Integer phone, AddOrderRequest orderInfo) {
        User getUser=userRepository.getUserByPhone(phone);
        if(getUser!=null && getUser.getRole().equals("Customer")){

            Order newOrder=new Order();
            newOrder.setUser(getUser);
            newOrder.setCreatedAt(LocalDateTime.now());
            newOrder.setChickenType(orderInfo.getChickenType());
            newOrder.setTotalPrice(orderInfo.getTotalPrice());
            newOrder.setKg(orderInfo.getKg());
            newOrder.setAddress(orderInfo.getAddress());
            newOrder.setOrderStatus("Pending");
            return orderRepository.save(newOrder);


        }else{
            throw new ErrorMessage("Somthing wrong, please try again");
        }
    }
}
