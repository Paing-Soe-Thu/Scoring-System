package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class scoringSystem {


        public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub

            displayWelcomeAndRules();

            char choice;

            do {

                System.out.println("******** MENU ************");
                System.out.println("Please Enter the following: \n " + "1 for Normal Teams \n "
                        + "2 for Normal Individuals \n " + "3 for Special Teams \n " + "4 for Special Individuals");
                int option;
                do {
                    option = getInt();

                    if (option == -1) {
                        System.out.println("!!! INVALID INPUT, PLEASE ENTER NUMBER FORMAT ONLY !!!");
                        System.out.println("Please Re-enter the following: \n " + "1 for Normal Teams \n "
                                + "2 for Normal Individuals \n" + " 3 for Special Teams \n " + "4 for Special Individuals");
                    }
                } while (option == -1);

                switch (option) {
                    case 1:
                        normalTeam();
                        break;
                    case 2:
                        normalIndividuals();
                        break;
                    case 3:
                        specialTeam();
                        break;
                    case 4:
                        specialIndividuals();
                        break;
                    default:
                        System.out.println(" Please enter 1 or 2 or 3 or 4 only ");
                }

                System.out.println("Do you want to continue (y/n) ?");
                choice = getString().toLowerCase().charAt(0);
            } while (choice == 'y');

            System.out.println("Thanks for Participation! See you Again, Thank you!");
            System.out.println("----------------------------------------------------------------------------\n");
        }

        private static String getString() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            return br.readLine();
        }

        private static int getInt() throws IOException {

            String st = getString();

            if (isNum(st)) {
                return Integer.parseInt(st);
            } else {
                return -1;
            }
        }

        private static boolean isNum(String st) {

            try {
                Integer.parseInt(st);
                return true;
            } catch (NumberFormatException e) {
                // TODO: handle exception
                return false;
            }

        }

        private static void displayWelcomeAndRules() {
            System.out.println("\n***** College Tournament Scoring System ******");
            System.out.println("\nTournament Scoring System Rules:" + "\n\nNormal Team Scoring Rules:\n"
                    + "(a) For Normal Teams and Individuals Participants:\n" + "Rank 1 gives 20 points ");
            System.out.println("Rank 2 gives 10 points \n" + "Rank 3 gives 5 points");
            System.out.println("Rank 4 and lower will not receive any points\n");
            System.out.println("(b) For Special Teams and Individuals");
            System.out.println("Rank 1 gives 100 points \n" + "Rank 2 Gives 80 points \n" + "Rank 3 Gives 60 points");
            System.out.println("Rank 4 or lower will not give any points");
            System.out.println("\nGeneral Rules:");
            System.out.println("***************");
            System.out.println("=> 5 Events are set for Normal Teams and Individuals");
            System.out.println("=> Only 1 event is allowed for Special Teams and Individuals ");
            System.out.println("=> There can only be 5 Participants in both Normal and Special team");
            System.out.println("=> Normal Teams and Individual Participants will participate in 5 Events");
            System.out.println("=> Special Teams and Individual Participants will participate in only 1 Event\n");
        }

        private static void displayRankScoreHeader() {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("----------------------------- RANK SCORE -----------------------------------");
            System.out.println("----------------------------------------------------------------------------");
        }

        private static void displayScoreForEachRank(int rank1, int rank2, int rank3) {
            System.out.println("\nRank 1 : " + rank1 + "\nRank 2 : " + rank2 + "\nRank 3 : " + rank3
                    + "\nThe rest of the ranks will not be scored any points.\n");
        }

        private static void normalTeam() throws IOException {
            // Start of the teams and number of teams
            System.out.println("\n*****************************************************************************\n");
            System.out.println("\n----- Teams of College ------");
            System.out.print("Points of Normal Teams ");
            displayScoreForEachRank(20, 10, 5);

            System.out.print("Enter the total number of Teams for 5 EVENTS : ");
            int teamNo;

            do {

                teamNo = getInt();

                if (teamNo == -1) {
                    System.out.println("!!! INVALID INPUT !!!");
                    System.out.print("Re-Enter the total number of Teams for 5 EVENTS : ");
                }

            } while (teamNo == -1);
            System.out.println();

            // Declaring Single Dimension Array
            String[] teamName = new String[teamNo];
            int[] teamScore = new int[teamNo];
            String[] Tevent = new String[5];
            String[] teamPart = new String[teamNo * 5];// create array base on team number, each team have 5 members

            int teamRank;
            int eventNo, partNo;
            eventNo = partNo = 5;

            String temp;
            boolean isValid = true;

            // To check for number of teams
            // skip all if team size 0
            if (teamNo == 0) {
                System.out.println("Oops!! There are no Event. Because of no participant !!");
            } else {

                // for event names
                for (int i = 0; i < eventNo; i++) {
                    System.out.print("Enter Event Name " + (i + 1) + " for the teams : ");

                    // check the input value is empty or not
                    do {
                        temp = getString();
                        isValid = true;// reset the value

                        if (temp.length() == 0) {
                            System.out.println("!!! EMPTY INPUT VALUE !!!");
                            System.out.print("Re-Enter Event Name " + (i + 1) + " for the teams : ");
                            isValid = false;
                        }
                    } while (!isValid);
                    Tevent[i] = temp;
                }

                // for team name and each participant name
                System.out.println();
                for (int i = 0; i < teamNo; i++) {
                    System.out.print("Enter the Name of team " + (i + 1) + " : ");

                    // check the input team name is empty or not
                    do {
                        temp = getString();
                        isValid = true;// reset the value

                        if (temp.length() == 0) {
                            System.out.println("!!! TEAM NAME CANNOT BE EMPTY !!!");
                            System.out.print("Re-Enter the Name of team " + (i + 1) + " : ");
                            isValid = false;
                        }
                    } while (!isValid);

                    teamName[i] = temp;

                    for (int a = 0; a < partNo; a++) {
                        System.out.print("Enter Participant name " + (a + 1) + " for team " + teamName[i] + " : ");

                        // check the participant name is empty or not

                        do {
                            temp = getString();
                            isValid = true;

                            if (temp.length() == 0) {
                                System.out.println("!!! PARTICIPANT NAME CANNOT BE EMPTY !!!");
                                System.out
                                        .print("Re-Enter Participant name " + (a + 1) + " for team " + teamName[i] + " : ");
                                isValid = false;
                            }
                        } while (!isValid);

                        teamPart[a + (i * partNo)] = temp;
                    }
                    System.out.println();
                }

                // for team name and the rank of the teams
                displayRankScoreHeader();
                for (int i = 0; i < teamNo; i++) {

                    for (int e = 0; e < eventNo; e++) {
                        System.out.print("Enter Rank of the team " + teamName[i] + " on the " + Tevent[e] + " event : ");

                        // to check the input value is number or not
                        do {
                            teamRank = getInt();
                            isValid = true;// reset the value+

                            if (teamRank == -1) {
                                System.out.println("!!! INVALID INPUT !!!");
                                System.out.print(
                                        "Re-Enter Rank of the team " + teamName[i] + " on the " + Tevent[e] + " event : ");
                                isValid = false;
                            }

                        } while (!isValid);

                        int tRank = 0;

                        // for scoring system for the teams
                        switch (teamRank) {
                            case 3:
                                tRank = 5;
                                break;
                            case 2:
                                tRank = 10;
                                break;
                            case 1:
                                tRank = 20;
                                break;
                            default:
                                System.out.println("Team \"" + teamName[i] + "\" will not be scored any points for " + Tevent[e]
                                        + " event\n");
                        }

                        teamScore[i] += tRank;
                        System.out.println(
                                "Team \"" + teamName[i] + "\" got " + tRank + " points scored for " + Tevent[e] + " event");
                        System.out.println("Current total scores of Team " + teamName[i] + " : " + teamScore[i] + "\n");

                        System.out.println();
                    }
                    System.out.println("----------------------------------------------------------------------------\n");
                }

                // Output for all Teams with their respective events and scores

                System.out.println("\n--- Normal Team Information ---");
                System.out.println("Number of Teams Registered    : " + teamNo);
                System.out.println("Number of Events Participated : 5");
                System.out.println("Events List for Teams : " + Arrays.asList(Tevent));
                System.out.println("Score Points Won:");
                System.out.println("-----------------");
                System.out.println();
                System.out.println("All Teams Scores : " + Arrays.toString(teamScore));

                System.out.println("----------------------------------------------------------------------------");
                System.out.println("\t  Team\t\t      Participants\t\t       Score");
                System.out.println("----------------------------------------------------------------------------");

                int winner_team_score = teamScore[0];

                ArrayList<Integer> myWinnerIndexList = new ArrayList<Integer>();
                myWinnerIndexList.add(0);

                for (int i = 1; i < teamNo; i++) {

                    if (teamScore[i] == winner_team_score) {
                        myWinnerIndexList.add(i);
                    }

                    else if (teamScore[i] > winner_team_score) {
                        winner_team_score = teamScore[i];
                        myWinnerIndexList.clear();
                        myWinnerIndexList.add(i);
                    }
                }

                for (int i = 0; i < teamNo; i++) {

                    System.out.print("\t Team: " + teamName[i] + "\t ");

                    // display each participate name
                    for (int ii = 0; ii < partNo; ii++) {

                        int index = ii + (partNo * i);

                        if (ii == 0) {
                            System.out.println("\t" + teamPart[index]);
                        } else if (ii != (partNo - 1)) {
                            System.out.println("\t\t\t\t" + teamPart[index]);
                        } else {
                            System.out.print("\t\t\t\t" + teamPart[index]);
                        }

                    }

                    System.out.println("\t\t\tTeam Score: " + teamScore[i]);
                    System.out.println("----------------------------------------------------------------------------");
                }

                System.out.print("Congratulations!! Team(s) ");

                printArrayListWithCustomFormat(myWinnerIndexList, teamName);

                System.out.println(" has won with score :" + winner_team_score);
                System.out.println("----------------------------------------------------------------------------");
            }
            System.out.println("\n*****************************************************************************\n");
        }

        private static void normalIndividuals() throws IOException {

            System.out.println("\n*****************************************************************************\n");
            System.out.println("----- College Individual Participants -----");
            System.out.print("Points of Individual Participants");
            displayScoreForEachRank(20, 10, 5);

            int PartNo;
            System.out.println("Enter the number of individuals participating 5 EVENTS" + "\nLIMITED SPACE OF 20");
            boolean isValid = true;
            String tempInputValue;

            // to check input is valid or not
            do {
                PartNo = getInt();
                isValid=true;

                if (PartNo == -1) {
                    System.out.println("!!! INVALID INPUT !!!");
                    isValid = false;
                } else if (PartNo > 20) {
                    System.out.println("!!! NOT MORE THAN 20 PARTICIPATES !!!");
                    isValid = false;
                }

                if (!isValid)
                    System.out
                            .println("Re-Enter the number of individuals participating 5 EVENTS" + "\nLIMITED SPACE OF 20");

            } while (isValid == false);

            String[] PartName = new String[PartNo];
            int[] PartScore = new int[PartNo];
            String[] Pevent = new String[5];
            int PartRank = -1;
            int eventCount = 5;

            // condition checking
            // skip all code for individual if 0

            if (PartNo != 0) {

                // for event name for the individuals
                System.out.println("\nEnter the 5 event names for participants ");
                for (int i = 0; i < eventCount; i++) {
                    System.out.print("Enter Name of the event " + (i + 1) + " that the individuals are entering : ");

                    // to check the event name is empty or not
                    do {
                        tempInputValue = getString();
                        isValid = true;

                        if (tempInputValue.length() == 0) {
                            System.out.println("!!! EMPTY EVENT NAME !!!");
                            System.out.print(
                                    "Re-Enter Name of the event " + (i + 1) + " that the individuals are entering : ");
                            isValid = false;
                        }
                    } while (!isValid);

                    Pevent[i] = tempInputValue;
                }

                // name of the individuals
                System.out.println();
                for (int i = 0; i < PartNo; i++) {
                    System.out.print("Enter name of Participant " + (i + 1) + " : ");

                    // to check input name is empty or not
                    do {
                        tempInputValue = getString();
                        isValid = true;

                        if (tempInputValue.length() == 0) {
                            System.out.println("!!! EMPTY PARTICIPANT NAME !!!");
                            System.out.print("Re-Enter name of Participant " + (i + 1) + " : ");
                            isValid = false;
                        }
                    } while (!isValid);

                    PartName[i] = tempInputValue;
                }

                // for the rank of the team
                System.out.println();
                displayRankScoreHeader();
                for (int i = 0; i < PartNo; i++) {
                    for (int a = 0; a < 5; a++) {
                        System.out.print(
                                "Enter rank of the Participant  \"" + PartName[i] + "\" on the " + Pevent[a] + " event : ");
                        // check the rank input is valid or not
                        do {
                            PartRank = getInt();

                            if (PartRank == -1) {

                                System.out.println("!!! INVALID INPUT !!!");
                                System.out.print("Re-Enter rank of the Participant  \"" + PartName[i] + "\" on the "
                                        + Pevent[a] + " event : ");
                            }
                        } while (PartRank == -1);

                        int pRank = 0;
                        // start of scoring system for the individuals
                        switch (PartRank) {
                            case 3:
                                pRank = 5;
                                break;
                            case 2:
                                pRank = 10;
                                break;
                            case 1:
                                pRank = 20;
                                break;
                            default:
                                System.out.println("Participant \"" + PartName[i] + "\" will not be scored any points for "
                                        + Pevent[i] + " event\n");
                        }

                        PartScore[i] += pRank;
                        System.out.println("Paticipant \"" + PartName[i] + "\" got " + pRank + " points scored for "
                                + Pevent[a] + " event");
                        System.out.println("Current Total scores of " + PartName[i] + " is " + PartScore[i] + "\n");

                    }
                    System.out.println("----------------------------------------------------------------------------\n");
                }

                // Output for all Individuals with their respective events and scores
                System.out.println("\nNo. of Participants: " + PartNo);
                System.out.println("Events Participated : " + eventCount);
                System.out.println("Events List for Individuals : " + Arrays.asList(Pevent));
                System.out.println("Score Points won:");
                System.out.println("All Individual Scores:" + Arrays.toString(PartScore));
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("\tIndividual Name \t\t\t  Score");
                System.out.println("----------------------------------------------------------------------------");

                int pwinner_score = PartScore[0];
                ArrayList<Integer> myWinnerIndexList = new ArrayList<Integer>();
                myWinnerIndexList.add(0);

                // display each participant scores
                for (int i = 0; i < PartNo; i++) {
                    System.out.println(" \tIndividual Name: " + PartName[i] + "\t\t Score: " + PartScore[i]);
                }

                System.out.println("----------------------------------------------------------------------------");

                // find all index of highest scores
                for (int i = 1; i < PartNo; i++) {

                    if (PartScore[i] == pwinner_score) {
                        myWinnerIndexList.add(i);
                    }

                    else if (PartScore[i] > pwinner_score) {
                        pwinner_score = PartScore[i];
                        myWinnerIndexList.clear();
                        myWinnerIndexList.add(i);

                    }
                }

                System.out.print("Conngratulations!! Individual Particiapant(s) ");
                printArrayListWithCustomFormat(myWinnerIndexList, PartName);
                System.out.println(" has won with score :" + pwinner_score);
                System.out.println("----------------------------------------------------------------------------");

            } else {
                System.out.println("Oops! There are no participants\n");
            }

            System.out.println("\n*****************************************************************************\n");
        }

        private static void specialTeam() throws IOException {
            // Starting of special teams
            // for number of special teams
            System.out.println("\n*****************************************************************************\n");
            System.out.println("Special Teams and Individuals Represent Teams and Individuals entering only 1 event");

            System.out.println("----- Special Teams -----");
            System.out.print("Points of Special Teams ");
            displayScoreForEachRank(100, 80, 60);

            System.out.print("Enter number of Teams Entering only 1 EVENT : ");
            int SpecTeamNo;
            boolean isValid = true;
            String tempInputStringValue;

            // to check input number is valid or not
            do {
                SpecTeamNo = getInt();
                isValid = true;

                if (SpecTeamNo == -1) {
                    System.out.println("!!! INVALID INPUT !!!");
                    System.out.print("Re-Enter number of Teams Entering only 1 EVENT : ");
                    isValid = false;
                }

            } while (!isValid);

            String[] SpecTeamName = new String[SpecTeamNo];
            String STevent;
            int[] SpecTeamScore = new int[SpecTeamNo];
            String[] SteamPart = new String[SpecTeamNo * 5];
            int sTeamRank = -1;
            int partNo = 5;

            // condition checking for number of special teams
            // skip if 0

            if (SpecTeamNo != 0) {

                // event for special team
                System.out.print("\nEnter Event Name for the teams : ");

                // to check the even name is empty or not
                do {

                    tempInputStringValue = getString();
                    isValid = true;

                    if (tempInputStringValue.length() == 0) {
                        System.out.println("!!! EMPTY EVEN NAME !!!");
                        System.out.print("Re-Enter Event Name for the teams : ");
                        isValid = false;
                    }

                } while (!isValid);

                STevent = tempInputStringValue;

                // name for team
                System.out.println();
                for (int i = 0; i < SpecTeamNo; i++) {
                    System.out.print("Enter Name of team " + (i + 1) + " : ");

                    // to check the input team name is empty or not
                    do {
                        tempInputStringValue = getString();
                        isValid = true;

                        if (tempInputStringValue.length() == 0) {
                            System.out.println("!!! EMPTY TEAM NAME !!!");
                            System.out.print("Re-Enter Name of team " + (i + 1) + " : ");
                            isValid = false;
                        }
                    } while (!isValid);

                    SpecTeamName[i] = tempInputStringValue;
                }

                // participant name for special team
                System.out.println();
                for (int a = 0; a < SpecTeamNo; a++) {
                    for (int i = 0; i < partNo; i++) {
                        System.out.print("Enter Participant name " + (i + 1) + " for team " + SpecTeamName[a] + " : ");

                        // to check the name is empty or not
                        do {
                            tempInputStringValue = getString();
                            isValid = true;

                            if (tempInputStringValue.length() == 0) {
                                System.out.println("!!! EMPTY PARTICIPANT NAME !!!");
                                System.out.print(
                                        "Re-Enter Participant name " + (i + 1) + " for team " + SpecTeamName[a] + " : ");
                                isValid = false;
                            }
                        } while (!isValid);

                        SteamPart[i + (a * partNo)] = tempInputStringValue;

                    }
                    System.out.println();
                }

                // name and rank of special teams
                System.out.println();
                for (int i = 0; i < SpecTeamNo; i++) {
                    System.out
                            .print("Enter rank of the team \"" + SpecTeamName[i] + "\" on the + " + STevent + " event : ");

                    // to check input rank value is valid or not
                    do {
                        sTeamRank = getInt();

                        if (sTeamRank == -1) {
                            System.out.println("!!! INVALID INPUT !!!");
                            System.out.print("Re-Enter rank of the team  \"" + SpecTeamName[i] + "\" on the " + STevent
                                    + " event : ");
                        }
                    } while (sTeamRank == -1);

                    int stRank = 0;
                    // scoring system for special team
                    switch (sTeamRank) {
                        case 3:
                            stRank = 60;
                            break;
                        case 2:
                            stRank = 80;
                            break;
                        case 1:
                            stRank = 100;
                            break;
                        default:
                            System.out.println("Team \"" + SpecTeamName[i] + "\" will not be scored any points for " + STevent
                                    + " event\n");
                    }

                    SpecTeamScore[i] += stRank;
                    System.out.println(
                            "Team \"" + SpecTeamName[i] + "\" got " + stRank + " points for " + STevent + " event");
                    System.out.println(
                            "Current Total points of Team \"" + SpecTeamName[i] + "\" is " + SpecTeamScore[i] + "\n");

                }

                // Output for all Special Teams with their respective events and scores
                System.out.println("The Number of Special Teams " + SpecTeamNo);
                System.out.println("Events Participated : 1");
                System.out.println("Events List for Teams: " + Arrays.asList(STevent));
                System.out.println("Scores Won:");
                System.out.println("All Special Team Scores: " + Arrays.toString(SpecTeamScore));
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("\t Special Team\t  Individual Participants\t    Score");
                System.out.println("----------------------------------------------------------------------------");

                for (int i = 0; i < SpecTeamNo; i++) {

                    System.out.print("\t Team: " + SpecTeamName[i] + "\t ");

                    // display each participate name
                    for (int ii = 0; ii < partNo; ii++) {

                        int temp = ii + (i * partNo);

                        if (ii == 0) {
                            System.out.println("\t" + SteamPart[temp]);
                        } else if (ii != (partNo - 1)) {
                            System.out.println("\t\t\t\t" + SteamPart[temp]);
                        } else {
                            System.out.print("\t\t\t\t" + SteamPart[temp]);
                        }

                    }

                    System.out.println("\t\t\tTeam Score: " + SpecTeamScore[i]);
                    System.out.println("----------------------------------------------------------------------------");

                }

                int Swinner_team_score = SpecTeamScore[0];
                ArrayList<Integer> myWinnerIndexList = new ArrayList<Integer>();
                myWinnerIndexList.add(0);

                // find the highest scores index
                for (int i = 1; i < SpecTeamNo; i++) {

                    int temp = SpecTeamScore[i];

                    if (Swinner_team_score == temp) {
                        myWinnerIndexList.add(i);
                    } else if (Swinner_team_score < temp) {
                        Swinner_team_score = temp;
                        myWinnerIndexList.clear();
                        myWinnerIndexList.add(i);
                    }
                }

                System.out.println("----------------------------------------------------------------------------");
                System.out.print("Congratulations!! Special Team(s) ");
                printArrayListWithCustomFormat(myWinnerIndexList, SpecTeamName);
                System.out.println(" has won with score :" + Swinner_team_score);
                System.out.println("----------------------------------------------------------------------------");

            } else {
                System.out.println("There are no Special Teams");
            }
            System.out.println("\n*****************************************************************************\n");
        }

        private static void specialIndividuals() throws IOException {
            // the start of special individuals
            // number of special individuals
            System.out.println("\n*****************************************************************************\n");
            System.out.println("-----Special_Individuals-----");
            System.out.print("Points for Special Individuals");
            displayScoreForEachRank(100, 80, 60);

            int SpecPartNo;
            boolean isValid = true;
            String tempInputStringValue;

            System.out.print("Enter Number of Individuals only Entering 1 event :");
            // to check number format
            do {
                SpecPartNo = getInt();

                if (SpecPartNo == -1) {
                    System.out.println("!!! INVALID INPUT !!!");
                    System.out.print("Re-Enter Number of Individuals only Entering 1 event :");
                }
                else if(SpecPartNo > 20) {
                    System.out.println("!!! INPUT NUMBER IS NOT MORE THAN 20 !!!");
                    System.out.print("Re-Enter Number of Individuals only Entering 1 event :");
                    SpecPartNo = -1;
                }
            } while (SpecPartNo == -1);

            String[] SpecPartName = new String[SpecPartNo];
            String SPevent;
            int[] SpecPartScore = new int[SpecPartNo];

            // condition checking number of special individuals
            // skip all codes for special individuals if 0

            if (SpecPartNo != 0) {
                // event for the special individuals
                System.out.print("Enter Event Name for the individuals : ");

                // check event name is empty or not
                do {
                    tempInputStringValue = getString();
                    isValid = true;

                    if (tempInputStringValue.length() == 0) {
                        System.out.println("!!! EMPTY EVENT NAME !!!");
                        System.out.print("Re-Enter Event Name for the individuals :");
                        isValid = false;
                    }
                } while (!isValid);

                SPevent = tempInputStringValue;

                // name and rank input of special individuals
                System.out.println();
                for (int i = 0; i < SpecPartNo; i++) {
                    System.out.print("Enter Name of individual " + (i + 1) +" : ");

                    // to check the name is empty or not
                    do {
                        tempInputStringValue = getString();
                        isValid = true;

                        if (tempInputStringValue.length() == 0) {
                            System.out.println("!!! EMPTY NAME !!!");
                            System.out.print("Re-Enter Name of individual " + (i + 1) +" : ");
                            isValid = false;
                        }
                    } while (!isValid);

                    SpecPartName[i] = tempInputStringValue;
                }

                System.out.println();
                for (int i = 0; i < SpecPartNo; i++) {

                    System.out.print(
                            "Enter rank of the individual \"" + SpecPartName[i] + "\" on the " + SPevent + " event : ");
                    int sPartRank;

                    // to check number format
                    do {
                        sPartRank = getInt();

                        if (sPartRank == -1) {
                            System.out.println("!!! INVALID INPUT !!!");
                            System.out.print("Re-Enter rank of the individual \"" + SpecPartName[i] + "\" on the " + SPevent
                                    + " event : ");
                        }
                    } while (sPartRank == -1);

                    int spRank = 0;
                    // scoring system for the individuals
                    switch (sPartRank) {
                        case 3:
                            spRank = 60;
                            break;
                        case 2:
                            spRank = 80;
                            break;
                        case 1:
                            spRank = 100;
                            break;
                        default:
                            System.out.println("This individual \"" + SpecPartName[i] + "\" will not be scored any points");
                    }

                    SpecPartScore[i] = spRank;
                    System.out.println(
                            "This individual \"" + SpecPartName[i] + "\" got " + spRank + " points scored for this event");

                }

                // Output for all Special Individuals with their respective events and scores
                System.out.println("Number of Special Individuals " + SpecPartNo);
                System.out.println("Events Participated : 1");
                System.out.println("Events List for Teams : " + Arrays.asList(SPevent));
                System.out.println("Scores Won: ");
                System.out.println("All Special Individuals Scores: " + Arrays.toString(SpecPartScore));
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("\tSpecial Individual\t    Score");
                System.out.println("----------------------------------------------------------------------------");

                // display each participate score
                for (int i = 0; i < SpecPartNo; i++) {
                    System.out.println("\tIndividual Name: " + SpecPartName[i] + " \t Score: " + SpecPartScore[i]);
                }
                System.out.println("----------------------------------------------------------------------------");

                int spwinner_score = SpecPartScore[0];
                ArrayList<Integer> myWinnerIndexList = new ArrayList<Integer>();
                myWinnerIndexList.add(0);

                // find highest score and then save their index number
                for (int i = 1; i < SpecPartNo; i++) {

                    if (spwinner_score == SpecPartScore[i]) {
                        myWinnerIndexList.add(i);
                    } else if(spwinner_score < SpecPartScore[i]){
                        spwinner_score = SpecPartScore[i];
                        myWinnerIndexList.clear();
                        myWinnerIndexList.add(i);
                    }
                }

                System.out.print("Conngratulations!! Special Individual Particiapant ");
                printArrayListWithCustomFormat(myWinnerIndexList, SpecPartName);
                System.out.println(" has won with score :" + spwinner_score);
                System.out.println("----------------------------------------------------------------------------");

            } else {
                System.out.println("There are  no Special Individuals");
            }
            System.out.println("\n*****************************************************************************\n");

        }

        private static void printArrayListWithCustomFormat(ArrayList<Integer> myList, String[] nameArr) {
            int size = myList.size();

            System.out.print(nameArr[myList.get(0)]);

            for (int i = 1; i < size; i++) {

                if (i == size - 1)
                    System.out.print(" and ");
                else
                    System.out.print(", ");

                System.out.print(nameArr[myList.get(i)]);

            }
        }
    }

