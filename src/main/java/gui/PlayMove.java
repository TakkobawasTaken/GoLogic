package gui;

import org.example.Player;
import org.example.StoneChain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMove implements ActionListener {
    /**
     * The (x,y) coordinates of the played move
     */
    private int x,y;

    /**
     * The GUI on which this action is applied
     *
     */
    private GUI gui;

    /**
     * Constructor
     * @param gui
     * @param x
     * @param y
     */
    public PlayMove(GUI gui, int x, int y) {
        super();

        this.gui = gui;
        this.x = x;
        this.y = y;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(gui.getGoban().getSuccessivePassCount()<3) {
            Player player = gui.getGoban().getPlayer();
            System.out.println(player+" want to play in ["+x+"-"+y+"]");
            try {
                if (gui.getGoban().play(x, y, player)) {
                    System.out.println("Move applied");
                    gui.getGoban().nextPlayer();
                    gui.updateGoban();

                    // Enabling undo, disabling redo
                    gui.setUndoEnabled(true);
                    gui.setRedoEnabled(false);
                }
            } catch (Exception ex) {

            }
        } else {
            StoneChain chain = gui.getGoban().getIntersection(x,y).getStoneChain();
            gui.updateScore(chain);
        }
    }
}
