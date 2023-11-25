package vn.edu.iuh.lab_07.controllers;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.lab_07.models.Customer;
import vn.edu.iuh.lab_07.models.Employee;
import vn.edu.iuh.lab_07.models.Order;
import vn.edu.iuh.lab_07.services.CustomerService;
import vn.edu.iuh.lab_07.services.EmployeeService;
import vn.edu.iuh.lab_07.services.OrderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/orders")
    public String getOrderPage(@Param("page")Optional<Integer>page,
                               @Param("limit")Optional<Integer> limit,
                               Model model,
                               @RequestParam(name = "start_date", required = false) Optional<String> startDate,
                               @RequestParam(name = "end_date", required = false)Optional<String> endDate,
                               @RequestParam(name = "employee", required = false) Optional<Long> employeeId,
                               @RequestParam(name = "customer", required = false) Optional<Long> customerId
    ){
        int currentPage = page.orElse(1);
        int currentLimit = limit.orElse(10);
        LocalDateTime finalStartDate = LocalDateTime.parse(startDate.orElse(LocalDateTime.of(1970, 1, 1, 0, 0).toString()));
        LocalDateTime finalEndDate = LocalDateTime.parse(endDate.orElse(LocalDateTime.now().toString()));
        long finalCustomerId = customerId.orElse(0L);
        long finalEmployeeId = employeeId.orElse(0L);

        Page<Order> result = orderService.findAll(finalStartDate, finalEndDate, finalCustomerId, finalEmployeeId, currentPage, currentLimit);
        List<Customer> customers = customerService.findAll();
        List<Employee> employees = employeeService.findAll();


        int totalPage = result.getTotalPages();
        String[] pages = new String[totalPage];
        Arrays.fill(pages, "");

        model.addAttribute("pages", pages);
        model.addAttribute("orders", result.getContent());
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        return "admin/order/order_list";
    }

    @GetMapping("/orders/{id}")
    public String getOrderDetail(@PathVariable("id")long id, Model model){
        Optional<Order> result = orderService.findById(id);
        if(result.isEmpty()){
            return "redirect:/admin/orders";
        }
        model.addAttribute("order", result.get());

        return "admin/order/order_detail";
    }
}