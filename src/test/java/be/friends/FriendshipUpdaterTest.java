package be.friends;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FriendshipUpdaterTest {
    @Test
    void emptyFriendList() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{});
        app.update();
        assertEquals(0, app.friends.length);
    }

    @Test
    void noInteractionMeansNoUpdateOfStars() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 0, 0, false, false)});
        app.update();
        assertEquals(0, app.friends[0].nrOfStars);
    }

    @Test
    void noInteractionForStar0MeansNoUpdateOfLevel() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 0, 0, false, false)});
        app.update();
        assertEquals(0, app.friends[0].friendshipLevel);
    }

    @Test
    void noInteractionForStar1MeansNoUpdateOfLevel() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 1, 0, false, false)});
        app.update();
        assertEquals(0, app.friends[0].friendshipLevel);
    }

    @Test
    void star0() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 0, 0, false, true)});
        app.update();
        assertEquals(0, app.friends[0].friendshipLevel);
        assertEquals(1, app.friends[0].nrOfStars);
    }

    @Test
    void star1Level0() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 1, 0, false, true)});
        app.update();
        assertEquals(1, app.friends[0].friendshipLevel);
        assertEquals(1, app.friends[0].nrOfStars);
    }

    @Test
    void star1Level8() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 1, 8, false, true)});
        app.update();
        assertEquals(9, app.friends[0].friendshipLevel);
        assertEquals(1, app.friends[0].nrOfStars);
    }
    @Test
    void star1Level9() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 1, 9, false, true)});
        app.update();
        assertEquals(0, app.friends[0].friendshipLevel);
        assertEquals(2, app.friends[0].nrOfStars);
    }
    @Test
    void star2Level0() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 2, 0, false, true)});
        app.update();
        assertEquals(1, app.friends[0].friendshipLevel);
        assertEquals(2, app.friends[0].nrOfStars);
    }
    @Test
    void star2Level9() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 2, 9, false, true)});
        app.update();
        assertEquals(10, app.friends[0].friendshipLevel);
        assertEquals(2, app.friends[0].nrOfStars);
    }
    @Test
    void star2Level14() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 2, 14, false, true)});
        app.update();
        assertEquals(15, app.friends[0].friendshipLevel);
        assertEquals(2, app.friends[0].nrOfStars);
    }
    @Test
    void star2Level29() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 2, 29, false, true)});
        app.update();
        assertEquals(0, app.friends[0].friendshipLevel);
        assertEquals(3, app.friends[0].nrOfStars);
    }
    @Test
    void star3Level17() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 17, false, true)});
        app.update();
        assertEquals(18, app.friends[0].friendshipLevel);
        assertEquals(3, app.friends[0].nrOfStars);
    }
    @Test
    void star3Level29() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 29, false, true)});
        app.update();
        assertEquals(30, app.friends[0].friendshipLevel);
        assertEquals(3, app.friends[0].nrOfStars);
    }
    @Test
    void star3Level65() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 65, false, true)});
        app.update();
        assertEquals(66, app.friends[0].friendshipLevel);
        assertEquals(3, app.friends[0].nrOfStars);
    }
    @Test
    void star3Level59NotLucky() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 59, false, true)});
        app.update();
        assertFalse(app.friends[0].isLucky);
        assertEquals(60, app.friends[0].friendshipLevel);
    }
    @Test
    void star3Level589() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 589, false, true)});
        app.update();
        assertEquals(590, app.friends[0].friendshipLevel);
        assertEquals(3, app.friends[0].nrOfStars);
    }
    @Test
    void star3Level60Lucky() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 60, true, true)});
        app.update();
        assertEquals(65, app.friends[0].friendshipLevel);
        assertEquals(3, app.friends[0].nrOfStars);
    }
    @Test
    void luckyWorksOnlyOnce() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 60, true, true)});
        app.update();
        assertFalse(app.friends[0].isLucky);
    }
    @Test
    void luckyStaysWhenNoInteraction() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 60, true, false)});
        app.update();
        assertTrue(app.friends[0].isLucky);
    }
    @Test
    void luckyAndNoInteraction() {
        FriendshipUpdater app = new FriendshipUpdater(new Friend[]{new Friend("Aagje", 3, 68, true, false)});
        app.update();
        assertEquals(68, app.friends[0].friendshipLevel);
    }
}
