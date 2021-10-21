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
            CheckIfNotLucky(wasLucky, friend);
            CheckIfInteraction(friend);
            CheckIfNotLuckyAndNoInteraction(wasLucky, friend);
        }
    }

    public void CheckIfLucky(Friend friend){
        if (friend.isLucky && friend.didSomeInteractionToday) {
            friend.isLucky = !friend.isLucky;
        }
    }

    public void CheckIfNotLucky(boolean wasLucky, Friend friend){
        if (!wasLucky){
            friend.friendshipLevel += 4;
        }
    }

    public void CheckIfInteraction(Friend friend){
        if (friend.didSomeInteractionToday) {
            CheckIfAddStars(friend);
            CheckIfNeedAddStars(friend);
        }
    }

    public void CheckIfAddStars(Friend friend) {
        if (friend.nrOfStars == 0) {
            friend.nrOfStars++;
        }
        else {
            CheckFriendshipLvl(friend);
            friend.friendshipLevel++;
        }
    }

    public void CheckFriendshipLvl(Friend friend){
        if (friend.friendshipLevel == 9) {
            if (friend.nrOfStars == 1) {
                friend.friendshipLevel = -1;
                friend.nrOfStars = 2;
            }
        }
    }

    public void CheckIfNeedAddStars(Friend friend){
        if (friend.nrOfStars != 3 && friend.friendshipLevel == 30) {
            friend.friendshipLevel = 0;
            friend.nrOfStars = friend.nrOfStars + 1;
        }
    }

    public void CheckIfNotLuckyAndNoInteraction(boolean wasLucky, Friend friend){
        if (!wasLucky && !friend.didSomeInteractionToday) {
            friend.isLucky = true;
            friend.friendshipLevel -= 4;
        }
    }
}
