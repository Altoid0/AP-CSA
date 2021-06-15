package com.freekash.springboot;

import java.util.ArrayList;
import java.util.Arrays;

import com.freekash.springboot.Eyaad.InsertionSort;
import com.freekash.springboot.Eyaad.Recursion;
import com.freekash.springboot.Eyaad.Book;
import com.freekash.springboot.Eyaad.PictureBook;
import com.freekash.springboot.Eyaad.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@RequestMapping("/eyaad")
@Controller
public class EyaadController {
        private static ArrayList<Book> bookArray;
        private static int[] linkedArray = {4, 8, 3, 2, 5};

        public ArrayList<Integer> toArrayList(int[] arr) {
            ArrayList<Integer> nums = new ArrayList<>();
            for (int a : arr) {
                nums.add(a);
            }
            return nums;
        }

        public int[] toArray(ArrayList<Integer> arr) {
            int[] array = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                array[i] = arr.get(i);
            }
            return array;
        }

        @GetMapping("")
        public String index(){
            return "Eyaad/index.html";
        }

        @GetMapping("/recursion")
        public String recursion(@RequestParam(value ="num", required = false) Integer num, @RequestParam(value = "decimal", required = false) Integer decimal, @RequestParam(value = "num1", required = false) Integer num1, @RequestParam(value = "num2", required = false) Integer num2, Model model) {
            long startTime = System.nanoTime();
            Recursion recursion = new Recursion();
            if (num == null) {
                num = 1;
            }
            if (decimal == null) {
                decimal = 255;
            }
            if (num1 == null) {
                num1 = 7;
            }
            if (num2 == null) {
                num2 = 3;
            }
            model.addAttribute("numb", recursion.returnFact(num));
            model.addAttribute("bin", recursion.returnBinary(decimal));
            model.addAttribute("greatest", recursion.returnGcf(num1, num2));
            long finalTime = System.nanoTime() - startTime;
            model.addAttribute("time", "Time it took: " + finalTime + " nanoseconds");
            return "Eyaad/recursion.html";
        }

        @GetMapping("/inheritance")
        public String inheritance(@RequestParam(value="title", required = false) String title, @RequestParam(value="author", required = false) String author, @RequestParam(value="illustrator", required = false) String illustrator, Model model) {
            long startTime = System.nanoTime();
            if (title == null || title == "") {
                title = "League of Legends Guide";
            }
            if (author == null || author == "") {
                author = "5 year Challenger Eyaad Mir";
            }
            if (illustrator == null || illustrator == "") {
                Book book = new Book(title, author);
                bookArray.add(book);
                model.addAttribute("sentence", book);
                long finalTime = System.nanoTime() - startTime;
                model.addAttribute("time", "Time it took: " + finalTime + " nanoseconds");
                return "Eyaad/inheritance.html";
            }
            PictureBook picturebook = new PictureBook(title, author, illustrator);
            model.addAttribute("sentence", picturebook);
            long finalTime = System.nanoTime() - startTime;
            model.addAttribute("time", "Time it took: " + finalTime + " nanoseconds");
            return "Eyaad/inheritance.html";
        }

        @GetMapping("/insertion")
        public String insertion(@RequestParam(value="length", required = false, defaultValue = "8") int length, @RequestParam(value="array", required = false, defaultValue = "[\"Win\", \"Loss\", \"James\", \"Dog\", \"Cat\"]") String array, Model model) {
            long startTime = System.nanoTime();
            ArrayList<Integer> array1 = new ArrayList<Integer>();
            for (int i = 0; i < length; i++) {
                array1.add((int)(Math.random()*100+1));
            }
            model.addAttribute("unsorted", "This is the unsorted array randomly generated: " + array1.toString());
            //Integer[] arr = (Integer[]) array.toArray();
            Integer[] arr = new Integer[length];
            for (int j = 0; j < length; j++) {
                arr[j] = array1.get(j);
            }
            InsertionSort insertion = new InsertionSort();
            model.addAttribute("sorted", "This is the array after sorting: " + insertion.returnSort(arr));
            long finalTime = System.nanoTime() - startTime;
            model.addAttribute("time", "Time it took: " + finalTime + " nanoseconds");


            long startTime1 = System.nanoTime();
            String[] unsorted = array.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
            model.addAttribute("notsorted", "This is the array before sorting: " + array);
            InsertionSort stringInsertion = new InsertionSort();
            model.addAttribute("sorted2", "This is the array after sorting: " + stringInsertion.returnSort(unsorted));
            long finalTime1 = System.nanoTime() - startTime1;
            model.addAttribute("time1", "Time it took: " + finalTime1 + " nanoseconds");

            Book book = new Book("Record of Ragnarok", "Allen");
            Book book2 = new Book("League of legends guide", "Eyaad");
            Book book3 = new PictureBook("Last Game", "Anthony", "James Pellerin");
            Book[] books = {book, book2, book3};

            model.addAttribute("bookunsorted", "This is the array before sorting: " + Arrays.toString(books));
            InsertionSort bookInsertion = new InsertionSort();
            model.addAttribute("booksorted", "This is the array after sorting " + Arrays.toString(bookInsertion.sort(books)));


            return "Eyaad/insertion.html";
        }

        @GetMapping("/linkedlist")
        public String linkedList(@RequestParam(value = "num1", required = false) Integer num1, @RequestParam(value = "num2", required = false) Integer num2, @RequestParam(value = "num3", required = false) Integer num3, @RequestParam(value = "headdel", required = false, defaultValue = "no") String headdel, @RequestParam(value = "taildel", required = false, defaultValue = "no") String taildel, @RequestParam(value = "middledel", required = false, defaultValue = "no") String middledel, Model model) {
            ArrayList<Integer> numbers = toArrayList(linkedArray);
            if (num1 != null) {
                numbers.add(0, num1);
            }
            if (num2 != null) {
                numbers.add(num2);
            }
            if (num3 != null) {
                numbers.add(numbers.size() / 2, num3);
            }
            if (headdel.equals("yes")) {
                numbers.remove(0);
            }
            if (taildel.equals("yes")) {
                numbers.remove(numbers.size() - 1);
            }
            if (middledel.equals("yes")) {
                numbers.remove(numbers.size() / 2);
            }
            linkedArray = toArray(numbers);
            LinkedList list = new LinkedList(linkedArray);
            model.addAttribute("list", list);
            return "Eyaad/linkedlist.html";
        }

       /* @GetMapping("/fac")
        public String fact(@RequestParam(name="num", required = false, defaultValue = "1") int num, Model model) {
            Recursion recursion = new Recursion();
            model.addAttribute("numb", recursion.returnFact(num));
            return "Eyaad/recursion.html";
        }*/

}
