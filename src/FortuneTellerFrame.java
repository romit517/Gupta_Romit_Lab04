import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;


public class FortuneTellerFrame extends JFrame {


    JPanel top, middle, bottom, main;
    JLabel topLbl, bottomLbl;
    JButton actionBtn, quitBtn;
    JTextArea textArea;
    JScrollPane scroller;
    ImageIcon icon;
    JScrollBar verticle;


    ArrayList<String> fortunes = new ArrayList<>();

    ArrayList<Integer> repeatChecker = new ArrayList<>();

    public int index;


    public FortuneTellerFrame()
    {
        super("Fortune Teller");
        main = new JPanel();
        createTopPanel();
        createMiddlePanel();
        createBottomPanel();
        loadFortunes();


        //Adding our Sub-Panels to the MainFRAME


        main.setLayout(new BorderLayout());
        main.add(top,BorderLayout.NORTH);
        main.add(middle,BorderLayout.CENTER);
        main.add(bottom,BorderLayout.SOUTH);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(3 * (screenSize.width / 4), 3 * (screenSize.height / 4));
        setLocationRelativeTo(null);


        add(main);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loadFortunes()
    {
        fortunes.add("You will get an “A” on a test.");
        fortunes.add("You will be rich.");
        fortunes.add("Good fortune will be yours.");
        fortunes.add("You will have many friends.");
        fortunes.add("You will see the light, just not the one you are expecting.");
        fortunes.add("Do a good deed today.");
        fortunes.add("Someone will call you today.");
        fortunes.add("The fortune you seek is not here.");
        fortunes.add("You will go to a party soon.");
        fortunes.add("Be careful on Tuesday.");
        fortunes.add("You will have very good luck today.");
        fortunes.add("You will be unusually successful in business");
    }

    private void createTopPanel()
    {
        top = new JPanel();
        icon = new ImageIcon("fortuneTeller.png");
        topLbl = new JLabel("Fortune Teller", icon, SwingConstants.CENTER);
        topLbl.setFont(new Font("Comic Sans MS",Font.PLAIN, 36));
        top.add(topLbl);
    }

    private void createMiddlePanel()
    {
        middle = new JPanel();
        textArea = new JTextArea(10, 50);
        scroller = new JScrollPane(textArea);

        scroller.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(700, 400));


        middle.setFont(new Font("Bradley Hand ITC", Font.ITALIC, 20));

        middle.add(scroller);
    }

    private void createBottomPanel()
    {
        bottom = new JPanel();
        bottomLbl = new JLabel();

        actionBtn = new JButton("Read My Fortune!");
        actionBtn.addActionListener((ActionEvent ae) -> {
            mixFortunes();
        });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });

        bottom.setFont(new Font("Bradley Hand ITC", Font.ITALIC, 12));
        bottom.add(actionBtn);
        bottom.add(quitBtn);
    }

    public void mixFortunes() throws ArrayIndexOutOfBoundsException
    {
        Random random = new Random();
        int previousNum;

        if(repeatChecker.size() > 1)
        {
            previousNum = repeatChecker.size() -1;
        }
        else
        {
            previousNum = 0;
        }

        while (true)
            {
                index = random.nextInt(fortunes.size());
                repeatChecker.add(index);
                if (index != repeatChecker.get(previousNum)) break;
            }

        textArea.append(fortunes.get(index) + "\n");
    }


}
