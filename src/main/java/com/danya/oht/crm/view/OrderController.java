package com.danya.oht.crm.view;

import com.danya.oht.crm.dao.OrderRepository;
import com.danya.oht.crm.data.Order;
import com.danya.oht.crm.util.StringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Component
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{id}")
    public ModelAndView homePage(@PathVariable int id, ModelMap model) {
        Optional<Order> opt = orderRepository.findById((long) id);
        if (opt.isPresent()) {
            model.addAttribute("order", opt.get());
        } else {
            throw new RuntimeException("Change Exception! orderRepository in OrderController.homePage couldn't find order by that id: " + id);
        }
        return new ModelAndView("order", model);
    }

    @GetMapping("")
    public ModelAndView findPage(ModelMap model) {
        model.addAttribute("stringValue", new StringValue());
        return new ModelAndView("find", model);
    }

    @PostMapping("")
    public ModelAndView findOrder(StringValue idString, ModelMap model) {
        long id;
        try {
            id = Long.valueOf(idString.getValue());
        } catch (Exception e) {
            throw new RuntimeException("Change Exception! It's not long value: " + idString);
        }
        Optional<Order> opt = orderRepository.findById(id);
        if (opt.isPresent()) {
            return new ModelAndView("redirect:/order/" + opt.get().getId());
        } else {
            throw new RuntimeException("Change Exception! orderRepository in OrderController.findOrder couldn't find order by that id: " + id);
        }

    }

    @GetMapping("/create")
    public ModelAndView open(ModelMap model) {
        model.addAttribute("order", new Order());
        return new ModelAndView("create");
    }

    @PostMapping("/create")
    public ModelAndView createOrder(Order order, BindingResult bindingResult, ModelMap model) {
        Order order2 = (Order) orderRepository.save(order);
        return new ModelAndView("redirect:/order/" + order2.getId());
    }
}
