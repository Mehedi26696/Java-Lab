 

// (a) Consider that you are working on a simple ChatBot project named SimpleBot. The functionalities and features of SimpleBot are as follows:
// SimpleBot works with prompts.

// The prompts are considered within three categories Educational, Entertainment-centric, and Miscellaneous.

// Under the Educational category, it considers the prompts within three subcategories- Technical, General, and Basic.

// The Entertainment-centric category sub-divides it into two additional categories- Movie-Series and Book.

// Under the Miscellaneous category, it also considers one single sub-category named Random-Article.

// To process prompts for generating the outputs, the system has mainly three main machine learning architectures, RLUModel, 
// TransformerModel, and LSTMModel. All the sub-categories eventually use them as per their availability and the subscription 
// model the clients have bought. The model and subscription follow the policy given below:

// The performance order of the models is - TransformerModel> LSTMModel> RLUModel. There are three subscription models -

// o Basic (uses at most RLUModel)
// o Medium (uses at most LSTMModel)
// o Pro (Uses at most TransformerModel).

// During the processing, as per the subscription model, the highest available ML model is first searched to be used. However,
// if they are not available, the lower-powered ML model is searched to be used.

// Develop an object-oriented design and identify the class diagrams, their relationships, and a minimal set of attributes and methods for the above project. 
// Also, discuss the rationale in brief.
 

import java.util.Scanner;

class User {

    String name;
    int id;
    String[] Subscription = new String[3];

    int[] subAvailabilty = new int[3];

    public User(int id, String name, String Subscription) {
        this.name = name;
        this.id = id;

        if (Subscription.equals("Basic")) {
            this.Subscription[0] = Subscription;
            this.subAvailabilty[0] = 2;
        } else if (Subscription.equals("Medium")) {
            this.Subscription[0] = Subscription;
            this.Subscription[1] = "Basic";
            this.subAvailabilty[0] = 2;
            this.subAvailabilty[1] = 2;
        } else if (Subscription.equals("Pro")) {
            this.Subscription[0] = Subscription;
            this.Subscription[1] = "Medium";
            this.Subscription[2] = "Basic";
            this.subAvailabilty[0] = 2;
            this.subAvailabilty[1] = 2;
            this.subAvailabilty[2] = 2;
        }
    }
}

class Bot {
    String category;
    String subCategory;
    String model;
    String prompt;

    User[] user = new User[100];
    int userCount = 0;

    public void addUser(int id, String name, String Subscription) {
        if (userCount < user.length) {
            user[userCount++] = new User(id, name, Subscription);
        } else {
            System.out.println("Database is full! Cannot add more users.");
        }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getModel() {
        return model;
    }

    public void subscriptionupgrade(int id, String Subscription) {
        for (int i = 0; i < userCount; i++) {
            if (user[i].id == id) {
                if (Subscription.equals("Basic")) {
                    user[i].Subscription[0] = Subscription;
                    user[i].subAvailabilty[0] = 2;
                } else if (Subscription.equals("Medium")) {
                    user[i].Subscription[0] = Subscription;
                    user[i].Subscription[1] = "Basic";
                    user[i].subAvailabilty[0] = 2;
                    user[i].subAvailabilty[1] = 2;
                } else if (Subscription.equals("Pro")) {
                    user[i].Subscription[0] = Subscription;
                    user[i].Subscription[1] = "Medium";
                    user[i].Subscription[2] = "Basic";
                    user[i].subAvailabilty[0] = 2;
                    user[i].subAvailabilty[1] = 2;
                    user[i].subAvailabilty[2] = 2;
                }
            }
        }
    }

    public void processPrompt(int id) {

        for (int i = 0; i < userCount; i++) {
            if (user[i].id == id) {
                if (user[i].Subscription[0].equals("Pro")) {

                    if (user[i].subAvailabilty[0] > 0) {
                        System.out.println("Using TransformerModel to process the prompt...");
                        this.model = "TransformerModel";
                        System.out.println("Your prompt information: Category: " + category + ", Sub-Category: "
                                + subCategory + ", Model: " + model + ", Subscription: " + user[i].Subscription[0]
                                + ", Prompt: " + prompt);
                        user[i].subAvailabilty[0]--;
                    } else if (user[i].subAvailabilty[1] > 0) {
                        System.out.println("Using LSTMModel to process the prompt...");
                        this.model = "LSTMModel";
                        System.out.println("Your prompt information: Category: " + category + ", Sub-Category: "
                                + subCategory + ", Model: " + model + ", Subscription: " + user[i].Subscription[1]
                                + ", Prompt: " + prompt);
                        user[i].subAvailabilty[1]--;
                    } else if (user[i].subAvailabilty[2] > 0) {
                        System.out.println("Using RLUModel to process the prompt...");
                        this.model = "RLUModel";
                        System.out.println("Your prompt information: Category: " + category + ", Sub-Category: "
                                + subCategory + ", Model: " + model + ", Subscription: " + user[i].Subscription[2]
                                + ", Prompt: " + prompt);
                        user[i].subAvailabilty[2]--;
                    } else {
                        System.out.println("Subscription limit exceeded!");
                        System.out.println("Please upgrade your subscription to use SimpleBot.");
                        System.out.println("Do you want to continue chatting? (yes/no)");
                        Scanner sc = new Scanner(System.in);
                        String choice = sc.next();
                        if (choice.equals("no")) {
                            sc.close();
                            return;
                        } else {

                            System.out.println(
                                    "Take subscription: 1.Basic-RLUModel 2.Medium-LSTMModel 3.Pro-TransformerModel");
                            System.out.println("Enter the subscription option:");
                            int sub = sc.nextInt();
                            String subscription = "";
                            if (sub == 1) {
                                subscription = "Basic";
                            } else if (sub == 2) {
                                subscription = "Medium";
                            } else if (sub == 3) {
                                subscription = "Pro";
                            } else {
                                System.out.println("Invalid subscription");
                                sc.close();
                                return;
                            }
                            subscriptionupgrade(id, subscription);
                            sc.close();

                        }
                    }
                } else if (user[i].Subscription[0].equals("Medium")) {
                    if (user[i].subAvailabilty[0] > 0) {
                        System.out.println("Using LSTMModel to process the prompt...");
                        this.model = "LSTMModel";
                        System.out.println("Your prompt information: Category: " + category + ", Sub-Category: "
                                + subCategory + ", Model: " + model + ", Subscription: " + user[i].Subscription[0]
                                + ", Prompt: " + prompt);
                        user[i].subAvailabilty[0]--;
                    } else if (user[i].subAvailabilty[1] > 0) {
                        System.out.println("Using RLUModel to process the prompt...");
                        this.model = "RLUModel";
                        System.out.println("Your prompt information: Category: " + category + ", Sub-Category: "
                                + subCategory + ", Model: " + model + ", Subscription: " + user[i].Subscription[1]
                                + ", Prompt: " + prompt);
                        user[i].subAvailabilty[1]--;
                    } else {
                        System.out.println("Subscription limit exceeded!");

                        System.out.println("Please upgrade your subscription to use SimpleBot.");
                        System.out.println("Do you want to continue chatting? (yes/no)");
                        Scanner sc = new Scanner(System.in);
                        String choice = sc.next();

                        if (choice.equals("no")) {
                            sc.close();
                            return;
                        } else {

                            System.out.println(
                                    "Take subscription: 1.Basic-RLUModel 2.Medium-LSTMModel 3.Pro-TransformerModel");
                            System.out.println("Enter the subscription option:");
                            int sub = sc.nextInt();
                            String subscription = "";
                            if (sub == 1) {
                                subscription = "Basic";
                            } else if (sub == 2) {
                                subscription = "Medium";
                            } else if (sub == 3) {
                                subscription = "Pro";
                            } else {
                                System.out.println("Invalid subscription");
                                sc.close();
                                return;
                            }
                            subscriptionupgrade(id, subscription);
                            sc.close();

                        }
                    }
                } else if (user[i].Subscription[0].equals("Basic")) {
                    if (user[i].subAvailabilty[0] > 0) {
                        System.out.println("Using RLUModel to process the prompt...");
                        this.model = "RLUModel";
                        System.out.println("Your prompt information: Category: " + category + ", Sub-Category: "
                                + subCategory + ", Model: " + model + ", Subscription: " + user[i].Subscription[0]
                                + ", Prompt: " + prompt);
                        user[i].subAvailabilty[0]--;
                    } else {
                        System.out.println("Subscription limit exceeded!");

                        System.out.println("Please upgrade your subscription to use SimpleBot.");
                        System.out.println("Do you want to continue chatting? (yes/no)");
                        Scanner sc = new Scanner(System.in);
                        String choice = sc.next();

                        if (choice.equals("no")) {
                            sc.close();
                            return;
                        } else {

                            System.out.println(
                                    "Take subscription: 1.Basic-RLUModel 2.Medium-LSTMModel 3.Pro-TransformerModel");
                            System.out.println("Enter the subscription option:");
                            int sub = sc.nextInt();
                            String subscription = "";
                            if (sub == 1) {
                                subscription = "Basic";
                            } else if (sub == 2) {
                                subscription = "Medium";
                            } else if (sub == 3) {
                                subscription = "Pro";
                            } else {
                                System.out.println("Invalid subscription");
                                sc.close();
                                return;
                            }
                            subscriptionupgrade(id, subscription);
                            sc.close();
                        }
                    }
                }

            }
        }
    }
}

public class SimpleBot {
    public static void main(String[] args) {

        System.out.println("SimpleBot Project.......");

        System.out.println("Enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        System.out.println("Welcome, " + name + "!");
        System.out.println("Enter your id:");
        int id = sc.nextInt();

        System.out.println("Take subscription: 1.Basic-RLUModel 2.Medium-LSTMModel 3.Pro-TransformerModel");
        System.out.println("Enter the subscription option:");
        int sub = sc.nextInt();
        String subscription = "";
        if (sub == 1) {
            subscription = "Basic";
        } else if (sub == 2) {
            subscription = "Medium";
        } else if (sub == 3) {
            subscription = "Pro";
        } else {
            System.out.println("Invalid subscription");
            sc.close();
            return;
        }

        System.out.println("Congratulations! You have taken the " + subscription + " subscription.");

        Bot bot = new Bot();
        bot.addUser(id, name, subscription);

        System.out.println("Now you can start chatting with SimpleBot.");

        boolean flag = true;
        while (flag) {

            System.out.println("Select the category: 1.Educational 2.Entertainment-centric 3.Miscellaneous");
            int category = sc.nextInt();
            String cat = "";
            if (category == 1) {
                cat = "Educational";
            } else if (category == 2) {
                cat = "Entertainment-centric";
            } else if (category == 3) {
                cat = "Miscellaneous";
            } else {
                System.out.println("Invalid category");
                sc.close();
                return;
            }

            bot.setCategory(cat);

            System.out.println(
                    "Select the sub-category: 1.Technical 2.General 3.Basic 4.Movie-Series 5.Book 6.Random-Article");
            int subCategory = sc.nextInt();
            String subCat = "";

            if (subCategory == 1) {
                subCat = "Technical";
            } else if (subCategory == 2) {
                subCat = "General";
            } else if (subCategory == 3) {
                subCat = "Basic";
            } else if (subCategory == 4) {
                subCat = "Movie-Series";
            } else if (subCategory == 5) {
                subCat = "Book";
            } else if (subCategory == 6) {
                subCat = "Random-Article";
            } else {
                System.out.println("Invalid sub-category");
                sc.close();
                return;
            }

            bot.setSubCategory(subCat);
            System.out.println("Enter the prompt:");
            sc.nextLine();
            String prompt = sc.nextLine();
            bot.setPrompt(prompt);
            bot.processPrompt(id);

            System.out.println("Do you want to continue chatting? (yes/no)");
            String choice = sc.next();
            if (choice.equals("no")) {
                flag = false;
            }
        }
        sc.close();
    }
}


// Class Diagram

// Class: User
// Attributes:
// - name: String
// - id: int
// - Subscription: String[]
// - subAvailabilty: int[]
 

// + User(int id, String name, String Subscription)

// Class: Bot   
// Attributes:
// - category: String
// - subCategory: String
// - model: String
// - prompt: String
// - user: User[]

// + Bot()
// + addUser(int id, String name, String Subscription): void
// + setCategory(String category): void
// + setSubCategory(String subCategory): void
// + setModel(String model): void
// + setPrompt(String prompt): void
// + getPrompt(): String
// + getCategory(): String
// + getSubCategory(): String
// + getModel(): String
// + subscriptionupgrade(int id, String Subscription): void
// + processPrompt(int id): void

// Class: SimpleBot

// + main(String[] args): void

