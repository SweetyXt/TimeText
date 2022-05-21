import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeTextWindow extends JFrame{
    private Time time;
    private JLabel hourLabel,minuteLabel,secondLabel;
    private JTextField hourField,minuteField,secondField,displayField;
    public TimeTextWindow(){
        super("嵌套内部类的使用例子");
        time=new Time();
        creatGUI();
        registerEventHandlers();
    }
    private void creatGUI(){
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        hourLabel=new JLabel("设置时");
        hourField=new JTextField(10);
        container.add(hourLabel);
        container.add(hourField);
        minuteLabel=new JLabel("设置分");
        minuteField=new JTextField(10);
        container.add(minuteLabel);
        container.add(minuteField);
        secondField=new JTextField(10);
        secondLabel=new JLabel("设置秒");
        container.add(secondLabel);
        container.add(secondField);
        displayField=new JTextField(30);
        displayField.setEditable(false);
        container.add(displayField);
    }
    private void registerEventHandlers(){
        ActionEventHandler handler=new ActionEventHandler();
        hourField.addActionListener(handler);
        minuteField.addActionListener(handler);
        secondField.addActionListener(handler);
    }
    private  class ActionEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==hourField){
                time.setHour(Integer.parseInt(event.getActionCommand()));
            }else if(event.getSource()==minuteField){
                time.setMinute(Integer.parseInt(event.getActionCommand()));
            }else if(event.getSource()==secondField){
                time.setSecond(Integer.parseInt(event.getActionCommand()));
            }
        }
    }
    public static void main(String args[]){
        TimeTextWindow window=new TimeTextWindow();
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
        window.setSize(550,150);
        window.setVisible(true);
    }
}
