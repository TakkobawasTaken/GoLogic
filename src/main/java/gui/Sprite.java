package gui;

import org.example.Goban;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Sprite {
    public static final int TOKEN_INITIAL_SIZE = GUI.TOKEN_INITIAL_SIZE;

    static URL urlBackground = Sprite.class.getClassLoader().getResource("sprites/b.png");
    // Background sprite, for color
    public static final ImageIcon background = new ImageIcon(new ImageIcon(urlBackground).getImage().getScaledInstance(TOKEN_INITIAL_SIZE, TOKEN_INITIAL_SIZE, Image.SCALE_FAST));

    static URL urlGrid_ul = Sprite.class.getClassLoader().getResource("sprites/ul.png");
    static URL urlGrid_u = Sprite.class.getClassLoader().getResource("sprites/u.png");
    static URL urlGrid_ur = Sprite.class.getClassLoader().getResource("sprites/ur.png");
    static URL urlGrid_l = Sprite.class.getClassLoader().getResource("sprites/l.png");
    static URL urlGrid_c = Sprite.class.getClassLoader().getResource("sprites/c.png");
    static URL urlGrid_spot = Sprite.class.getClassLoader().getResource("sprites/spot.png");
    static URL urlGrid_r = Sprite.class.getClassLoader().getResource("sprites/r.png");
    static URL urlGrid_bl = Sprite.class.getClassLoader().getResource("sprites/bl.png");
    static URL urlGrid_b = Sprite.class.getClassLoader().getResource("sprites/b.png");
    static URL urlGrid_br = Sprite.class.getClassLoader().getResource("sprites/br.png");
    static URL url_p1 = Sprite.class.getClassLoader().getResource("sprites/p1.png");
    static URL url_p2 = Sprite.class.getClassLoader().getResource("sprites/p2.png");
    static URL url_wrong = Sprite.class.getClassLoader().getResource("sprites/wrong.png");

    static URL url_mp1 = Sprite.class.getClassLoader().getResource("sprites/mp1.png");
    static URL url_mp2 = Sprite.class.getClassLoader().getResource("sprites/mp2.png");


    // All grid sprites
    public static final ImageIcon grid_ul = new ImageIcon(new ImageIcon(urlGrid_ul).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_u = new ImageIcon(new ImageIcon(urlGrid_u).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_ur = new ImageIcon(new ImageIcon(urlGrid_ur).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_l = new ImageIcon(new ImageIcon(urlGrid_l).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_c = new ImageIcon(new ImageIcon(urlGrid_c).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_spot = new ImageIcon(new ImageIcon(urlGrid_spot).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_r = new ImageIcon(new ImageIcon(urlGrid_r).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_bl = new ImageIcon(new ImageIcon(urlGrid_bl).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_b = new ImageIcon(new ImageIcon(urlGrid_b).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon grid_br = new ImageIcon(new ImageIcon(urlGrid_br).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));

    public static final ImageIcon wrong = new ImageIcon(new ImageIcon(url_wrong).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon mp1 = new ImageIcon(new ImageIcon(url_mp1).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon mp2 = new ImageIcon(new ImageIcon(url_mp2).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));

    public static final ImageIcon p1 = new ImageIcon(new ImageIcon(url_p1).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));
    public static final ImageIcon p2 = new ImageIcon(new ImageIcon(url_p2).getImage().getScaledInstance(TOKEN_INITIAL_SIZE,TOKEN_INITIAL_SIZE, Image.SCALE_FAST));

    // Player sprites

    // Images that are frequently used need initialisation
    public static final ImageIcon grid_p1 = merge(new ArrayList<ImageIcon>(Arrays.asList(background, p1)));
    public static final ImageIcon grid_p2 = merge(new ArrayList<ImageIcon>(Arrays.asList(background, p2)));
    public static final ImageIcon grid_p1_c = merge(new ArrayList<ImageIcon>(Arrays.asList(background, p1, wrong)), new ArrayList<Float>(Arrays.asList(Float.valueOf((float) 1.0), Float.valueOf((float)1.0), Float.valueOf((float)0.4))));
    public static final ImageIcon grid_p2_c = merge(new ArrayList<ImageIcon>(Arrays.asList(background, p2, wrong)), new ArrayList<Float>(Arrays.asList(Float.valueOf((float) 1.0), Float.valueOf((float)1.0), Float.valueOf((float)0.4))));

    /**
     * Merge the images listed in ArrayList, all with a 1.0 alpha transparency
     * @param images list of ImageIcons to merge
     * @return ImageIcon result of the merge
     */

    public static ImageIcon merge(ArrayList<ImageIcon> images) {
        ArrayList<Float> transparency = new ArrayList<Float>();

        for (ImageIcon i : images) {
            transparency.add(Float.valueOf((float)1.0));
        }

        return merge(images, transparency);
    }

    /**
     * Merge the images listed in ArrayList, with the corresponding alpha transparency
     * @param images list of ImageIcons to merge
     * @param transparency list of alpha transparency
     * @return ImageIcon result of the merge
     */

    public static ImageIcon merge(ArrayList<ImageIcon> images, ArrayList<Float> transparency)
    {
        BufferedImage dest = null;
        Graphics2D destG = null;
        int rule; // This is SRC for the top image, and DST_OVER for the other ones
        float alpha;

        for (int i = 0, size = images.size(); i < size; i++)
        {
            Image image = images.get(i).getImage();

            rule = AlphaComposite.SRC_OVER; // Default value
            alpha = transparency.get(i);

            if (i == 0)
            {
                dest = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                destG = dest.createGraphics();

                rule = AlphaComposite.SRC; // Rule for 1st image
            }

            dest = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            destG.setComposite(AlphaComposite.getInstance(rule, alpha));
            destG.drawImage(image, 0, 0, null);
        }

        return new ImageIcon(dest);
    }

    /**
     * Allow to know if the intersection should be marked on the goban
     * @param goban goban to get the size of this one
     * @param x x coord
     * @param y y coord
     * @return true if the intersection is marked
     */
    private static boolean shouldBeSpot(Goban goban, int x, int y) {
        int gobanWidth = goban.getWidth();
        int gobanHeight = goban.getHeight();
        int offset = 3;
        if (gobanWidth < 10) offset = 2;

        return (x == offset || x == (gobanWidth-1)/2 || x == gobanWidth-offset-1) && (y == offset || y == (gobanHeight-1)/2 || y == gobanHeight-offset-1);
    }

    /**
     *
     * @param goban goban to get the size of this one
     * @param x x coord
     * @param y y coord
     * @param ownerID if the intersection has owner, for score handling
     * @return icon of grid
     */
    public static ImageIcon getGridIcon(Goban goban, int x, int y, int ownerID) {
        ImageIcon mp;

        switch (ownerID) {
            default:
                return getGridIcon(goban, x, y);
            case 1:
                mp = mp1;
                break;
            case 2:
                mp = mp2;
                break;
        }

        return  merge(new ArrayList<ImageIcon>(Arrays.asList(getGridIcon(goban, x, y), mp)));
    }

    /**
     *
     * @param goban goban to get the size of this one
     * @param x x coord
     * @param y y coord
     * @return icon of grid
     */
    public static ImageIcon getGridIcon(Goban goban, int x, int y) {
        int gobanWidth = goban.getWidth();
        int gobanHeight = goban.getHeight();

        if (x == gobanWidth - 1) {
            if (y == 0) {
                return grid_ul;
            } else if (y == gobanHeight - 1) {
                return grid_ur;
            } else {
                return grid_u;
            }
        } else if (x == 0) {
            if (y == 0) {
                return grid_bl;
            } else if (y == gobanHeight - 1) {
                return grid_br;
            } else {
                return grid_b;
            }
        } else {
            if (y == 0) {
                return grid_l;
            } else if (y == gobanHeight - 1) {
                return grid_r;
            } else {
                if (shouldBeSpot(goban, x, y)) {
                    return grid_spot;
                } else {
                    return grid_c;
                }
            }
        }
    }

    public static ImageIcon getPlayerIcon(int player) {
        switch (player) {
            case 1:
                return p1;
            case 2:
                return p2;
            default:
                return null;
        }
    }

    public static ImageIcon getPlayerIcon(int player, int owner, Goban goban, int x, int y) {
        if (player != owner) {
            switch (player) {
                case 1:
                    return merge(new ArrayList<ImageIcon>(Arrays.asList(getGridIcon(goban, x, y), p1, mp2)), new ArrayList<Float>(Arrays.asList(Float.valueOf((float)1.0), Float.valueOf((float)1.0), Float.valueOf((float)1.0))));
                case 2:
                    return merge(new ArrayList<ImageIcon>(Arrays.asList(getGridIcon(goban, x, y), p2, mp1)), new ArrayList<Float>(Arrays.asList(Float.valueOf((float)1.0), Float.valueOf((float)1.0), Float.valueOf((float)1.0))));
                default:
                    return null;
            }
        } else {
            return getPlayerIcon(player);
        }
    }
}
