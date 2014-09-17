import javax.swing.ImageIcon;

/*
 * Created by Luigi on 9/8/2014.
 */

public enum Element {
    NONE(new ImageIcon("Images/None.gif")),
    NORMAL(new ImageIcon("Images/Normal.gif")),
    FIRE(new ImageIcon("Images/Fire.gif")),
    WATER(new ImageIcon("Images/Water.gif")),
    ELECTRIC(new ImageIcon("Images/Electric.gif")),
    GRASS(new ImageIcon("Images/Grass.gif")),
    BUG(new ImageIcon("Images/Bug.gif")),
    POISON(new ImageIcon("Images/Poison.gif")),
    ICE(new ImageIcon("Images/Ice.gif")),
    DRAGON(new ImageIcon("Images/Dragon.gif")),
    FAIRY(new ImageIcon("Images/Fairy.gif")),
    STEEL(new ImageIcon("Images/Steel.gif")),
    ROCK(new ImageIcon("Images/Rock.gif")),
    GROUND(new ImageIcon("Images/Ground.gif")),
    FIGHTING(new ImageIcon("Images/Fighting.gif")),
    FLYING(new ImageIcon("Images/Flying.gif")),
    PSYCHIC(new ImageIcon("Images/Psychic.gif")),
    DARK(new ImageIcon("Images/Dark.gif")),
    GHOST(new ImageIcon("Images/Ghost.gif"));

    public final ImageIcon icon;

    Element(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, 1).toUpperCase() + 
            super.toString().substring(1).toLowerCase();
    }
}
