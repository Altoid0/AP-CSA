package com.freekash.springboot;


import com.freekash.springboot.Dhruv.*;
import com.freekash.springboot.Dhruv.Inheritance.*;
import com.freekash.springboot.Dhruv.Insertion.*;
import com.freekash.springboot.Dhruv.QuickSortLinkedList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@RequestMapping("/dhruv")
@Controller
public class DhruvController {
    @GetMapping("")
    public String index() {
        return "Dhruv/index.html";
    }

    @GetMapping("/recursion")
    public String recursion(@RequestParam(value = "sum", required = false) Integer sum,
                            @RequestParam(value = "bin", required = false) Integer bin, Model model) {

        Recursion r = new Recursion();
        // Logic for summation factorial
        Integer finsum;
        if (sum == null) {
            finsum = 0;
        }
        else {
            finsum = r.sum(sum);
        }

        // Logic for Decimal to Binary
        String finbin;
        if (bin == null) {
            finbin = "0";
        }
        else {
            finbin = r.toBinary(bin);
        }

        model.addAttribute("finsum", finsum);
        model.addAttribute("finbin", finbin);
        return "Dhruv/recursion.html";
    }

    @GetMapping("/inheritance")
    public String inheritance(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "age", required = false) Integer age, Model model) {

        if (name == null) {
            name = " ";
        }
        if (age == null) {
            age = 0;
        }
        //Create child class instance bird
        Bird bird = new Bird(name, age);


        //Create child class instance giraffe
        Giraffe giraffe = new Giraffe(name, age);

        model.addAttribute("birdtext", bird.returnabout());
        model.addAttribute("girtext", giraffe.returnabout());
        return "Dhruv/inheritance.html";
    }

    @GetMapping("/insertion")
    public String insertion(@RequestParam(value = "unsortarray", required = false) String unsort,
                            @RequestParam(value = "strunsortarray", required = false) String strunsort,
                            @RequestParam(value = "bubbleunsort", required = false) String bubbleunsort,
                            @RequestParam(value = "bubblestrunsort",required = false) String bubblestrunsort,
                            @RequestParam(value = "selectionunsort", required = false) String selecunsort,
                            @RequestParam(value = "selectionstrunsort", required = false) String selecstrunsort, Model model) {
        // Insertion Sort for integers
        if (unsort == null) {
            unsort = " ";
        }
        String str = unsort;

        String[] items = str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        int[] results = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                //NOTE: write something here if you need to recover from formatting errors
            };
        }


        // Insertion Sort for String Sort
        if (strunsort == null) {
            strunsort = " ";
        }
        String[] stritems = strunsort.split(" ");


        Insertion test = new Insertion();
        test.Insertion(results);
        test.Insertion(stritems);






        //Bubble Sort for Integer Sort
        if (bubbleunsort == null) {
            bubbleunsort = " ";
        }
        String arr = bubbleunsort;

        String[] bubitems = arr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        int[] bubresults = new int[bubitems.length];

        for (int i = 0; i < bubitems.length; i++) {
            try {
                bubresults[i] = Integer.parseInt(bubitems[i]);
            } catch (NumberFormatException nfe) {
                //NOTE: write something here if you need to recover from formatting errors
            };
        }



        //Bubble Sort for String Sort
        if (bubblestrunsort == null) {
            bubblestrunsort = " ";
        }
        String[] bubstritems = bubblestrunsort.split(" ");

        Bubble bubtest = new Bubble();
        bubtest.Bubble(results);
        bubtest.Bubble(bubstritems, bubstritems.length);








        //Selection Sort for Integer Sort
        if (selecunsort == null) {
            selecunsort = " ";
        }
        String selecstr = selecunsort;

        String[] selecitems = selecstr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        int[] selecresults = new int[selecitems.length];

        for (int i = 0; i < selecitems.length; i++) {
            try {
                selecresults[i] = Integer.parseInt(selecitems[i]);
            } catch (NumberFormatException nfe) {
                //NOTE: write something here if you need to recover from formatting errors
            };
        }

        //Selection Sort for String Sort
        if (selecstrunsort == null) {
            selecstrunsort = " ";
        }
        String[] selecstritems = selecstrunsort.split(" ");


        Selection selectest = new Selection();
        selectest.Selection(selecresults);
        selectest.Selection(selecstritems);


        //Adding attributes for Insertion Sort
        model.addAttribute("unsort", str);
        model.addAttribute("sort", Arrays.toString(results));
        model.addAttribute("strunsort", strunsort);
        model.addAttribute("strsort", Arrays.toString(stritems));

        //Adding attributes for Bubble Sort
        model.addAttribute("bubunsort", arr);
        model.addAttribute("bubsort", Arrays.toString(bubresults));
        model.addAttribute("bubstrunsort", bubblestrunsort);
        model.addAttribute("bubstrsort", Arrays.toString(bubstritems));

        //Adding attributes for Selection Sort
        model.addAttribute("selecunsort", selecstr);
        model.addAttribute("selecsort", Arrays.toString(selecresults));
        model.addAttribute("selecstrunsort", selecstrunsort);
        model.addAttribute("selecstrsort", Arrays.toString(selecstritems));







        return "Dhruv/insertion.html";
    }

    @GetMapping("/linkedlist")
    public String linkedlist(@RequestParam(value = "val1", required = false)Integer val1,
                             @RequestParam(value = "val2", required = false)Integer val2,
                             @RequestParam(value = "val3", required = false)Integer val3,
                             @RequestParam(value = "val4", required = false)Integer val4,
                             @RequestParam(value = "val5", required = false)Integer val5,
                             @RequestParam(value = "val6", required = false)Integer val6,
                             Model model
                             ) {
        Integer[] unsort = new Integer[]{val1, val2, val3, val4, val5, val6};

        if (val1 == null) {
            val1 = 0;
        }
        if (val2 == null) {
            val2 = 0;
        }
        if (val3 == null) {
            val3 = 0;
        }
        if (val4 == null) {
            val4 = 0;
        }
        if (val5 == null) {
            val5 = 0;
        }
        if (val6 == null) {
            val6 = 0;
        }


        QuickSortLinkedList linkedsort = new QuickSortLinkedList();

        //Add values to the unsorted linked list
        linkedsort.addNode(val1);
        linkedsort.addNode(val2);
        linkedsort.addNode(val3);
        linkedsort.addNode(val4);
        linkedsort.addNode(val5);
        linkedsort.addNode(val6);

        QuickSortLinkedList.Node n = linkedsort.head;
        while(n.next != null){
            n = n.next;
        }

        linkedsort.sort(linkedsort.head, n);


        model.addAttribute("unsorted", Arrays.toString(unsort));
        model.addAttribute("sorted", Arrays.toString(linkedsort.printList(linkedsort.head)));


        return "Dhruv/linkedlist.html";
    }



}
