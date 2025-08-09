package com.pasdmsG.padms.Order;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import com.pasdmsG.padms.User.User;
import com.pasdmsG.padms.User.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServicesImp implements OrderServices{
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    public OrderServicesImp(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrders(OrderDto orderInf, Integer phone) {
        User user=userRepository.getUserByPhone(phone);
        if(user!=null){
            Order addNewOrder=new Order();
            addNewOrder.setCreatedAt(LocalDateTime.now());
            addNewOrder.setUser(user);
            addNewOrder.setOrderStatus(orderInf.getOrderStatus());
            addNewOrder.setChicken_type(orderInf.getChicken_type());
            addNewOrder.setQuantity(orderInf.getQuantity());
            addNewOrder.setTotalPrice(orderInf.getTotalPrice());
            Order createdOrder=orderRepository.save(addNewOrder);
            OrderDto cretedOrderDlv=new OrderDto();
            cretedOrderDlv.setOrderStatus(createdOrder.getOrderStatus());
            cretedOrderDlv.setCreatedAt(createdOrder.getCreatedAt());
            cretedOrderDlv.setQuantity(createdOrder.getQuantity());
            cretedOrderDlv.setChicken_type(createdOrder.getChicken_type());
            cretedOrderDlv.setTotalPrice(createdOrder.getTotalPrice());
            return cretedOrderDlv;

        }
        else {
            throw new ErrorMessage("Somthing went wrong, please try again");
        }
    }
}
