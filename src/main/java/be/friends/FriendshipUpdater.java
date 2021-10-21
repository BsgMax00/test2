package be.friends;

public class FriendshipUpdater {

    final Friend[] friends;

    public FriendshipUpdater(Friend[] friends) {
        this.friends = friends;
    }

    public void update() {
        for (Friend friend : friends) {
            boolean wasLucky = !friend.isLucky;
            if (friend.isLucky && friend.didSomeInteractionToday) {
                friend.isLucky = !friend.isLucky;
            }
            if (!wasLucky)
                friend.friendshipLevel += 4;
            if (friend.didSomeInteractionToday) {
                if (friend.nrOfStars == 0)
                    friend.nrOfStars++;
                else {
                    if (friend.friendshipLevel == 9) {
                        if (friend.nrOfStars == 1) {
                            friend.friendshipLevel = -1;
                            friend.nrOfStars = 2;
                        }
                    }
                    friend.friendshipLevel++;
                }
                if (friend.nrOfStars != 3 && friend.friendshipLevel == 30) {
                    friend.friendshipLevel = 0;
                    friend.nrOfStars = friend.nrOfStars + 1;
                }
            }
            if (!wasLucky && !friend.didSomeInteractionToday) {
                friend.isLucky = true;
                friend.friendshipLevel -= 4;
            }
        }
    }
}
