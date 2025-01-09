// In this problem, we will deal with a cricket team. A team member can be identified
// with the following pieces of information: name (string data), quality (batsman,
// bowler, all_rounder), and jersey number (integer).
// a) We should have a class that would address associated members to solve this
// problem (Mark 10).
// b) We should have a function that adds a new player to the team with his
// associated information (Mark 20).
// c) We are going to construct teams for 7 days denoting, 7 team formations. We
// should have a method that would take the day number (1st day, 2nd day, …)
// and the player’s jersey number to include him/her in a particular day’s
// formation. (Mark 30).
// d) Finally, we should have another method that would take a parameter denoting
// the day number on which we are going to print the information. In the printing,
// we would expect to see all the players of that particular day’s formation: their
// names, jersey numbers, and attributes. We would also expect statistics
// denoting the total number of batsmen, bowlers, and all_rounders in that
// particular day’s formation in a summarized manner (Mark 40).


import java.util.Scanner;
class Players {
    String name;
    String quality;
    int jersey;
    int number = 0;

    Players(String name, String quality, int jersey) {
        this.name = name;
        this.quality = quality;
        this.jersey = jersey;
    }

}

class match {
    String name;
    String quality;
    int jersey;

    match(String name, String quality, int jersey) {
        this.name = name;
        this.quality = quality;
        this.jersey = jersey;
    }
}

class features {

    int i = 0;

    Players[] member = new Players[100];

    void addplayer() {

        for (i = 0; i <50; i++) {

            if (i % 3 == 0) {
                member[i] = new Players("Marcus(" + i + ")", "All_rounder", i);
            } else if (i % 2 == 0) {
                member[i] = new Players("Marcus(" + i+ ")", "Batsman", i);
            }

            else {
                member[i] = new Players("Marcus(" + i+ ")", "Bowler", i);
            }

        }

    }

    void newplayer(String name, String quality, int jersey) {
        
        member[jersey] = new Players(name + i, "All_rounder", jersey);
        if(i<jersey)
        {
            i=jersey;
        }

       

    }

    match[][] newman = new match[8][8];

    void addmatch(int day,int index) {

        for (int k = 1; k <8; k++) {
            
            int m = k;
            if(day==1)
            {
                newman[day][k] = new match(member[m].name, member[m].quality, member[m].jersey);
            }
            if(day==2)
            {   
                m = m+7;
                newman[day][k] = new match(member[m].name, member[m].quality, member[m].jersey);
            }
            if(day==3)
            {
                m = m+14;
                newman[day][k] = new match(member[m].name, member[m].quality, member[m].jersey);
            }
            if(day==4)
            {
                m = m+21;
                newman[day][k] = new match(member[m].name, member[m].quality, member[m].jersey);
            }
            if(day==5)
            {
                m = m+28;
                newman[day][k] = new match(member[m].name, member[m].quality, member[m].jersey);
            }
            if(day==6)
            {
                m = m+35;
                newman[day][k] = new match(member[m].name, member[m].quality, member[m].jersey);
            }
            if(day==7)
            {
                m = m+42;
                newman[day][k] = new match(member[m].name, member[m].quality, member[m].jersey);
            }
        }

    }

    void totaplayer() {
        for (int index = 0; index <= i; index++) {
            
            if(member[index]== null){
                
            }

            else{
                System.out.println(member[index].name);
                System.out.println(member[index].quality);
                System.out.println(member[index].jersey);
            }
        }
    }

    void matchplayer(int n) {

        int b = 0;
        int bow = 0;
        int al = 0;
        for (int index = 1; index <=7; index++) {

            for (int k = 1; k <=7; k++) {
                {
                    if (n == index) {

                        System.out.println(newman[index][k].name);
                        System.out.println(newman[index][k].quality);
                        System.out.println(newman[index][k].jersey);

                        if (newman[index][k].quality.equals("Batsman")) {
                            b++;
                        }

                        else if (newman[index][k].quality.equals("Bowler")) {
                            bow++;
                        }

                        else if (newman[index][k].quality.equals("All_rounder")) {
                            al++;
                        }

                    }

                }

            }
        }

        System.out.println("Total batsman in the match : " + b);
        System.out.println("Total bowlers in the match : " + bow);
        System.out.println("Total all rounder in the match : " + al);
    }
}

public class CricketDatabase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        features ff = new features();

        ff.addplayer();

        
        for(int i = 1; i <= 7; i++){
            for(int j = 1; j <= 7; j++){
                ff.addmatch(i, j);
            }
        }

        System.out.println("Enter Choice Number : ");

        System.out.println("1. Add New Player");
        System.out.println("2. Match Players");
        System.out.println("3. Total Players");
        System.out.println("4. Exit");

        int choice = sc.nextInt();
        
        if(choice == 1){
            System.out.println("Enter Player Name : ");
            String name = sc.next();
            System.out.println("Enter Player Quality : ");
            String quality = sc.next();
            System.out.println("Enter Player Jersey Number : ");
            int jersey = sc.nextInt();
            ff.newplayer(name, quality, jersey);

            System.out.println("If you want to see the player list:\n 1.Yes \n 2.No");
            int ch = sc.nextInt();
            if(ch == 1){
                ff.totaplayer();
            }

        }

        else if(choice == 2){
            System.out.println("Enter Match Number : ");
            int n = sc.nextInt();
            ff.matchplayer(n);
        }

        else if(choice == 3){
            ff.totaplayer();
        }

        else if(choice == 4){
            System.exit(0);
        }
        sc.close();

    }
}
