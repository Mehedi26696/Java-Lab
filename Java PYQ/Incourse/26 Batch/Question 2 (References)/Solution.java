
// Question:
//The following code creates one array and one string object. How many references to those objects exist after the code executes'?
// is either object eligible for garbage_·collection after the·code executes?


// Answer:
public class Solution {
    public static void main(String[] args) {
        // 1 reference for array object and 1 reference for string object
        String[] persons = new String[10];  
        // another reference for string object
        String person_name = "Muhammad Abdullah"; 
        persons[0] = person_name; 
        // dereference the string object
        person_name = null;  

        // Total remaining before nullifying the reference: one reference for array object and two references for string object
        // Total remaining after nullifying the reference:  one reference for array object and one reference for string object
        // so, neither object is eligible for garbage collection
    }
}

// Explanation:

// The code creates one array object and one string object. The array object is referenced by the variable persons, 
// and the string object is referenced by the variable person_name. After the code executes, the array object is still referenced by the variable persons,
// and the string object is still referenced by the array object. The variable person_name is set to null, so it no longer references the string object.
// Therefore, there are two references to the array object and one reference to the string object after the code executes. Neither object is eligible for garbage collection because they are still referenced.

