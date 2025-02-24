package Package_MENU;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MenuClassTest<menuBar> {
    @Test
    void menuFrame(){
        MenuClass menuclass = new MenuClass();

        JFrame frame = menuclass.MenuFrame();
        assertNotNull(frame, "The frame should not be null");
        assertEquals("Menu", frame.getTitle(),"The JFrame title should be Menu");


        JPanel panel = (JPanel) frame.getContentPane().getComponent(1);
        assertTrue(panel.getLayout() instanceof CardLayout,"The panel should use CardLayout");


        assertNotNull(panel.getComponent(0),"The 'MainPanel' should be added to the panel");
        assertNotNull(panel.getComponent(1),"The 'DetailsPanel' should be added to the panel");


    }

    @Test
    void MenuBar(){
        MenuClass menuclass = new MenuClass();

        JFrame frame = menuclass.MenuFrame();
        assertNotNull(frame, "The frame should not be null");
        assertEquals("Menu", frame.getTitle(),"The JFrame title should be Menu");


        JPanel panel = (JPanel) frame.getContentPane().getComponent(1);
        assertTrue(panel.getLayout() instanceof CardLayout,"The panel should use CardLayout");


        assertNotNull(panel.getComponent(0),"The 'MainPanel' should be added to the panel");
        assertNotNull(panel.getComponent(1),"The 'DetailsPanel' should be added to the panel");



        SwingUtilities. invokeLater(()->{
                   menuBar m = (menuBar)menuclass.MenuBar();
            System.out.println("MenuBar is created Succesfully");

                }) ;


    }

}