
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    private static JLabel label;
    private JLabel label1;
    private JLabel label11;
    private JLabel generatedFilm;
    private JFrame frame;
    private JFrame frame1;
    private JFrame frame11;
    private JFrame gFrame;
    private JFrame frameFileDirectory;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button11;
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel11;
    private JPanel gPanel;
    private JPanel paneFileDirectory;
    private JTextArea textFilmList;
    private JTextField userTextFilm;
    private JTextField userDeletedFilm;
    private JTextField printTextField;
    private int count;
    private static Scanner scanner;
    private static String a;
    private static String b;
    static List<String> films;
    private String filmGet;
    private String filmTodelete;
    private JTextArea textArea1;
    private int g;

    private static final String FILE_PATH = "C:\\Users\\julia\\Desktop\\save\\Save.txt";

    public Main() {
        a = "brak";
        films = new ArrayList<>();
        frame = new JFrame();
        frame.setSize(500, 500);
        button1 = new JButton("Wybierz lokalizacje zapisu");
        button1.setBounds(160, 50, 180, 25);
        button2 = new JButton("Dodaj film");
        button2.setBounds(160, 80, 180, 25);
        button2.addActionListener(this::actionPerformed1);
        button1.addActionListener(this::actionPerformed);
        button6 = new JButton("Usuń film");
        button6.setBounds(160, 110, 180, 25);
        button6.addActionListener(this::actiondeleteFrame);
        button3 = new JButton("Zapisz");
        button3.setBounds(160, 140, 180, 25);
        button3.addActionListener(this::actionZapisz);
        button4 = new JButton("Wczytaj");
        button4.setBounds(160, 170, 180, 25);
        button4.addActionListener(this::actionLoad);
        button5 = new JButton("Wylosuj film");
        button5.setBounds(160, 200, 180, 25);
        button5.addActionListener(this::actionRandom);

        textFilmList = new JTextArea("Filmy: " + a);
        textFilmList.setBounds(160, 5, 180, 40);
        textFilmList.setEditable(false);

        panel = new JPanel();

        panel.setLayout(null);
        panel.add(textFilmList);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);

        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Losowacz filmów");

        frame.setVisible(true);

    }

    private void saveFilms() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String film : films) {
                writer.println(film);
            }
            System.out.println("Zapisano filmy do pliku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadFilms() {
        films.clear(); // Wyczyść listę przed wczytaniem danych
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                films.add(line);
            }
            System.out.println("Wczytano filmy z pliku.");
        } catch (IOException e) {
            System.out.println("Nie można wczytać pliku. Pusta lista filmów.");
        }
    }

    private void randomGenaerator() {

        Random random = new Random();
        int nuberGet = random.nextInt(films.size());
        filmGet = films.get(nuberGet);
        System.out.println("film" + filmGet);
    }

    // Obsługa przyciusku dodaj film
    public void Main1() {
        panel1 = new JPanel();
        frame1 = new JFrame();
        frame1.setSize(350, 200);
        frame1.add(panel1);

        panel1.setLayout(null);

        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setTitle("Losowacz filmów");

        frame1.setVisible(true);

        label1 = new JLabel("Podaj nazwę");
        label1.setBounds(10, 20, 100, 25);
        panel1.add(label1);

        userTextFilm = new JTextField(20);
        userTextFilm.setBounds(100, 20, 165, 25);
        userTextFilm.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (10 == e.getKeyCode()) {
                    System.out.println("Dodano film");
                    String texttaken = userTextFilm.getText();

                    if (!texttaken.isEmpty()) {
                        films.add(userTextFilm.getText());
                    } else {
                        System.out.println("zle");
                    }
                    StringBuilder filmList = new StringBuilder("Filmy:");
                    for (String film : films) {
                        filmList.append(", ").append(film);
                    }
                    textFilmList.setText(filmList.toString());
                    userTextFilm.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        panel1.add(userTextFilm);

        button1 = new JButton("Dodaj");
        button1.addActionListener(this::actionPerformed2);
        button1.setBounds(10, 50, 80, 25);
        panel1.add(button1);

        button2 = new JButton("powrót");
        button2.addActionListener(this::actionPerformed3);
        button2.setBounds(10, 80, 80, 25);
        panel1.add(button2);

    }

    public void generatorFrame() {
        gFrame = new JFrame();
        gPanel = new JPanel();
        gFrame.setSize(350, 200);
        gFrame.add(gPanel);

        gPanel.setLayout(null);
        gFrame.setVisible(true);

        gFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        gFrame.setTitle("Wylosowany Film");

        generatedFilm = new JLabel();
        generatedFilm.setText("Wylosowany film: " + filmGet);
        generatedFilm.setBounds(5, 10, 250, 25);

        gPanel.add(generatedFilm);

    }

    public void deleteFrame() {

        panel11 = new JPanel();
        frame11 = new JFrame();
        frame11.setSize(500, 500);
        frame11.add(panel11);

        panel11.setLayout(null);

        frame11.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame11.setTitle("Usuń film");

        frame11.setVisible(true);

        label11 = new JLabel("Podaj indeks filmu");
        label11.setBounds(10, 20, 115, 25);
        panel11.add(label11);

        userDeletedFilm = new JTextField(20);
        userDeletedFilm.setBounds(120, 20, 165, 25);

        button11 = new JButton("Usuń");
        button11.addActionListener(this::actionDelete);
        button11.setBounds(10, 50, 80, 25);

        int i = -1;
        StringBuilder filmList1 = new StringBuilder("Filmy:\n");
        for (String film : films) {

            i++;
            filmList1.append(i + ".").append(film + "\n");
        }
        textArea1 = new JTextArea();
        textArea1.setBounds(10, 80, 300, 300);
        textArea1.setText(filmList1.toString());
        textArea1.setEditable(false);

        panel11.add(button11);
        panel11.add(userDeletedFilm);
        panel11.add(textArea1);

    }

    public void errorMessage() {
        gFrame = new JFrame();
        gPanel = new JPanel();
        gFrame.setSize(350, 200);
        gFrame.add(gPanel);
        gFrame.setAlwaysOnTop(true);

        gPanel.setLayout(null);
        gFrame.setVisible(true);

        gFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        gFrame.setTitle("ERROR");

        generatedFilm = new JLabel();
        generatedFilm.setText("ERROR: Lista jest pusta,\n nie można wylosować filmu");
        generatedFilm.setBounds(5, 10, 300, 50);

        gPanel.add(generatedFilm);
    }

    public static void main(String[] args) {
        new Main();

    }

    static void printList() {

        for (String film : films) {
            a = "" + film + "\n";
            System.out.println(a);
        }

    }

    public void actionDelete(ActionEvent e) {
        filmTodelete = userDeletedFilm.getText();

        films.remove(films.get(Integer.parseInt(filmTodelete)));

        StringBuilder filmList2 = new StringBuilder("Filmy:");
        for (String film : films) {
            filmList2.append(", ").append(film);

            textFilmList.setText(filmList2.toString());
            userTextFilm.setText("");
        }
    }

    public void actiondeleteFrame(ActionEvent e) {

        deleteFrame();

    }

    public void actionZapisz(ActionEvent e) {

        saveFilms();

    }

    public void actionLoad(ActionEvent e) {

        loadFilms();
        StringBuilder filmy = new StringBuilder("Filmy:");
        for (String film : films) {
            filmy.append(",").append(film);
            textFilmList.setText(filmy.toString());
        }
    }

    public void actionPerformed3(ActionEvent e) {

        new Main();

    }

    public void actionPerformed2(ActionEvent e) {

        System.out.println("Dodano film");
        String texttaken = userTextFilm.getText();

        if (!texttaken.isEmpty()) {
            films.add(userTextFilm.getText());
        } else {
            System.out.println("zle");
        }
        StringBuilder filmList = new StringBuilder("Filmy:");
        for (String film : films) {
            filmList.append(", ").append(film);
        }
        textFilmList.setText(filmList.toString());
        userTextFilm.setText("");
    }

    public void actionPerformed1(ActionEvent e) {

        Main1();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    frameFileDirecroty = new JFrame();
    panelFileDirectory = new JPanel();
    frameFileDirectory.setSize(300, 500);

    textAreaFileD = new JTextArea();
    ButtonSelect = new JButton("Zapisz lokalizacje pliku");
    ButtonSelect.addActionListener(this::saveFileDirectory)

    
    panelFileDirectory.add(ButtonSelect)

    }
    public void saveFileDirectory(ActionEvent e) {
        
    }

    public void actionRandom(ActionEvent e) {
        if (!films.isEmpty()) {
            randomGenaerator();
            generatorFrame();
        } else {
            errorMessage();
        }

    }
}
