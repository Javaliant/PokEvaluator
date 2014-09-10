import javax.swing.ImageIcon;

/*
 * Created by Luigi on 9/8/2014.
 */

public enum Element {
    NONE("None", new ImageIcon("Images/None.gif")),
    NORMAL("Normal",new ImageIcon("Images/Normal.gif")),
    FIRE("Fire", new ImageIcon("Images/Fire.gif")),
    WATER("Water", new ImageIcon("Images/Water.gif")),
    ELECTRIC("Electric", new ImageIcon("Images/Electric.gif")),
    GRASS("Grass", new ImageIcon("Images/Grass.gif")),
    BUG("Bug", new ImageIcon("Images/Bug.gif")),
    POISON("Poison", new ImageIcon("Images/Poison.gif")),
    ICE("Ice", new ImageIcon("Images/Ice.gif")),
    DRAGON("Dragon", new ImageIcon("Images/Dragon.gif")),
    FAIRY("Fairy", new ImageIcon("Images/Fairy.gif")),
    STEEL("Steel", new ImageIcon("Images/Steel.gif")),
    ROCK("Rock", new ImageIcon("Images/Rock.gif")),
    GROUND("Ground", new ImageIcon("Images/Ground.gif")),
    FIGHTING("Fighting", new ImageIcon("Images/Fighting.gif")),
    FLYING("Flying", new ImageIcon("Images/Flying.gif")),
    PSYCHIC("Psychic", new ImageIcon("Images/Psychic.gif")),
    DARK("Dark", new ImageIcon("Images/Dark.gif")),
    GHOST("Ghost", new ImageIcon("Images/Ghost.gif"));

    public final ImageIcon icon;
    public final String name;

    Element(String name, ImageIcon icon) {
        this.name = name; this.icon = icon;
    }
}
