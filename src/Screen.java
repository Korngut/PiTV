import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_SMOOTH;
import static java.awt.event.KeyEvent.VK_F4;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;

public class Screen extends JFrame implements KeyListener {
    //initialize

    //design panels
    private final JPanel excaliburPanel;
    private final JLabel excaliburLabel;
    private ImageIcon excaliburIcon;

    private final JPanel ironSwordPanel;
    private final JLabel ironSwordLabel;
    private final ImageIcon ironSwordIcon;

//    private final JPanel hourPanel;
//    private final JLabel hourLabel;
//    private final Calendar calendar;


    //menus
    private final Menu stuffMenu;
    private final Menu mechanicsMenu;
    private final Menu electronicsMenu;
    private final Menu programmingMenu;
    private final Menu communityMenu;
    private Menu currentMenu;


    //windows

    //mechanics
    private final Window modelingWindow;
    private final Window productionWindow;
    private final Window swerveMechanicsWindow;
    private final Window intakeMechanicsWindow;
    private final Window shooterMechanicsWindow;
    private final Window climberMechanicsWindow;

    //electronics
    private final Window swerveElectronicsWindow;
    private final Window intakeElectronicsWindow;
    private final Window shooterElectronicsWindow;
    private final Window mainElectronicsWindow;
    private final Window wiringWindow;
    private final Window monitoringWindow;

    //programming
    private final Window swerveProgrammingWindow;
    private final Window intakeProgrammingWindow;
    private final Window shooterProgrammingWindow;
    private final Window climberProgrammingWindow;
    private final Window autonomousWindow;
    private final Window imageProcessingWindow;

    //community
    private final Window javaCourse;
    private final Window mentorsCourseToFLL;
    private final Window babaDa;
    private final Window mentoringFLLGroups;
    private final Window volunteeringInFIRST;
    private final Window excaliday;
    private final Window exposingRoboticsToChildren;
    private final Window distributionFIRSTandSTEM;
    private final Window donatingBooksToSoldiers;
    private final Window swordOfPeace;
    private final Window volunteeringWithDisplacedFamilies;

    private Window currentWindow;

    //constants
    private static final int DEPUTY_MENU_WIDTH = 165;
    private static final int DEPUTY_MENU_HEIGHT = 522;

    private static final int DEPUTY_MENU_X = 1745;
    private static final int DEPUTY_MENU_Y = 120;

    private static final int DEPUTY_MENU_BUTTONS_WIDTH = 150;
    private static final int DEPUTY_MENU_BUTTONS_HEIGHT = 80;

    private static final int DEPUTY_MENU_BUTTONS_X = 823;

    private static final int DEPUTY_MENU_BUTTONS_H_GAP = 5;
    private static final int DEPUTY_MENU_BUTTONS_V_GAP = 5;

    private static final int WINDOWS_WIDTH = 1770;
    private static final int WINDOWS_HEIGHT = 950;

    private static final int WINDOWS_X = 7;
    private static final int WINDOWS_Y = 120;

    public Screen() {
        //design panels
        this.excaliburPanel = new JPanel();
        this.excaliburIcon = new ImageIcon("excalibur6738.png");
        this.excaliburIcon = this.scaleImageIcon(excaliburIcon, 0.65);
        this.excaliburLabel = new JLabel(excaliburIcon, CENTER);

        this.excaliburLabel.setHorizontalTextPosition(RIGHT);
        this.excaliburLabel.setFont(new Font("", BOLD, 45));
        this.excaliburLabel.setForeground(Colors.YELLOW.color);
        this.excaliburLabel.setBounds(13, 2, 790, 80);

        this.excaliburPanel.setLayout(null);
        this.excaliburPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.excaliburPanel.setBackground(Colors.BLUE.color);

        this.excaliburPanel.add(excaliburLabel);
        this.excaliburPanel.setBounds(10, 10, 800, 100);
        this.add(excaliburPanel);

        this.ironSwordPanel = new JPanel();
        this.ironSwordIcon = new ImageIcon("ironSword.jpg");
        this.ironSwordLabel = new JLabel(ironSwordIcon);

        this.ironSwordLabel.setBounds(870, 650, 105, 300);

        this.ironSwordPanel.setLayout(null);
        this.ironSwordPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.ironSwordPanel.setBackground(Colors.BLUE.color);

        this.ironSwordPanel.add(ironSwordLabel);
        this.ironSwordPanel.setBounds(1745, 645, 165, 425);
        this.add(ironSwordPanel);

        //hour panel
//        this.hourPanel = new JPanel();
//        this.hourPanel.setBounds(820, 10, 500, 100);
//        this.hourLabel = new JLabel();
//        this.hourLabel.setForeground(Colors.YELLOW.color);
//        this.calendar = Calendar.getInstance();
//
//        TimerTask updateTimeTask = new TimerTask() {
//            @Override
//            public void run() {
//                Calendar now = Calendar.getInstance();
//                int hour = now.get(Calendar.HOUR_OF_DAY); // 24-hour clock
//                int minute = now.get(Calendar.MINUTE);
//                int second = now.get(Calendar.SECOND);
//
//                hourLabel.setText("%d-%02d-%02d %02d:%02d:%02d\n" + hour + minute + second);
//            }
//        };
//
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(updateTimeTask, 0, 1000);
//
//        this.hourPanel.setLayout(null);
//        this.hourPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
//        this.hourPanel.setBackground(Colors.BLUE.color);
//
//        this.hourLabel.setBounds(830, 10, 490, 100);
//        this.hourPanel.add(hourLabel);
//        this.add(hourPanel);

        //set frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH); // 1920 * 1080
        this.getContentPane().setBackground(Colors.BLUE.color);
        this.setLayout(null);

        //windows
        this.currentWindow = new Window("", 0, 0, 0, 0);

        //mechanics
        modelingWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(modelingWindow);
        this.modelingWindow.setVisible(false);

        productionWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(productionWindow);
        this.productionWindow.setVisible(false);

        swerveMechanicsWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swerveMechanicsWindow);
        this.swerveMechanicsWindow.setVisible(false);

        intakeMechanicsWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(intakeMechanicsWindow);
        this.intakeMechanicsWindow.setVisible(false);

        shooterMechanicsWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(shooterMechanicsWindow);
        this.shooterMechanicsWindow.setVisible(false);

        climberMechanicsWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(climberMechanicsWindow);
        this.climberMechanicsWindow.setVisible(false);

        //electronics
        mainElectronicsWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(mainElectronicsWindow);
        this.mainElectronicsWindow.setVisible(false);

        swerveElectronicsWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swerveElectronicsWindow);
        this.swerveElectronicsWindow.setVisible(false);

        intakeElectronicsWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(intakeElectronicsWindow);
        this.intakeElectronicsWindow.setVisible(false);

        shooterElectronicsWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(shooterElectronicsWindow);
        this.shooterElectronicsWindow.setVisible(false);

        wiringWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(wiringWindow);
        this.wiringWindow.setVisible(false);

        monitoringWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(monitoringWindow);
        this.monitoringWindow.setVisible(false);

        //programming
        swerveProgrammingWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swerveProgrammingWindow);
        this.swerveProgrammingWindow.setVisible(false);

        intakeProgrammingWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(intakeProgrammingWindow);
        this.intakeProgrammingWindow.setVisible(false);

        shooterProgrammingWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(shooterProgrammingWindow);
        this.shooterProgrammingWindow.setVisible(false);

        climberProgrammingWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(climberProgrammingWindow);
        this.climberProgrammingWindow.setVisible(false);

        autonomousWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(autonomousWindow);
        this.autonomousWindow.setVisible(false);

        imageProcessingWindow = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(imageProcessingWindow);
        this.imageProcessingWindow.setVisible(false);

        //community
        javaCourse = new Window("javaCourse.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(javaCourse);
        this.javaCourse.setVisible(false);
        mentorsCourseToFLL = new Window("mentorsCourse.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.3);
        this.add(mentorsCourseToFLL);
        this.mentorsCourseToFLL.setVisible(false);
        babaDa = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(babaDa);
        this.babaDa.setVisible(false);
        mentoringFLLGroups = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(mentoringFLLGroups);
        this.mentoringFLLGroups.setVisible(false);
        volunteeringInFIRST = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(volunteeringInFIRST);
        this.volunteeringInFIRST.setVisible(false);
        excaliday = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(excaliday);
        this.excaliday.setVisible(false);
        exposingRoboticsToChildren = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(exposingRoboticsToChildren);
        this.exposingRoboticsToChildren.setVisible(false);
        distributionFIRSTandSTEM = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(distributionFIRSTandSTEM);
        this.distributionFIRSTandSTEM.setVisible(false);
        donatingBooksToSoldiers = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(donatingBooksToSoldiers);
        this.donatingBooksToSoldiers.setVisible(false);
        swordOfPeace = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swordOfPeace);
        this.swordOfPeace.setVisible(false);
        volunteeringWithDisplacedFamilies = new Window("", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(volunteeringWithDisplacedFamilies);
        this.volunteeringWithDisplacedFamilies.setVisible(false);

        //menus
        this.currentMenu = new Menu(0, 0, 0, 0, 0, 0);

        this.mechanicsMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(modelingWindow), "Modeling", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 17),
                new MyButton(() -> this.hidePrevAndShowNextWindow(productionWindow), "Production", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 293, 11),
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveMechanicsWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 376, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeMechanicsWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 459, 30),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterMechanicsWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(climberMechanicsWindow), "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 659, 24)
        );
        this.add(mechanicsMenu);

        this.electronicsMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(mainElectronicsWindow), "<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;main<br>electronics</html>", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 459, 10),
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveElectronicsWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeElectronicsWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 293, 30),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterElectronicsWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 376, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(wiringWindow), "Wiring", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 542, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(monitoringWindow), "Sensors", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 659, 20)
        );
        this.add(electronicsMenu);

        this.programmingMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveProgrammingWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeProgrammingWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 293, 30),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterProgrammingWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 376, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(climberProgrammingWindow), "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 459, 24),
                new MyButton(() -> this.hidePrevAndShowNextWindow(autonomousWindow), "Autonomous", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 9),
                new MyButton(() -> this.hidePrevAndShowNextWindow(imageProcessingWindow), "<html>&nbsp;&nbsp;&nbsp;&nbsp;image<br>processing</html>", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 659, 10)
        );
        this.add(programmingMenu);

        this.communityMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT + this.ironSwordPanel.getHeight(), DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(javaCourse), String.format("<html>%sjava<br>%scourse</html>", this.indent(8), this.indent(6)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(mentorsCourseToFLL), String.format("<html>%smentors<br>%scourse<br>%sto FLL</html>", this.indent(5), this.indent(6), this.indent(7)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 293, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(babaDa), "בבא-דע", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 376, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(mentoringFLLGroups), String.format("<html>%smentoring<br>%sFLL groups</html>", this.indent(3), this.indent(2)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 459, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(volunteeringInFIRST), String.format("<html>%svolunteering<br>%sin FIRST</html>", this.indent(1), this.indent(5)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(excaliday), "EXCALIDAY", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 659, 10),
                new MyButton(() -> this.hidePrevAndShowNextWindow(exposingRoboticsToChildren), String.format("<html>%sexposing<br>%srobotics<br>%sto children</html>", this.indent(4), this.indent(5), this.indent(3)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(distributionFIRSTandSTEM), String.format("<html>%sdistribution<br>%sFIRST and<br>%sSTEM</html>", this.indent(2), this.indent(3), this.indent(7)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(donatingBooksToSoldiers), String.format("<html>%sdonating<br>%sbooks<br>%sto soldiers</html>", this.indent(4), this.indent(6), this.indent(3)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(swordOfPeace), String.format("<html>%sSWORD<br>%sof<br>%sPEACE</html>", this.indent(5), this.indent(10), this.indent(6)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(volunteeringWithDisplacedFamilies), String.format("<html>%svolunteering<br>%swith<br>%sdisplaced<br>%sfamilies</html>", this.indent(1), this.indent(9), this.indent(4), this.indent(6)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0)
        );
        this.add(communityMenu);

        this.stuffMenu = new Menu(630, 100, 1280, 10, 5, 7,
                new MyButton(() -> {
                    if (this.currentMenu == this.communityMenu) this.add(ironSwordPanel);
                    this.hidePrevAndShowNextMenu(this.mechanicsMenu);
                }, "Mechanics", 150, 80, 557, 20, 24, 20),
                new MyButton(() -> {
                    if (this.currentMenu == this.communityMenu) this.add(ironSwordPanel);
                    this.hidePrevAndShowNextMenu(this.electronicsMenu);
                }, "Electronics", 150, 80, 662, 20, 21, 20),
                new MyButton(() -> {
                    if (this.currentMenu == this.communityMenu) this.add(ironSwordPanel);
                    this.hidePrevAndShowNextMenu(this.programmingMenu);
                }, "Programming", 150, 80, 767, 20, 11, 20),
                new MyButton(() -> {
                    this.hidePrevAndShowNextMenu(this.communityMenu);
                    this.remove(ironSwordPanel);
                }, "Community", 150, 80, 872, 20, 20, 20)
        );
        this.add(stuffMenu);

        ///////////////////
        mechanicsMenu.setVisible(false);
        electronicsMenu.setVisible(false);
        programmingMenu.setVisible(false);
        communityMenu.setVisible(false);

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        this.setVisible(true);
    }

    private void hidePrevAndShowNextMenu(Menu menu) {
        this.currentWindow.setVisible(false);
        this.currentMenu.setVisible(false);
        this.currentMenu = menu;
        this.currentMenu.setVisible(true);
    }

    private void hidePrevAndShowNextWindow(Window window) {
        this.currentWindow.setVisible(false);
        this.currentWindow = window;
        this.currentWindow.setVisible(true);
    }

    private ImageIcon scaleImageIcon(ImageIcon originalIcon, double scaleFactor) {
        Image originalImage = originalIcon.getImage();

        int newWidth = (int) (originalImage.getWidth(null) * scaleFactor);
        int newHeight = (int) (originalImage.getHeight(null) * scaleFactor);

        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

    public String indent(int numberOfSpaces) {
        return "&nbsp;".repeat(numberOfSpaces);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == VK_F4) System.exit(0);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


//    private void hideOtherWindowsAndMenus(Menu... menus, Window... windows) {
//        for (Menu menu : menus)  menu.setVisible(false);
//        for (Window window : windows)  window.setVisible(false);
//    }

//    https://chat.openai.com/share/36e1b1b9-0c41-4acd-87ad-069a1c7bc119
}
