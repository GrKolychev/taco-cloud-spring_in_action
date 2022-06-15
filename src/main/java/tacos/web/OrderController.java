package tacos.web;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.TacoOrder;
import tacos.data.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@AllArgsConstructor
public class OrderController {

    private OrderRepository orderRepo;

    @GetMapping("/current")
    public String orderForm(final Model model) {
        model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid final TacoOrder order, final Errors errors, final SessionStatus sessionStatus) {
        if (errors.hasErrors()){
            return "orderForm";
        }
        orderRepo.save(order);
        sessionStatus.setComplete();
        log.info("Order submitted: " + order);
        return "redirect:/";
    }

}
