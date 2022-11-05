package kz.bitimbay.first.demo.controllers;

import kz.bitimbay.first.demo.db.DBManager;
import kz.bitimbay.first.demo.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @GetMapping(value = "/")
    String getIndex(Model model) {
        List<Item> allItems = DBManager.getItemsList();
        model.addAttribute("itemlist", allItems);
        return "index";
    }

    @GetMapping(value = "/addItem")
    String getItemForm(Model model) {
        return "addItem";
    }


    @PostMapping(value = "/addItem")
    String addItem(Model model, @RequestParam(name = "itemName") String name,
                   @RequestParam(name = "itemDescription") String description,
                    @RequestParam(name = "itemPrice") Double price) {
        Item newItem = new Item();
        newItem.setName(name);
        newItem.setDescription(description);
        newItem.setPrice(price);
        DBManager.addItem(newItem);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    String detailsRequest(@PathVariable(name="id") Long id, Model model){
        String text = DBManager.getDetails(id);
        model.addAttribute("text", text);
                return "details";
    }
}
