package com.freekash.springboot;

import com.freekash.springboot.Nathan.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RequestMapping("/nathan")
@Controller
public class NathanController {

    @GetMapping("")
    public String index(){
        return "Nathan/index.html";
    }

    @GetMapping("/recursion")
    public String recursion(@RequestParam(value = "length", required = false) Integer length,
                            @RequestParam(value = "iterations", required = false) Integer iterations, Model model){

        int l = (length == null || length<1 || length>100)?10:length.intValue();
        String[] exampleData = Recursion.getExampleSort(l);


        List<Long> iterationData = null;
        if(iterations != null){
            int i = iterations.intValue();
            i = Math.min(i, 10000);
            i = Math.max(i, 10);

            iterationData = Recursion.sortMany(i);
        }else{
            iterations = 100;
        }

        model.addAttribute("iterations", iterations);
        model.addAttribute("iterationData", iterationData);
        model.addAttribute("length", l);
        model.addAttribute("unsorted", exampleData[0]);
        model.addAttribute("sorted", exampleData[1]);
        return "Nathan/recursion.html";
    }

    @GetMapping("/insertion")
    public String insertion(@RequestParam(value = "length", required = false) Integer length,
                            @RequestParam(value = "randomCeil", required = false) Integer randomCeil, Model model){

        int l = (length == null || length<10 || length>40)?15:length.intValue();
        int rc = (randomCeil == null || randomCeil<20 || randomCeil>100)?20:randomCeil.intValue();

        Random rand = new Random();
        int[] arr = new int[l];
        for(int i=0;i<arr.length;i++){
            arr[i] = rand.nextInt(rc)+1;
        }
        int[][] steps = Insertion.insertionSortWithSteps(arr);

        model.addAttribute("steps", steps);
        model.addAttribute("length", l);
        model.addAttribute("randomCeil", rc);

        return "Nathan/insertion.html";
    }

    @GetMapping("/inheritance")
    public String inheritance(@RequestParam(value = "hotdogsRelish", required = false) Integer hotdogsRelish,
                              @RequestParam(value = "hotdogsMustard", required = false) Integer hotdogsMustard,
                              @RequestParam(value = "plainChip", required = false) Integer plainChip,
                              @RequestParam(value = "doritosSpicy", required = false) Integer doritosSpicy,
                              @RequestParam(value = "doritosCheesy", required = false) Integer doritosCheesy,
                              Model model){



        int hotdogRelishNum = (hotdogsRelish == null || hotdogsRelish<0 || hotdogsRelish>10)?0:hotdogsRelish.intValue();
        int hotdogsMustardNum = (hotdogsMustard == null || hotdogsMustard<0 || hotdogsMustard>10)?0:hotdogsMustard.intValue();
        int plainChipNum = (plainChip == null || plainChip<0 || plainChip>10)?0:plainChip.intValue();
        int doritosSpicyNum = (doritosSpicy == null || doritosSpicy<0 || doritosSpicy>10)?0:doritosSpicy.intValue();
        int doritosCheesyNum = (doritosCheesy == null || doritosCheesy<0 || doritosCheesy>10)?0:doritosCheesy.intValue();

        ArrayList<Inheritance.Consumable> lunchbox = new ArrayList<>();
        for(int i=0;i<hotdogRelishNum;i++){ lunchbox.add(new Inheritance.Hotdog("relish")); }
        for(int i=0;i<hotdogsMustardNum;i++){ lunchbox.add(new Inheritance.Hotdog("mustard")); }
        for(int i=0;i<plainChipNum;i++){ lunchbox.add(new Inheritance.PlainChip()); }
        for(int i=0;i<doritosSpicyNum;i++){ lunchbox.add(new Inheritance.Doritos("spicy")); }
        for(int i=0;i<doritosCheesyNum;i++){ lunchbox.add(new Inheritance.Doritos("cheesy")); }


        String[] strings = new String[lunchbox.size()];
        Integer[] cals = new Integer[lunchbox.size()];
        int totalCals = 0;

        for(int i=0;i<strings.length;i++){
            strings[i] = lunchbox.get(i).toString();
            cals[i] = lunchbox.get(i).getCalories();
            totalCals += cals[i];
        }

        model.addAttribute("strings", strings);
        model.addAttribute("cals", cals);
        model.addAttribute("totalCals", totalCals);

        model.addAttribute("hotdogsRelish", hotdogRelishNum);
        model.addAttribute("hotdogsMustard", hotdogsMustardNum);
        model.addAttribute("plainChip", plainChipNum);
        model.addAttribute("doritosSpicy", doritosSpicyNum);
        model.addAttribute("doritosCheesy", doritosCheesyNum);


        return "Nathan/inheritance.html";
    }

    @GetMapping("/multi-sort")
    public String multiSort(@RequestParam(value = "sortType", required = false) String sortType,
                            @RequestParam(value = "dataType", required = false) String dataType, Model model){

        System.out.println(String.format("sortType %s, dataType %s", sortType, dataType));


        if(sortType != null && dataType != null){
            MultiSort ms;
            if(dataType.equals("string")){
                ms = new MultiSort<Integer>();
            }else if(dataType.equals("car")){
                ms = new MultiSort<String>();
            }else{ //default to integer
                ms = new MultiSort<MultiSort.Car>();
                dataType = "integer";
            }

            Comparable[] objects = new Comparable[10];
            for(int i=0;i<objects.length;i++){
                if(dataType.equals("string")){
                    objects[i] = new String(getRandomWord());
                }else if(dataType.equals("car")){
                    objects[i] = new MultiSort.Car((int)(Math.random()*100000));
                }else if(dataType.equals("integer")){
                    objects[i] = new Integer((int)(Math.random()*100));
                }
            }

            Object[] sortedObjects = new Object[objects.length];
            if(sortType.equals("bubble")){
                sortedObjects = ms.bubbleSort(objects);
            }else if(sortType.equals("selection")){
                sortedObjects = ms.selectionSort(objects);
            }else { //default to insertion
                sortedObjects = ms.insertionSort(objects);
            }

            String[] datas = new String[sortedObjects.length];
            for(int i=0;i<objects.length;i++){
                datas[i] = sortedObjects[i].toString(); //replace objects here
            }

            model.addAttribute("sortedData",datas);
        }


        model.addAttribute("sortType", sortType);
        model.addAttribute("dataType", dataType);
        return "Nathan/multi-sort";
    }

    LinkedList l = new LinkedList(new int[]{10,40,2});

    @GetMapping("/linked-list")
    public String linkedList(@RequestParam(value = "addHead", required = false) Integer addHead,
                             @RequestParam(value = "addTail", required = false) Integer addTail,
                             @RequestParam(value = "remHead", required = false) Boolean remHead,
                             @RequestParam(value = "remTail", required = false) Boolean remTail, Model model){

        if(addHead != null){
            l.addHead(new LinkedList.Item(addHead.intValue()));
            return "Nathan/linked-list.html";
        }

        if(addTail != null){
            l.addTail(new LinkedList.Item(addTail.intValue()));
            return "Nathan/linked-list.html";
        }

        if(remHead != null){
            l.removeFirst();
            return "Nathan/linked-list.html";
        }

        if(remTail != null){
            l.removeLast();
            return "Nathan/linked-list.html";
        }

        model.addAttribute("linkedList", l);
        return "Nathan/linked-list.html";
    }




    @GetMapping("/tpt-lesson")
    public String tptlesson(){
        return "Nathan/tpt-lesson";
    }
    private static String[] words = new String[]{"variable", "rumor", "robin", "examination", "comfort", "metro", "feather", "down", "understanding", "diadem", "shirtdress", "situation", "ikebana", "cappelletti", "stock-in-trade", "store", "gosling", "tobacco", "newsprint", "ingredient", "range", "collector", "southeast", "scaffold", "mask", "well", "boom", "enthusiasm", "consciousness", "association", "facility", "modernist", "walkway", "chandelier", "adrenalin", "ballpark", "achievement", "order", "tummy", "thread", "south", "grandfather", "licorice", "softening", "viewer", "circumference", "beech", "courage", "estrogen", "creme brulee", "evening", "throat", "conversion", "patent", "everything", "harpsichord", "completion", "motor", "celery", "reservation", "crewmember", "repeat", "regulator", "kendo", "cooking", "ordination", "innocent", "residence", "briefing", "convenience", "grain", "widget", "rebellion", "smog", "butler", "lady", "bride", "raven", "parliament", "sir", "merchandise", "iron", "beret", "pinto", "flintlock", "evidence", "lumber", "futon", "developing", "dollop", "goose", "chinchilla", "landscape", "ton", "flame", "television", "venture", "schnitzel", "preparation", "wardrobe"};
    private static String getRandomWord(){
        return words[(int)(Math.random()* words.length)];
    }
}
