import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MenuGui implements ItemListener, ActionListener {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel diffLabel = new JLabel("Choose The Difficulty");
    JButton startButton = new JButton("Start");
    JRadioButton easy = new JRadioButton("Easy");
    JRadioButton medium = new JRadioButton("Medium");
    JRadioButton hard = new JRadioButton("Hard");

    MenuGui(){

        frame.setSize(500,500);
        frame.setTitle("Rocket Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        int lWidth=200;
        int lHeight=30;

        int centerX = (frame.getWidth()-lWidth)/2;

        diffLabel.setBounds(centerX,20,lWidth,lHeight);
        diffLabel.setFont(new Font("Arial", Font.BOLD, 15));

        easy.setBounds((frame.getWidth()-200)/2,50,180,30);
        medium.setBounds((frame.getWidth()-200)/2,80,180,30);
        hard.setBounds((frame.getWidth()-200)/2,110,180,30);
        startButton.setBounds((frame.getWidth()-200)/2,150, 180, 30);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(easy);
        g1.add(medium);
        g1.add(hard);

        easy.addItemListener(this);
        medium.addItemListener(this);
        hard.addItemListener(this);
        startButton.addActionListener(this);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(diffLabel);
        panel.add(easy);
        panel.add(medium);
        panel.add(hard);
        panel.add(startButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton selectedButton = (JRadioButton) e.getSource();
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(null, "You have selected " + selectedButton.getText());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(easy.isSelected()||medium.isSelected()||hard.isSelected())){
            JOptionPane.showMessageDialog(null, "You need to select one of the options");
        }

        else if(easy.isSelected()){
            frame.dispose();
            new GameGui(1);
        }

        else if(medium.isSelected()){
            frame.dispose();
            new GameGui(2);
        }
        else {
            frame.dispose();
            new GameGui(3);
        }
    }
}
