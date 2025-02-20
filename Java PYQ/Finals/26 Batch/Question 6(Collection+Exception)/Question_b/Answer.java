

// (b) Suppose your code may throw multiple exceptions E1, E2, E3 and E4 where E2 inherits E1, and E3 and E4 inherits E2. 
// Write the try-catch ladder to catch each of these exceptions for your code.

// Answer:


// try {
//     // Code that may throw E1, E2, E3, or E4 exceptions

// } catch (E3 e) {

//     // Handle E3 (more specific than E2 and E1)

// } catch (E4 e) {

//     // Handle E4 (more specific than E2 and E1)

// } catch (E2 e) {

//     // Handle E2 (more specific than E1)

// } catch (E1 e) {

//     // Handle E1 (most general exception in the hierarchy)

// } catch (Exception e) {

//     // Handle any other exceptions not caught above

// }
