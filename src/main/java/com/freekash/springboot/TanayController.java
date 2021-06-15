package com.freekash.springboot;

import com.freekash.springboot.Tanay.Recursion;
import com.freekash.springboot.Tanay.SportsCar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.LinkedList;

@RequestMapping("/tanay")
@Controller
public class TanayController {

    //ArrayList<Car> Cars = new ArrayList<>();

    @GetMapping("")
    public String index(){
        return "Tanay/index.html";
    }

    @GetMapping("/recursion")
    public String recursion(@RequestParam(value = "number", required = false, defaultValue = "10") Integer number, Model model){

        Integer factorial;
        if (number == null) {
            factorial = 0;
        }
        else {
            factorial = Recursion.factorial(number);
        }
        model.addAttribute("factorial", factorial);
        return "Tanay/recursion.html";
    }

    @GetMapping("/inheritance")
    public String recursion(@RequestParam(value = "make", required = false, defaultValue = "Mazda") String make,
                            @RequestParam(value = "model", required = false, defaultValue = "Miata") String model,
                            @RequestParam(value = "age", required = false, defaultValue = "2006") Integer age,
                            @RequestParam(value = "topspeed", required = false, defaultValue = "135") Integer topspeed, Model springmodel){

        SportsCar sportscar1 = new SportsCar(make, model, age, topspeed);
        //Cars.add(sportscar1);

        springmodel.addAttribute("cars", sportscar1);
        return "Tanay/inheritance.html";
    }

    @GetMapping("/linkedlist")
    public String LinkedExample(@RequestParam(value = "unsortedlist", required = false, defaultValue = "[2,9,123,46,17,56,63]") String unsortedlist, Model model ) {
        if (unsortedlist == null) {
            unsortedlist = " ";
        }
        String parsedlist = unsortedlist;
        String[] items = parsedlist.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        LinkedList<Integer> mylist = new LinkedList<Integer>();
        for(int i = 0; i < items.length; i++) {
            mylist.add(Integer.parseInt(items[i]));
        }
        LinkedList<Integer> mylistremovehead = new LinkedList<>(mylist);
        mylistremovehead.remove();

        LinkedList<Integer> mylistremovemid = new LinkedList<>(mylist);
        int mid = mylistremovemid.size()/2;
        mylistremovemid.remove(mid);

        LinkedList<Integer> mylistremovetail = new LinkedList<>(mylist);
        int tail = mylistremovetail.size() - 1;
        mylistremovetail.remove(tail);

        LinkedList<Integer> mylistinserthead = new LinkedList<>(mylist);
        mylistinserthead.add(0,97);

        LinkedList<Integer> mylistinsertmid = new LinkedList<>(mylist);
        mylistinsertmid.add(mid, 97);

        LinkedList<Integer> mylistinsertail = new LinkedList<>(mylist);
        mylistinsertail.add(97);
        // make sure this adds to the end

        LinkedList<Integer> mylistsorted = new LinkedList<>(mylist);
        Collections.sort(mylistsorted);

        model.addAttribute("unsorted", parsedlist);
        model.addAttribute("removehead", mylistremovehead);
        model.addAttribute("removemid", mylistremovemid);
        model.addAttribute("removetail", mylistremovetail);
        model.addAttribute("addhead", mylistinserthead);
        model.addAttribute("addmid", mylistinsertmid);
        model.addAttribute("addtail", mylistinsertail);
        model.addAttribute("sorted", mylistsorted);

        return "Tanay/linkedlist.html";
    }
}
