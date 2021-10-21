package be.friends;

public class FriendshipUpdater {

    final Friend[] friends;

    public FriendshipUpdater(Friend[] friends) {
        this.friends = friends;
    }

    public void update() {
        FriendLoop();
    }

    public void FriendLoop(){
        for (Friend friend : friends) {
            boolean wasLucky = !friend.isLucky;

            CheckIfLucky(friend);

            if (!wasLucky){
                friend.friendshipLevel += 4;
            }

            if (friend.didSomeInteractionToday) {
                CheckIfAddStars(friend);

                CheckIfNeedAddStars(friend);
            }

            if (!wasLucky && !friend.didSomeInteractionToday) {
                friend.isLucky = true;
                friend.friendshipLevel -= 4;
            }
        }
    }

    public void CheckIfLucky(Friend friend){
        if (friend.isLucky && friend.didSomeInteractionToday) {
            friend.isLucky = !friend.isLucky;
        }
    }

    public void CheckIfAddStars(Friend friend) {
        if (friend.nrOfStars == 0) {
            friend.nrOfStars++;
        }
        else {
            if (friend.friendshipLevel == 9) {
                if (friend.nrOfStars == 1) {
                    friend.friendshipLevel = -1;
                    friend.nrOfStars = 2;
                }
            }
            friend.friendshipLevel++;
        }
    }

    public void CheckIfNeedAddStars(Friend friend){
        if (friend.nrOfStars != 3 && friend.friendshipLevel == 30) {
            friend.friendshipLevel = 0;
            friend.nrOfStars = friend.nrOfStars + 1;
        }
    }
}
