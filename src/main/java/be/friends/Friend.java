package be.friends;

public class Friend {
    String name;
    int nrOfStars;
    int friendshipLevel;
    boolean isLucky;
    boolean didSomeInteractionToday;

    public Friend(String name, int nrOfStars, int friendshipLevel, boolean isLucky, boolean didSomeInteractionToday) {
        this.name = name;
        this.nrOfStars = nrOfStars;
        this.friendshipLevel = friendshipLevel;
        this.isLucky = isLucky;
        this.didSomeInteractionToday = didSomeInteractionToday;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", nrOfStars=" + nrOfStars +
                ", friendshipLevel=" + friendshipLevel +
                ", isLucky=" + isLucky +
                ", didSomeInteractionToday=" + didSomeInteractionToday +
                '}';
    }
}
