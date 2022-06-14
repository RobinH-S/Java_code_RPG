
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest
{
    /**
     * Default constructor for test class UnitTest
     */
    public UnitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Player player = new Player ("TestPlayer", "warrior");
        Monster monster = new Monster ("Dragon", 120, 100, 50);

        Item knife = new Item("knife","Sharp blade","cut" , 120, 5);
        Item potion = new Item("potion","health potion","drink", 100, 1);
        Item banana = new Item("banana", "food", "eat", 5, 1);

        player.buyItem(knife);
        player.buyItem(potion);
        player.buyItem(banana);

        Battleground battleground = new Battleground (player, monster);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void positivItem()
    {
        Player player = new Player("TestPlayer", "warrior");
        Item banana = new Item("banana", "food", "eat", 5, 1);
        player.buyItem(banana);
        assertEquals(true, player.sellItem(banana));
    }

    /**
     * Negativ test for sellItem
     */
    @Test
    public void negativSellItem()
    {
        Player player = new Player("TestPlayer", "warrior");
        Item banana = new Item("banana", "food", "eat", 5, 1);
        assertEquals(false, player.sellItem(banana));
    }

    @Test
    public void testHealth()
    {
        Player player = new Player("TestPlayer", "warrior");
        player.changeHealth(-50);
        assertEquals(50, player.getHealth());
    }

    @Test
    public void testSetName()
    {
        Player player = new Player("TestPlayer", "warrior");
        player.setName("    ");
        assertEquals("Unspecified", player.getName());
    }
}
