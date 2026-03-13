import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Scholarship {
    String name;
    String state;
    int minAge;
    int maxAge;
    String education;
    int incomeLimit;
    int amount;

    Scholarship(String name, String state, int minAge, int maxAge,
                String education, int incomeLimit, int amount) {
        this.name = name;
        this.state = state;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.education = education;
        this.incomeLimit = incomeLimit;
        this.amount = amount;
    }
}

public class ScholarshipApp {

    static ArrayList<Scholarship> scholarships = new ArrayList<>();

    public static void main(String[] args) {

        loadScholarships();

        JFrame frame = new JFrame("Scholarship Finder App");
        frame.setSize(500,500);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Age
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(20,20,100,30);
        frame.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(150,20,200,30);
        frame.add(ageField);

        // Education
        JLabel eduLabel = new JLabel("Education:");
        eduLabel.setBounds(20,70,100,30);
        frame.add(eduLabel);

        JTextField eduField = new JTextField();
        eduField.setBounds(150,70,200,30);
        frame.add(eduField);

        // Income
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setBounds(20,120,100,30);
        frame.add(incomeLabel);

        JTextField incomeField = new JTextField();
        incomeField.setBounds(150,120,200,30);
        frame.add(incomeField);

        // State
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setBounds(20,170,100,30);
        frame.add(stateLabel);

        JTextField stateField = new JTextField();
        stateField.setBounds(150,170,200,30);
        frame.add(stateField);

        // Button
        JButton button = new JButton("Find Scholarships");
        button.setBounds(150,220,180,40);
        frame.add(button);

        // Result Area
        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(20,300,440,120);
        frame.add(resultArea);

        // Button Logic
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    int age = Integer.parseInt(ageField.getText());
                    String education = eduField.getText().toLowerCase();
                    int income = Integer.parseInt(incomeField.getText());
                    String state = stateField.getText().toLowerCase();

                    String result = "";

                    for(Scholarship s : scholarships){

                        if(age >= s.minAge &&
                           age <= s.maxAge &&
                           education.equals(s.education) &&
                           income <= s.incomeLimit &&
                           (s.state.equals("all") || s.state.equals(state))){

                            result += s.name + " (₹" + s.amount + ")\n";
                        }
                    }

                    if(result.equals("")){
                        result = "No scholarships found.";
                    }

                    resultArea.setText(result);

                } catch(Exception ex){
                    resultArea.setText("Please enter valid inputs.");
                }
            }
        });

        frame.setVisible(true);
    }

    static void loadScholarships() {

        // National scholarships
        scholarships.add(new Scholarship("Central Sector Scholarship","all",18,25,"degree",800000,20000));
        scholarships.add(new Scholarship("AICTE Pragati Scholarship","all",17,23,"engineering",800000,50000));
        scholarships.add(new Scholarship("INSPIRE Scholarship","all",17,22,"science",0,80000));

        // Andhra Pradesh
        scholarships.add(new Scholarship("AP Post-Matric Scholarship","andhra pradesh",16,25,"degree",250000,15000));
        scholarships.add(new Scholarship("AP Pre-Matric Scholarship","andhra pradesh",13,16,"school",200000,10000));

        // Telangana
        scholarships.add(new Scholarship("Telangana ePASS Scholarship","telangana",16,25,"degree",250000,15000));

        // Tamil Nadu
        scholarships.add(new Scholarship("Tamil Nadu BC Scholarship","tamil nadu",16,25,"degree",200000,12000));

        // Karnataka
        scholarships.add(new Scholarship("Karnataka Vidyasiri Scholarship","karnataka",16,25,"degree",200000,15000));

        // Maharashtra
        scholarships.add(new Scholarship("Maharashtra Post Matric Scholarship","maharashtra",16,25,"degree",250000,12000));

        // Gujarat
        scholarships.add(new Scholarship("Gujarat Digital Scholarship","gujarat",16,25,"degree",200000,12000));

        // Rajasthan
        scholarships.add(new Scholarship("Rajasthan Scholarship Scheme","rajasthan",16,25,"degree",200000,10000));

        // Kerala
        scholarships.add(new Scholarship("Kerala eGrantz Scholarship","kerala",16,25,"degree",200000,15000));

        // Uttar Pradesh
        scholarships.add(new Scholarship("UP Scholarship Scheme","uttar pradesh",16,25,"degree",200000,10000));
    }
}